package com.asialjim.microapplet.wechat.applet.live.response;

import lombok.Data;

import java.io.Serializable;

/**
 * 直播商品信息
 *
 * @author Asial Jim
 * @version 1.0
 * @since 2025/10/30
 */
@Data
public class GoodsInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /**
     * 商品ID
     */
    private String goodsId;
    
    /**
     * 商品名称
     */
    private String goodsName;
    
    /**
     * 商品图片
     */
    private String coverImg;
    
    /**
     * 商品价格
     */
    private Integer price;
}