package com.asialjim.microapplet.wechat.applet.live.response;

import com.asialjim.microapplet.wechat.applet.message.meta.BaseWeChatMessageRes;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * 删除直播回放响应结果类
 * <p>
 * 接口文档：<a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/livebroadcast/studio-management/deleteLiveReplay.html">...</a>
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/10/30, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class DeleteLiveReplayResponse extends BaseWeChatMessageRes implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    /**
     * 删除状态，0：成功，非0：失败
     */
    @JsonProperty("status")
    private Integer status;
    
    /**
     * 错误信息
     */
    @JsonProperty("msg")
    private String msg;
}