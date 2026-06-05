package com.asialjim.microapplet.wechat.applet.live.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 商品上下架请求参数
 * 接口文档：<a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/livebroadcast/studio-management/SaleGoods.html">...</a>
 *
 * @author Asial Jim
 * @version 1.0
 * @since 2025/10/30
 */
@Data
public class SaleGoodsRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /**
     * 直播间ID
     */
    private Integer roomId;
    
    /**
     * 商品ID
     */
    private Long goodsId;
    
    /**
     * 上下架状态，0：下架，1：上架
     */
    private Integer onOff;
}