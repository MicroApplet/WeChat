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

package com.asialjim.microapplet.wechat.official.remoting.user;

import com.asialjim.microapplet.remote.http.annotation.HttpMapping;
import com.asialjim.microapplet.remote.http.annotation.HttpMethod;
import com.asialjim.microapplet.remote.http.annotation.body.JsonBody;
import com.asialjim.microapplet.remote.net.annotation.Server;
import com.asialjim.microapplet.remote.http.annotation.HttpQuery;
import com.asialjim.microapplet.wechat.constant.WeChatCons;
import com.asialjim.microapplet.wechat.official.remoting.user.meta.*;
import com.asialjim.microapplet.wechat.remoting.context.BaseWeChatApiRes;
import com.asialjim.microapplet.wechat.remoting.context.WeChatAccessTokenParam;

/**
 * 微信公众号用户管理接口
 * <p>参考文档：
 * <a href="https://developers.weixin.qq.com/doc/subscription/api/usermanage/tag/api_gettagfans.html">获取标签下粉丝列表</a>
 * <a href="https://developers.weixin.qq.com/doc/subscription/api/usermanage/tag/api_gettags.html">获取标签</a>
 * <a href="https://developers.weixin.qq.com/doc/subscription/api/usermanage/tag/api_createtag.html">创建标签</a>
 * <a href="https://developers.weixin.qq.com/doc/subscription/api/usermanage/tag/api_updatetag.html">编辑标签</a>
 * <a href="https://developers.weixin.qq.com/doc/subscription/api/usermanage/tag/api_deletetag.html">删除标签</a>
 * <a href="https://developers.weixin.qq.com/doc/subscription/api/usermanage/tag/api_batchuntagging.html">批量为用户取消标签</a>
 * <a href="https://developers.weixin.qq.com/doc/subscription/api/usermanage/tag/api_batchtagging.html">批量为用户打标签</a>
 * <a href="https://developers.weixin.qq.com/doc/subscription/api/usermanage/tag/api_gettagidlist.html">获取用户标签</a>
 * <a href="https://developers.weixin.qq.com/doc/subscription/api/usermanage/userinfo/api_batchunblacklist.html">取消拉黑用户</a>
 * <a href="https://developers.weixin.qq.com/doc/subscription/api/usermanage/userinfo/api_getblacklist.html">获取公众号的黑名单列表</a>
 * <a href="https://developers.weixin.qq.com/doc/subscription/api/usermanage/userinfo/api_userinfo.html">获取用户基本信息</a>
 * <a href="https://developers.weixin.qq.com/doc/subscription/api/usermanage/userinfo/api_batchuserinfo">批量获取用户基本信息</a>
 * <a href="https://developers.weixin.qq.com/doc/subscription/api/usermanage/userinfo/api_getfans.html">获取粉丝列表</a>
 * <a href="https://developers.weixin.qq.com/doc/subscription/api/usermanage/userinfo/api_batchblacklist.html">批量拉黑用户</a>
 * </p>
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2024-10-31, &nbsp;&nbsp; <em>version:1.0</em>
 */
@SuppressWarnings("unused")
@Server(
        supplier = WeChatCons.Supplier.WECHAT,
        namespace = WeChatCons.Namespace.COMMON,
        schema = WeChatCons.Api.DEFAULT_SCHEMA,
        host = WeChatCons.Api.DEFAULT_HOST,
        port = WeChatCons.Api.DEFAULT_PORT
)
public interface WeChatPaUserRemoting {

    /**
     * 获取标签下粉丝列表
     * <p>参考文档：<a href="https://developers.weixin.qq.com/doc/subscription/api/usermanage/tag/api_gettagfans.html">获取标签下粉丝列表</a></p>
     *
     * @param weChatIndex 微信应用索引
     * @param req         获取标签粉丝请求参数
     * @return 获取标签粉丝响应结果
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/user/tag/get")
    GetUsersByTagRes getTagFans(@WeChatAccessTokenParam String weChatIndex,
                                @JsonBody GetUsersByTagReq req);

    /**
     * 获取公众号已创建的标签列表
     * <p>参考文档：<a href="https://developers.weixin.qq.com/doc/subscription/api/usermanage/tag/api_gettags.html">获取标签</a></p>
     *
     * @param weChatIndex 微信应用索引
     * @return 标签列表响应结果
     */
    @HttpMapping(method = HttpMethod.GET, uri = "/cgi-bin/tags/get")
    GetUserTagListRes getTags(@WeChatAccessTokenParam String weChatIndex);

