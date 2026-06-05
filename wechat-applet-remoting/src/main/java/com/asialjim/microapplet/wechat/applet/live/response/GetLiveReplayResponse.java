package com.asialjim.microapplet.wechat.applet.live.response;

import com.asialjim.microapplet.wechat.applet.message.meta.BaseWeChatMessageRes;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * 获取直播回放响应结果类
 * <p>
 * 接口文档：<a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/livebroadcast/studio-management/getLiveReplay.html">...</a>
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/10/30, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class GetLiveReplayResponse extends BaseWeChatMessageRes implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    /**
     * 回放列表
     */
    @JsonProperty("live_replay")
    private List<ReplayInfo> liveReplay;
    
    /**
     * 回放信息类
     */
    @Data
    public static class ReplayInfo implements Serializable {
        
        private static final long serialVersionUID = 1L;
        
        /**
         * 回放视频ID
         */
        @JsonProperty("media_id")
        private String mediaId;
        
        /**
         * 回放视频URL
         */
        @JsonProperty("play_url")
        private String playUrl;
        
        /**
         * 回放视频封面图URL
         */
        @JsonProperty("cover_url")
        private String coverUrl;
        
        /**
         * 回放视频时长，单位秒
         */
        @JsonProperty("duration")
        private Integer duration;
        
        /**
         * 回放视频创建时间
         */
        @JsonProperty("create_time")
        private Long createTime;
        
        /**
         * 回放视频大小，单位字节
         */
        @JsonProperty("size")
        private Long size;
    }
}