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

package io.github.microapplet.wechat.official.event;

import io.github.microapplet.wechat.official.message.WeChatOfficialOutputXmlMessage;
import org.springframework.context.ApplicationEvent;

import java.util.List;

/**
 * 多个微信公众号回复消息事件
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0.0
 * @since 2024 04 09, &nbsp;&nbsp; <em>version:1.0.0</em>
 */
public final class WeChatOfficialOutputXmlRepliesEvent extends ApplicationEvent {
    public WeChatOfficialOutputXmlRepliesEvent(List<WeChatOfficialOutputXmlMessage> messages) {
        super(messages);
    }

    public List<WeChatOfficialOutputXmlMessage> messages(){
        //noinspection unchecked
        return (List<WeChatOfficialOutputXmlMessage>) this.getSource();
    }
}