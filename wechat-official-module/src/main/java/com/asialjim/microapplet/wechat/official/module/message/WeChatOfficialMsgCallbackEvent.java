/*
 *    Copyright 2014-2025 <a href="mailto:asialjim@qq.com">Asial Jim</a>
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.asialjim.microapplet.wechat.official.module.message;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.TextNode;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;

/**
 * 消息回调事件
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/9/25, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Data
@Accessors(chain = true)
public class WeChatOfficialMsgCallbackEvent implements Serializable {

    @Serial
    private static final long serialVersionUID = -2944465643702015617L;

    String appid;
    String signature;
    String timestamp;
    String nonce;
    String openid;
    String encrypt_type;
    String msg_signature;
    String sourceXml;
    String decryptXml;
    JsonNode msgNode;

    String msgType;
    String event;
    String eventKey;

    public WeChatOfficialMsgCallbackEvent init() {
        this.msgType = nodeTextValue("MsgType");
        this.event = nodeTextValue("Event");
        this.eventKey = nodeTextValue("EventKey");
        return this;
    }

    public boolean isEvent(){
        return StringUtils.isNotBlank(this.event);
    }

    public String nodeTextValue(String key) {
        return Optional.ofNullable(this.msgNode)
                .filter(item -> item.hasNonNull(key))
                .map(item -> item.get(key))
                .map(JsonNode::asText)
                .orElse(StringUtils.EMPTY);
    }

    public JsonNode nodeOf(String key){
        return Optional.ofNullable(this.msgNode)
                .filter(item -> item.hasNonNull(key))
                .map(item -> item.get(key))
                .orElse(NullNode.instance);
    }
}