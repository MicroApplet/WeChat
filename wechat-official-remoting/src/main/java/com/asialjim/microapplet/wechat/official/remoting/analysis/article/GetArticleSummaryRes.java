/*
 * Copyright 2014-2025 <a href="mailto:asialjim@qq.com">Asial Jim</a>
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

package com.asialjim.microapplet.wechat.official.remoting.analysis.article;

import com.asialjim.microapplet.wechat.remoting.context.BaseWeChatApiRes;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

/**
 * Get Articles Summary Req
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0.0
 * @since 2024/3/1, &nbsp;&nbsp; <em>version:1.0.0</em>
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class GetArticleSummaryRes extends BaseWeChatApiRes {


    private static final long serialVersionUID = 7274042969730503581L;
    private List<GetArticleSummaryData> list;

    @Data
    public static class GetArticleSummaryData{
        @JsonProperty("ref_date")
        private String refDate;
        @JsonProperty("msgid")
        private String msgId;
        private String title;
        @JsonProperty("int_page_read_user")
        private Long intPageReadUser;
        @JsonProperty("int_page_read_count")
        private Long intPageReadCount;
        @JsonProperty("ori_page_read_user")
        private Long oriPageReadUser;
        @JsonProperty("ori_page_read_count")
        private Long oriPageReadCount;
        @JsonProperty("share_user")
        private Long shareUser;
        @JsonProperty("share_count")
        private Long shareCount;
        @JsonProperty("add_to_fav_user")
        private Long addToFavUser;
        @JsonProperty("add_to_fav_count")
        private Long addToFavCount;
    }
}