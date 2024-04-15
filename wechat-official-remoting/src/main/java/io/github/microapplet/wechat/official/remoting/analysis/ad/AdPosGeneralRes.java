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

// AdPosGeneralRes.java

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

package io.github.microapplet.wechat.official.remoting.analysis.ad;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;
import java.io.Serializable;
import java.util.List;

@Data
public class AdPosGeneralRes implements Serializable {

    private static final long serialVersionUID = 2412578314643092608L;
    private Summary summary;
    @JsonProperty("base_resp")
    private BaseResp baseResp;
    @JsonProperty("total_num")
    private Long totalNum;
    private List<ListElement> list;

    @Data
    public static class ListElement {
        private LocalDate date;
        @JsonProperty("req_succ_count")
        private Long reqSuccCount;
        private Long income;
        private Double ecpm;
        private Long slotid;
        @JsonProperty("exposure_count")
        private Long exposureCount;
        @JsonProperty("click_rate")
        private Double clickRate;

        @JsonProperty("click_count")
        private Long clickCount;
        @JsonProperty("ad_slot")
        private String adSlot;
        @JsonProperty("exposure_rate")
        private Double exposureRate;
    }


    @Data
    public static class Summary {
        @JsonProperty("req_succ_count")
        private Long reqSuccCount;
        private Long income;
        private Double ecpm;
        @JsonProperty("exposure_count")
        private Long exposureCount;
        @JsonProperty("click_rate")
        private Double clickRate;
        @JsonProperty("click_count")
        private Long clickCount;
        @JsonProperty("exposure_rate")
        private Double exposureRate;
    }
}