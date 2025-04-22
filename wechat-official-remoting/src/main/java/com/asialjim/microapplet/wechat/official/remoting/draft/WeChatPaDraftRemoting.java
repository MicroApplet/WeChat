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

package com.asialjim.microapplet.wechat.official.remoting.draft;

import com.asialjim.microapplet.remote.http.annotation.HttpMapping;
import com.asialjim.microapplet.remote.http.annotation.HttpMethod;
import com.asialjim.microapplet.remote.http.annotation.HttpQuery;
import com.asialjim.microapplet.remote.http.annotation.body.JsonBody;
import com.asialjim.microapplet.remote.net.annotation.Server;
import com.asialjim.microapplet.wechat.constant.WeChatCons;
import com.asialjim.microapplet.wechat.official.remoting.draft.meta.*;
import com.asialjim.microapplet.wechat.remoting.context.BaseWeChatApiRes;
import com.asialjim.microapplet.wechat.remoting.context.WeChatAccessTokenParam;

/**
 * 微信公众号草稿箱API客户端
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0.0
 * @since 2024/2/22, &nbsp;&nbsp; <em>version:1.0.0</em>
 */
@SuppressWarnings("unused")
@Server(
        supplier = WeChatCons.Supplier.WECHAT,
        namespace = WeChatCons.Namespace.COMMON,
        schema = WeChatCons.Api.DEFAULT_SCHEMA,
        host = WeChatCons.Api.DEFAULT_HOST,
        port = WeChatCons.Api.DEFAULT_PORT
)
public interface WeChatPaDraftRemoting {

    /**
     * 新建草稿
     * <pre>
     *     开发者可新增常用的素材到草稿箱中进行使用。上传到草稿箱中的素材被群发或发布后，该素材将从草稿箱中移除。新增草稿可在公众平台官网-草稿箱中查看和管理。
     * </pre>
     *
     * @param weChatIndexOrAccessToken {@link String weChatIndexOrAccessToken}
     * @param body                     {@link AddDraftReq body}
     * @return {@link AddDraftRes }
     * @since 2024/2/22
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/draft/add")
    AddDraftRes add(@WeChatAccessTokenParam String weChatIndexOrAccessToken, @JsonBody AddDraftReq body);

    /**
     * 获取草稿
     * <pre>
     *     新增草稿后，开发者可以根据草稿指定的字段来下载草稿。
     * </pre>
     *
     * @param weChatIndexOrAccessToken {@link String weChatIndexOrAccessToken}
     * @param body                     {@link DraftMedia body}
     * @return {@link GetDraftRes }
     * @since 2024/2/22
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/draft/get")
    GetDraftRes get(@WeChatAccessTokenParam String weChatIndexOrAccessToken, @JsonBody DraftMedia body);

    /**
     * 删除草稿
     * <pre>
     *     新增草稿后，开发者可以根据本接口来删除不再需要的草稿，节省空间。此操作无法撤销，请谨慎操作。
     * </pre>
     *
     * @param weChatIndexOrAccessToken {@link String weChatIndexOrAccessToken}
     * @param body                     {@link DraftMedia body}
     * @return {@link BaseWeChatApiRes }
     * @since 2024/2/22
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/draft/delete")
    BaseWeChatApiRes delete(@WeChatAccessTokenParam String weChatIndexOrAccessToken, @JsonBody DraftMedia body);

    /**
     * 修改草稿
     *
     * @param weChatIndexOrAccessToken {@link String weChatIndexOrAccessToken}
     * @param body                     {@link UpdateDraftReq body}
     * @return {@link BaseWeChatApiRes }
     * @since 2024/2/23
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/draft/update")
    BaseWeChatApiRes update(@WeChatAccessTokenParam String weChatIndexOrAccessToken, @JsonBody UpdateDraftReq body);

    /**
     * 获取草稿总数
     *
     * @param weChatIndexOrAccessToken {@link String weChatIndexOrAccessToken}
     * @return {@link DraftCountRes }
     * @since 2024/2/23
     */
    @HttpMapping(method = HttpMethod.GET, uri = "/cgi-bin/draft/count")
    DraftCountRes count(@WeChatAccessTokenParam String weChatIndexOrAccessToken);

    /**
     * 获取草稿列表
     *
     * @param weChatIndexOrAccessToken {@link String weChatIndexOrAccessToken}
     * @param body                     {@link DraftListReq body}
     * @return {@link DraftListRes }
     * @since 2024/2/23
     */
    @HttpMapping(method = HttpMethod.GET, uri = "/cgi-bin/draft/batchget")
    DraftListRes batchGet(@WeChatAccessTokenParam String weChatIndexOrAccessToken, @JsonBody DraftListReq body);

    /**
     * MP端开关
     * <pre>
     *     由于草稿箱和发布功能仍处于内测阶段，若公众号没有被灰度覆盖，可能无法体验草稿箱和发布功能。为了解决这个问题，我们在上述API接口的基础上，设了这样一个开关：当一个公众号选择开启后，该账号在微信公众平台后台（mp.weixin.qq.com)上的图文素材库将升级为草稿箱，并可以在微信公众平台后台使用发布功能。
     *
     * 请注意：
     *
     * 内测期间会逐步放量，任何用户都可能会自动打开；
     * 此开关开启后不可逆，换言之，无法从开启的状态回到关闭；
     * 内测期间，无论开关开启与否，旧版的图文素材API，以及新版的草稿箱、发布等API均可以正常使用；
     * 在内测结束之后，所有用户都将自动开启，即草稿箱、发布等功能将对所有用户开放，本开关连同之前的图文素材API也将随后下线。
     * </pre>
     *
     * @param weChatIndexOrAccessToken {@link String weChatIndexOrAccessToken}
     * @param checkOnly                {@link String checkOnly}
     * @return {@link DraftSwitchRes }
     * @since 2024/2/23
     */
    @HttpMapping(method = HttpMethod.GET, uri = "/cgi-bin/draft/switch")
    DraftSwitchRes switchDraft(@WeChatAccessTokenParam String weChatIndexOrAccessToken, @HttpQuery(name = "checkonly") String checkOnly);
}