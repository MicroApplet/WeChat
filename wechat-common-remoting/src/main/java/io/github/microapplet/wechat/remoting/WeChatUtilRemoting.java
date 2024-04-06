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

package io.github.microapplet.wechat.remoting;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.microapplet.wechat.constant.WeChatCons;
import io.github.microapplet.wechat.remoting.context.BaseWeChatApiRes;
import io.github.microapplet.wechat.remoting.context.WeChatAccessTokenParam;
import io.github.microapplet.remote.http.annotation.HttpMapping;
import io.github.microapplet.remote.http.annotation.HttpMethod;
import io.github.microapplet.remote.http.annotation.HttpQuery;
import io.github.microapplet.remote.http.annotation.body.JsonBody;
import io.github.microapplet.remote.net.annotation.Server;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * 微信API工具客户端
 *
 * @author Copyright © <a href="mailto:asialjim@hotmail.com">Asial Jim</a>   Co., LTD
 * @version 1.0
 * @since 2023/12/16, &nbsp;&nbsp; <em>version:1.0</em>,  &nbsp;&nbsp;  <em>java version:8</em>
 */
@Server(
        supplier = WeChatCons.Supplier.WECHAT,
        namespace = WeChatCons.Namespace.COMMON,
        schema = WeChatCons.Api.DEFAULT_SCHEMA,
        host = WeChatCons.Api.DEFAULT_HOST,
        port = WeChatCons.Api.DEFAULT_PORT
)
public interface WeChatUtilRemoting {

    /**
     * API接口IP即api.weixin.qq.com的解析地址，由开发者调用微信侧的接入IP。
     *
     * @param weChatIndex {@link String weChatIndex}
     * @return {@link WeChatIPList }
     * @since 2023/12/16
     */
    @HttpMapping(method = HttpMethod.GET, uri = "/cgi-bin/get_api_domain_ip")
    WeChatIPList domainIp(@WeChatAccessTokenParam String weChatIndex);

    /**
     * callback IP即微信调用开发者服务器所使用的出口IP。
     *
     * @param weChatIndex {@link String weChatIndex}
     * @return {@link WeChatIPList}
     * @since 2023/12/16
     */
    @HttpMapping(method = HttpMethod.GET, uri = "/cgi-bin/getcallbackip")
    WeChatIPList callbackIp(@WeChatAccessTokenParam String weChatIndex);

