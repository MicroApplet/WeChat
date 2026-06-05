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
import com.asialjim.microapplet.wechat.applet.analysis.request.*;
import com.asialjim.microapplet.wechat.applet.analysis.response.*;
import com.asialjim.microapplet.wechat.constant.WeChatCons;
import com.asialjim.microapplet.wechat.remoting.context.WeChatAccessTokenParam;

/**
 * 微信小程序数据分析相关服务API客户端
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/11/01, &nbsp;&nbsp; <em>version:1.0</em>
 */
@JsonResult
@Server(
        supplier = WeChatCons.Supplier.WECHAT,
        namespace = WeChatCons.Namespace.COMMON,
        schema = WeChatCons.Api.DEFAULT_SCHEMA,
        host = WeChatCons.Api.DEFAULT_HOST,
        port = WeChatCons.Api.DEFAULT_PORT
)
public interface WeChatAppletAnalysisRemoting {

    /**
     * 获取用户访问小程序周留存
     * <p>
     * 该接口用于获取用户访问小程序周留存
     * 官方文档：<a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/data-analysis/visit-retain/getWeeklyRetain.html">...</a>
     * <p>
     * 注意事项：请求必须按照自然周的方式输入，如：20170306(周一), 20170312(周日)
     *
     * @param weChatIndex 微信索引
     * @param req         获取周留存请求参数
     * @return {@link GetWeeklyRetainRes}
     * @since 2025/11/01
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/datacube/getweanalysisappidweeklyretaininfo")
    GetWeeklyRetainRes getWeeklyRetain(@WeChatAccessTokenParam String weChatIndex, @JsonBody GetWeeklyRetainReq req);

    /**
     * 获取用户访问小程序月留存
     * <p>
     * 该接口用于获取用户访问小程序月留存
     * 官方文档：<a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/data-analysis/visit-retain/getMonthlyRetain.html">...</a>
     * <p>
     * 注意事项：请求必须按照自然月的方式输入，如：20170201(月初), 20170228(月末)
     *
     * @param weChatIndex 微信索引
     * @param req         获取月留存请求参数
     * @return {@link GetMonthlyRetainRes}
     * @since 2025/11/01
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/datacube/getweanalysisappidmonthlyretaininfo")
    GetMonthlyRetainRes getMonthlyRetain(@WeChatAccessTokenParam String weChatIndex, @JsonBody GetMonthlyRetainReq req);

    /**
     * 获取用户访问小程序日留存
     * <p>
     * 该接口用于获取用户访问小程序日留存
     * 官方文档：<a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/data-analysis/visit-retain/getDailyRetain.html">...</a>
     * <p>
     * 注意事项：限定查询1天数据，允许设置的最大值为昨日
     *
     * @param weChatIndex 微信索引
     * @param req         获取日留存请求参数
     * @return {@link GetDailyRetainRes}
     * @since 2025/11/01
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/datacube/getweanalysisappiddailyretaininfo")
    GetDailyRetainRes getDailyRetain(@WeChatAccessTokenParam String weChatIndex, @JsonBody GetDailyRetainReq req);
    
    /**
     * 获取用户访问小程序数据周趋势
     * <p>
     * 该接口用于获取用户访问小程序数据周趋势
     * 官方文档：<a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/data-analysis/visit-trend/getWeeklyVisitTrend.html">...</a>
     * <p>
     * 注意事项：限定查询一个自然周的数据，时间必须按照自然周的方式输入，如：20170306(周一), 20170312(周日)
     *
     * @param weChatIndex 微信索引
     * @param req         获取周趋势请求参数
     * @return {@link GetWeeklyVisitTrendRes}
     * @since 2025/11/01
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/datacube/getweanalysisappidweeklyvisittrend")
    GetWeeklyVisitTrendRes getWeeklyVisitTrend(@WeChatAccessTokenParam String weChatIndex, @JsonBody GetWeeklyVisitTrendReq req);
    
    /**
     * 获取用户访问小程序数据月趋势
     * <p>
     * 该接口用于获取用户访问小程序数据月趋势(能查询到的最新数据为上一个自然月的数据)
     * 官方文档：<a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/data-analysis/visit-trend/getMonthlyVisitTrend.html">...</a>
     * <p>
     * 注意事项：限定查询一个自然月的数据，时间必须按照自然月的方式输入，如：20170301, 20170331
     *
     * @param weChatIndex 微信索引
     * @param req         获取月趋势请求参数
     * @return {@link GetMonthlyVisitTrendRes}
     * @since 2025/11/01
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/datacube/getweanalysisappidmonthlyvisittrend")
    GetMonthlyVisitTrendRes getMonthlyVisitTrend(@WeChatAccessTokenParam String weChatIndex, @JsonBody GetMonthlyVisitTrendReq req);
    
    /**
     * 获取用户访问小程序数据日趋势
     * <p>
     * 该接口用于获取用户访问小程序数据日趋势
     * 官方文档：<a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/data-analysis/visit-trend/getDailyVisitTrend.html">...</a>
     * <p>
     * 注意事项：限定查询1天数据，允许设置的最大值为昨日
     *
     * @param weChatIndex 微信索引
     * @param req         获取日趋势请求参数
     * @return {@link GetDailyVisitTrendRes}
     * @since 2025/11/01
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/datacube/getweanalysisappiddailyvisittrend")
    GetDailyVisitTrendRes getDailyVisitTrend(@WeChatAccessTokenParam String weChatIndex, @JsonBody GetDailyVisitTrendReq req);

    /**
     * 获取用户访问数据概况
     * <p>
     * 该接口用于获取用户访问数据概况
     * 官方文档：<a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/data-analysis/overview/getDailySummary.html">...</a>
     * <p>
     * 注意事项：只能获取最近30天的数据，单次查询时间跨度不超过7天
     *
     * @param weChatIndex 微信索引
     * @param req         获取数据概况请求参数
     * @return {@link GetDailySummaryRes}
     * @since 2025/11/01
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/datacube/getweanalysisappiddailysummarytrend")
    GetDailySummaryRes getDailySummary(@WeChatAccessTokenParam String weChatIndex, @JsonBody GetDailySummaryReq req);

    /**
     * 获取访问页面数据
     * <p>
     * 该接口用于获取访问页面数据
     * 官方文档：<a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/data-analysis/page-visit/getVisitPage.html">...</a>
     * <p>
     * 注意事项：时间范围最大7天
     *
     * @param weChatIndex 微信索引
     * @param req         获取访问页面请求参数
     * @return {@link GetVisitPageRes}
     * @since 2025/11/01
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/datacube/getweanalysisappidvisitpage")
    GetVisitPageRes getVisitPage(@WeChatAccessTokenParam String weChatIndex, @JsonBody GetVisitPageReq req);

    /**
     * 获取用户画像分布数据
     * <p>
     * 该接口用于获取用户画像分布数据
     * 官方文档：<a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/data-analysis/user-portrait/getUserPortrait.html">...</a>
     * <p>
     * 注意事项：时间范围最大7天
     *
     * @param weChatIndex 微信索引
     * @param req         获取用户画像请求参数
     * @return {@link GetUserPortraitRes}
     * @since 2025/11/01
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/datacube/getweanalysisappiduserportrait")
    GetUserPortraitRes getUserPortrait(@WeChatAccessTokenParam String weChatIndex, @JsonBody GetUserPortraitReq req);

    /**
     * 获取性能数据
     * <p>
     * 该接口用于获取性能数据
     * 官方文档：<a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/data-analysis/performance/getPerformanceData.html">...</a>
     * <p>
     * 注意事项：只能查询最近30天的数据，单次查询时间跨度不超过7天
     *
     * @param weChatIndex 微信索引
     * @param req         获取性能数据请求参数
     * @return {@link GetPerformanceDataRes}
     * @since 2025/11/01
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/datacube/getweanalysisappidperformance")
    GetPerformanceDataRes getPerformanceData(@WeChatAccessTokenParam String weChatIndex, @JsonBody GetPerformanceDataReq req);

    /**
     * 获取访问分布数据
     * <p>
     * 该接口用于获取访问分布数据
     * 官方文档：<a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/data-analysis/visit-distribution/getVisitDistribution.html">...</a>
     * <p>
     * 注意事项：时间范围最大7天
     *
     * @param weChatIndex 微信索引
     * @param req         获取访问分布请求参数
     * @return {@link GetVisitDistributionRes}
     * @since 2025/11/01
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/datacube/getweanalysisappidvisitdistribution")
    GetVisitDistributionRes getVisitDistribution(@WeChatAccessTokenParam String weChatIndex, @JsonBody GetVisitDistributionReq req);
}