package com.asialjim.microapplet.wechat.applet.live.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 导入商品请求参数类
 * <p>
 * 接口文档：<a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/livebroadcast/goods-management/addGoods.html">...</a>
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/10/30, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Data
public class ImportGoodsRequest implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    /**
     * 商品信息列表
     */
    @JsonProperty("goods")
    private List<GoodsInfo> goods;
    
    /**
     * 商品信息类
     */
    @Data
    public static class GoodsInfo implements Serializable {
        
        private static final long serialVersionUID = 1L;
        
        /**
         * 商品名称，最长14个汉字，1个汉字等于2个字符
         */
        @JsonProperty("name")
        private String name;
        
        /**
         * 商品图片，图片mediaID，图片规则：建议像素800*800，大小不超过1M
         */
        @JsonProperty("cover_img")
        private String coverImg;
        
        /**
         * 商品价格，单位分
         */
        @JsonProperty("price")
        private Integer price;
        
        /**
         * 商品原价，单位分
         */
        @JsonProperty("original_price")
        private Integer originalPrice;
        
        /**
         * 商品详情页路径，相对路径
         */
        @JsonProperty("url")
        private String url;
        
        /**
         * 商品描述，最长200字
         */
        @JsonProperty("description")
        private String description;
        
        /**
         * 商品SKU信息，最大支持100个SKU，必填
         */
        @JsonProperty("skus")
        private List<SkuInfo> skus;
    }
    
    /**
     * SKU信息类
     */
    @Data
    public static class SkuInfo implements Serializable {
        
        private static final long serialVersionUID = 1L;
        
        /**
         * 商品ID，必须是小程序商城商品ID，必填
         */
        @JsonProperty("product_id")
        private Integer productId;
        
        /**
         * skuID，必须是小程序商城SKUID，必填
         */
        @JsonProperty("sku_id")
        private Integer skuId;
        
        /**
         * 商品价格，单位分，必填
         */
        @JsonProperty("price")
        private Integer price;
        
        /**
         * 商品库存，必填
         */
        @JsonProperty("stock")
        private Integer stock;
        
        /**
         * 商品图片，图片mediaID，必填
         */
        @JsonProperty("cover_img")
        private String coverImg;
        
        /**
         * 商品名称，必填
         */
        @JsonProperty("name")
        private String name;
    }
}