package com.asialjim.microapplet.wechat.applet.live.response;

import lombok.Data;

import java.io.Serializable;

/**
 * 直播助手信息
 *
 * @author Asial Jim
 * @version 1.0
 * @since 2025/10/30
 */
@Data
public class AssistantInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /**
     * 助手微信号
     */
    private String openId;
    
    /**
     * 助手类型，1：管理员，2：普通助手
     */
    private Integer type;
    
    /**
     * 助手昵称
     */
    private String nickName;
    
    /**
     * 助手头像
     */
    private String headImg;
}