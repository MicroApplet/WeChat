
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

package io.github.microapplet.wechat.official.remoting.autoreplay.meta;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.microapplet.wechat.remoting.context.BaseWeChatApiRes;
import lombok.*;


import java.io.Serializable;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class QueryCurrentAutoReplyInfoRes extends BaseWeChatApiRes implements Serializable {
    
    private static final long serialVersionUID = 769016887617555883L;

    @JsonProperty("add_friend_autoreply_info")
    private AddFriendAutoReplyInfo addFriendAutoreplyInfo;
    @JsonProperty("is_add_friend_reply_open")
    private Long isAddFriendReplyOpen;
    @JsonProperty("is_autoreply_open")
    private Long isAutoreplyOpen;
    @JsonProperty("keyword_autoreply_info")
    private KeywordAutoReplyInfo keywordAutoreplyInfo;
    @JsonProperty("message_default_autoreply_info")
    private MessageDefaultAutoReplyInfo messageDefaultAutoreplyInfo;
}