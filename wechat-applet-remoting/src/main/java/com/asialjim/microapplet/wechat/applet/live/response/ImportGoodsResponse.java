package com.asialjim.microapplet.wechat.applet.live.response;

import com.asialjim.microapplet.wechat.applet.message.meta.BaseWeChatMessageRes;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * 导入商品响应结果类
 * <p>
 * 接口文档：<a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/livebroadcast/goods-management/addGoods.html">...</a>
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/10/30, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ImportGoodsResponse extends BaseWeChatMessageRes implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    /**
     * 商品ID列表
     */
    @JsonProperty("goods_ids")
    private List<Long> goodsIds;
    
    /**
     * 商品信息列表
     */
    @JsonProperty("goods_info")
    private List<GoodsInfo> goodsInfo;
    
    /**
     * 商品信息类
     */
    @Data
    public static class GoodsInfo implements Serializable {
        
        private static final long serialVersionUID = 1L;
        
        /**
         * 商品ID
         */
        @JsonProperty("goods_id")
        private Long goodsId;
        
        /**
         * 审核单ID
         */
        @JsonProperty("audit_id")
        private Long auditId;
        
        /**
         * 商品名称
         */
        @JsonProperty("name")
        private String name;
        
        /**
         * 商品图片
         */
        @JsonProperty("cover_img")
        private String coverImg;
        
        /**
         * 商品价格
         */
        @JsonProperty("price")
        private Integer price;
        
        /**
         * 商品原价
         */
        @JsonProperty("original_price")
        private Integer originalPrice;
        
        /**
         * 商品详情页路径
         */
        @JsonProperty("url")
        private String url;
        
        /**
         * 商品描述
         */
        @JsonProperty("description")
        private String description;
        
        /**
         * 商品状态
         */
        @JsonProperty("status")
        private Integer status;
    }
}