/*
 * Copyright 2014-2025 <a href="mailto:asialjim@qq.com">Asial Jim</a>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.asialjim.microapplet.wechat.remoting.message.subscribemsg;

import com.asialjim.microapplet.remote.http.annotation.HttpMapping;
import com.asialjim.microapplet.remote.http.annotation.HttpMethod;
import com.asialjim.microapplet.remote.http.annotation.body.JsonBody;
import com.asialjim.microapplet.remote.net.annotation.Server;
import com.asialjim.microapplet.wechat.constant.WeChatCons;
import com.asialjim.microapplet.wechat.remoting.context.BaseWeChatApiRes;
import com.asialjim.microapplet.wechat.remoting.context.WeChatAccessTokenParam;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * 微信订阅消息/模板消息API客户端
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/10/30, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Server(supplier = WeChatCons.Supplier.WECHAT, namespace = WeChatCons.Namespace.COMMON, schema = WeChatCons.Api.DEFAULT_SCHEMA, host = WeChatCons.Api.DEFAULT_HOST, port = WeChatCons.Api.DEFAULT_PORT)
public interface WeChatPaSubscribeMsgRemoting {

    String URI_TEMP = "https://mp.weixin.qq.com/mp/subscribemsg?action=get_confirm&appid=%s&scene=%d&template_id=%s&redirect_url=%s&reserved=%s#wechat_redirect";

    /**
     * 构建订阅消息授权链接
     * <pre>
     * 公众号一次性订阅消息
     * 说明：服务号订阅通知功能（见左侧目录“订阅通知”）开启灰度测试，公众号一次性订阅消息能力可正常使用
     * 开发者可以通过一次性订阅消息授权让微信用户授权第三方移动应用（接入说明）或公众号，获得发送一次订阅消息给到授权微信用户的机会。授权微信用户可以不需要关注公众号。微信用户每授权一次，开发者可获得一次下发消息的权限。（注意：同一用户在同一scene场景值下的多次授权不累积下发权限，只能下发一条。若要订阅多条，需要不同scene场景值）
     * 消息下发位置说明：对于已关注公众号的，消息将下发到公众号会话里；未关注公众号的，将下发到服务通知。
     * 公众号或网页使用一次性订阅消息流程如下：
     * 第一步：需要用户同意授权，获取一次给用户推送一条订阅模板消息的机会
     * 在确保微信公众账号拥有订阅消息授权的权限的前提下（已认证的公众号即有权限，可登录公众平台在接口权限列表处查看），引导用户在微信客户端打开如下链接：
     * <a href="https://mp.weixin.qq.com/mp/subscribemsg?action=get_confirm&appid=****&scene=1000&template_id=1uDxHNXwYQfBmXOfPJcjAS3FynHArD8aWMEFNRGSbCc&redirect_url=http%3a%2f%2fsupport.qq.com&reserved=test#wechat_redirect">官方文档</a>
     * </pre>
     *
     * @param appid       {@link String 公众号的唯一标识}
     * @param scene       {@link Integer 重定向后会带上scene参数，开发者可以填0-10000的整型值，用来标识订阅场景值}
     * @param templateId  {@link String 订阅消息模板ID，登录公众平台后台，在接口权限列表处可查看订阅模板ID}
     * @param redirectUrl {@link String 授权后重定向的回调地址，请使用UrlEncode对链接进行处理。 注：要求redirect_url的域名要跟登记的业务域名一致，且业务域名不能带路径。 业务域名需登录公众号，在设置-公众号设置-功能设置里面对业务域名设置。}
     * @param resreved    {@link String 用于保持请求和回调的状态，授权请后原样带回给第三方。该参数可用于防止csrf攻击（跨站请求伪造攻击），建议第三方带上该参数，可设置为简单的随机数加session进行校验，开发者可以填写a-zA-Z0-9的参数值，最多128字节，要求做urlencode}
     * @return {@link String }
     * @since 2023/12/26
     */
    @SneakyThrows
    default String buildSubscriptMsgUrl(String appid, int scene, String templateId, String redirectUrl, String resreved) {
        return String.format(URI_TEMP, appid, scene, templateId, URLEncoder.encode(redirectUrl, StandardCharsets.UTF_8), URLEncoder.encode(resreved, StandardCharsets.UTF_8));
    }


    /**
     * 通过API推送订阅模板消息给到授权微信用户
     *
     * @param ewChatIndex {@link String ewChatIndex}
     * @param req         {@link SendSubscribeTemplateMsgReq req}
     * @return {@link BaseWeChatApiRes}
     * @since 2023/12/26
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/message/template/subscribe")
    BaseWeChatApiRes sendSubscribeTemplateMsg(@WeChatAccessTokenParam String ewChatIndex, @JsonBody SendSubscribeTemplateMsgReq req);

    /**
     * 发送订阅消息
     * <pre>
     * 接口英文名：sendMessage
     * 功能描述：该接口用于发送订阅消息
     * 调用方式：HTTPS 调用
     * 官方文档：<a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/mp-message-management/subscribe-message/sendMessage.html">发送订阅消息</a>
     * </pre>
     *
     * @param weChatIndex {@link String weChatIndex}
     * @param req         {@link SendSubscribeMessageReq 发送订阅消息请求参数}
     * @return {@link BaseWeChatApiRes}
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/message/subscribe/send")
    BaseWeChatApiRes sendSubscribeMessage(@WeChatAccessTokenParam String weChatIndex, @JsonBody SendSubscribeMessageReq req);

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    class SendSubscribeTemplateMsgReq implements Serializable {

        @Serial
        private static final long serialVersionUID = -2762720653829973705L;

        private String touser;
        private String template_id;
        private String url;
        private String scene;
        private String title;
        private MiniProgram miniprogram;
        private SendSubscribeTemplateMsgReqData data;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    class MiniProgram {
        private String appid;
        private String pagepath;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    class SendSubscribeTemplateMsgReqData {
        private SendSubscribeTemplateMsgReqDataContent content;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    class SendSubscribeTemplateMsgReqDataContent {
        private String value;
        private String color;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    class SendSubscribeMessageReq implements Serializable {

        @Serial
        private static final long serialVersionUID = 3761438820633030114L;
        /**
         * 接收者（用户）的 openid
         */
        private String touser;

        /**
         * 所需下发的订阅模板id
         */
        private String template_id;

        /**
         * 点击模板卡片后的跳转页面，仅限本小程序内的页面。支持带参数，（示例index?foo=bar）。该字段不填则模板无跳转
         */
        private String page;

        /**
         * 模板内容，格式形如{"phrase3":{"value":"审核通过"},"name1":{"value":"订阅"},"date2":{"value":"2019-12-25 09:42"}}
         */
        private Map<String, TemplateDataValue> data;

        /**
         * 跳转小程序类型：developer为开发版；trial为体验版；formal为正式版；默认为正式版
         */
        private String miniprogram_state;

        /**
         * 进入小程序查看”的语言类型，支持zh_CN(简体中文)、en_US(英文)、zh_HK(繁体中文)、zh_TW(繁体中文)，默认为zh_CN
         */
        private String lang;
    }


    @Data
    class TemplateDataValue implements Serializable {
        @Serial
        private static final long serialVersionUID = 6677141881184963064L;

        private String value;
        private String color;
    }
}