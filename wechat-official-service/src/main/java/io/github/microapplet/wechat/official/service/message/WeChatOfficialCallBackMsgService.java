/*
 * Copyright 2014-2024 <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.microapplet.wechat.official.service.message;

import io.github.microapplet.wechat.application.WeChatApplication;
import io.github.microapplet.wechat.application.WeChatApplicationRepository;
import io.github.microapplet.wechat.official.event.WeChatOfficialInputMessageEvent;
import io.github.microapplet.wechat.official.event.WeChatOfficialOutputXmlRepliesEvent;
import io.github.microapplet.wechat.official.message.WeChatOfficialInputMessageHandler;
import io.github.microapplet.wechat.official.message.WeChatOfficialInputXmlMessage;
import io.github.microapplet.wechat.official.message.WeChatOfficialOutputXmlMessage;
import io.github.microapplet.wechat.official.service.authpage.WeChatOfficialAuthPageService;
import io.github.microapplet.wechat.official.service.authpage.WeChatOfficialAuthPageUser;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import io.github.microapplet.wechat.aes.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 微信公众号消息回调服务
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 3.0.0
 * @since 2024 04 07, &nbsp;&nbsp; <em>version:3.0.0</em>
 */
@Slf4j
@Component
public class WeChatOfficialCallBackMsgService implements ApplicationContextAware {
    @Setter
    private ApplicationContext applicationContext;
    @Resource
    private WeChatApplicationRepository.Aggregator aggregator;
    @Resource
    private WeChatBusinessCryptService weChatBusinessCryptService;
    @Resource
    private WeChatOfficialAuthPageService weChatOfficialAuthPageService;
    @Resource
    private WeChatOfficialInputMessageRepeatService weChatOfficialInputMessageRepeatService;
    @Resource
    private List<WeChatOfficialInputMessageHandler> weChatOfficialInputMessageHandlers;

    public boolean check(String signature, String timestamp, String nonce) {
        List<WeChatApplication> apps = this.aggregator.allApps();
        if (CollectionUtils.isEmpty(apps)) return false;
        for (WeChatApplication app : apps) {
            try {
                WeChatBusinessCrypt crypt = this.weChatBusinessCryptService.wxBizMsgCrypt(app);
                crypt.verifyUrl(signature, timestamp, nonce);
                return true;
            } catch (Throwable t) {
                log.info("使用：{} 验证失败，使用下一个公众平台账号验证", app);
            }
        }
        return false;
    }

    public String redirect(String code, String state) {
        WeChatOfficialAuthPageUser user = weChatOfficialAuthPageService.userOfCodeAndState(code, state);
        return user.getRedirectUrl();
    }

    public String event(String xml, String signature, String timestamp, String nonce, String encryptType) {
        try {
            boolean encrypt = StringUtils.equalsIgnoreCase(encryptType, "aes");
            // 解密
            String sourceXml = encrypt ? this.weChatBusinessCryptService.decrypt(xml, signature, timestamp, nonce) : xml;
            WeChatOfficialInputXmlMessage inputMessage = WeChatOfficialInputXmlMessage.fromXml(sourceXml);
            // 重复消息
            if (this.weChatOfficialInputMessageRepeatService.repeat(inputMessage)) return "success";

            // 异步消息处理
            this.applicationContext.publishEvent(new WeChatOfficialInputMessageEvent(inputMessage));

            // 同步消息处理
            List<WeChatOfficialOutputXmlMessage> replies = handlers().stream().map(item -> item.handle(inputMessage)).filter(Objects::nonNull).collect(Collectors.toList());

            // 空响应或者多相应,  空相应将转换为客服消息主动发送
            if (CollectionUtils.isEmpty(replies) || CollectionUtils.size(replies) > 1) {
                this.applicationContext.publishEvent(new WeChatOfficialOutputXmlRepliesEvent(replies));
                return "success";
            }

            // 被动回复
            WeChatOfficialOutputXmlMessage outXml = replies.get(0);
            String replyXml = outXml.toXml();
            String targetXml = encrypt ? this.weChatBusinessCryptService.encrypt(xml, signature, timestamp, nonce) : replyXml;
            log.info("微信公众号被动回复消息结果:{}", targetXml);
            return targetXml;
        } catch (Throwable t) {
            if (log.isDebugEnabled()) log.info("处理微信公众号用户消息：{}  异常：{}", xml, t.getMessage(), t);
            else log.info("处理微信公众号用户消息：{}  异常：{}", xml, t.getMessage());
            return "success";
        }
    }

    private List<WeChatOfficialInputMessageHandler> handlers() {
        return Optional.ofNullable(this.weChatOfficialInputMessageHandlers).orElseGet(ArrayList::new);
    }
}