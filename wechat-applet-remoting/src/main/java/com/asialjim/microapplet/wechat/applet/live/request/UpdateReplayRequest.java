package com.asialjim.microapplet.wechat.applet.live.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 修改回放状态请求参数
 * 接口文档：<a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/livebroadcast/studio-management/updateReplay.html">...</a>
 *
 * @author Asial Jim
 * @version 1.0
 * @since 2025/10/30
 */
@Data
public class UpdateReplayRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /**
     * 回放视频ID
     */
    private Integer roomId;
    
    /**
     * 回放状态，0：未开始，1：转码中，2：转码完成，3：转码失败，4：已上架，10：已下架
     */
    private Integer closeReplay;
}