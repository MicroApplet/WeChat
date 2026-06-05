package com.asialjim.microapplet.wechat.applet.live.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 查询成员列表请求参数
 * 接口文档：<a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/livebroadcast/role-management/getRoleList.html">...</a>
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/10/30, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Data
public class GetRoleListRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 查询的用户角色
     * 取值 [-1-所有成员， 0-超级管理员，1-管理员，2-主播，3-运营者]，默认-1
     */
    @JsonProperty("role")
    private Integer role;

    /**
     * 起始偏移量, 默认0
     */
    @JsonProperty("offset")
    private Integer offset;

    /**
     * 查询个数，最大30，默认10
     */
    @JsonProperty("limit")
    private Integer limit;

    /**
     * 搜索的微信号或昵称，不传则返回全部
     */
    @JsonProperty("keyword")
    private String keyword;
}