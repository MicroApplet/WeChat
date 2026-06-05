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

package com.asialjim.microapplet.wechat.applet.url.request;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 查询小程序scheme码请求参数
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/10/30
 */
@Data
@Accessors(chain = true)
public class QuerySchemeRequest {
    
    /**
     * 小程序scheme码。支持加密scheme和明文scheme
     */
    private String scheme;
    
    /**
     * 查询类型。默认值0，查询scheme码信息：0，查询每天剩余访问次数：1
     */
    private Integer queryType = 0;
}