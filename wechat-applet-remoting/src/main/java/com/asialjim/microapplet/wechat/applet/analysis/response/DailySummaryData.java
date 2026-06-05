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

package com.asialjim.microapplet.wechat.applet.analysis.response;

import lombok.Data;

import java.io.Serializable;

/**
 * 数据概况数据项
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/11/01, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Data
public class DailySummaryData implements Serializable {
    /**
     * 日期，如："20170306"
     */
    private String ref_date;

    /**
     * 累计用户数
     */
    private Integer visit_total;

    /**
     * 新增用户数
     */
    private Integer visit_pv;

    /**
     * 访问次数
     */
    private Integer visit_uv;

    /**
     * 转发次数
     */
    private Integer share_pv;

    /**
     * 转发人数
     */
    private Integer share_uv;

    /**
     * 访问人数
     */
    private Integer stay_time_uv;

    /**
     * 人均停留时长
     */
    private Integer stay_time_session;

    /**
     * 次均停留时长
     */
    private Double visit_depth;
}