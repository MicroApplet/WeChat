package com.asialjim.microapplet.wechat.applet.live.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 获取商品列表请求参数类
 * <p>
 * 接口文档：<a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/livebroadcast/goods-management/getGoods.html">...</a>
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/10/30, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Data
public class GetGoodsListRequest implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    /**
     * 分页起始值
     */
    @JsonProperty("start")
    private Integer start;
    
    /**
     * 分页大小，默认值为10，最大值为100
     */
    @JsonProperty("limit")
    private Integer limit;
    
    /**
     * 商品状态，0：未审核，1：审核中，2：审核通过，3：审核驳回
     */
    @JsonProperty("status")
    private Integer status;
}