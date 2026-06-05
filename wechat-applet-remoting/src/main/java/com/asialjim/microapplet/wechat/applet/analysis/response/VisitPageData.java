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
 * 访问页面数据项
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/11/01, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Data
public class VisitPageData implements Serializable {
    /**
     * 页面路径
     */
    private String page_path;

    /**
     * 页面标题
     */
    private String page_visit_pv;

    /**
     * 访问次数
     */
    private Integer page_visit_uv;

    /**
     * 访问人数
     */
    private Integer page_staytime_pv;

    /**
     * 次均停留时长
     */
    private Double entrypage_ratio;

    /**
     * 进入页次数占比
     */
    private Double exitpage_ratio;

    /**
     * 退出页次数占比
     */
    private Double page_share_pv;

    /**
     * 分享次数
     */
    private Double page_share_uv;

    /**
     * 分享人数
     */
    private String page_title;
}