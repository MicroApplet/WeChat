package com.asialjim.microapplet.wechat.applet.url.request;

import lombok.Data;

/**
 * 查询小程序加密URL Link配置请求参数
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/10/30, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Data
public class QueryUrlLinkRequest {

    /**
     * 小程序加密url_link
     */
    private String url_link;

    /**
     * 查询类型。默认值0，查询url_link信息：0，查询每天剩余访问次数：1
     */
    private Integer query_type = 0;
}