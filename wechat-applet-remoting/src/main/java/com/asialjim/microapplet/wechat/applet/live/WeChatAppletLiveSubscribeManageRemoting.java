package com.asialjim.microapplet.wechat.applet.live;

import com.asialjim.microapplet.remote.http.annotation.HttpMethod;
import com.asialjim.microapplet.remote.http.annotation.HttpMapping;
import com.asialjim.microapplet.remote.http.annotation.body.JsonBody;
import com.asialjim.microapplet.remote.net.annotation.Server;
import com.asialjim.microapplet.wechat.applet.live.request.GetFollowersRequest;
import com.asialjim.microapplet.wechat.applet.live.request.PushMessageRequest;
import com.asialjim.microapplet.wechat.applet.live.response.GetFollowersResponse;
import com.asialjim.microapplet.wechat.applet.live.response.PushMessageResponse;
import com.asialjim.microapplet.wechat.constant.WeChatCons;
import com.asialjim.microapplet.wechat.remoting.context.WeChatAccessTokenParam;

/**
 * 微信小程序直播长期订阅管理远程调用接口
 * 接口文档：<a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/livebroadcast/subscribe-management/pushMessage.html">...</a>
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
public interface WeChatAppletLiveSubscribeManageRemoting {

    /**
     * 发送直播开始事件
     * 该接口用于向长期订阅用户群发直播间开始事件
     * 注意事项：调用额度：5000次/一天；群发订阅用户个数限制：2000/次
     * <p>
     * 接口英文名: pushMessage
     * 调用方式: HTTPS调用
     * 请求地址: <a href="https://api.weixin.qq.com/wxa/business/push_message">...</a>
     *
     * @param request 发送直播开始事件请求参数
     * @return 发送直播开始事件响应结果
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxa/business/push_message")
    PushMessageResponse pushMessage(@WeChatAccessTokenParam String weChatIndex, @JsonBody PushMessageRequest request);

    /**
     * 获取长期订阅用户
     * 该接口用于获取长期订阅用户列表
     * <p>
     * 接口英文名: getFollowers
     * 调用方式: HTTPS调用
     * 请求地址: <a href="https://api.weixin.qq.com/wxa/business/get_wxa_followers">...</a>
     *
     * @param request 获取长期订阅用户请求参数
     * @return 获取长期订阅用户响应结果
     */
    @HttpMapping(method = HttpMethod.GET, uri = "/wxa/business/get_wxa_followers")
    GetFollowersResponse getFollowers(@WeChatAccessTokenParam String weChatIndex, @JsonBody GetFollowersRequest request);
}