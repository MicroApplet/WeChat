package com.asialjim.microapplet.wechat.applet.message.meta;

import com.asialjim.microapplet.wechat.remoting.context.BaseWeChatApiRes;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 创建动态消息activity_id响应
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/10/30, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class CreateActivityIdRes extends BaseWeChatApiRes {

    /**
     * 动态消息的ID
     */
    private String activity_id;

    /**
     * activity_id的过期时间戳。默认24小时后过期。
     */
    private Long expiration_time;
}