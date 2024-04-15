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

package io.github.microapplet.wechat.official.remoting.card.meta;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @since 2024 04 15, &nbsp;&nbsp; <em>version:</em>
 */
@Accessors(chain = true)
@Data(staticConstructor = "create")
public class BaseInfo {
    private Long useLimit;
    private String centerurl;
    private String color;
    private String logourl;
    private String description;
    private Boolean canGiveFriend;
    private List<Long> locationidList;
    private String source;
    private String title;
    private Boolean useCustomCode;
    private String customurlSubTitle;
    private Boolean bindOpenid;
    private Sku sku;
    private String codeType;
    private String notice;
    private String customurl;
    private String centerSubTitle;
    private Long getLimit;
    private String centerTitle;
    private String customurlName;
    private String promotionurlName;
    private Boolean canShare;
    private String brandName;
    private String servicePhone;
    private String promotionurl;
    private DateInfo dateInfo;

}
