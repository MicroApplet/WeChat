package com.asialjim.microapplet.wechat.applet.live.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 获取直播间详情请求参数类
 * <p>
 * 接口文档：<a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/livebroadcast/studio-management/getLiveInfo.html">...</a>
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/10/30, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Data
public class GetLiveInfoRequest implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    /**
     * 房间ID列表，传入则返回指定房间，否则返回所有房间
     */
    @JsonProperty("room_ids")
    private Integer[] roomIds;
    
    /**
     * 分页起始值，默认0
     */
    @JsonProperty("start")
    private Integer start;
    
    /**
     * 分页大小，默认10，最大值100
     */
    @JsonProperty("limit")
    private Integer limit;
}