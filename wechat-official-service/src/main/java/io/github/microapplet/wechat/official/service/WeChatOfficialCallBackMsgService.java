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

package io.github.microapplet.wechat.official.service;

import io.github.microapplet.wechat.application.WeChatApplication;
import io.github.microapplet.wechat.application.WeChatApplicationRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;
import io.github.microapplet.wechat.aes.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 微信公众号消息回调服务
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 3.0.0
 * @since 2024 04 07, &nbsp;&nbsp; <em>version:3.0.0</em>
 */
@Slf4j
@Component
public class WeChatOfficialCallBackMsgService {
    @Resource
    private WeChatApplicationRepository.Aggregator aggregator;
    @Resource
    private WeChatBusinessCryptService weChatBusinessCryptService;

    public boolean check(String signature, String timestamp, String nonce) {
        List<WeChatApplication> apps = this.aggregator.allApps();
        if (CollectionUtils.isEmpty(apps))
            return false;
        for (WeChatApplication app : apps) {
            try {
                WeChatBusinessCrypt crypt = this.weChatBusinessCryptService.wxBizMsgCrypt(app);
                crypt.verifyUrl(signature, timestamp, nonce);
                return true;
            } catch (Throwable t) {
                log.info("使用：{} 验证失败，使用下一个公众平台账号验证",app);
            }
        }
        return false;
    }

    public String redirect(String code, String state) {
        return null;
    }

    public String event(String xml, String signature, String timestamp, String nonce, String echoStr) {
        return null;
    }
}