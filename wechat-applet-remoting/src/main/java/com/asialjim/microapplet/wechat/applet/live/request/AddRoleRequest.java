package com.asialjim.microapplet.wechat.applet.live.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 设置成员角色请求参数
 * 接口文档：<a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/livebroadcast/role-management/getRoleListdw.html">...</a>
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/10/30, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Data
public class AddRoleRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 用户的微信号
     */
    @JsonProperty("username")
    private String username;

    /**
     * 设置用户的角色
     * 0-超级管理员，1-管理员，2-主播，3-运营者
     */
    @JsonProperty("role")
    private Integer role;
}