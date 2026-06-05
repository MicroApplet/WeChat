package com.asialjim.microapplet.wechat.applet.message;

import com.asialjim.microapplet.remote.http.annotation.HttpMapping;
import com.asialjim.microapplet.remote.http.annotation.HttpMethod;
import com.asialjim.microapplet.remote.http.annotation.body.JsonBody;
import com.asialjim.microapplet.remote.net.annotation.Server;
import com.asialjim.microapplet.wechat.constant.WeChatCons;
import com.asialjim.microapplet.wechat.remoting.context.WeChatAccessTokenParam;
import com.asialjim.microapplet.wechat.applet.message.meta.BaseWeChatMessageRes;
import com.asialjim.microapplet.wechat.applet.message.meta.CreateActivityIdRes;
import com.asialjim.microapplet.wechat.applet.message.request.CreateActivityIdRequest;
import com.asialjim.microapplet.wechat.applet.message.request.SetUpdatableMsgRequest;
import com.asialjim.microapplet.wechat.applet.message.request.SetChatToolMsgRequest;

/**
 * 微信小程序消息相关服务API客户端
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/10/30, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Server(
        supplier = WeChatCons.Supplier.WECHAT,
        namespace = WeChatCons.Namespace.COMMON,
        schema = WeChatCons.Api.DEFAULT_SCHEMA,
        host = WeChatCons.Api.DEFAULT_HOST,
        port = WeChatCons.Api.DEFAULT_PORT
)
public interface WeChatAppletMessageRemoting {

    /**
     * 创建动态消息activity_id
     * <p>
     * 接口说明：
     * <ul>
     * <li>该接口用于创建被分享动态消息或私密消息的activity_id</li>
     * <li>支持为私密消息指定分享者（通过openid或unionid）</li>
     * <li>私密消息暂不支持云函数生成activity id</li>
     * </ul>
     *
     * @param weChatIndex {@link String weChatIndex}
     * @param requestParam 请求参数，包含openid和unionid（二选一）
     * @return 创建的activity_id和过期时间戳
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/mp-message-management/updatable-message/createActivityId.html">创建activity_id</a>
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/message/wxopen/activityid/create")
    CreateActivityIdRes createActivityId(@WeChatAccessTokenParam String weChatIndex, @JsonBody CreateActivityIdRequest requestParam);

    /**
     * 修改动态消息
     * <p>
     * 接口说明：
     * <ul>
     * <li>该接口用于修改被分享的动态消息</li>
     * <li>target_state支持0（未开始）和1（已开始）两种状态</li>
     * <li>根据不同状态需要设置不同的参数：
     *   <ul>
     *     <li>target_state = 0时：需要设置member_count和room_limit参数</li>
     *     <li>target_state = 1时：需要设置path和version_type参数</li>
     *   </ul>
     * </li>
     * <li>活动默认有效期是24小时</li>
     * </ul>
     *
     * @param weChatIndex {@link String weChatIndex}
     * @param requestParam 请求参数，包含activity_id、target_state和template_info
     * @return 修改结果
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/mp-message-management/updatable-message/setUpdatableMsg.html">修改动态消息</a>
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/message/wxopen/updatablemsg/send")
    BaseWeChatMessageRes setUpdatableMsg(@WeChatAccessTokenParam String weChatIndex, @JsonBody SetUpdatableMsgRequest requestParam);

    /**
     * 修改小程序聊天工具的动态卡片消息
     * <p>
     * 接口说明：
     * <ul>
     * <li>该接口用于修改被分享的小程序聊天工具的动态卡片消息</li>
     * <li>需要提供activity_id、target_state、template_id等参数</li>
     * <li>participator_info_list用于更新聊天室成员状态</li>
     * </ul>
     *
     * @param weChatIndex {@link String weChatIndex}
     * @param requestParam 请求参数，包含activity_id、target_state、template_id和participator_info_list
     * @return 修改结果
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/mp-message-management/updatable-message/setChatToolMsg.html">修改小程序聊天工具的动态卡片消息</a>
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/message/wxopen/chattoolmsg/send")
    BaseWeChatMessageRes setChatToolMsg(@WeChatAccessTokenParam String weChatIndex, @JsonBody SetChatToolMsgRequest requestParam);
}