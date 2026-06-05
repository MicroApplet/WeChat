package com.asialjim.microapplet.wechat.applet.message.meta;

import com.asialjim.microapplet.wechat.remoting.context.BaseWeChatApiRes;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 微信小程序消息相关基础响应类
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/10/30, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BaseWeChatMessageRes extends BaseWeChatApiRes {
    // 修改动态消息和聊天工具消息的响应只包含标准的errcode和errmsg
    // 这些字段已在BaseWeChatApiRes中定义
}