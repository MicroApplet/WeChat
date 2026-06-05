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

package com.asialjim.microapplet.wechat.applet.analysis.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 时间范围参数
 *
 * @author <a href="mailto:asialjim@qq.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/10/31, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Data
public class Time implements Serializable {
    /**
     * 开始日期时间戳
     */
    private Long begin_timestamp;

    /**
     * 结束日期时间戳
     */
    private Long end_timestamp;
}