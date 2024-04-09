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

package io.github.microapplet.wechat.official.listener;

import io.github.microapplet.wechat.official.event.WeChatOfficialOutputXmlRepliesEvent;
import io.github.microapplet.wechat.official.message.WeChatOfficialOutputXmlMessage;
import io.github.microapplet.wechat.official.remoting.customer.WeChatPaCustomerMessageRemoting;
import io.github.microapplet.wechat.official.remoting.customer.meta.WeChatCustomerTextMessage;
import io.github.microapplet.wechat.official.remoting.customer.meta.item.Text;
import io.github.microapplet.wechat.remoting.context.BaseWeChatApiRes;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * 多个微信公众号消息回复事件监听器
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0.0
 * @since 2024 04 09, &nbsp;&nbsp; <em>version:1.0.0</em>
 */
@Slf4j
@Component
public class WeChatOfficialOutputXmlRepliesListener implements ApplicationListener<WeChatOfficialOutputXmlRepliesEvent> {
    @Resource
    private WeChatPaCustomerMessageRemoting weChatPaCustomerMessageRemoting;
    @Override
    public void onApplicationEvent(@SuppressWarnings("NullableProblems") WeChatOfficialOutputXmlRepliesEvent event) {
        //noinspection ConstantValue
        if (Objects.isNull(event))
            return;

        List<WeChatOfficialOutputXmlMessage> messages = event.messages();
        for (WeChatOfficialOutputXmlMessage message : messages) {
            if (Objects.isNull(message))
                continue;

            String msgType = message.getMsgType();
            String openid = message.getToUserName();
            String subjectId = message.getFromUserName();
            if (StringUtils.equalsIgnoreCase(msgType,"text")){
                sendTextMessage(message, openid, subjectId);
            }
        }
    }

    private void sendTextMessage(WeChatOfficialOutputXmlMessage message, String openid, String subjectId) {
        String content = message.getContent();
        WeChatCustomerTextMessage msg = new WeChatCustomerTextMessage();
        msg.setTouser(openid);
        msg.setText(Text.builder().content(content).build());
        BaseWeChatApiRes res = this.weChatPaCustomerMessageRemoting.sendCustomerMsg(subjectId, msg);
        log.info("\r\n\t被动回复文本消息:{}\r\n\t改为发送客服消息：{}\r\n\t结果：{}", message,msg,res);
    }
}