    /**
     * 创建公众号标签
     * <p>参考文档：<a href="https://developers.weixin.qq.com/doc/subscription/api/usermanage/tag/api_createtag.html">创建标签</a></p>
     *
     * @param weChatIndex 微信应用索引
     * @param req         创建标签请求参数
     * @return 创建标签响应结果
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/tags/create")
    CreateUserTagRes createTag(@WeChatAccessTokenParam String weChatIndex,
                               @JsonBody CreateUserTagReq req);

    /**
     * 修改已存在的标签信息
     * <p>参考文档：<a href="https://developers.weixin.qq.com/doc/subscription/api/usermanage/tag/api_updatetag.html">编辑标签</a></p>
     *
     * @param weChatIndex 微信应用索引
     * @param req         编辑标签请求参数
     * @return 基础响应结果
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/tags/update")
    BaseWeChatApiRes updateTag(@WeChatAccessTokenParam String weChatIndex,
                               @JsonBody OperateTagReq req);

    /**
     * 删除已存在的标签信息
     * <p>参考文档：<a href="https://developers.weixin.qq.com/doc/subscription/api/usermanage/tag/api_deletetag.html">删除标签</a></p>
     *
     * @param weChatIndex 微信应用索引
     * @param req         删除标签请求参数
     * @return 基础响应结果
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/tags/delete")
    BaseWeChatApiRes deleteTag(@WeChatAccessTokenParam String weChatIndex,
                               @JsonBody OperateTagReq req);

    /**
     * 批量为多个用户取消标签
     * <p>参考文档：<a href="https://developers.weixin.qq.com/doc/subscription/api/usermanage/tag/api_batchuntagging.html">批量为用户取消标签</a></p>
     *
     * @param weChatIndex 微信应用索引
     * @param req         批量取消标签请求参数
     * @return 批量操作响应结果
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/tags/members/batchuntagging")
    BatchTaggingRes batchUntagging(@WeChatAccessTokenParam String weChatIndex,
                                   @JsonBody BatchTaggingReq req);

    /**
     * 批量为多个用户打标签
     * <p>参考文档：<a href="https://developers.weixin.qq.com/doc/subscription/api/usermanage/tag/api_batchtagging.html">批量为用户打标签</a></p>
     *
     * @param weChatIndex 微信应用索引
     * @param req         批量打标签请求参数
     * @return 批量操作响应结果
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/tags/members/batchtagging")
    BatchTaggingRes batchTagging(@WeChatAccessTokenParam String weChatIndex,
                                 @JsonBody BatchTaggingReq req);

    /**
     * 获取用户身上的标签列表
     * <p>参考文档：<a href="https://developers.weixin.qq.com/doc/subscription/api/usermanage/tag/api_gettagidlist.html">获取用户标签</a></p>
     *
     * @param weChatIndex 微信应用索引
     * @return 用户标签列表响应结果
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/tags/getidlist")
    GetUserTagListRes getUserTagList(@WeChatAccessTokenParam String weChatIndex,
                                     @JsonBody GetUserTagListReq req);

    /**
     * 取消拉黑用户
     * <p>参考文档：<a href="https://developers.weixin.qq.com/doc/subscription/api/usermanage/userinfo/api_batchunblacklist.html">取消拉黑用户</a></p>
     *
     * @param weChatIndex 微信应用索引
     * @param req         批量取消拉黑请求参数
     * @return 基础响应结果
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/tags/members/batchunblacklist")
    BaseWeChatApiRes batchUnblacklist(@WeChatAccessTokenParam String weChatIndex,
                                      @JsonBody BatchBlackListReq req);

    /**
     * 获取公众号的黑名单列表
     * <p>参考文档：<a href="https://developers.weixin.qq.com/doc/subscription/api/usermanage/userinfo/api_getblacklist.html">获取公众号的黑名单列表</a></p>
     *
     * @param weChatIndex 微信应用索引
     * @param req         获取黑名单请求参数
     * @return 黑名单列表响应结果
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/tags/members/getblacklist")
    GetBlackListRes getBlacklist(@WeChatAccessTokenParam String weChatIndex,
                                 @JsonBody GetBlackListReq req);

    /**
     * 获取用户基本信息
     * <p>参考文档：<a href="https://developers.weixin.qq.com/doc/subscription/api/usermanage/userinfo/api_userinfo.html">获取用户基本信息</a></p>
     *
     * @param weChatIndex 微信应用索引
     * @param openid      用户的标识，对当前公众号唯一
     * @param lang        返回国家地区语言版本
     * @return 用户基本信息响应结果
     */
    @HttpMapping(method = HttpMethod.GET, uri = "/cgi-bin/user/info")
    WeChatPublicAccountUserInfo getUserInfo(@WeChatAccessTokenParam String weChatIndex,
                                            @HttpQuery(name = "openid") String openid,
                                            @HttpQuery(name = "lang", value = "zh_CN") String lang);

    /**
     * 批量获取用户基本信息
     * <p>参考文档：<a href="https://developers.weixin.qq.com/doc/subscription/api/usermanage/userinfo/api_batchuserinfo">批量获取用户基本信息</a></p>
     *
     * @param weChatIndex 微信应用索引
     * @param req         批量获取用户信息请求参数
     * @return 批量用户信息响应结果
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/user/info/batchget")
    WeChatPublicAccountBatchGetUserRes batchGetUserInfo(@WeChatAccessTokenParam String weChatIndex,
                                                        @JsonBody WeChatPublicAccountBatchGetUserReq req);

    /**
     * 获取粉丝列表
     * <p>参考文档：<a href="https://developers.weixin.qq.com/doc/subscription/api/usermanage/userinfo/api_getfans.html">获取粉丝列表</a></p>
     *
     * @param weChatIndex 微信应用索引
     * @param nextOpenId  第一个拉取的OPENID，不填默认从头开始拉取
     * @return 粉丝列表响应结果
     */
    @HttpMapping(method = HttpMethod.GET, uri = "/cgi-bin/user/get")
    WeChatPublicAccountBatchGetOpenIdsRes getFans(@WeChatAccessTokenParam String weChatIndex,
                                                  @HttpQuery(name = "next_openid") String nextOpenId);

    /**
     * 批量拉黑用户
     * <p>参考文档：<a href="https://developers.weixin.qq.com/doc/subscription/api/usermanage/userinfo/api_batchblacklist.html">批量拉黑用户</a></p>
     *
     * @param weChatIndex 微信应用索引
     * @param req         批量拉黑请求参数
     * @return 基础响应结果
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/tags/members/batchblacklist")
    BaseWeChatApiRes batchBlacklist(@WeChatAccessTokenParam String weChatIndex,
                                    @JsonBody BatchBlackListReq req);
}