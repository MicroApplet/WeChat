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
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * 获取性能数据请求参数
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/11/01, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Data
@Accessors(chain = true)
public class GetPerformanceDataReq implements Serializable {
    /**
     * 查询数据的类型
     * 10016：打开率
     * 10017：启动各阶段耗时
     * 10021：页面切换耗时
     * 10022：内存指标
     * 10023：内存异常
     */
    private Integer module;

    /**
     * 开始和结束日期的时间戳，时间跨度不能超过30天
     */
    private Time time;

    /**
     * 查询条件，比如机型，网络类型等等
     */
    private List<Param> params;
    
    /**
     * 开始时间。格式为 yyyymmdd
     */
    private String begin_date;

    /**
     * 结束时间，限定查询时间跨度为7天。格式为 yyyymmdd
     */
    private String end_date;
}