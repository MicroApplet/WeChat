package com.asialjim.microapplet.wechat.applet.live.response;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 直播间信息
 *
 * @author Asial Jim
 * @version 1.0
 * @since 2025/10/30
 */
@Data
public class LiveInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /**
     * 直播间ID
     */
    private Integer roomId;
    
    /**
     * 直播间名称
     */
    private String name;
    
    /**
     * 直播间图片
     */
    private String coverImg;
    
    /**
     * 直播间背景图
     */
    private String shareImg;
    
    /**
     * 直播间状态，101：直播中，102：未开始，103：已结束，104：禁播，105：暂停，106：异常，107：已过期
     */
    private Integer liveStatus;
    
    /**
     * 主播名
     */
    private String anchorName;
    
    /**
     * 直播计划开始时间
     */
    private Long startTime;
    
    /**
     * 直播计划结束时间
     */
    private Long endTime;
    
    /**
     * 直播商品列表
     */
    private List<GoodsInfo> goods;
    
    /**
     * 实际开始时间
     */
    private Long actualStartTime;
    
    /**
     * 实际结束时间
     */
    private Long actualEndTime;
    
    /**
     * 观看人数
     */
    private Integer viewerCount;
    
    /**
     * 点赞人数
     */
    private Integer likeCount;
}