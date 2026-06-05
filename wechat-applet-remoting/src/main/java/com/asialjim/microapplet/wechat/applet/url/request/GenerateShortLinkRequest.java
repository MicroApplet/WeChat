package com.asialjim.microapplet.wechat.applet.url.request;

import lombok.Data;

/**
 * 获取小程序ShortLink请求参数
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/10/30, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Data
public class GenerateShortLinkRequest {

    /**
     * 通过ShortLink进入的小程序页面路径，必须是已经发布的小程序存在的页面，可携带query，最大1024个字符
     */
    private String page_url;

    /**
     * 页面标题，不能包含违法信息，超过20字符会用...截断代替
     */
    private String page_title;

    /**
     * 默认值false。生成的ShortLink类型，短期有效：false，永久有效：true
     */
    private Boolean is_permanent = false;
}