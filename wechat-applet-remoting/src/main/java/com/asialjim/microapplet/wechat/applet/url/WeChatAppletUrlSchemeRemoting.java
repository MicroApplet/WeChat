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

package com.asialjim.microapplet.wechat.applet.url;

import com.asialjim.microapplet.remote.http.annotation.HttpMapping;
import com.asialjim.microapplet.remote.http.annotation.HttpMethod;
import com.asialjim.microapplet.remote.http.annotation.body.JsonBody;
import com.asialjim.microapplet.remote.net.annotation.Server;
import com.asialjim.microapplet.wechat.constant.WeChatCons;
import com.asialjim.microapplet.wechat.remoting.context.WeChatAccessTokenParam;
import com.asialjim.microapplet.wechat.applet.url.meta.GenerateSchemeRes;
import com.asialjim.microapplet.wechat.applet.url.meta.GenerateNFCSchemeRes;
import com.asialjim.microapplet.wechat.applet.url.meta.QuerySchemeRes;
import com.asialjim.microapplet.wechat.applet.url.request.GenerateSchemeRequest;
import com.asialjim.microapplet.wechat.applet.url.request.GenerateNFCSchemeRequest;
import com.asialjim.microapplet.wechat.applet.url.request.QuerySchemeRequest;

/**
 * 微信小程序URL Scheme相关服务API客户端
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/10/30, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Server(
        supplier = WeChatCons.Supplier.WECHAT,
        namespace = WeChatCons.Namespace.COMMON,
        schema = WeChatCons.Api.DEFAULT_SCHEMA,
        host = WeChatCons.Api.DEFAULT_HOST,
        port = WeChatCons.Api.DEFAULT_PORT
)
public interface WeChatAppletUrlSchemeRemoting {

    /**
     * 获取小程序scheme码
     * <p>
     * 接口说明：
     * <ul>
     * <li>该接口用于获取小程序scheme码，适用于短信、邮件、外部网页、微信内等拉起小程序的业务场景</li>
     * <li>目前仅针对国内非个人主体的小程序开放</li>
     * <li>生成端：每天生成URL Scheme（加密/明文）和URL Link的总数量上限为50万</li>
     * <li>打开端：每天通过URL Scheme（加密/明文）和URL Link打开小程序的总次数上限为300万</li>
     * <li>加密URL Scheme支持开发者自行在链接后面拼接query参数</li>
     * <li>只能生成已发布的小程序的URL Scheme</li>
     * </ul>
     *
     * @param weChatIndex {@link String weChatIndex}
     * @param requestParam 请求参数，包含jumpWxa、expireTime、expireType、expireInterval等参数
     * @return 生成的小程序scheme码
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/qrcode-link/url-scheme/generateScheme.html">获取小程序scheme码</a>
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxa/generatescheme")
    GenerateSchemeRes generateScheme(@WeChatAccessTokenParam String weChatIndex, @JsonBody GenerateSchemeRequest requestParam);

    /**
     * 查询小程序scheme码
     * <p>
     * 接口说明：
     * <ul>
     * <li>该接口用于查询小程序scheme码，包括加密scheme和明文scheme</li>
     * <li>支持查询scheme码信息和每天剩余访问次数</li>
     * <li>可以查询加密scheme和明文scheme的详细信息</li>
     * </ul>
     *
     * @param weChatIndex {@link String weChatIndex}
     * @param requestParam 请求参数，包含scheme（小程序scheme码）和queryType（查询类型）
     * @return 查询结果，包含schemeInfo（scheme信息）和quotaInfo（quota配置）
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/qrcode-link/url-scheme/queryScheme.html">查询小程序scheme码</a>
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxa/queryscheme")
    QuerySchemeRes queryScheme(@WeChatAccessTokenParam String weChatIndex, @JsonBody QuerySchemeRequest requestParam);
    
    /**
     * 获取NFC的小程序scheme码
     * <p>
     * 接口说明：
     * <ul>
     * <li>该接口用于获取用于NFC的小程序scheme码，适用于NFC拉起小程序的业务场景</li>
     * <li>目前仅针对国内非个人主体的小程序开放</li>
     * <li>频率限制：100次/秒</li>
     * <li>生成端：每天生成URL Scheme和URL Link的总数量上限为50万</li>
     * <li>长期有效Scheme或short link达到生成上限10万，不可再生成</li>
     * </ul>
     *
     * @param weChatIndex {@link String weChatIndex}
     * @param requestParam 请求参数，包含jumpWxa、modelId、sn等参数
     * @return 生成的小程序scheme码
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/qrcode-link/url-scheme/generateNFCScheme.html">获取NFC的小程序scheme码</a>
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxa/generatenfcscheme")
    GenerateNFCSchemeRes generateNFCScheme(@WeChatAccessTokenParam String weChatIndex, @JsonBody GenerateNFCSchemeRequest requestParam);
}