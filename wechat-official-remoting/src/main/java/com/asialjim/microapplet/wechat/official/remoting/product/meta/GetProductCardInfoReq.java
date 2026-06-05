package com.asialjim.microapplet.wechat.official.remoting.product.meta;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

/**
 * 获取商品卡片DOM结构请求类
 * 参考文档：<a href="https://developers.weixin.qq.com/doc/subscription/api/draftbox/shop/api_ecsgetproductcardinfo.html">获取商品卡片的DOM结构</a>
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2024-10-31, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Data
@Accessors(chain = true)
public class GetProductCardInfoReq implements Serializable {

    @Serial
    private static final long serialVersionUID = -6849794470754667710L; // WeChat-wechat-official-remoting-com.asialjim.microapplet.wechat.official.remoting.product.meta.GetProductCardInfoReq

    /**
     * 商品id
     */
    @JsonProperty("product_id")
    private String productId;

    /**
     * 文章类型，当前支持：图片消息(newspic)、图文消息(news)
     */
    @JsonProperty("article_type")
    private String articleType;

    /**
     * 卡片类型，当前支持：大卡(0)、小卡(1)、文字链接(2)、条卡(3)
     */
    @JsonProperty("card_type")
    private Integer cardType;
}