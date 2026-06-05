package com.asialjim.microapplet.wechat.applet.live.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 修改主播副号信息请求参数
 * 接口文档：<a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/livebroadcast/studio-management/modifySubAnchor.html">...</a>
 *
 * @author Asial Jim
 * @version 1.0
 * @since 2025/10/30
 */
@Data
public class ModifySubAnchorRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /**
     * 主播副号ID
     */
    private Integer subAnchorId;
    
    /**
     * 主播副号昵称
     */
    private String anchorName;
    
    /**
     * 主播副号微信号
     */
    private String anchorWechat;
}