    /**
     * 为了帮助开发者排查回调连接失败的问题，提供这个网络检测的API。它可以对开发者URL做域名解析，然后对所有IP进行一次ping操作，得到丢包率和耗时。
     *
     * @param weChatIndex {@link String weChatIndex}
     * @param body        {@link NetCheckReq body}
     * @return {@link NetCheckRes }
     * @since 2023/12/26
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/callback/check")
    NetCheckRes netCheck(@WeChatAccessTokenParam String weChatIndex, @JsonBody NetCheckReq body);

    /**
     * <pre>
     * 清空api的调用quota
     *          本接口用于清空公众号/小程序/第三方平台等接口的每日调用接口次数。
     *          使用过程中如遇到问题，可在开放平台服务商专区发帖交流。
     * 注意事项
     * 1、如果要清空公众号的接口的quota，则需要用公众号的access_token；如果要清空小程序的接口的quota，则需要用小程序的access_token；如果要清空第三方平台的接口的quota，则需要用第三方平台的component_access_token
     * 2、如果是第三方服务商代公众号或者小程序清除quota，则需要用authorizer_access_token
     * 3、每个账号每月共10次清零操作机会，清零生效一次即用掉一次机会；第三方帮助公众号/小程序调用时，实际上是在消耗公众号/小程序自身的quota
     * 4、由于指标计算方法或统计时间差异，实时调用量数据可能会出现误差，一般在1%以内
     * </pre>
     *
     * @param weChatIndex {@link String weChatIndex}
     * @param body        {@link ClearuQotaReq body}
     * @return {@link BaseWeChatApiRes}
     * @since 2023/12/26
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/clear_quota")
    BaseWeChatApiRes clearQuota(@WeChatAccessTokenParam String weChatIndex, @JsonBody ClearuQotaReq body);

    /**
     * <pre>
     * 查询openAPI调用quota
     *          本接口用于查询公众号/小程序/第三方平台等接口的每日调用接口的额度以及调用次数。
     *          使用过程中如遇到问题，可在开放平台服务商专区发帖交流。
     * 注意事项
     * 1、如果查询的api属于公众号的接口，则需要用公众号的access_token；如果查询的api属于小程序的接口，则需要用小程序的access_token；如果查询的接口属于第三方平台的接口，则需要用第三方平台的component_access_token；否则会出现76022报错。
     * 2、如果是第三方服务商代公众号或者小程序查询公众号或者小程序的api，则需要用authorizer_access_token
     * 3、每个接口都有调用次数限制，请开发者合理调用接口
     * 4、”/xxx/sns/xxx“这类接口不支持使用该接口，会出现76022报错。
     * </pre>
     *
     * @param weChatIndex {@link String weChatIndex}
     * @param body        {@link QueryQuotaReq body}
     * @return {@link QueryQuotaRes }
     * @since 2023/12/26
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/openapi/auota/get")
    QueryQuotaRes queryQuota(@WeChatAccessTokenParam String weChatIndex, @JsonBody QueryQuotaReq body);

    /**
     * <pre>
     * 查询rid信息
     * 本接口用于查询调用公众号/小程序/第三方平台等接口报错返回的rid详情信息，辅助开发者高效定位问题。
     * 注意事项
     * 1、由于查询rid信息属于开发者私密行为，因此仅支持同账号的查询。举个例子，rid=1111，是小程序账号A调用某接口出现的报错，那么则需要使用小程序账号A的access_token调用当前接口查询rid=1111的详情信息，如果使用小程序账号B的身份查询，则出现报错，错误码为xxx。公众号、第三方平台账号的接口同理。
     * 2、如果是第三方服务商代公众号或者小程序查询公众号或者小程序的api返回的rid，则使用同一账号的authorizer_access_token调用即可
     * 3、rid的有效期只有7天，即只可查询最近7天的rid，查询超过7天的rid会出现报错，错误码为76001
     * </pre>
     *
     * @param weChatIndex {@link String weChatIndex}
     * @param body        {@link QueryRidReq body}
     * @return {@link QueryRidRes}
     * @since 2023/12/26
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/openapi/rid/get")
    QueryRidRes queryRid(@WeChatAccessTokenParam String weChatIndex, @JsonBody QueryRidReq body);


    /**
     * <pre>
     * 功能描述
     * 本接口用于清空公众号/小程序等接口的每日调用接口次数
     * 注意事项
     * 1、该接口通过appsecret调用，解决了accesss_token耗尽无法调用重置 API 调用次数的情况
     * 2、每个账号每月使用重置 API 调用次数 与本接口共10次清零操作机会，清零生效一次即用掉一次机会；
     * 3、由于指标计算方法或统计时间差异，实时调用量数据可能会出现误差，一般在1%以内
     * 4、该接口仅支持POST调用
     * </pre>
     *
     * @param appid  {@link String appid}
     * @param secret {@link String secret}
     * @return {@link BaseWeChatApiRes }
     * @since 2023/12/26
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/openapi/rid/get")
    BaseWeChatApiRes clearQuotaV2(@HttpQuery(name = "appid") String appid, @HttpQuery(name = "appsecret") String secret);

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    class QueryRidReq implements Serializable {
        private String rid;
    }

    @Data
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    class QueryRidRes extends BaseWeChatApiRes {
        private RidRequest request;
    }

    @Data
    class RidRequest {
        private Long invoke_time;
        private Integer cost_in_ms;
        private String request_url;
        private String request_body;
        private String response_body;
        private String client_ip;
    }

    @Data
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    class QueryQuotaRes extends BaseWeChatApiRes {
        private Quota quota;
    }

    @Data
    class Quota {
        private Integer daily_limit;
        private Integer used;
        private Integer remain;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    class QueryQuotaReq implements Serializable {
        private static final long serialVersionUID = 6140830683300582536L;
        private String cgi_path;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    class ClearuQotaReq implements Serializable {
        private static final long serialVersionUID = -5684073411227225834L;
        private String appid;
    }

    @Data
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    class WeChatIPList extends BaseWeChatApiRes {
        private static final long serialVersionUID = 914642389706182234L;
        @JsonProperty("ip_list")
        private List<String> ipList;
    }

    @Data
    class NetCheckReq implements Serializable {
        private static final long serialVersionUID = 2992017493498755575L;
        private String action;
        private String check_operator;
    }

    @Data
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    class NetCheckRes extends BaseWeChatApiRes {
        private static final long serialVersionUID = -5207978613699970475L;

        private List<DNS> dns;
        private List<PING> ping;
    }

    @Data
    class DNS {
        private String ip;
        @JsonProperty("real_operator")
        private String realOperator;
    }

    @Data
    class PING {
        private String ip;
        @JsonProperty("from_operator")
        private String fromOperator;
        @JsonProperty("package_loss")
        private String packageLoss;
        private String time;
    }
}