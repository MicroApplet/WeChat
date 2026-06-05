/*
 *    Copyright 2014-2025 <a href="mailto:asialjim@qq.com">Asial Jim</a>
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.asialjim.microapplet.wechat.applet.meta;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class WaterMark implements Serializable {
    @Serial
    private static final long serialVersionUID = 2737301286761641228L;
    /**
     * number	用户获取手机号操作的时间戳
     */
    private Long timestamp;
    /**
     * string	小程序appid
     */
    private String appid;
}
