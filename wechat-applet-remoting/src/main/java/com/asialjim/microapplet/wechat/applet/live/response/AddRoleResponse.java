package com.asialjim.microapplet.wechat.applet.live.response;

import com.asialjim.microapplet.wechat.applet.message.meta.BaseWeChatMessageRes;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;

/**
 * 设置成员角色响应结果
 * 接口文档：<a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/livebroadcast/role-management/getRoleListdw.html">...</a>
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/10/30, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AddRoleResponse extends BaseWeChatMessageRes implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 如果主播未实名认证，需要先前往"小程序直播"小程序进行实名验证，点击查看小程序二维码链接
     */
    @JsonProperty("codeurl")
    private String codeUrl;
}