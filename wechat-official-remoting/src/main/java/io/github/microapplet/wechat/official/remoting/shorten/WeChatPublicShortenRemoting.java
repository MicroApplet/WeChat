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

package io.github.microapplet.wechat.official.remoting.shorten;

import io.github.microapplet.remote.http.annotation.HttpMapping;
import io.github.microapplet.remote.http.annotation.HttpMethod;
import io.github.microapplet.remote.http.annotation.body.JsonBody;
import io.github.microapplet.remote.net.annotation.Server;
import io.github.microapplet.wechat.constant.WeChatCons;
import io.github.microapplet.wechat.official.remoting.shorten.meta.FetchShortenReq;
import io.github.microapplet.wechat.official.remoting.shorten.meta.FetchShortenRes;
import io.github.microapplet.wechat.official.remoting.shorten.meta.ShortenKeyReq;
import io.github.microapplet.wechat.official.remoting.shorten.meta.ShortenKeyRes;
import io.github.microapplet.wechat.remoting.context.WeChatAccessTokenParam;

/**
 * WeChat Gen Shorten Key API Remoting
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
public interface WeChatPublicShortenRemoting {


    /**
     * 短key托管类似于短链API，开发者可以通过GenShorten将不超过4KB的长信息转成短key，再通过FetchShorten将短key还原为长信息。
     *
     * @param weChatIndexOrAccessToken {@link String weChatIndexOrAccessToken}
     * @param body                     {@link ShortenKeyReq body}
     * @return {@link ShortenKeyRes }
     * @since 2024/3/1
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/shorten/gen")
    ShortenKeyRes genShortKey(@WeChatAccessTokenParam String weChatIndexOrAccessToken, @JsonBody ShortenKeyReq body);

    /**
     * 根据 ShortenKey 获取LongData
     *
     * @param weChatIndexOrAccessToken {@link String weChatIndexOrAccessToken}
     * @param body                     {@link FetchShortenReq body}
     * @return {@link FetchShortenRes }
     * @since 2024/3/1
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/shorten/fetch")
    FetchShortenRes fetchShortKey(@WeChatAccessTokenParam String weChatIndexOrAccessToken, @JsonBody FetchShortenReq body);
}