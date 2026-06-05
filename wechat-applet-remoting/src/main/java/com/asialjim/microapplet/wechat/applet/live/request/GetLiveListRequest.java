package com.asialjim.microapplet.wechat.applet.live.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 获取直播间列表请求参数类
 * <p>
 * 接口文档：<a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/livebroadcast/studio-management/getRooms.html">...</a>
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/10/30, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Data
public class GetLiveListRequest implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    /**
     * 分页起始值
     */
    @JsonProperty("start")
    private Integer start;
    
    /**
     * 分页大小，默认10，最大100
     */
    @JsonProperty("limit")
    private Integer limit;
    
    /**
     * 直播间状态筛选，0：未开始，1：直播中，2：已结束，3：已关闭
     */
    @JsonProperty("status")
    private Integer status;
}