package com.asialjim.microapplet.wechat.applet.live.response;

import com.asialjim.microapplet.wechat.applet.message.meta.BaseWeChatMessageRes;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * 获取直播间列表响应结果类
 * <p>
 * 接口文档：<a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/livebroadcast/studio-management/getRooms.html">...</a>
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/10/30, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class GetLiveListResponse extends BaseWeChatMessageRes implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    /**
     * 直播间总数
     */
    @JsonProperty("total")
    private Integer total;
    
    /**
     * 直播间列表
     */
    @JsonProperty("room_info")
    private List<RoomInfo> roomInfo;
    
    /**
     * 直播间信息类
     */
    @Data
    public static class RoomInfo implements Serializable {
        
        private static final long serialVersionUID = 1L;
        
        /**
         * 直播间ID
         */
        @JsonProperty("roomid")
        private Integer roomId;
        
        /**
         * 直播间名称
         */
        @JsonProperty("name")
        private String name;
        
        /**
         * 主播昵称
         */
        @JsonProperty("anchor_name")
        private String anchorName;
        
        /**
         * 直播状态，0：未开始，1：直播中，2：已结束，3：已关闭
         */
        @JsonProperty("live_status")
        private Integer liveStatus;
        
        /**
         * 直播开始时间
         */
        @JsonProperty("start_time")
        private Long startTime;
        
        /**
         * 直播结束时间
         */
        @JsonProperty("end_time")
        private Long endTime;
        
        /**
         * 直播间封面图URL
         */
        @JsonProperty("cover_img")
        private String coverImg;
        
        /**
         * 直播间分享图片URL
         */
        @JsonProperty("share_img")
        private String shareImg;
        
        /**
         * 直播间介绍
         */
        @JsonProperty("introduction")
        private String introduction;
        
        /**
         * 直播观看人数
         */
        @JsonProperty("viewer_count")
        private Integer viewerCount;
    }
}