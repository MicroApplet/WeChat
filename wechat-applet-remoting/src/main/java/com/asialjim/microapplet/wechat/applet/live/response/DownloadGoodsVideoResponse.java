package com.asialjim.microapplet.wechat.applet.live.response;

import com.asialjim.microapplet.wechat.applet.message.meta.BaseWeChatMessageRes;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * 下载商品视频响应结果
 * 接口文档：<a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/livebroadcast/studio-management/downloadGoodsVideo.html">...</a>
 *
 * @author Asial Jim
 * @version 1.0
 * @since 2025/10/30
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class DownloadGoodsVideoResponse extends BaseWeChatMessageRes implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /**
     * 视频地址
     */
    private String videoUrl;
}