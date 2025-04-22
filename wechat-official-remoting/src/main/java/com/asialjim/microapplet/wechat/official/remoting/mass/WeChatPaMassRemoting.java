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

package com.asialjim.microapplet.wechat.official.remoting.mass;


import com.asialjim.microapplet.remote.http.annotation.HttpMapping;
import com.asialjim.microapplet.remote.http.annotation.HttpMethod;
import com.asialjim.microapplet.remote.http.annotation.body.JsonBody;
import com.asialjim.microapplet.remote.net.annotation.Server;
import com.asialjim.microapplet.wechat.constant.WeChatCons;
import com.asialjim.microapplet.wechat.official.remoting.mass.meta.SendMassMessageToAll;
import com.asialjim.microapplet.wechat.official.remoting.mass.meta.SendMassMessageToPreview;
import com.asialjim.microapplet.wechat.official.remoting.mass.meta.SendMassMessageToUser;
import com.asialjim.microapplet.wechat.remoting.context.BaseWeChatApiRes;
import com.asialjim.microapplet.wechat.remoting.context.WeChatAccessTokenParam;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("unused")
@Server(supplier = WeChatCons.Supplier.WECHAT, namespace = WeChatCons.Namespace.COMMON, schema = WeChatCons.Api.DEFAULT_SCHEMA, host = WeChatCons.Api.DEFAULT_HOST, port = WeChatCons.Api.DEFAULT_PORT)
public interface WeChatPaMassRemoting {

    /**
     * 根据标签进行群发【订阅号与服务号认证后均可用】*
     *
     * @param weChatIndex {@link String weChatIndex}
     * @param body        {@link SendMassMessageToAll body}
     * @return {@link SendMassMessageRes }
     * @since 2023/12/27
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/message/mass/sendall")
    SendMassMessageRes sendMassToAll(@WeChatAccessTokenParam String weChatIndex, @JsonBody SendMassMessageToAll body);

    /**
     * 根据OpenID列表群发【订阅号不可用，服务号认证后可用】
     *
     * @param weChatIndex {@link String weChatIndex}
     * @param body        {@link SendMassMessageToUser body}
     * @return {@link SendMassMessageRes}
     * @since 2023/12/27
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/message/mass/send")
    SendMassMessageRes sendMassToUsers(@WeChatAccessTokenParam String weChatIndex, @JsonBody SendMassMessageToUser body);

    /**
     * <pre>
     * 删除群发【订阅号与服务号认证后均可用】
     * 群发之后，随时可以通过该接口删除群发。
     * msg_id和url中必须有一个参数有传值，当两个参数都有值时只有msg_id有效。
     * article_idx只有在msg_id有传值的时候才生效。
     * 只有通过api发送的并且已经发送成功的消息才能删除。
     * 删除消息是将消息的图文详情页失效，已经收到的用户，还是能在其本地看到消息卡片。
     * 删除群发消息只能删除图文消息和视频消息，其他类型的消息一经发送，无法删除。
     * 如果多次群发发送的是一个图文消息，那么删除其中一次群发，就会删除掉这个图文消息页，导致所有群发都失效。*
     * </pre>
     *
     * @param weChatIndex {@link String weChatIndex}
     * @param body        {@link DeleteMassMessageReq body}
     * @return {@link BaseWeChatApiRes}
     * @since 2023/12/27
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/message/mass/delete")
    BaseWeChatApiRes deleteMassMessage(@WeChatAccessTokenParam String weChatIndex, @JsonBody DeleteMassMessageReq body);

    /**
     * <pre>
     * 预览接口【订阅号与服务号认证后均可用】
     * 开发者可通过该接口发送消息给指定用户，在手机端查看消息的样式和排版。为了满足第三方平台开发者的需求，在保留对openID预览能力的同时，增加了对指定微信号发送预览的能力，但该能力每日调用次数有限制（100次），请勿滥用。
     * </pre>
     *
     * @param weChatIndex {@link String weChatIndex}
     * @param body        {@link SendMassMessageToPreview body}
     * @return {@link BaseWeChatApiRes }
     * @since 2023/12/27
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/message/mass/preview")
    BaseWeChatApiRes previewMassMessage(@WeChatAccessTokenParam String weChatIndex, @JsonBody SendMassMessageToPreview body);

    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/message/mass/get")
    QueryMassMessageSendStatusRes sendStatus(@WeChatAccessTokenParam String weChatIndex, @JsonBody QueryMassMessageSendStatusReq body);

    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/message/mass/speed/get")
    QueryMassMesageSendSpeedRes querySpeed(@WeChatAccessTokenParam String weChatIndex);

    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/message/mass/speed/set")
    BaseWeChatApiRes configSpeed(@WeChatAccessTokenParam String weChatIndex, @JsonBody SetMassMessageSendSpeedReq req);

    @Data
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    class QueryMassMesageSendSpeedRes extends BaseWeChatApiRes{
        
        private static final long serialVersionUID = -6490925918064024024L;
        /**
         * 速度级别
         */
        private Integer speed;
        /**
         * 群发速度的真实值，单位：万/分钟
         */
        private Integer realspped;
    }

    @Data
    class SetMassMessageSendSpeedReq implements Serializable{
        
        private static final long serialVersionUID = 7147723068684638238L;
        /**
         * 速度级别
         */
        private Integer speed;

        public static Builder builder(){
            return new Builder();
        }

        public static class Builder{
            /**
             * <pre>
             * speed 与 realspeed 的关系如下：
             * speed	realspeed
             * 0	80w/分钟
             * 1	60w/分钟
             * 2	45w/分钟
             * 3	30w/分钟
             * 4	10w/分钟
             *
             * 注意：若用户传空，或者值小于0， 默认取0， 若值大于4，默认取4
             * </pre>
             * @param speed 速度
             */
            public SetMassMessageSendSpeedReq build(Integer speed){
                SetMassMessageSendSpeedReq req = new SetMassMessageSendSpeedReq();
                int target = 0;
                if (Objects.nonNull(speed)){
                    target = Math.max(0, speed);
                    target = Math.min(4,target);
                }
                req.setSpeed(target);
                return req;
            }
        }
    }

    @Data
    class QueryMassMessageSendStatusReq implements Serializable{
        
        private static final long serialVersionUID = -2185620250607181941L;
        private Integer msg_id;
        private String msg_status;
    }

    @Data
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    class QueryMassMessageSendStatusRes extends BaseWeChatApiRes{
        
        private static final long serialVersionUID = 3298917046569810814L;
        private String msg_id;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    class DeleteMassMessageReq implements Serializable {
        
        private static final long serialVersionUID = 5574047756590767011L;
        private Integer msg_id;
        private Integer article_idx;
        private String url;
    }

    @Data
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    class SendMassMessageRes extends BaseWeChatApiRes {
        
        private static final long serialVersionUID = 6743833537771306754L;

        private String type;
        private Integer msg_id;
        private Integer msg_data_id;
    }
}
