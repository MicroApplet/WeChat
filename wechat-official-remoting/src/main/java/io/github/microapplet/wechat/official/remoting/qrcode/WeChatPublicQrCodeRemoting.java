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
package io.github.microapplet.wechat.official.remoting.qrcode;

import io.github.microapplet.remote.http.annotation.HttpMapping;
import io.github.microapplet.remote.http.annotation.HttpMethod;
import io.github.microapplet.remote.http.annotation.body.JsonBody;
import io.github.microapplet.remote.net.annotation.Server;
import io.github.microapplet.wechat.constant.WeChatCons;
import io.github.microapplet.wechat.official.remoting.qrcode.meta.CreateQrCodeRequest;
import io.github.microapplet.wechat.official.remoting.qrcode.meta.CreateQrCodeResponse;
import io.github.microapplet.wechat.remoting.context.WeChatAccessTokenParam;

/**
 * 微信公众号二维码服务 Remoting
 *
 * @author Copyright © <a href="mailto:asialjim@hotmail.com">Asial Jim</a>   Co., LTD
 * @version 1.0
 * @since 2022/2/23   &nbsp;&nbsp; JDK 8
 */
@SuppressWarnings("unused")
@Server(
        supplier = WeChatCons.Supplier.WECHAT,
        namespace = WeChatCons.Namespace.COMMON,
        schema = WeChatCons.Api.DEFAULT_SCHEMA,
        host = WeChatCons.Api.DEFAULT_HOST,
        port = WeChatCons.Api.DEFAULT_PORT
)
public interface WeChatPublicQrCodeRemoting {

    /**
     * 创建微信公众号二维码
     *
     * @param weChatIndexOrAccessToken {@link String 公众号索引}
     * @param body                     {@link CreateQrCodeRequest body}
     * @return {@link CreateQrCodeResponse }
     * @since 2024/2/7
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/qrcode/create")
    CreateQrCodeResponse createQrCode(@WeChatAccessTokenParam String weChatIndexOrAccessToken, @JsonBody CreateQrCodeRequest body);
}