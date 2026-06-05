package com.asialjim.microapplet.wechat.applet.live.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 更新商品状态请求参数类
 * <p>
 * 接口文档：<a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/livebroadcast/goods-management/resumeGoods.html">...</a>
 * <a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/livebroadcast/goods-management/deleteGoods.html">...</a>
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/10/30, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Data
public class UpdateGoodsStatusRequest implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    /**
     * 商品ID列表
     */
    @JsonProperty("goods_ids")
    private List<Long> goodsIds;
    
    /**
     * 商品状态，0：下架，1：上架
     */
    @JsonProperty("status")
    private Integer status;
}