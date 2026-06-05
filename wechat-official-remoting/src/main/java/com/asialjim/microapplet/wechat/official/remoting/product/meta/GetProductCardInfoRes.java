package com.asialjim.microapplet.wechat.official.remoting.product.meta;

import com.asialjim.microapplet.wechat.remoting.context.BaseWeChatApiRes;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serial;

/**
 * 获取商品卡片DOM结构响应类
 * 参考文档：<a href="https://developers.weixin.qq.com/doc/subscription/api/draftbox/shop/api_ecsgetproductcardinfo.html">获取商品卡片的DOM结构</a>
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2024-10-31, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Data
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class GetProductCardInfoRes extends BaseWeChatApiRes  {

    @Serial
    private static final long serialVersionUID = -8683879425861106848L; // WeChat-wechat-official-remoting-com.asialjim.microapplet.wechat.official.remoting.product.meta.GetProductCardInfoRes



    /**
     * 商品key，部分文章类型插入商品卡片需要该key
     */
    @JsonProperty("product_key")
    private String productKey;

    /**
     * 商品卡DOM结构，多数文章类型插入商品卡片需要DOM结构
     */
    @JsonProperty("DOM")
    private String dom;
}