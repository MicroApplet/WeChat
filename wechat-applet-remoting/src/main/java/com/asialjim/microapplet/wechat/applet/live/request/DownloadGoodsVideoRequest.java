package com.asialjim.microapplet.wechat.applet.live.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 下载商品视频请求参数
 * 接口文档：<a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/livebroadcast/studio-management/downloadGoodsVideo.html">...</a>
 *
 * @author Asial Jim
 * @version 1.0
 * @since 2025/10/30
 */
@Data
public class DownloadGoodsVideoRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long roomId;
    
    /**
     * 商品ID
     */
    private Long goodsId;
}