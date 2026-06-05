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

package com.asialjim.microapplet.wechat.applet.analysis;

import com.asialjim.microapplet.remote.http.annotation.HttpMapping;
import com.asialjim.microapplet.remote.http.annotation.HttpMethod;
import com.asialjim.microapplet.remote.http.annotation.body.JsonBody;
import com.asialjim.microapplet.remote.net.annotation.Server;
import com.asialjim.microapplet.remote.net.response.JsonResult;
import com.asialjim.microapplet.wechat.constant.WeChatCons;
import com.asialjim.microapplet.wechat.remoting.context.BaseWeChatApiRes;
import com.asialjim.microapplet.wechat.remoting.context.WeChatAccessTokenParam;
import com.asialjim.microapplet.wechat.applet.analysis.request.GetDailySummaryReq;
import com.asialjim.microapplet.wechat.applet.analysis.request.GetVisitPageReq;
import com.asialjim.microapplet.wechat.applet.analysis.request.GetUserPortraitReq;
import com.asialjim.microapplet.wechat.applet.analysis.request.GetPerformanceDataReq;
import com.asialjim.microapplet.wechat.applet.analysis.request.GetVisitDistributionReq;
import com.asialjim.microapplet.wechat.applet.analysis.response.GetDailySummaryRes;
import com.asialjim.microapplet.wechat.applet.analysis.response.GetVisitPageRes;
import com.asialjim.microapplet.wechat.applet.analysis.response.GetUserPortraitRes;
import com.asialjim.microapplet.wechat.applet.analysis.response.GetPerformanceDataRes;
import com.asialjim.microapplet.wechat.applet.analysis.response.GetVisitDistributionRes;

import java.util.List;

/**
 * 微信小程序其他数据分析相关服务API客户端
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/11/01, &nbsp;&nbsp; <em>version:1.0</em>
 */
@JsonResult
@Server(supplier = WeChatCons.Supplier.WECHAT, namespace = WeChatCons.Namespace.COMMON, schema = WeChatCons.Api.DEFAULT_SCHEMA, host = WeChatCons.Api.DEFAULT_HOST, port = WeChatCons.Api.DEFAULT_PORT)
public interface WeChatAppletOtherAnalysisRemoting {

    /**
     * 获取用户访问小程序数据概况
     * <p>
     * 该接口用于获取用户访问小程序数据概况
     * 官方文档：<a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/data-analysis/others/getDailySummary.html">...</a>
     * <p>
     * 注意事项：限定查询1天数据，允许设置的最大值为昨日
     *
     * @param weChatIndex 微信索引
     * @param req         获取日概况请求参数
     * @return {@link GetDailySummaryRes}
     * @since 2025/11/01
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/datacube/getweanalysisappiddailysummarytrend")
    GetDailySummaryRes getDailySummary(@WeChatAccessTokenParam String weChatIndex, @JsonBody GetDailySummaryReq req);

    /**
     * 获取访问页面数据
     * <p>
     * 该接口用于获取访问页面数据，目前只提供按 page_visit_pv 排序的 top200
     * 官方文档：<a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/data-analysis/others/getVisitPage.html">...</a>
     * <p>
     * 注意事项：限定查询1天数据，允许设置的最大值为昨日
     *
     * @param weChatIndex 微信索引
     * @param req         获取访问页面请求参数
     * @return {@link GetVisitPageRes}
     * @since 2025/11/01
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/datacube/getweanalysisappidvisitpage")
    GetVisitPageRes getVisitPage(@WeChatAccessTokenParam String weChatIndex, @JsonBody GetVisitPageReq req);

    /**
     * 获取小程序用户画像分布
     * <p>
     * 该接口用于获取小程序新增或活跃用户的画像分布数据
     * 官方文档：<a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/data-analysis/others/getUserPortrait.html">...</a>
     * <p>
     * 注意事项：时间范围支持昨天、最近7天、最近30天。开始日期与结束日期相差的天数限定为0/6/29，分别表示查询最近1/7/30天数据
     *
     * @param weChatIndex 微信索引
     * @param req         获取用户画像请求参数
     * @return {@link GetUserPortraitRes}
     * @since 2025/11/01
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/datacube/getweanalysisappiduserportrait")
    GetUserPortraitRes getUserPortrait(@WeChatAccessTokenParam String weChatIndex, @JsonBody GetUserPortraitReq req);

    /**
     * 获取小程序性能数据
     * <p>
     * 该接口用于获取小程序启动性能，运行性能等数据
     * 官方文档：<a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/data-analysis/others/getPerformanceData.html">...</a>
     * <p>
     * 注意事项：时间跨度不能超过30天
     *
     * @param weChatIndex 微信索引
     * @param req         获取性能数据请求参数
     * @return {@link GetPerformanceDataRes}
     * @since 2025/11/01
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxa/business/getperformance")
    GetPerformanceDataRes getPerformanceData(@WeChatAccessTokenParam String weChatIndex, @JsonBody GetPerformanceDataReq req);

    /**
     * 获取用户小程序访问分布数据
     * <p>
     * 该接口用于获取用户小程序访问分布数据
     * 官方文档：<a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/data-analysis/others/getVisitDistribution.html">...</a>
     * <p>
     * 注意事项：限定查询1天数据，允许设置的最大值为昨日
     *
     * @param weChatIndex 微信索引
     * @param req         获取访问分布请求参数
     * @return {@link GetVisitDistributionRes}
     * @since 2025/11/01
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/datacube/getweanalysisappidvisitdistribution")
    GetVisitDistributionRes getVisitDistribution(@WeChatAccessTokenParam String weChatIndex, @JsonBody GetVisitDistributionReq req);


}