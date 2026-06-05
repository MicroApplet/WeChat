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

package com.asialjim.microapplet.wechat.applet.qrcode.request;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

/**
 * 获取无限量小程序码请求参数
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/10/30, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Data
@Accessors(chain = true)
public class GetWxaCodeUnlimitRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = -2345678901234567890L;

    /**
     * 最大32个可见字符，只支持数字，大小写英文以及部分特殊字符
     * !#$&'()*+,/:;=?@-._~，其它字符请自行编码为合法字符（因不支持%，中文无法使用 urlencode 处理，请使用其他编码方式）
     */
    private String scene;

    /**
     * 页面路径，例如 pages/index/index
     */
    private String page;

    /**
     * 二维码宽度，单位px，最小280px，最大1280px
     */
    private Integer width = 430;

    /**
     * 自动配置线条颜色，如果颜色依然是黑色，则说明不建议配置主色调
     */
    private Boolean autoColor = false;

    /**
     * 线条颜色配置
     */
    private LineColor lineColor;

    /**
     * 是否需要透明底色，为true时，生成透明底色的小程序码
     */
    private Boolean isHyaline = false;

    /**
     * 要打开的小程序版本。正式版为"release"，体验版为"trial"，开发版为"develop"
     */
    private String envVersion;
}