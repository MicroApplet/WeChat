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
package com.asialjim.microapplet.wechat.official.remoting.datacube;

import com.asialjim.microapplet.remote.http.annotation.HttpMapping;
import com.asialjim.microapplet.remote.http.annotation.HttpMethod;
import com.asialjim.microapplet.remote.http.annotation.body.JsonBody;
import com.asialjim.microapplet.remote.net.annotation.Server;
import com.asialjim.microapplet.wechat.constant.WeChatCons;
import com.asialjim.microapplet.wechat.remoting.context.WeChatAccessTokenParam;
import com.asialjim.microapplet.wechat.official.remoting.datacube.meta.GetInterfaceSummaryReq;
import com.asialjim.microapplet.wechat.official.remoting.datacube.meta.GetInterfaceSummaryRes;
import com.asialjim.microapplet.wechat.official.remoting.datacube.meta.GetInterfaceSummaryHourReq;
import com.asialjim.microapplet.wechat.official.remoting.datacube.meta.GetInterfaceSummaryHourRes;
import com.asialjim.microapplet.wechat.official.remoting.datacube.meta.GetUpstreamMsgDistReq;
import com.asialjim.microapplet.wechat.official.remoting.datacube.meta.GetUpstreamMsgDistRes;
import com.asialjim.microapplet.wechat.official.remoting.datacube.meta.GetUpstreamMsgHourReq;
import com.asialjim.microapplet.wechat.official.remoting.datacube.meta.GetUpstreamMsgHourRes;
import com.asialjim.microapplet.wechat.official.remoting.datacube.meta.GetUpstreamMsgReq;
import com.asialjim.microapplet.wechat.official.remoting.datacube.meta.GetUpstreamMsgRes;
import com.asialjim.microapplet.wechat.official.remoting.datacube.meta.GetUpstreamMsgWeekReq;
import com.asialjim.microapplet.wechat.official.remoting.datacube.meta.GetUpstreamMsgWeekRes;
import com.asialjim.microapplet.wechat.official.remoting.datacube.meta.GetUpstreamMsgMonthReq;
import com.asialjim.microapplet.wechat.official.remoting.datacube.meta.GetUpstreamMsgMonthRes;

