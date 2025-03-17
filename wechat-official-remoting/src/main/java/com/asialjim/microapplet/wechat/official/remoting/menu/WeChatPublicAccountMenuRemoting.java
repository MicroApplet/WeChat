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
package com.asialjim.microapplet.wechat.official.remoting.menu;

import com.asialjim.microapplet.remote.http.annotation.HttpMapping;
import com.asialjim.microapplet.remote.http.annotation.HttpMethod;
import com.asialjim.microapplet.remote.http.annotation.body.JsonBody;
import com.asialjim.microapplet.remote.net.annotation.Server;
import com.asialjim.microapplet.wechat.constant.WeChatCons;
import com.asialjim.microapplet.wechat.official.remoting.menu.meta.*;
import com.asialjim.microapplet.wechat.official.remoting.menu.meta.create.WeChatPublicAccountCreateMenuReq;
import com.asialjim.microapplet.wechat.remoting.context.BaseWeChatApiRes;
import com.asialjim.microapplet.wechat.remoting.context.WeChatAccessTokenParam;

@SuppressWarnings("unused")
@Server(
        supplier = WeChatCons.Supplier.WECHAT,
        namespace = WeChatCons.Namespace.COMMON,
        schema = WeChatCons.Api.DEFAULT_SCHEMA,
        host = WeChatCons.Api.DEFAULT_HOST,
        port = WeChatCons.Api.DEFAULT_PORT
)
public interface WeChatPublicAccountMenuRemoting {

    /**
     * 创建公众号菜单
     *
     * @param subjectId {@link String subjectId}
     * @param body      {@link WeChatPublicAccountCreateMenuReq }
     * @return {@link BaseWeChatApiRes}
     * @since 2021/12/25 15:35
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/menu/create")
    BaseWeChatApiRes create(@WeChatAccessTokenParam String subjectId, @JsonBody WeChatPublicAccountCreateMenuReq body);

    /**
     * 查询公众号菜单接口
     *
     * @param subjectId {@link String subjectId} 公众号应用关键字，可选值： publicId, subjectId, appId
     * @return {@link WeChatPublicAccountCurrentMenuInfoRes }
     * @since 2021/12/25 15:45
     */
    @HttpMapping(method = HttpMethod.GET, uri = "/cgi-bin/get_current_selfmenu_info")
    WeChatPublicAccountCurrentMenuInfoRes currentSelfMenuInfo(@WeChatAccessTokenParam String subjectId);

    /**
     * 删除公众号菜单接口
     *
     * @param subjectId {@link String subjectId} 公众号应用关键字，可选值： publicId, subjectId, appId
     * @return {@link BaseWeChatApiRes }
     * @since 2021/12/25 15:46
     */
    @HttpMapping(method = HttpMethod.GET, uri = "/cgi-bin/menu/delete")
    BaseWeChatApiRes deleteMenu(@WeChatAccessTokenParam String subjectId);

    /**
     * 创建个性化的公众号菜单
     *
     * @param subjectId {@link String subjectId} 公众号应用关键字，可选值： publicId, subjectId, appId
     * @param body      {@link WeChatPublicAccountCreateMenuReq }
     * @return {@link WeChatPublicAccountAddConditionalMenuId}
     * @since 2021/12/25 15:35
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/menu/addconditional")
    WeChatPublicAccountAddConditionalMenuId addConditionalMenu(@WeChatAccessTokenParam String subjectId, @JsonBody WeChatPublicAccountCreateMenuReq body);

    /**
     * 删除个性化菜单
     *
     * @param subjectId {@link String subjectId} 公众号应用关键字，可选值： publicId, subjectId, appId
     * @param body      {@link WeChatPublicAccountAddConditionalMenuId body}
     * @return {@link BaseWeChatApiRes}
     * @since 2021/12/25 15:54
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/menu/delconditional")
    BaseWeChatApiRes deleteConditionalMenu(@WeChatAccessTokenParam String subjectId, @JsonBody WeChatPublicAccountAddConditionalMenuId body);

    /**
     * 测试个性化菜单匹配结果
     *
     * @param subjectId {@link String subjectId} 公众号应用关键字，可选值： publicId, subjectId, appId
     * @param body      {@link WeChatPublicAccountMenuTryMatchReq body}
     * @return {@link WeChatPublicAccountMenuTryMatchRes}
     * @since 2021/12/25 15:59
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/menu/trymatch")
    WeChatPublicAccountMenuTryMatchRes tryMatchMenu(@WeChatAccessTokenParam String subjectId, @JsonBody WeChatPublicAccountMenuTryMatchReq body);

    /**
     * 使用接口创建自定义菜单后，开发者还可使用接口查询自定义菜单的结构。另外请注意，在设置了个性化菜单后，使用本自定义菜单查询接口可以获取默认菜单和全部个性化菜单信息。
     *
     * @param subjectId {@link String subjectId} 公众号应用关键字，可选值： publicId, subjectId, appId
     * @return {@link WeChatPublicAccountMenuConfigRes}
     * @since 2021/12/25 16:04
     */
    @HttpMapping(method = HttpMethod.GET, uri = "/cgi-bin/menu/get")
    WeChatPublicAccountMenuConfigRes menuConfig(@WeChatAccessTokenParam String subjectId);
}