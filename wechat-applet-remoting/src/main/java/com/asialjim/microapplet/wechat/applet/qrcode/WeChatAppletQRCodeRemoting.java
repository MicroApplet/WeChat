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

package com.asialjim.microapplet.wechat.applet.qrcode;

import com.asialjim.microapplet.remote.http.annotation.HttpMapping;
import com.asialjim.microapplet.remote.http.annotation.HttpMethod;
import com.asialjim.microapplet.remote.http.annotation.body.JsonBody;
import com.asialjim.microapplet.remote.net.annotation.Server;
import com.asialjim.microapplet.wechat.constant.WeChatCons;
import com.asialjim.microapplet.wechat.remoting.context.WeChatAccessTokenParam;
import com.asialjim.microapplet.wechat.remoting.context.BaseWeChatDownloadApiRes;

import com.asialjim.microapplet.wechat.applet.qrcode.request.CreateWxaQRCodeRequest;
import com.asialjim.microapplet.wechat.applet.qrcode.request.GetWxaCodeRequest;
import com.asialjim.microapplet.wechat.applet.qrcode.request.GetWxaCodeUnlimitRequest;

/**
 * 微信小程序二维码相关服务API客户端
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
public interface WeChatAppletQRCodeRemoting {

    /**
     * 获取小程序码，适用于需要的码数量较少的业务场景
     * <p>
     * 接口说明：
     * <ul>
     * <li>通过该接口生成的小程序码，永久有效，有数量限制</li>
     * <li>如果调用成功，会直接返回图片二进制内容，如果请求失败，会返回 JSON 格式的数据</li>
     * <li>POST 参数需要转成 JSON 字符串，不支持 form 表单提交</li>
     * <li>与 createQRCode 总共生成的码数量限制为 100,000，请谨慎调用</li>
     * </ul>
     * 
     * @param weChatIndex {@link String weChatIndex}
     * @param requestParam 请求参数，包含 path、width、autoColor、lineColor、isHyaline、envVersion 等参数
     * @return 小程序码的二进制数据
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/qrcode-link/qr-code/getQRCode.html">获取小程序码</a>
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxa/getwxacode")
    BaseWeChatDownloadApiRes getWxaCode(@WeChatAccessTokenParam String weChatIndex, @JsonBody GetWxaCodeRequest requestParam);

    /**
     * 获取不限制的小程序码，适用于需要的码数量极多的业务场景
     * <p>
     * 接口说明：
     * <ul>
     * <li>通过该接口生成的小程序码，永久有效，数量暂无限制</li>
     * <li>如果调用成功，会直接返回图片二进制内容，如果请求失败，会返回 JSON 格式的数据</li>
     * <li>POST 参数需要转成 JSON 字符串，不支持 form 表单提交</li>
     * <li>调用分钟频率受限（5000次/分钟），如需大量小程序码，建议预生成</li>
     * </ul>
     * <p>
     * scene 字段的值会作为 query 参数传递给小程序/小游戏。用户扫描该码进入小程序/小游戏后，
     * 开发者可以获取到二维码中的 scene 值，再做处理逻辑。
     * 
     * @param weChatIndex {@link String weChatIndex}
     * @param requestParam 请求参数，包含 scene、page、checkPath、envVersion、width、autoColor、lineColor、isHyaline 等参数
     * @return 小程序码的二进制数据
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/qrcode-link/qr-code/getUnlimitedQRCode.html">获取不限制的小程序码</a>
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxa/getwxacodeunlimit")
    BaseWeChatDownloadApiRes getWxaCodeUnlimit(@WeChatAccessTokenParam String weChatIndex, @JsonBody GetWxaCodeUnlimitRequest requestParam);

    /**
     * 获取小程序二维码
     * <p>
     * 接口说明：
     * <ul>
     * <li>获取小程序二维码，适用于需要的码数量较少的业务场景</li>
     * <li>通过该接口生成的小程序码，永久有效，有数量限制</li>
     * <li>如果调用成功，会直接返回图片二进制内容，如果请求失败，会返回 JSON 格式的数据</li>
     * <li>POST 参数需要转成 JSON 字符串，不支持 form 表单提交</li>
     * <li>接口只能生成已发布的小程序的二维码</li>
     * <li>与 wxacode.get 总共生成的码数量限制为 100,000，请谨慎调用</li>
     * </ul>
     * 
     * @param weChatIndex {@link String weChatIndex}
     * @param requestParam 请求参数，包含 path、width 等参数
     * @return 小程序二维码的二进制数据
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/qrcode-link/qr-code/createQRCode.html">获取小程序二维码</a>
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/wxaapp/createwxaqrcode")
    BaseWeChatDownloadApiRes createWxaQRCode(@WeChatAccessTokenParam String weChatIndex, @JsonBody CreateWxaQRCodeRequest requestParam);
}