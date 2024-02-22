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
package io.github.microapplet.wechat.official.remoting.user;

import io.github.microapplet.remote.http.annotation.HttpMapping;
import io.github.microapplet.remote.http.annotation.HttpMethod;
import io.github.microapplet.remote.http.annotation.HttpQuery;
import io.github.microapplet.remote.http.annotation.body.JsonBody;
import io.github.microapplet.remote.net.annotation.Server;
import io.github.microapplet.wechat.constant.WeChatCons;
import io.github.microapplet.wechat.remoting.context.WeChatAccessTokenParam;
import io.github.microapplet.wechat.remoting.context.BaseWeChatApiRes;
import io.github.microapplet.wechat.official.remoting.user.meta.*;

/**
 * <h1><em>ASIAL JIM JAVA DOC</em></h1><hr/>
 * <h2>CLASS DESCRIPTION <i>[ NAME: WeChatPublicAccountUserRemoting ]</i> </h2><strong>
 * <p> 微信公众号应用服务
 * @author Copyright © <a href="mailto:asialjim@hotmail.com">Asial Jim</a>   Co., LTD
 * @version 1.0.0
 * @since 2021/12/25 20:52   &nbsp;&nbsp; JDK 8
 */
@SuppressWarnings("unused")
@Server(
        supplier = WeChatCons.Supplier.WECHAT,
        namespace = WeChatCons.Namespace.COMMON,
        schema = WeChatCons.Api.DEFAULT_SCHEMA,
        host = WeChatCons.Api.DEFAULT_HOST,
        port = WeChatCons.Api.DEFAULT_PORT
)
public interface WeChatPublicAccountUserRemoting {

    /**
     * 获取授权网页用户令牌
     *
     * @param appid  {@link String appid}
     * @param secret {@link String secret}
     * @param code   {@link String code}
     * @return {@link WeChatPublicAccountUserAccessTokenRes}
     * @since 2021/12/28 9:03
     */
    @HttpMapping(method = HttpMethod.GET, uri = "/sns/oauth2/access_token", queries = @HttpQuery(name = "grant_type", value = "authorization_code"))
    WeChatPublicAccountUserAccessTokenRes userAccessToken(@HttpQuery(name = "appid") String appid,
                                                          @HttpQuery(name = "secret") String secret,
                                                          @HttpQuery(name = "code") String code);

    /**
     * 刷新授权网页用户令牌
     *
     * @param appid        {@link String appid}
     * @param refreshToken {@link String refreshToken}
     * @return {@link WeChatPublicAccountUserAccessTokenRes}
     * @since 2021/12/28 9:04
     * @since 2021/12/28 9:04
     */
    @HttpMapping(method = HttpMethod.GET, uri = "/sns/oauth2/refresh_token", queries = @HttpQuery(name = "grant_type", value = "refresh_token"))
    WeChatPublicAccountUserAccessTokenRes refreshAccessToken(@HttpQuery(name = "appid") String appid,
                                                             @HttpQuery(name = "refresh_token") String refreshToken);

    /**
     * 通过微信用户信息令牌 获取微信公众号授权网页用户的用户信息
     *
     * @param accessToken {@link String accessToken} 微信用户信息获取令牌，此令牌并非 微信通用接口访问令牌
     * @param openid      {@link String openid} 微信公众平台用户唯一标识符
     * @return {@link WeChatPublicAccountUserInfo }
     * @since 2021/12/28 9:11
     */
    @HttpMapping(method = HttpMethod.GET, uri = "/sns/userinfo", queries = @HttpQuery(name = "lang", value = "zh_CN"))
    WeChatPublicAccountUserInfo weChatUserInfo(@HttpQuery(name = "access_token") String accessToken,
                                               @HttpQuery(name = "openid") String openid);

    /**
     * 检验授权凭证（access_token）是否有效
     *
     * @param accessToken {@link String accessToken} 微信用户信息获取令牌，此令牌并非 微信通用接口访问令牌
     * @param openid      {@link String openid} 微信公众平台用户唯一标识符
     * @return {@link BaseWeChatApiRes}
     * @since 2021/12/28 9:14
     */
    @HttpMapping(method = HttpMethod.GET, uri = "/sns/auth")
    BaseWeChatApiRes accessTokenValid(@HttpQuery(name = "access_token") String accessToken,
                                      @HttpQuery(name = "openid") String openid);

    /**
     * 通过微信访问令牌获取微信用户信息
     *
     * @param subjectId {@link String subjectId}微信应用平台编号
     * @param openid    {@link String openid} 微信公众平台用户编号
     * @return {@link WeChatPublicAccountUserInfo}
     * @since 2021/12/29 17:05
     */
    @HttpMapping(method = HttpMethod.GET, uri = "/cgi-bin/user/info", queries = @HttpQuery(name = "lang", value = "zh_CN"))
    WeChatPublicAccountUserInfo weChatUserInfoByApi(@WeChatAccessTokenParam String subjectId,
                                                    @HttpQuery(name = "openid") String openid);

    /**
     * 批量获取微信用户信息
     *
     * @param subjectId {@link String subjectId} 微信应用编号
     * @param req       {@link WeChatPublicAccountBatchGetUserReq req} 批量获取微信用户请求
     * @return {@link WeChatPublicAccountBatchGetUserRes }  批量获取微信用户结果
     * @since 2021/12/29 17:18
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/user/info/batchget")
    WeChatPublicAccountBatchGetUserRes batchGetUserInfo(@WeChatAccessTokenParam String subjectId,
                                                        @JsonBody WeChatPublicAccountBatchGetUserReq req);

    /**
     * 批量获取微信公众平台用户唯一标识符
     *
     * @param subjectId {@link String subjectId}微信公众平台应用编号
     * @param nextUser  {@link String nextUser} 微信公众号下一个唯一标识符
     * @return {@link WeChatPublicAccountBatchGetOpenIdsRes}
     * @since 2021/12/29 17:24
     */
    @HttpMapping(method = HttpMethod.GET, uri = "/cgi-bin/user/get")
    WeChatPublicAccountBatchGetOpenIdsRes weChatUserOpenIds(@WeChatAccessTokenParam String subjectId,
                                                            @HttpQuery(name = "next_openid") String nextUser);
}