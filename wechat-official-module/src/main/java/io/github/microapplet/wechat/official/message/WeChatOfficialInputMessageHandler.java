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

package io.github.microapplet.wechat.official.message;

/**
 * 微信公众号被动消息回复处理器
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0.0
 * @since 2024 04 09, &nbsp;&nbsp; <em>version:1.0.0</em>
 */
public interface WeChatOfficialInputMessageHandler {

    /**
     * 处理微信公众号消息
     *
     * @param xmlMessage {@link WeChatOfficialInputXmlMessage xmlMessage}
     * @return {@link WeChatOfficialOutputXmlMessage }
     * @since 2024 04 09
     */
    default WeChatOfficialOutputXmlMessage handle(WeChatOfficialInputXmlMessage xmlMessage) {
        boolean support = support(xmlMessage);
        if (Boolean.FALSE.equals(support))
            return null;

        return doHandle(xmlMessage);
    }

    /**
     * 判断处理器是否支持消息
     */
    boolean support(WeChatOfficialInputXmlMessage xmlMessage);

    /**
     * 执行消息处理,并响应结果
     */
    WeChatOfficialOutputXmlMessage doHandle(WeChatOfficialInputXmlMessage xmlMessage);
}