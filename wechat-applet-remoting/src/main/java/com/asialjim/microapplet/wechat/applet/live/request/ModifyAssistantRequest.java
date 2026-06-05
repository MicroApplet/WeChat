package com.asialjim.microapplet.wechat.applet.live.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 修改直播助手信息请求参数
 * 接口文档：<a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/livebroadcast/studio-management/modifyAssistant.html">...</a>
 *
 * @author Asial Jim
 * @version 1.0
 * @since 2025/10/30
 */
@Data
public class ModifyAssistantRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /**
     * 直播间ID
     */
    private Integer roomId;
    
    /**
     * 助手微信号
     */
    private String openId;
    
    /**
     * 助手类型，1：管理员，2：普通助手
     */
    private Integer type;
}