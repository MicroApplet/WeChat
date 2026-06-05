package com.asialjim.microapplet.wechat.applet.live.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 添加主播副号请求参数
 * 接口文档：<a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/livebroadcast/studio-management/addSubAnchor.html">...</a>
 *
 * @author Asial Jim
 * @version 1.0
 * @since 2025/10/30
 */
@Data
public class AddSubAnchorRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /**
     * 主播副号昵称
     */
    private String anchorName;
    
    /**
     * 主播副号微信号
     */
    private String anchorWechat;
}