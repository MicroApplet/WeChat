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

// CPSGeneralRes.java

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

package io.github.microapplet.wechat.official.remoting.analysis.ad;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CpsGeneralRes implements Serializable {
    private static final long serialVersionUID = 6284218482197611096L;

    private Summary summary;
    private BaseResp baseResp;
    private Long totalNum;
    private List<Summary> list;

    @Data
    public static class Summary {
        private String date;
        private Long orderCount;
        private Long totalCommission;
        private Double orderRate;
        private Long exposureCount;
        private Double clickRate;
        private Long totalFee;
        private Long clickCount;
    }
}