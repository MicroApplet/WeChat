package com.asialjim.microapplet.wechat.official.remoting.product;

import com.asialjim.microapplet.remote.http.annotation.HttpMapping;
import com.asialjim.microapplet.remote.http.annotation.HttpMethod;
import com.asialjim.microapplet.remote.http.annotation.body.JsonBody;
import com.asialjim.microapplet.remote.net.annotation.Server;
import com.asialjim.microapplet.wechat.constant.WeChatCons;
import com.asialjim.microapplet.wechat.official.remoting.product.meta.GetProductCardInfoReq;
import com.asialjim.microapplet.wechat.official.remoting.product.meta.GetProductCardInfoRes;
import com.asialjim.microapplet.wechat.remoting.context.WeChatAccessTokenParam;

/**
 * 微信公众号商品相关接口
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2024-10-31, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Server(
        supplier = WeChatCons.Supplier.WECHAT,
        namespace = WeChatCons.Namespace.COMMON,
        schema = WeChatCons.Api.DEFAULT_SCHEMA,
        host = WeChatCons.Api.DEFAULT_HOST,
        port = WeChatCons.Api.DEFAULT_PORT
)
public interface WeChatOfficialProductRemoting {

    /**
     * 获取商品卡片的DOM结构
     * 参考文档：<a href="https://developers.weixin.qq.com/doc/subscription/api/draftbox/shop/api_ecsgetproductcardinfo.html">获取商品卡片的DOM结构</a>
     *
     * @param weChatIndex 微信公众平台应用索引
     * @param request     请求参数
     * @return 商品卡片DOM结构响应
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/channels/ec/service/product/getcardinfo")
    GetProductCardInfoRes getProductCardInfo(
            @WeChatAccessTokenParam String weChatIndex,
            @JsonBody GetProductCardInfoReq request
    );
}