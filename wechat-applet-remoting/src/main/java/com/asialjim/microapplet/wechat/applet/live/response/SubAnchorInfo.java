package com.asialjim.microapplet.wechat.applet.live.response;

import lombok.Data;

import java.io.Serializable;

/**
 * 主播副号信息
 *
 * @author Asial Jim
 * @version 1.0
 * @since 2025/10/30
 */
@Data
public class SubAnchorInfo implements Serializable {
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