/*
 * Copyright 2014-2024 <a href="mailto:asialjim@qq.com">Asial Jim</a>
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
package com.asialjim.microapplet.wechat.official.remoting.datacube.meta;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

/**
 * 获取被动回复分布数据请求参数
 * <p>
 * 参考文档: <a href="https://developers.weixin.qq.com/doc/subscription/api/wedata/api/api_getinterfacesummaryhour.html">获取被动回复分布数据</a>
 * </p>
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2024-10-31, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Data
@Accessors(chain = true)
public class GetInterfaceSummaryHourReq implements Serializable {

    @Serial
    private static final long serialVersionUID = -45678901L;

    /**
     * 起始日期（格式：yyyy-MM-dd）
     */
    private String begin_date;

    /**
     * 结束日期（格式：yyyy-MM-dd），最大时间跨度为1天
     */
    private String end_date;
}