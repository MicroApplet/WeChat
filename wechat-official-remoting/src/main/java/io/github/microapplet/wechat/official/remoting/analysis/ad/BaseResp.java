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

package io.github.microapplet.wechat.official.remoting.analysis.ad;

import lombok.Data;

import java.io.Serializable;

/**
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @since 2024 04 15, &nbsp;&nbsp; <em>version:</em>
 */
@Data
public class BaseResp implements Serializable {
    private static final long serialVersionUID = 4481376679904452902L;

    private Long ret;
    private String errMsg;
}