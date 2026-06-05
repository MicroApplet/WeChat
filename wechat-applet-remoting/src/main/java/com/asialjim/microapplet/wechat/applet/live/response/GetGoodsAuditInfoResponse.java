package com.asialjim.microapplet.wechat.applet.live.response;

import com.asialjim.microapplet.wechat.applet.message.meta.BaseWeChatMessageRes;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * 获取商品的信息与审核状态响应结果类
 * <p>
 * 接口文档：<a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/livebroadcast/commodity-management/getGoodsAuditInfo.html">...</a>
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/10/30, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class GetGoodsAuditInfoResponse extends BaseWeChatMessageRes implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 商品信息列表
     */
    @JsonProperty("goods_list")
    private List<GoodsAuditInfo> goodsList;

    /**
     * 商品个数
     */
    @JsonProperty("total")
    private Integer total;

    /**
     * 商品审核信息类
     */
    @Data
    public static class GoodsAuditInfo implements Serializable {
        private static final long serialVersionUID = 1L;

        /**
         * 商品ID
         */
        @JsonProperty("goods_id")
        private Integer goodsId;

        /**
         * 商品名称
         */
        @JsonProperty("name")
        private String name;

        /**
         * 商品图片url
         */
        @JsonProperty("cover_img_url")
        private String coverImgUrl;

        /**
         * 商品详情页的小程序路径
         */
        @JsonProperty("url")
        private String url;

        /**
         * 1:一口价，此时读price字段; 2:价格区间，此时price字段为左边界，price2字段为右边界; 3:折扣价，此时price字段为原价，price2字段为现价
         */
        @JsonProperty("priceType")
        private Integer priceType;

        /**
         * 价格左区间，单位"元"
         */
        @JsonProperty("price")
        private Double price;

        /**
         * 价格右区间，单位"元"
         */
        @JsonProperty("price2")
        private Double price2;

        /**
         * 0：未审核，1：审核中，2:审核通过，3审核失败
         */
        @JsonProperty("audit_status")
        private Integer auditStatus;

        /**
         * 1、2：表示是为 API 添加商品，否则是直播控制台添加的商品
         */
        @JsonProperty("third_party_tag")
        private Integer thirdPartyTag;

        /**
         * 当商品为第三方小程序的商品则为对应第三方小程序的appid，自身小程序商品则为空字符串
         */
        @JsonProperty("thirdPartyAppid")
        private String thirdPartyAppid;
    }
}