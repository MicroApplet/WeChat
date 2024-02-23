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

package io.github.microapplet.wechat.official.remoting.material;

import com.fasterxml.jackson.annotation.JsonAlias;
import io.github.microapplet.remote.http.annotation.HttpMapping;
import io.github.microapplet.remote.http.annotation.HttpMethod;
import io.github.microapplet.remote.http.annotation.body.JsonBody;
import io.github.microapplet.remote.net.annotation.Server;
import io.github.microapplet.wechat.constant.WeChatCons;
import io.github.microapplet.wechat.official.remoting.material.meta.AddNewsReq;
import io.github.microapplet.wechat.official.remoting.material.meta.AddNewsRes;
import io.github.microapplet.wechat.remoting.context.WeChatAccessTokenParam;

/**
 * 图文消息留言管理API客户端
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0.0
 * @since 2024/2/23, &nbsp;&nbsp; <em>version:1.0.0</em>
 */
@SuppressWarnings("unused")
@Server(supplier = WeChatCons.Supplier.WECHAT, namespace = WeChatCons.Namespace.COMMON, schema = WeChatCons.Api.DEFAULT_SCHEMA, host = WeChatCons.Api.DEFAULT_HOST, port = WeChatCons.Api.DEFAULT_PORT)
public interface WeChatPaMaterialManageRemoting {

    /**
     * 新增永久素材
     *
	 * @param weChatIndexOrAccessToken {@link String weChatIndexOrAccessToken}
	 * @param body {@link AddNewsReq body}
     * @return {@link AddNewsRes }
     * @since 2024/2/23
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/material/add_news")
    AddNewsRes addNews(@WeChatAccessTokenParam String weChatIndexOrAccessToken, @JsonBody AddNewsReq body);
}