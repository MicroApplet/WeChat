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

package io.github.microapplet.wechat.applet.opendata;

import lombok.Data;

import java.io.Serializable;

/**
 * 解密后的开放数据
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/2/27, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Data
public class DecryptedOpenData implements Serializable {
    private static final long serialVersionUID = 8735489146056402179L;

    /**
     * 水印
     */
    private WaterMark waterMark;

    /* ----手机号----*/
    private String phoneNumber;
    private String purePhoneNumber;
    private String countryCode;
    /* ----手机号----*/

    /* ----用户信息----*/
    private String openId;
    private String nickName;
    private Integer gender;
    private String city;
    private String province;
    private String country;
    private String avatarUrl;
    private String unionId;
    /* ----用户信息----*/
}