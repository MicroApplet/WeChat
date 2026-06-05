package com.asialjim.microapplet.wechat.applet.live.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * 发送直播开始事件请求参数
 * 接口文档：<a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/livebroadcast/subscribe-management/pushMessage.html">...</a>
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/10/30, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Data
public class PushMessageRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 直播开始事件的房间ID
     */
    @JsonProperty("room_id")
    private Integer roomId;

    /**
     * 接收该群发开播事件的订阅用户OpenId列表
     */
    @JsonProperty("user_openid")
    private List<String> userOpenidList;
}