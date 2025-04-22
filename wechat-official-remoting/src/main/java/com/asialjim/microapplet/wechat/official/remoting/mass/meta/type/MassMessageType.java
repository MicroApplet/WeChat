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

package com.asialjim.microapplet.wechat.official.remoting.mass.meta.type;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public interface MassMessageType {
    String
            MPNEWS = "mpnews",
            TEXT = "text",
            IMAGE = "image",
            VOICE = "voice",
            VIDEO = "mpvideo",
            WX_CARD = "wxcard";


    String getMsgtype();


    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    class Filter {
        private Boolean is_to_all = false;
        private Integer tag_id;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    class MpNews {
        private String media_id;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    class Text {
        private String content;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    class Voice {
        private String media_id;
    }


    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    class Image {
        private List<String> media_ids;
        private String recommend;
        private Integer need_open_comment = 1;
        private Integer only_fans_can_comment = 0;
    }


    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    class Video {
        private String media_iD;
        private String title;
        private String description;
    }


    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    class WxCard {
        private String card_id;
        private Ext card_ext;

    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    class Ext{
        private String code;
        private String openid;
        private String timestamp;
        private String signature;
    }
}