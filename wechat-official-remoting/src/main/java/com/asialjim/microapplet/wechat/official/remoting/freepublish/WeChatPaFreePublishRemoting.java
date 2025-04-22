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

package com.asialjim.microapplet.wechat.official.remoting.freepublish;

import com.asialjim.microapplet.remote.http.annotation.HttpMapping;
import com.asialjim.microapplet.remote.http.annotation.HttpMethod;
import com.asialjim.microapplet.remote.http.annotation.body.JsonBody;
import com.asialjim.microapplet.remote.net.annotation.Server;
import com.asialjim.microapplet.wechat.constant.WeChatCons;
import com.asialjim.microapplet.wechat.official.remoting.freepublish.meta.*;
import com.asialjim.microapplet.wechat.remoting.context.WeChatAccessTokenParam;

/**
 * 公众号文章发布能力API客户端
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0.0
 * @since 2024/2/23, &nbsp;&nbsp; <em>version:1.0.0</em>
 */
@SuppressWarnings("unused")
@Server(
        supplier = WeChatCons.Supplier.WECHAT,
        namespace = WeChatCons.Namespace.COMMON,
        schema = WeChatCons.Api.DEFAULT_SCHEMA,
        host = WeChatCons.Api.DEFAULT_HOST,
        port = WeChatCons.Api.DEFAULT_PORT
)
public interface WeChatPaFreePublishRemoting {

    /**
     * 发布接口
     * <pre>
     *     开发者需要先将图文素材以草稿的形式保存（见“草稿箱/新建草稿”，如需从已保存的草稿中选择，见“草稿箱/获取草稿列表”），选择要发布的草稿 media_id 进行发布
     * </pre>
     *
     * @param weChatIndexOrAccessToken {@link String weChatIndexOrAccessToken}
     * @param body                     {@link SubmitReq body}
     * @return {@link SubmitRes }
     * @since 2024/2/23
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/freepublish/submit")
    SubmitRes submit(@WeChatAccessTokenParam String weChatIndexOrAccessToken, @JsonBody SubmitReq body);

    /**
     * 发布状态轮询接口
     *
     * @param weChatIndexOrAccessToken {@link String weChatIndexOrAccessToken}
     * @param body                     {@link FreePublishGetReq body}
     * @return {@link FreePublishGetRes }
     * @since 2024/2/23
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/freepublish/get")
    FreePublishGetRes get(@WeChatAccessTokenParam String weChatIndexOrAccessToken, @JsonBody FreePublishGetReq body);

    /**
     * 删除发布
     *
     * @param weChatIndexOrAccessToken {@link String weChatIndexOrAccessToken}
     * @param body                     {@link FreePublishDeleteReq body}
     * @return {@link FreePublishDeleteRes }
     * @since 2024/2/23
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/freepublish/delete")
    FreePublishDeleteRes delete(@WeChatAccessTokenParam String weChatIndexOrAccessToken, @JsonBody FreePublishDeleteReq body);

    /**
     * 通过article_id获取已发布文章
     *
     * @param weChatIndexOrAccessToken {@link String weChatIndexOrAccessToken}
     * @param body                     {@link FreePublishGetArticleReq body}
     * @return {@link FreePublishGetArticleRes }
     * @since 2024/2/23
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/freepublish/getarticle")
    FreePublishGetArticleRes article(@WeChatAccessTokenParam String weChatIndexOrAccessToken, @JsonBody FreePublishGetArticleReq body);

    /**
     * 获取成功发布列表
     *
     * @param weChatIndexOrAccessToken {@link String weChatIndexOrAccessToken}
     * @param body                     {@link FreePublishBatchGetReq body}
     * @return {@link FreePublishBatchGetRes }
     * @since 2024/2/23
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/freepublish/batchget")
    FreePublishBatchGetRes batch(@WeChatAccessTokenParam String weChatIndexOrAccessToken, @JsonBody FreePublishBatchGetReq body);
}