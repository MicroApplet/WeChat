package com.asialjim.microapplet.wechat.applet.url;

import com.asialjim.microapplet.remote.http.annotation.HttpMapping;
import com.asialjim.microapplet.remote.http.annotation.HttpMethod;
import com.asialjim.microapplet.remote.http.annotation.body.JsonBody;
import com.asialjim.microapplet.remote.net.annotation.Server;
import com.asialjim.microapplet.wechat.constant.WeChatCons;
import com.asialjim.microapplet.wechat.remoting.context.WeChatAccessTokenParam;
import com.asialjim.microapplet.wechat.applet.url.meta.GenerateUrlLinkRes;
import com.asialjim.microapplet.wechat.applet.url.meta.QueryUrlLinkRes;
import com.asialjim.microapplet.wechat.applet.url.meta.GenerateShortLinkRes;
import com.asialjim.microapplet.wechat.applet.url.request.GenerateUrlLinkRequest;
import com.asialjim.microapplet.wechat.applet.url.request.QueryUrlLinkRequest;
import com.asialjim.microapplet.wechat.applet.url.request.GenerateShortLinkRequest;

/**
 * 微信小程序URL Link相关服务API客户端
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
public interface WeChatAppletUrlLinkRemoting {

    /**
     * 获取小程序URL Link
     * <p>
     * 接口说明：
     * <ul>
     * <li>该接口用于获取小程序URL Link，适用于短信、邮件、网页、微信内等拉起小程序的业务场景</li>
     * <li>目前仅针对国内非个人主体的小程序开放</li>
     * <li>生成端：每天生成URL Scheme（加密/明文）和URL Link的总数量上限为50万</li>
     * <li>打开端：每天通过URL Scheme（加密/明文）和URL Link打开小程序的总次数上限为300万</li>
     * <li>取消URL Link一人一链的限制，支持同一条连接被多名用户访问</li>
     * <li>加密URL Link支持开发者自行在链接后面拼接query参数</li>
     * <li>只能生成已发布的小程序的URL Link</li>
     * <li>频率限制：100次/秒</li>
     * </ul>
     *
     * @param weChatIndex {@link String weChatIndex}
     * @param requestParam 请求参数，包含path、query、expireType、expireTime、expireInterval、cloudBase、envVersion等参数
     * @return 生成的小程序URL Link
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/qrcode-link/url-link/generateUrlLink.html">获取加密URL Link</a>
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxa/generateurllink")
    GenerateUrlLinkRes generateUrlLink(@WeChatAccessTokenParam String weChatIndex, @JsonBody GenerateUrlLinkRequest requestParam);

    /**
     * 查询小程序加密URL Link配置
     * <p>
     * 接口说明：
     * <ul>
     * <li>该接口用于查询小程序加密url_link配置</li>
     * <li>支持查询url_link信息和查询每天剩余访问次数</li>
     * </ul>
     *
     * @param weChatIndex {@link String weChatIndex}
     * @param requestParam 请求参数，包含url_link和query_type参数
     * @return 查询结果，包含url_link_info和quota_info
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/qrcode-link/url-link/queryUrlLink.html">查询加密URLLink</a>
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxa/query_urllink")
    QueryUrlLinkRes queryUrlLink(@WeChatAccessTokenParam String weChatIndex, @JsonBody QueryUrlLinkRequest requestParam);

    /**
     * 获取小程序ShortLink
     * <p>
     * 接口说明：
     * <ul>
     * <li>该接口用于获取小程序ShortLink，适用于微信内拉起小程序的业务场景</li>
     * <li>目前只开放给电商类目(具体包含以下一级类目：电商平台、商家自营、跨境电商)</li>
     * <li>单个小程序每日生成ShortLink上限为100万个（包含短期有效ShortLink与长期有效ShortLink）</li>
     * <li>单个小程序总共可生成永久有效ShortLink上限为10万个，请谨慎调用</li>
     * <li>短期有效ShortLink有效时间为30天，单个小程序生成短期有效ShortLink不设上限</li>
     * </ul>
     *
     * @param weChatIndex {@link String weChatIndex}
     * @param requestParam 请求参数，包含page_url、page_title、is_permanent参数
     * @return 生成的小程序ShortLink
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/qrcode-link/short-link/generateShortLink.html">获取ShortLink</a>
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxa/genwxashortlink")
    GenerateShortLinkRes generateShortLink(@WeChatAccessTokenParam String weChatIndex, @JsonBody GenerateShortLinkRequest requestParam);
}