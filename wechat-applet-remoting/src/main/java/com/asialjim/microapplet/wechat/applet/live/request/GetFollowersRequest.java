package com.asialjim.microapplet.wechat.applet.live.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 获取长期订阅用户请求参数
 * 接口文档：<a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/livebroadcast/subscribe-management/getFollowers.html">...</a>
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/10/30, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Data
public class GetFollowersRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 获取长期订阅用户的个数限制，默认200，最大2000
     */
    @JsonProperty("limit")
    private Integer limit;

    /**
     * 翻页标记，获取第一页时不带，第二页开始需带上上一页返回结果中的page_break
     */
    @JsonProperty("page_break")
    private Long pageBreak;
}