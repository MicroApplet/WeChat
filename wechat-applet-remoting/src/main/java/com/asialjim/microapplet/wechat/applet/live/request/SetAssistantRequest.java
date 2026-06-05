package com.asialjim.microapplet.wechat.applet.live.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 设置直播助手请求参数类
 * <p>
 * 接口文档：<a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/livebroadcast/studio-management/setAssistant.html">...</a>
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/10/30, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Data
public class SetAssistantRequest implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    /**
     * 直播间ID
     */
    @JsonProperty("roomId")
    private Integer roomId;
    
    /**
     * 直播助手列表
     */
    @JsonProperty("assistants")
    private List<AssistantInfo> assistants;
    
    /**
     * 直播助手信息类
     */
    @Data
    public static class AssistantInfo implements Serializable {
        
        private static final long serialVersionUID = 1L;
        
        /**
         * 直播助手ID
         */
        @JsonProperty("openId")
        private String openId;
        
        /**
         * 直播助手类型，1：管理员，2：普通助手
         */
        @JsonProperty("type")
        private Integer type;
        
        /**
         * 直播助手昵称
         */
        @JsonProperty("nickName")
        private String nickName;
        
        /**
         * 直播助手头像URL
         */
        @JsonProperty("headImg")
        private String headImg;
    }
}