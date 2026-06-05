package com.asialjim.microapplet.wechat.applet.live.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 更新直播间请求参数类
 * <p>
 * 接口文档：<a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/livebroadcast/studio-management/updateRoom.html">...</a>
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/10/30, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Data
public class UpdateLiveRequest implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    /**
     * 直播间ID
     */
    @JsonProperty("roomId")
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
     * 主播微信号
     */
    @JsonProperty("anchor_wechat")
    private String anchorWechat;
    
    /**
     * 直播间背景图URL
     */
    @JsonProperty("cover_img")
    private String coverImg;
    
    /**
     * 直播类型，1：普通直播，2：推流直播，3：录播直播
     */
    @JsonProperty("type")
    private Integer type;
    
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
     * 直播间介绍
     */
    @JsonProperty("introduction")
    private String introduction;
    
    /**
     * 直播间分享图片URL
     */
    @JsonProperty("share_img")
    private String shareImg;
    
    /**
     * 是否关闭点赞，0：开启，1：关闭
     */
    @JsonProperty("close_like")
    private Integer closeLike;
    
    /**
     * 是否关闭送礼，0：开启，1：关闭
     */
    @JsonProperty("close_gift")
    private Integer closeGift;
    
    /**
     * 是否关闭评论，0：开启，1：关闭
     */
    @JsonProperty("close_comment")
    private Integer closeComment;
    
    /**
     * 是否关闭回放，0：开启，1：关闭
     */
    @JsonProperty("close_replay")
    private Integer closeReplay;
}