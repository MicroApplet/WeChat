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
package io.github.microapplet.wechat.official.remoting.qrcode.meta;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

/**
 * 创建微信公众号二维码
 * @author Copyright © <a href="mailto:asialjim@hotmail.com">Asial Jim</a>   Co., LTD
 * @version 1.0
 * @since 2022/2/23   &nbsp;&nbsp; JDK 8
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateQrCodeRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = -2542154974298361660L;

    @JsonProperty("expire_seconds")
    private Integer expireSeconds;

    @JsonProperty("action_name")
    private String actionName;

    @JsonProperty("action_info")
    private ActionInfo actionInfo;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ActionInfo implements Serializable{
        @Serial
        private static final long serialVersionUID = 2604520375906633214L;
        private Scene scene;
    }

    @Data
    public static class Scene implements Serializable {
        @Serial
        private static final long serialVersionUID = -7353280290065769354L;

        @JsonProperty("scene_str")
        private String sceneStr;

        @JsonProperty("scene_id")
        private Integer sceneId;
    }
}
