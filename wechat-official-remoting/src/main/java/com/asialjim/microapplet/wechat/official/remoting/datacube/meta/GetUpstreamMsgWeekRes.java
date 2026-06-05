/*
 * Copyright 2014-2024 <a href="mailto:asialjim@qq.com">Asial Jim</a>
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
package com.asialjim.microapplet.wechat.official.remoting.datacube.meta;

import com.asialjim.microapplet.wechat.remoting.context.BaseWeChatApiRes;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * 获取消息发送周数据响应结果
 * <p>
 * 参考文档: <a href="https://developers.weixin.qq.com/doc/subscription/api/wedata/mess/api_getupstreammsgweek.html">获取消息发送周数据</a>
 * </p>
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2024-10-31, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class GetUpstreamMsgWeekRes extends BaseWeChatApiRes {

    @Serial
    private static final long serialVersionUID = -45678901L;

    /**
     * 数据列表
     */
    private List<UpstreamMsgData> list;

    /**
     * 消息数据项
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Accessors(chain = true)
    public static class UpstreamMsgData implements Serializable {

        @Serial
        private static final long serialVersionUID = -56789012L;

        /**
         * 数据的日期，需在begin_date和end_date之间
         */
        private String ref_date;

        /**
         * 消息类型，代表含义如下：
         * 1代表文字
         * 2代表图片
         * 3代表语音
         * 4代表视频
         * 6代表第三方应用消息（链接消息）
         */
        private Integer msg_type;

        /**
         * 上行发送了（向公众号发送了）消息的用户数
         */
        private Integer msg_user;

        /**
         * 上行发送了消息的消息总数
         */
        private Integer msg_count;
    }
}