/**
 * 微信公众号数据统计接口
 * <p>
 * 提供微信公众号各类数据统计功能，包括：
 * <a href="https://developers.weixin.qq.com/doc/subscription/api/wedata/mess/api_getupstreammsg.html">获取消息发送概况数据</a>
 * <a href="https://developers.weixin.qq.com/doc/subscription/api/wedata/mess/api_getupstreammsgmonth.html">获取消息发送月数据</a>
 * <a href="https://developers.weixin.qq.com/doc/subscription/api/wedata/mess/api_getupstreammsgdistweek.html">获取消息发送分布周数据</a>
 * <a href="https://developers.weixin.qq.com/doc/subscription/api/wedata/mess/api_getupstreammsgdistmonth.html">获取消息发送分布月数据</a>
 * <a href="https://developers.weixin.qq.com/doc/subscription/api/wedata/mess/api_getupstreammsghour.html">获取消息发送小时数据</a>
 * <a href="https://developers.weixin.qq.com/doc/subscription/api/wedata/mess/api_getupstreammsgweek.html">获取消息发送周数据</a>
 * <a href="https://developers.weixin.qq.com/doc/subscription/api/wedata/mess/api_getupstreammsgdist.html">获取消息发送分布数据</a>
 * <a href="https://developers.weixin.qq.com/doc/subscription/api/wedata/api/api_getinterfacesummary.html">获取被动回复概要数据</a>
 * <a href="https://developers.weixin.qq.com/doc/subscription/api/wedata/api/api_getinterfacesummaryhour.html">获取被动回复分布数据</a>
 * </p>
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2024-10-31, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Server(
        supplier = WeChatCons.Supplier.WECHAT,
        namespace = WeChatCons.Namespace.COMMON,
        schema = WeChatCons.Api.DEFAULT_SCHEMA,
        host = WeChatCons.Api.DEFAULT_HOST,
        port = WeChatCons.Api.DEFAULT_PORT
)
public interface WeChatPaDataCubeRemoting {

    /**
     * 获取消息发送概况数据
     * <p>
     * 参考文档: <a href="https://developers.weixin.qq.com/doc/subscription/api/wedata/mess/api_getupstreammsg.html">获取消息发送概况数据</a>
     * </p>
     *
     * @param weChatIndex 微信应用索引
     * @param req         请求参数，包含起始日期和结束日期
     * @return 消息发送概况数据响应结果
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/datacube/getupstreammsg")
    GetUpstreamMsgRes getUpstreamMsg(@WeChatAccessTokenParam String weChatIndex,
                                     @JsonBody GetUpstreamMsgReq req);

    /**
     * 获取消息发送月数据
     * <p>
     * 参考文档: <a href="https://developers.weixin.qq.com/doc/subscription/api/wedata/mess/api_getupstreammsgmonth.html">获取消息发送月数据</a>
     * </p>
     *
     * @param weChatIndex 微信应用索引
     * @param req         请求参数，包含起始日期和结束日期（必须为同一天）
     * @return 消息发送月数据响应结果
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/datacube/getupstreammsgmonth")
    GetUpstreamMsgMonthRes getUpstreamMsgMonth(@WeChatAccessTokenParam String weChatIndex,
                                               @JsonBody GetUpstreamMsgMonthReq req);

    /**
     * 获取消息发送分布周数据
     * <p>
     * 参考文档: <a href="https://developers.weixin.qq.com/doc/subscription/api/wedata/mess/api_getupstreammsgdistweek.html">获取消息发送分布周数据</a>
     * </p>
     *
     * @param weChatIndex 微信应用索引
     * @param req         请求参数，包含起始日期和结束日期
     * @return 消息发送分布周数据响应结果
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/datacube/getupstreammsgdistweek")
    GetUpstreamMsgDistRes getUpstreamMsgDistWeek(@WeChatAccessTokenParam String weChatIndex,
                                                @JsonBody GetUpstreamMsgDistReq req);

    /**
     * 获取消息发送分布月数据
     * <p>
     * 参考文档: <a href="https://developers.weixin.qq.com/doc/subscription/api/wedata/mess/api_getupstreammsgdistmonth.html">获取消息发送分布月数据</a>
     * </p>
     *
     * @param weChatIndex 微信应用索引
     * @param req         请求参数，包含起始日期和结束日期
     * @return 消息发送分布月数据响应结果
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/datacube/getupstreammsgdistmonth")
    GetUpstreamMsgDistRes getUpstreamMsgDistMonth(@WeChatAccessTokenParam String weChatIndex,
                                                 @JsonBody GetUpstreamMsgDistReq req);

    /**
     * 获取消息发送小时数据
     * <p>
     * 参考文档: <a href="https://developers.weixin.qq.com/doc/subscription/api/wedata/mess/api_getupstreammsghour.html">获取消息发送小时数据</a>
     * </p>
     *
     * @param weChatIndex 微信应用索引
     * @param req         请求参数，包含起始日期和结束日期
     * @return 消息发送小时数据响应结果
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/datacube/getupstreammsghour")
    GetUpstreamMsgHourRes getUpstreamMsgHour(@WeChatAccessTokenParam String weChatIndex,
                                            @JsonBody GetUpstreamMsgHourReq req);

    /**
     * 获取消息发送周数据
     * <p>
     * 参考文档: <a href="https://developers.weixin.qq.com/doc/subscription/api/wedata/mess/api_getupstreammsgweek.html">获取消息发送周数据</a>
     * </p>
     *
     * @param weChatIndex 微信应用索引
     * @param req         请求参数，包含起始日期和结束日期
     * @return 消息发送周数据响应结果
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/datacube/getupstreammsgweek")
    GetUpstreamMsgWeekRes getUpstreamMsgWeek(@WeChatAccessTokenParam String weChatIndex,
                                            @JsonBody GetUpstreamMsgWeekReq req);

    /**
     * 获取消息发送分布数据
     * <p>
     * 参考文档: <a href="https://developers.weixin.qq.com/doc/subscription/api/wedata/mess/api_getupstreammsgdist.html">获取消息发送分布数据</a>
     * </p>
     *
     * @param weChatIndex 微信应用索引
     * @param req         请求参数，包含起始日期和结束日期
     * @return 消息发送分布数据响应结果
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/datacube/getupstreammsgdist")
    GetUpstreamMsgDistRes getUpstreamMsgDist(@WeChatAccessTokenParam String weChatIndex,
                                           @JsonBody GetUpstreamMsgDistReq req);

    /**
     * 获取被动回复概要数据
     * <p>
     * 参考文档: <a href="https://developers.weixin.qq.com/doc/subscription/api/wedata/api/api_getinterfacesummary.html">获取被动回复概要数据</a>
     * </p>
     *
     * @param weChatIndex 微信应用索引
     * @param req         请求参数，包含起始日期和结束日期
     * @return 被动回复概要数据响应结果
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/datacube/getinterfacesummary")
    GetInterfaceSummaryRes getInterfaceSummary(@WeChatAccessTokenParam String weChatIndex,
                                             @JsonBody GetInterfaceSummaryReq req);

    /**
     * 获取被动回复分布数据
     * <p>
     * 参考文档: <a href="https://developers.weixin.qq.com/doc/subscription/api/wedata/api/api_getinterfacesummaryhour.html">获取被动回复分布数据</a>
     * </p>
     *
     * @param weChatIndex 微信应用索引
     * @param req         请求参数，包含起始日期和结束日期
     * @return 被动回复分布数据响应结果
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/datacube/getinterfacesummaryhour")
    GetInterfaceSummaryHourRes getInterfaceSummaryHour(@WeChatAccessTokenParam String weChatIndex,
                                                     @JsonBody GetInterfaceSummaryHourReq req);
}