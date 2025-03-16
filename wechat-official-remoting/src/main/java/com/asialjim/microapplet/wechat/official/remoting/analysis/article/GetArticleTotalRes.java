/*
 *  Copyright 2014-2025 <a href="mailto:asialjim@qq.com">Asial Jim</a>
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.asialjim.microapplet.wechat.official.remoting.analysis.article;

import com.asialjim.microapplet.wechat.remoting.context.BaseWeChatApiRes;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

/**
 * Get Articles Total API Res
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0.0
 * @since 2024/3/1, &nbsp;&nbsp; <em>version:1.0.0</em>
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class GetArticleTotalRes extends BaseWeChatApiRes {
    
    private static final long serialVersionUID = 8213811032573016019L;
    private List<GetArticleTotalData> list;

    @Data
    public static class GetArticleTotalData {
        @JsonProperty("ref_date")
        private String refDate;
        private String msgid;
        private String title;
        private List<GetArticleTotalDetail> details;
    }

    @Data
    public static class GetArticleTotalDetail {
        @JsonProperty("stat_date")
        private String statDate;
        @JsonProperty("target_user")
        private Long targetUser;
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
        @JsonProperty("int_page_from_session_read_user")
        private Long intPageFromSessionReadUser;
        @JsonProperty("int_page_from_session_read_count")
        private Long intPageFromSessionReadCount;
        @JsonProperty("int_page_from_hist_msg_read_user")
        private Long intPageFromHistMsgReadUser;
        @JsonProperty("int_page_from_hist_msg_read_count")
        private Long intPageFromHistMsgReadCount;
        @JsonProperty("int_page_from_feed_read_user")
        private Long intPageFromFeedReadUser;
        @JsonProperty("int_page_from_feed_read_count")
        private Long intPageFromFeedReadCount;
        @JsonProperty("int_page_from_friends_read_user")
        private Long intPageFromFriendsReadUser;
        @JsonProperty("int_page_from_friends_read_count")
        private Long intPageFromFriendsReadCount;
        @JsonProperty("int_page_from_other_read_user")
        private Long intPageFromOtherReadUser;
        @JsonProperty("int_page_from_other_read_count")
        private Long intPageFromOtherReadCount;
        @JsonProperty("feed_share_from_session_user")
        private Long feedShareFromSessionUser;
        @JsonProperty("feed_share_from_session_cnt")
        private Long feedShareFromSessionCnt;
        @JsonProperty("feed_share_from_feed_user")
        private Long feedShareFromFeedUser;
        @JsonProperty("feed_share_from_feed_cnt")
        private Long feedShareFromFeedCnt;
        @JsonProperty("feed_share_from_other_user")
        private Long feedShareFromOtherUser;
        @JsonProperty("feed_share_from_other_cnt")
        private Long feedShareFromOtherCnt;
    }
}