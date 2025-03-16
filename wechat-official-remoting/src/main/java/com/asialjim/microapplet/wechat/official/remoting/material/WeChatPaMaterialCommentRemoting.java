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

package com.asialjim.microapplet.wechat.official.remoting.material;

import com.asialjim.microapplet.remote.http.annotation.HttpMapping;
import com.asialjim.microapplet.remote.http.annotation.HttpMethod;
import com.asialjim.microapplet.remote.http.annotation.body.JsonBody;
import com.asialjim.microapplet.remote.net.annotation.Server;
import com.asialjim.microapplet.wechat.constant.WeChatCons;
import com.asialjim.microapplet.wechat.official.remoting.material.meta.*;
import com.asialjim.microapplet.wechat.remoting.context.BaseWeChatApiRes;
import com.asialjim.microapplet.wechat.remoting.context.WeChatAccessTokenParam;

/**
 * 图文素材评论API客户端
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @since 2024/2/23, &nbsp;&nbsp; <em>version:</em>
 */
@SuppressWarnings("unused")
@Server(supplier = WeChatCons.Supplier.WECHAT, namespace = WeChatCons.Namespace.COMMON, schema = WeChatCons.Api.DEFAULT_SCHEMA, host = WeChatCons.Api.DEFAULT_HOST, port = WeChatCons.Api.DEFAULT_PORT)
public interface WeChatPaMaterialCommentRemoting {

    /**
     * 打开已发文章评论
     *
     * @param weChatIndexOrAccessToken {@link String weChatIndexOrAccessToken}
     * @param body                     {@link OpenCommentReq body}
     * @return {@link BaseWeChatApiRes }
     * @since 2024/2/23
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/comment/open")
    BaseWeChatApiRes open(@WeChatAccessTokenParam String weChatIndexOrAccessToken, @JsonBody OpenCommentReq body);

    /**
     * 关闭已群发文章评论
     *
     * @param weChatIndexOrAccessToken {@link String weChatIndexOrAccessToken}
     * @param body                     {@link OpenCommentReq body}
     * @return {@link BaseWeChatApiRes }
     * @since 2024/2/23
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/comment/close")
    BaseWeChatApiRes close(@WeChatAccessTokenParam String weChatIndexOrAccessToken, @JsonBody OpenCommentReq body);

    /**
     * 查看指定文章的评论数据
     *
     * @param weChatIndexOrAccessToken {@link String weChatIndexOrAccessToken}
     * @param body                     {@link CommentListReq body}
     * @return {@link CommentListRes }
     * @since 2024/2/23
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/comment/list")
    CommentListRes list(@WeChatAccessTokenParam String weChatIndexOrAccessToken, @JsonBody CommentListReq body);

    /**
     * 将评论标记精选
     *
     * @param weChatIndexOrAccessToken {@link String weChatIndexOrAccessToken}
     * @param body                     {@link MarkElectReq body}
     * @return {@link BaseWeChatApiRes }
     * @since 2024/2/23
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/comment/markelect")
    BaseWeChatApiRes markElect(@WeChatAccessTokenParam String weChatIndexOrAccessToken, @JsonBody MarkElectReq body);

    /**
     * 将评论取消精选
     *
     * @param weChatIndexOrAccessToken {@link String weChatIndexOrAccessToken}
     * @param body                     {@link MarkElectReq body}
     * @return {@link BaseWeChatApiRes }
     * @since 2024/2/23
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/comment/unmarkelect")
    BaseWeChatApiRes unMarkElect(@WeChatAccessTokenParam String weChatIndexOrAccessToken, @JsonBody MarkElectReq body);

    /**
     * 删除评论
     *
     * @param weChatIndexOrAccessToken {@link String weChatIndexOrAccessToken}
     * @param body                     {@link MarkElectReq body}
     * @return {@link BaseWeChatApiRes }
     * @since 2024/2/23
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/comment/delete")
    BaseWeChatApiRes delete(@WeChatAccessTokenParam String weChatIndexOrAccessToken, @JsonBody MarkElectReq body);

    /**
     * 回复评论
     *
     * @param weChatIndexOrAccessToken {@link String weChatIndexOrAccessToken}
     * @param body                     {@link AddReplyReq body}
     * @return {@link BaseWeChatApiRes }
     * @since 2024/2/23
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/comment/reply/add")
    BaseWeChatApiRes reply(@WeChatAccessTokenParam String weChatIndexOrAccessToken, @JsonBody AddReplyReq body);

    /**
     * 删除评论
     *
     * @param weChatIndexOrAccessToken {@link String weChatIndexOrAccessToken}
     * @param body                     {@link MarkElectReq body}
     * @return {@link BaseWeChatApiRes }
     * @since 2024/2/23
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/comment/reply/delete")
    BaseWeChatApiRes deleteReply(@WeChatAccessTokenParam String weChatIndexOrAccessToken, @JsonBody MarkElectReq body);
}