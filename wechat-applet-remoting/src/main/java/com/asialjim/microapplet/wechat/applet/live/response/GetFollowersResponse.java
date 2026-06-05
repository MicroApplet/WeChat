package com.asialjim.microapplet.wechat.applet.live.response;

import com.asialjim.microapplet.wechat.applet.message.meta.BaseWeChatMessageRes;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * 获取长期订阅用户响应结果
 * 接口文档：<a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/livebroadcast/subscribe-management/getFollowers.html">...</a>
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/10/30, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class GetFollowersResponse extends BaseWeChatMessageRes implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 长期订阅用户总数
     */
    @JsonProperty("total")
    private Integer total;

    /**
     * 翻页标记，用于下一页获取更多用户
     */
    @JsonProperty("page_break")
    private Long pageBreak;

    /**
     * 长期订阅用户列表
     */
    @JsonProperty("list")
    private List<FollowerInfo> list;

    /**
     * 长期订阅用户信息
     */
    @Data
    public static class FollowerInfo implements Serializable {
        @Serial
        private static final long serialVersionUID = 1L;

        /**
         * 用户openid
         */
        @JsonProperty("openid")
        private String openid;

        /**
         * 头像URL
         */
        @JsonProperty("avatar_url")
        private String avatarUrl;

        /**
         * 用户昵称
         */
        @JsonProperty("nickname")
        private String nickname;

        /**
         * 关注时间戳
         */
        @JsonProperty("follow_time")
        private Long followTime;
    }
}