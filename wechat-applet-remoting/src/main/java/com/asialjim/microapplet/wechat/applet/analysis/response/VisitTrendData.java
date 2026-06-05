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
 * 访问趋势数据项
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/11/01, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Data
public class VisitTrendData implements Serializable {
    /**
     * 时间，如："20170306"
     */
    private String ref_date;

    /**
     * 会话数
     */
    private Integer session_cnt;

    /**
     * 访问次数
     */
    private Integer visit_pv;

    /**
     * 访问人数
     */
    private Integer visit_uv;

    /**
     * 新用户数
     */
    private Integer visit_uv_new;

    /**
     * 人均停留时长(单位：秒)
     */
    private Integer stay_time_uv;

    /**
     * 次均停留时长(单位：秒)
     */
    private Integer stay_time_session;

    /**
     * 平均访问深度
     */
    private Double visit_depth;
}