package com.asialjim.microapplet.wechat.applet.live.response;

import com.asialjim.microapplet.wechat.applet.message.meta.BaseWeChatMessageRes;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;

/**
 * 发送直播开始事件响应结果
 * 接口文档：<a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/livebroadcast/subscribe-management/pushMessage.html">...</a>
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/10/30, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PushMessageResponse extends BaseWeChatMessageRes implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 此次群发消息的标识ID，用于对应【长期订阅群发结果回调】的message_id
     */
    @JsonProperty("message_id")
    private String messageId;
}