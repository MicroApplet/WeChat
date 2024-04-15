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
import io.github.microapplet.remote.http.annotation.HttpQuery;
import io.github.microapplet.remote.http.annotation.body.JsonBody;
import io.github.microapplet.remote.net.annotation.Server;
import io.github.microapplet.wechat.constant.WeChatCons;
import io.github.microapplet.wechat.official.remoting.analysis.ad.*;
import io.github.microapplet.wechat.remoting.context.WeChatAccessTokenParam;

/**
 * 微信公众号广告分析 API
 * <pre>
 * 向所有成为流量主的公众号、小程序、小游戏开发者开放数据接口。通过数据接口，开发者可以获取与公众平台官网统计模块类似但更灵活的数据，还可根据需要进行高级处理。
 * 请注意：
 *  接口侧数据库中仅存储了2016年1月1日之后的数据，将无法查询到此前的数据，即使查到，也是不可信的脏数据；
 *  建议开发者在调用接口获取数据后，将数据保存在自身数据库中，以最大化访问的效率，也降低微信侧接口调用的不必要损耗；
 *  由于数据量较大, 所有接口采取分页获取的方式, 每页最大获取量为90。（eg：total_num 为100，则当page = 1，page_size = 10，则返回前10条；page = 1，page_size = 20，则返回前20条；page = 2，page_size = 10，则返回第11条到第20条）
 *
 * 广告位枚举值变更说明
 *  由于多个接口都使用了广告位参数，为保证体验的一致性和参数的可读性，我们做了一些变更，所有接口均支持以 广告位类型名称（ad_slot） 传递参数，回包时新增这个名称来代表相关含义。此前的参数 slot_id 也可继续使用并回传。具体为：
 *  广告位类型名称（ad_slot）	            广告位类型
 *  SLOT_ID_BIZ_BOTTOM	            公众号底部广告
 *  SLOT_ID_BIZ_MID_CONTEXT	            公众号文中广告
 *  SLOT_ID_BIZ_VIDEO_END	            公众号视频后贴
 *  SLOT_ID_BIZ_SPONSOR	            公众号互选广告
 *  SLOT_ID_BIZ_CPS	                      公众号返佣商品
 *  SLOT_ID_WEAPP_BANNER	            小程序banner
 *  SLOT_ID_WEAPP_REWARD_VIDEO	            小程序激励视频
 *  SLOT_ID_WEAPP_INTERSTITIAL	            小程序插屏广告
 *  SLOT_ID_WEAPP_VIDEO_FEEDS	            小程序视频广告
 *  SLOT_ID_WEAPP_VIDEO_BEGIN	            小程序视频前贴
 *  SLOT_ID_WEAPP_BOX	                      小程序格子广告
 *
 *
 * <a href="https://developers.weixin.qq.com/doc/offiaccount/Analytics/Ad_Analysis.html">官方文档地址</a>
 * </pre>
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0.0
 * @since 2024 04 15, &nbsp;&nbsp; <em>version:1.0.0</em>
 */
@Server(
        supplier = WeChatCons.Supplier.WECHAT,
        namespace = WeChatCons.Namespace.COMMON,
        schema = WeChatCons.Api.DEFAULT_SCHEMA,
        host = WeChatCons.Api.DEFAULT_HOST,
        port = WeChatCons.Api.DEFAULT_PORT
)
public interface WeChatPublicAdAnalysisRemoting {

    /**
     * 获取公众号分广告位数据
     *
     * @param weChatIndex {@link String weChatIndex}
     * @param body        {@link AdPosGeneralReq body}
     * @return {@link AdPosGeneralRes }
     * @since 2024 04 15
     */
    @HttpMapping(method = HttpMethod.GET, uri = "/publisher/stat", queries = @HttpQuery(name = "action", value = "publisher_adpos_general"))
    AdPosGeneralRes adPosGeneral(@WeChatAccessTokenParam String weChatIndex, @JsonBody AdPosGeneralReq body);

    /**
     * 获取公众号返佣商品数据	60天
     *
     * @param weChatIndex {@link String weChatIndex}
     * @param body        {@link CpsGeneralReq body}
     * @return {@link CpsGeneralRes }
     * @since 2024 04 15
     */
    @HttpMapping(method = HttpMethod.GET, uri = "/publisher/stat", queries = @HttpQuery(name = "action", value = "publisher_cps_general"))
    CpsGeneralRes cpsGeneral(@WeChatAccessTokenParam String weChatIndex, @JsonBody CpsGeneralReq body);

    /**
     * 获取公众号结算收入数据及结算主体信息
     *
     * @param weChatIndex {@link String weChatIndex}
     * @param body        {@link SettlementReq body}
     * @return {@link SettlementRes }
     * @since 2024 04 15
     */
    @HttpMapping(method = HttpMethod.GET, uri = "/publisher/stat", queries = @HttpQuery(name = "action", value = "publisher_settlement"))
    SettlementRes settlement(@WeChatAccessTokenParam String weChatIndex, @JsonBody SettlementReq body);

}