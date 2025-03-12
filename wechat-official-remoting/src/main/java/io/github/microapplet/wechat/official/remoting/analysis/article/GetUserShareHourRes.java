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

package io.github.microapplet.wechat.official.remoting.analysis.article;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.microapplet.wechat.remoting.context.BaseWeChatApiRes;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


import java.util.List;

/**
 * Get User Share Hour Response
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0.0
 * @since 2024/3/1, &nbsp;&nbsp; <em>version:1.0.0</em>
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class GetUserShareHourRes extends BaseWeChatApiRes {
    
    private static final long serialVersionUID = -7242969103221394382L;
    private List<GetUserShareHourData> list;

    @Data
    public static class GetUserShareHourData{
        @JsonProperty("ref_date")
        private String refDate;
        @JsonProperty("ref_hour")
        private Long refHour;
        @JsonProperty("share_scene")
        private Long shareScene;
        @JsonProperty("share_count")
        private Long shareCount;
        @JsonProperty("share_user")
        private Long shareUser;
    }
}