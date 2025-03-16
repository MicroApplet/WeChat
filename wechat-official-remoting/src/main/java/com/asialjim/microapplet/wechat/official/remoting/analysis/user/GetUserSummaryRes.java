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

package com.asialjim.microapplet.wechat.official.remoting.analysis.user;

import com.asialjim.microapplet.wechat.remoting.context.BaseWeChatApiRes;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;
import java.util.Objects;

/**
 * Get User Summary Res
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0.0
 * @since 2024/3/1, &nbsp;&nbsp; <em>version:1.0.0</em>
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class GetUserSummaryRes extends BaseWeChatApiRes {


    private static final long serialVersionUID = 1784542836215056652L;
    private List<GetUserSummaryData> list;

    @Data
    public static class GetUserSummaryData {

        @JsonProperty("ref_date")
        private String refDate;

        @JsonProperty("user_source")
        private Integer userSource;

        @JsonProperty("new_user")
        private Long newUser;

        @JsonProperty("cancel_user")
        private Long cancelUser;

        @SuppressWarnings("unused")
        public String userSourceContent() {
            if (Objects.isNull(this.userSource))
                throw new IllegalStateException("Unexpected value: " + this.userSource);

            switch (this.userSource) {
                case 0:
                    return "代表其他合计";
                case 1:
                    return "代表公众号搜索";
                case 17:
                    return "代表名片分享";
                case 30:
                    return "代表扫描二维码";
                case 57:
                    return "代表文章内账号名称";
                case 100:
                    return "代表微信广告";
                case 161:
                    return "代表他人转载";
                case 149:
                    return "代表小程序关注";
                case 200:
                    return "代表视频号";
                case 201:
                    return "代表直播";
                default:
                    throw new IllegalStateException("Unexpected value: " + this.userSource);
            }
        }
    }
}