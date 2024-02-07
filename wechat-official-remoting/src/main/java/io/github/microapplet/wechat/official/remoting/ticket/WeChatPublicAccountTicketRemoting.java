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
package io.github.microapplet.wechat.official.remoting.ticket;

import io.github.microapplet.remote.http.annotation.HttpMapping;
import io.github.microapplet.remote.http.annotation.HttpMethod;
import io.github.microapplet.remote.http.annotation.HttpQuery;
import io.github.microapplet.remote.net.annotation.Server;
import io.github.microapplet.wechat.constant.WeChatCons;
import io.github.microapplet.wechat.official.remoting.ticket.meta.WeChatPublicAccountTicketInfo;
import io.github.microapplet.wechat.remoting.context.WeChatAccessTokenParam;

/**
 * 微信公众号 ticket 相关 REMOTING
 *
 * @author Copyright © <a href="mailto:asialjim@hotmail.com">Asial Jim</a>   Co., LTD
 * @version 1.0.0
 * @since 2021/12/28 9:18   &nbsp;&nbsp; JDK 8
 */
@SuppressWarnings("unused")
@Server(
        supplier = WeChatCons.Supplier.WECHAT,
        namespace = WeChatCons.Namespace.COMMON,
        schema = WeChatCons.Api.DEFAULT_SCHEMA,
        host = WeChatCons.Api.DEFAULT_HOST,
        port = WeChatCons.Api.DEFAULT_PORT
)
public interface WeChatPublicAccountTicketRemoting {

    /**
     * 获取微信卡券 票据
     *
     * @param subjectId {@link String subjectId}
     * @return {@link WeChatPublicAccountTicketInfo}
     * @since 2021/12/29 17:29
     */
    @HttpMapping(method = HttpMethod.GET, uri = "/cgi-bin/ticket/getticket", queries = @HttpQuery(name = "type", value = "wx_card"))
    WeChatPublicAccountTicketInfo weChatCardTicket(@WeChatAccessTokenParam String subjectId);

    /**
     * 获取微信 jsapi 票据
     *
     * @param subjectId {@link String subjectId}
     * @return {@link WeChatPublicAccountTicketInfo}
     * @since 2021/12/29 17:29
     */
    @HttpMapping(method = HttpMethod.GET, uri = "/cgi-bin/ticket/getticket", queries = @HttpQuery(name = "type", value = "jsapi"))
    WeChatPublicAccountTicketInfo jsApiTicket(@WeChatAccessTokenParam String subjectId);
}