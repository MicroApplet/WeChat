
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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KeywordAutoReplyItem {

    private String author;
    @JsonProperty("content_url")
    private String contentUrl;
    @JsonProperty("cover_url")
    private String coverUrl;
    @JsonProperty("create_time")
    private Long createTime;
    private String digest;
    @JsonProperty("keyword_list_info")
    private java.util.List<KeywordListInfo> keywordListInfo;
    @JsonProperty("reply_list_info")
    private java.util.List<ReplyListInfo> replyListInfo;
    @JsonProperty("reply_mode")
    private String replyMode;
    @JsonProperty("rule_name")
    private String ruleName;
    @JsonProperty("show_cover")
    private Long showCover;
    @JsonProperty("source_url")
    private String sourceUrl;
    private String title;
}
