package com.asialjim.microapplet.wechat.applet.live.request;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 删除商品请求参数
 * 接口文档：<a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/livebroadcast/studio-management/deleteDoods.html">...</a>
 *
 * @author Asial Jim
 * @version 1.0
 * @since 2025/10/30
 */
@Data
public class DeleteDoodsRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /**
     * 直播间ID
     */
    private Integer roomId;
    
    /**
     * 商品ID列表
     */
    private List<Long> goodsIds;
}