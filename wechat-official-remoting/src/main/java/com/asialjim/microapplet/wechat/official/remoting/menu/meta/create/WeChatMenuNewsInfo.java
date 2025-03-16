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

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class WeChatMenuNewsInfo implements Serializable {
    
    private static final long serialVersionUID = -3495808090127737414L;
	
	/**
     * 图文元素
     */
    private List<Info> list;

    /**
     * 图文信息
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Info{
        private String title;
        private String author;
        private String digest;
        @JsonProperty("show_cover")
        private Integer showCover;
        @JsonProperty("cover_url")
        private String coverUrl;
        @JsonProperty("content_url")
        private String contentUrl;
        @JsonProperty("source_url")
        private String sourceUrl;
    }
}
