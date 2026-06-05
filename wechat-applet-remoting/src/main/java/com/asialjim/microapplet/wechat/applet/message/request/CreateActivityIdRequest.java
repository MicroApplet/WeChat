package com.asialjim.microapplet.wechat.applet.message.request;

import lombok.Data;

/**
 * 创建动态消息activity_id请求参数
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/10/30, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Data
public class CreateActivityIdRequest {

    /**
     * 为私密消息创建activity_id时，指定分享者为unionid用户。其余用户不能用此activity_id分享私密消息。
     * openid与unionid填一个即可。私密消息暂不支持云函数生成activity id。
     */
    private String unionid;

    /**
     * 为私密消息创建activity_id时，指定分享者为openid用户。其余用户不能用此activity_id分享私密消息。
     * openid与unionid填一个即可。私密消息暂不支持云函数生成activity id。
     */
    private String openid;
}