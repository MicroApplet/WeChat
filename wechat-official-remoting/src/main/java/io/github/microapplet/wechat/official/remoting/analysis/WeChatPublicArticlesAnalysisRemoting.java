/*
 * Copyright 2014-2024 <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
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

package io.github.microapplet.wechat.official.remoting.analysis;

import io.github.microapplet.remote.http.annotation.HttpMapping;
import io.github.microapplet.remote.http.annotation.HttpMethod;
import io.github.microapplet.remote.http.annotation.body.JsonBody;
import io.github.microapplet.remote.net.annotation.Server;
import io.github.microapplet.wechat.constant.WeChatCons;
import io.github.microapplet.wechat.official.remoting.analysis.article.*;
import io.github.microapplet.wechat.remoting.context.WeChatAccessTokenParam;

/**
 * <pre>
 * 图文分析
 * 向所有认证公众号开发者开放数据接口。通过数据接口，开发者可以获取与公众平台官网统计模块类似但更灵活的数据，还可根据需要进行高级处理。
 *
 * 在公众号登录授权机制的权限集划分中，图文分析数据接口属于群发与通知权限。
 *
 * 请注意：
 *
 * 接口侧的公众号数据的数据库中仅存储了2014年12月1日之后的数据，将查询不到在此之前的日期，即使有查到，也是不可信的脏数据；
 * 请开发者在调用接口获取数据后，将数据保存在自身数据库中，即加快下次用户的访问速度，也降低了微信侧接口调用的不必要损耗。
 * 额外注意，获取图文群发每日数据接口的结果中，只有中间页阅读人数+原文页阅读人数+分享转发人数+分享转发次数+收藏次数 >=3的结果才会得到统计，过小的阅读量的图文消息无法统计。
 * 为确保公众号数据已完成统计和处理，请于每天上午8点后查询公众号前一天的数据。
 * 2020年2月28日起，获取图文统计数据（getuserread）、图文统计分时数据（getuserreadhour）数据接口的结果中，中间页阅读、分享统一提供user_source字段，用于区分<传播渠道>与<全部>数据，详见参数说明；额外注意，原文页阅读、收藏，只在图文统计数据（getuserread）中提供，并只提供<全部>数据。
 * </pre>
 * Articles Analysis API Remoting
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0.0
 * @since 2024/3/1, &nbsp;&nbsp; <em>version:1.0.0</em>
 */
@SuppressWarnings("unused")
@Server(
        supplier = WeChatCons.Supplier.WECHAT,
        namespace = WeChatCons.Namespace.COMMON,
        schema = WeChatCons.Api.DEFAULT_SCHEMA,
        host = WeChatCons.Api.DEFAULT_HOST,
        port = WeChatCons.Api.DEFAULT_PORT
)
public interface WeChatPublicArticlesAnalysisRemoting {

    /**
     * 获取图文群发每日数据
     *
     * @param weChatIndexOrAccessToken {@link String weChatIndexOrAccessToken}
     * @param body                     {@link ArticlesAnalysisReq body}
     * @return {@link GetArticleSummaryRes }
     * @since 2024/3/1
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/datacube/getarticlesummary")
    GetArticleSummaryRes articleSummary(@WeChatAccessTokenParam String weChatIndexOrAccessToken, @JsonBody ArticlesAnalysisReq body);

    /**
     * 获取图文群发总数据
     *
     * @param weChatIndexOrAccessToken {@link java.lang.String weChatIndexOrAccessToken}
     * @param body                     {@link ArticlesAnalysisReq body}
     * @return {@link GetArticleTotalRes }
     * @since 2024/3/1
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/datacube/getarticletotal")
    GetArticleTotalRes articleTotal(@WeChatAccessTokenParam String weChatIndexOrAccessToken, @JsonBody ArticlesAnalysisReq body);

    /**
     * 获取图文统计数据
     *
     * @param weChatIndexOrAccessToken {@link String weChatIndexOrAccessToken}
     * @param body                     {@link ArticlesAnalysisReq body}
     * @return {@link GetUserReadRes }
     * @since 2024/3/1
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/datacube/getuserread")
    GetUserReadRes userRead(@WeChatAccessTokenParam String weChatIndexOrAccessToken, @JsonBody ArticlesAnalysisReq body);

    /**
     * 获取图文统计分时数据
     *
     * @param weChatIndexOrAccessToken {@link String weChatIndexOrAccessToken}
     * @param body                     {@link ArticlesAnalysisReq body}
     * @return {@link GetUserReadHourRes }
     * @since 2024/3/1
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/datacube/getuserreadhour")
    GetUserReadHourRes userReadHour(@WeChatAccessTokenParam String weChatIndexOrAccessToken, @JsonBody ArticlesAnalysisReq body);

    /**
     * 获取图文分享转发数据
     *
     * @param weChatIndexOrAccessToken {@link String weChatIndexOrAccessToken}
     * @param body                     {@link ArticlesAnalysisReq body}
     * @return {@link GetUserShareRes }
     * @since 2024/3/1
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/datacube/getusershare")
    GetUserShareRes userShare(@WeChatAccessTokenParam String weChatIndexOrAccessToken, @JsonBody ArticlesAnalysisReq body);

    /**
     * 获取图文分享转发分时数据
     *
     * @param weChatIndexOrAccessToken {@link String weChatIndexOrAccessToken}
     * @param body                     {@link ArticlesAnalysisReq body}
     * @return {@link GetUserShareHourRes }
     * @since 2024/3/1
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/datacube/getusersharehour")
    GetUserShareHourRes userShareHour(@WeChatAccessTokenParam String weChatIndexOrAccessToken, @JsonBody ArticlesAnalysisReq body);
}