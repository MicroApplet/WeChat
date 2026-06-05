package com.asialjim.microapplet.wechat.applet.live.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 开关直播间评论请求参数
 * 接口文档：<a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/livebroadcast/studio-management/updateComment.html">...</a>
 *
 * @author Asial Jim
 * @version 1.0
 * @since 2025/10/30
 */
@Data
public class UpdateCommentRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /**
     * 直播间ID
     */
    private Integer roomId;
    
    /**
     * 是否关闭评论，0：开启，1：关闭
     */
    private Integer banComment;
}