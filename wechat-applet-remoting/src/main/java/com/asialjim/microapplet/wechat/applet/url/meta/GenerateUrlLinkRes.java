package com.asialjim.microapplet.wechat.applet.url.meta;

import com.asialjim.microapplet.wechat.remoting.context.BaseWeChatApiRes;
import lombok.*;

/**
 * 获取小程序URL Link响应
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/10/30, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class GenerateUrlLinkRes extends BaseWeChatApiRes {

    /**
     * 生成的小程序URL Link
     */
    private String urlLink;
}