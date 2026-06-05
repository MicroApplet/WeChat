package com.asialjim.microapplet.wechat.applet.live.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 添加直播助手请求参数类
 * <p>
 * 接口文档：<a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/livebroadcast/studio-management/addAssistant.html">...</a>
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/10/30, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Data
public class AddAssistantRequest implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    /**
     * 直播间ID
     */
    @JsonProperty("roomId")
    private Integer roomId;
    
    /**
     * 直播助手ID
     */
    @JsonProperty("openId")
    private String openId;
    
    /**
     * 直播助手类型，0：普通助手，1：管理员
     */
    @JsonProperty("type")
    private Integer type;
}