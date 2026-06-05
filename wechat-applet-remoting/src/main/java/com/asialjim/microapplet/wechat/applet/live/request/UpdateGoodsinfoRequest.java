package com.asialjim.microapplet.wechat.applet.live.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 更新商品请求参数类
 * <p>
 * 接口文档：<a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/livebroadcast/commodity-management/updateGoodsinfo.html">...</a>
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/10/30, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Data
public class UpdateGoodsinfoRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 填入mediaID（mediaID获取后，三天内有效）；图片mediaID的获取，请参考以下文档：New_temporary_materials；
     * 图片规则：图片尺寸最大300像素*300像素
     */
    @JsonProperty("coverImgUrl")
    private String coverImgUrl;

    /**
     * 商品名称，最长14个汉字，1个汉字相当于2个字符
     */
    @JsonProperty("name")
    private String name;

    /**
     * 价格类型，1：一口价（只需要传入price，price2不传）
     * 2：价格区间（price字段为左边界，price2字段为右边界，price和price2必传）
     * 3：显示折扣价（price字段为原价，price2字段为现价， price和price2必传）
     */
    @JsonProperty("priceType")
    private Integer priceType;

    /**
     * 数字，最多保留两位小数，单位元
     */
    @JsonProperty("price")
    private Double price;

    /**
     * 数字，最多保留两位小数，单位元
     */
    @JsonProperty("price2")
    private Double price2;

    /**
     * 商品详情页的小程序路径，路径参数存在 url 的，该参数的值需要进行 encode 处理再填入
     */
    @JsonProperty("url")
    private String url;

    /**
     * 商品ID
     */
    @JsonProperty("goodsId")
    private Integer goodsId;

    /**
     * 当商品为第三方小程序的商品则填写为对应第三方小程序的appid，自身小程序商品则为空字符串
     */
    @JsonProperty("thirdPartyAppid")
    private String thirdPartyAppid;
}