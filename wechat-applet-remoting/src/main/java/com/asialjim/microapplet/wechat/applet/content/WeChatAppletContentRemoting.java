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

package com.asialjim.microapplet.wechat.applet.content;

import com.asialjim.microapplet.remote.http.annotation.HttpMapping;
import com.asialjim.microapplet.remote.http.annotation.HttpMethod;
import com.asialjim.microapplet.remote.http.annotation.body.JsonBody;
import com.asialjim.microapplet.remote.net.annotation.Server;
import com.asialjim.microapplet.wechat.constant.WeChatCons;
import com.asialjim.microapplet.wechat.remoting.context.BaseWeChatApiRes;
import com.asialjim.microapplet.wechat.remoting.context.WeChatAccessTokenParam;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.io.Serial;
import java.util.List;

/**
 * 微信小程序内容安全API客户端
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/10/30, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Server(supplier = WeChatCons.Supplier.WECHAT, namespace = WeChatCons.Namespace.COMMON, schema = WeChatCons.Api.DEFAULT_SCHEMA, host = WeChatCons.Api.DEFAULT_HOST, port = WeChatCons.Api.DEFAULT_PORT)
public interface WeChatAppletContentRemoting {

    /**
     * 文本内容安全识别
     * 详细文档：<a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/sec-center/sec-check/msgSecCheck.html">...</a>
     *
     * @param weChatIndex {@link String weChatIndex}
     * @param req         {@link MsgSecCheckReq req}
     * @return {@link MsgSecCheckRes}
     * @since 2025/10/30
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxa/msg_sec_check")
    MsgSecCheckRes msgSecCheck(@WeChatAccessTokenParam String weChatIndex, @JsonBody MsgSecCheckReq req);

    /**
     * 多媒体内容安全识别
     * 详细文档：<a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/sec-center/sec-check/mediaCheckAsync.html">...</a>
     *
     * @param weChatIndex {@link String weChatIndex}
     * @param req         {@link MediaCheckAsyncReq req}
     * @return {@link MediaCheckAsyncRes}
     * @since 2025/10/30
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxa/media_check_async")
    MediaCheckAsyncRes mediaCheckAsync(@WeChatAccessTokenParam String weChatIndex, @JsonBody MediaCheckAsyncReq req);

    // 文本内容安全识别相关类
    @Data
    class MsgSecCheckReq implements Serializable {
        @Serial
        private static final long serialVersionUID = 1L;

        private String content;
        private Integer version = 2;
        private Integer scene;
        private String openid;
        private String title;
        private String nickname;
        private String signature;
    }

    @Data
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    class MsgSecCheckRes extends BaseWeChatApiRes {
        @Serial
        private static final long serialVersionUID = 2L;

        private List<Detail> detail;
        private Result result;
        private String trace_id;

        @Data
        static class Detail implements Serializable {
            @Serial
            private static final long serialVersionUID = 3L;

            private String strategy;
            private Integer errcode;
            private String suggest;
            private Integer label;
            private String keyword;
            private Integer prob;
        }

        @Data
        static class Result implements Serializable {
            @Serial
            private static final long serialVersionUID = 4L;

            private String suggest;
            private Integer label;
        }
    }

    // 多媒体内容安全识别相关类
    @Data
    class MediaCheckAsyncReq implements Serializable {
        @Serial
        private static final long serialVersionUID = 5L;

        @JsonProperty("media_url")
        private String mediaUrl;
        @JsonProperty("media_type")
        private Integer mediaType;
        private Integer version = 2;
        private Integer scene;
        private String openid;
    }

    @Data
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    class MediaCheckAsyncRes extends BaseWeChatApiRes {
        @Serial
        private static final long serialVersionUID = 6L;

        @JsonProperty("trace_id")
        private String traceId;
    }
}