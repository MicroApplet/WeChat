/*
 *  Copyright 2014-2025 <a href="mailto:asialjim@qq.com">Asial Jim</a>
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *   limitations under the License.
 */

import com.asialjim.microapplet.remote.http.annotation.HttpMapping;
import com.asialjim.microapplet.remote.http.annotation.HttpMethod;
import com.asialjim.microapplet.remote.http.annotation.HttpQuery;
import com.asialjim.microapplet.remote.http.annotation.body.JsonBody;
import com.asialjim.microapplet.remote.net.annotation.Server;
import com.asialjim.microapplet.wechat.constant.WeChatCons;
import com.asialjim.microapplet.wechat.official.remoting.user.meta.*;
import com.asialjim.microapplet.wechat.remoting.context.BaseWeChatApiRes;

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
    @HttpMapping(method = HttpMethod.GET, uri = "/cgi-bin/model/info", queries = @HttpQuery(name = "lang", value = "zh_CN"))
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
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/model/info/batchget")
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
    @HttpMapping(method = HttpMethod.GET, uri = "/cgi-bin/model/get")
    WeChatPublicAccountBatchGetOpenIdsRes weChatUserOpenIds(@WeChatAccessTokenParam String subjectId,
                                                            @HttpQuery(name = "next_openid") String nextUser);


    /**
     * 创建标签， 一个公众号，最多可以创建100个标签
     *
     * @param weChatIndexOrAccessToken {@link String weChatIndexOrAccessToken}
     * @param body                     {@link CreateUserTagReq body}
     * @return {@link CreateUserTagRes }
     * @since 2024/2/23
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/tags/create")
    CreateUserTagRes tag(@WeChatAccessTokenParam String weChatIndexOrAccessToken, @JsonBody CreateUserTagReq body);

    /**
     * 获取公众号已经创建所有的标签
     *
     * @param weChatIndexOrAccessToken {@link String weChatIndexOrAccessToken}
     * @return {@link CreateUserTagRes }
     * @since 2024/2/23
     */
    @HttpMapping(method = HttpMethod.GET, uri = "/cgi-bin/tags/get")
    CreateUserTagRes tags(@WeChatAccessTokenParam String weChatIndexOrAccessToken);

    /**
     * 编辑公众号用户标签
     *
     * @param weChatIndexOrAccessToken {@link String weChatIndexOrAccessToken}
     * @param body                     {@link OperateTagReq body}
     * @return {@link BaseWeChatApiRes }
     * @since 2024/2/23
     */
    @HttpMapping(method = HttpMethod.GET, uri = "/cgi-bin/tags/update")
    BaseWeChatApiRes update(@WeChatAccessTokenParam String weChatIndexOrAccessToken, @JsonBody OperateTagReq body);

    /**
     * 删除公众号用户标签
     *
     * @param weChatIndexOrAccessToken {@link String weChatIndexOrAccessToken}
     * @param body                     {@link OperateTagReq body}
     * @return {@link BaseWeChatApiRes }
     * @since 2024/2/23
     */
    @HttpMapping(method = HttpMethod.GET, uri = "/cgi-bin/tags/delete")
    BaseWeChatApiRes delete(@WeChatAccessTokenParam String weChatIndexOrAccessToken, @JsonBody OperateTagReq body);

    /**
     * 获取标签下粉丝
     *
     * @param weChatIndexOrAccessToken {@link String weChatIndexOrAccessToken}
     * @param body                     {@link GetUsersByTagReq body}
     * @return {@link GetUsersByTagRes }
     * @since 2024/2/23
     */
    @HttpMapping(method = HttpMethod.GET, uri = "/cgi-bin/model/tag/get")
    GetUsersByTagRes get(@WeChatAccessTokenParam String weChatIndexOrAccessToken, @JsonBody GetUsersByTagReq body);

    /**
     * 批量为用户打标签
     *
     * @param weChatIndexOrAccessToken {@link String weChatIndexOrAccessToken}
     * @param body                     {@link BatchTaggingReq body}
     * @return {@link BatchTaggingRes }
     * @since 2024/2/23
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/tags/members/batchtagging")
    BatchTaggingRes batchTagging(@WeChatAccessTokenParam String weChatIndexOrAccessToken, @JsonBody BatchTaggingReq body);

    /**
     * 批量取消用户打标签
     *
     * @param weChatIndexOrAccessToken {@link String weChatIndexOrAccessToken}
     * @param body                     {@link BatchTaggingReq body}
     * @return {@link BatchTaggingRes }
     * @since 2024/2/23
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/tags/members/batchuntagging")
    BatchTaggingRes unBatchTagging(@WeChatAccessTokenParam String weChatIndexOrAccessToken, @JsonBody BatchTaggingReq body);

    /**
     * 获取用户身上的标签列表
     *
     * @param weChatIndexOrAccessToken {@link String weChatIndexOrAccessToken}
     * @param body                     {@link GetUserTagListReq body}
     * @return {@link GetUserTagListRes }
     * @since 2024/2/23
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/tags/getidlist")
    GetUserTagListRes list(@WeChatAccessTokenParam String weChatIndexOrAccessToken, @JsonBody GetUserTagListReq body);

    /**
     * 设置用户备注名
     * <pre>
     *     开发者可以通过该接口对指定用户设置备注名，该接口暂时开放给微信认证的服务号。
     * </pre>
     *
     * @param weChatIndexOrAccessToken {@link String weChatIndexOrAccessToken}
     * @param body                     {@link UpdateRemarkReq body}
     * @return {@link BaseWeChatApiRes }
     * @since 2024/2/23
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/model/info/updateremark")
    BaseWeChatApiRes updateRemark(@WeChatAccessTokenParam String weChatIndexOrAccessToken, @JsonBody UpdateRemarkReq body);

    /**
     * 获取公众号黑名单列表
     *
     * @param weChatIndexOrAccessToken {@link String weChatIndexOrAccessToken}
     * @param body                     {@link GetBlackListReq body}
     * @return {@link GetBlackListRes }
     * @since 2024/2/23
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/tags/members/getblacklist")
    GetBlackListRes blackList(@WeChatAccessTokenParam String weChatIndexOrAccessToken, @JsonBody GetBlackListReq body);

    /**
     * 拉黑用户
     *
     * @param weChatIndexOrAccessToken {@link String weChatIndexOrAccessToken}
     * @param body                     {@link BatchBlackListReq body}
     * @return {@link BaseWeChatApiRes }
     * @since 2024/3/1
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/tags/members/batchblacklist")
    BaseWeChatApiRes batchBlackList(@WeChatAccessTokenParam String weChatIndexOrAccessToken, @JsonBody BatchBlackListReq body);

    /**
     * 取消拉黑用户
     *
     * @param weChatIndexOrAccessToken {@link String weChatIndexOrAccessToken}
     * @param body                     {@link BatchBlackListReq body}
     * @return {@link BaseWeChatApiRes }
     * @since 2024/3/1
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/tags/members/batchunblacklist")
    BaseWeChatApiRes batchUnBlackList(@WeChatAccessTokenParam String weChatIndexOrAccessToken, @JsonBody BatchBlackListReq body);

}