package com.asialjim.microapplet.wechat.applet.live.response;

import com.asialjim.microapplet.wechat.applet.message.meta.BaseWeChatMessageRes;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * 查询成员列表响应结果
 * 接口文档：<a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/livebroadcast/role-management/getRoleList.html">...</a>
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/10/30, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class GetRoleListResponse extends BaseWeChatMessageRes implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 总个数
     */
    @JsonProperty("total")
    private Integer total;

    /**
     * 角色列表
     */
    @JsonProperty("list")
    private List<RoleInfo> roleList;

    /**
     * 角色信息
     */
    @Data
    public static class RoleInfo implements Serializable {
        @Serial
        private static final long serialVersionUID = 1L;

        /**
         * 微信用户头像url
         */
        @JsonProperty("headingimg")
        private String headingImg;

        /**
         * 微信用户昵称
         */
        @JsonProperty("nickname")
        private String nickname;

        /**
         * openid
         */
        @JsonProperty("openid")
        private String openid;

        /**
         * 具有的身份，[0-超级管理员，1-管理员，2-主播，3-运营者]
         */
        @JsonProperty("roleList")
        private List<Integer> roleList;

        /**
         * 更新时间
         */
        @JsonProperty("updateTimestamp")
        private Long updateTimestamp;

        /**
         * 微信号
         */
        @JsonProperty("username")
        private String username;
    }
}