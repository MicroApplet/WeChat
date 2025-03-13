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

package io.github.microapplet.wechat.applet.user;

import io.github.microapplet.remote.http.annotation.HttpMapping;
import io.github.microapplet.remote.http.annotation.HttpMethod;
import io.github.microapplet.remote.http.annotation.HttpQuery;
import io.github.microapplet.remote.net.annotation.Server;
import io.github.microapplet.wechat.applet.user.meta.WeChatAppletUserLoginRes;
import io.github.microapplet.wechat.constant.WeChatCons;

/**
 * 微信小程序用户相关服务API客户端
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/2/25, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Server(
        supplier = WeChatCons.Supplier.WECHAT,
        namespace = WeChatCons.Namespace.COMMON,
        schema = WeChatCons.Api.DEFAULT_SCHEMA,
        host = WeChatCons.Api.DEFAULT_HOST,
        port = WeChatCons.Api.DEFAULT_PORT
)
public interface WeChatAppletUserRemoting {

    /**
     * 小程序用户登录
     * @param appid 应用编号
     * @param secret 密码
     * @param code 授权码
     */
    @HttpMapping(method = HttpMethod.GET,uri = "/sns/jscode2session", queries = @HttpQuery(name = "grant_type", value = "client_credential"))
    WeChatAppletUserLoginRes login(@HttpQuery(name = "appid") String appid, @HttpQuery(name = "secret") String secret, @HttpQuery(name = "js_code")String code);
}