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
 * 获取消息发送分布周数据响应结果
 * <p>
 * 参考文档: <a href="https://developers.weixin.qq.com/doc/subscription/api/wedata/mess/api_getupstreammsgdistweek.html">获取消息发送分布周数据</a>
 * </p>
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2024-10-31, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class GetUpstreamMsgDistWeekRes extends BaseWeChatApiRes {

    @Serial
    private static final long serialVersionUID = -78901234L;

    /**
     * 数据列表
     */
    private List<UpstreamMsgDistData> list;

    /**
     * 消息分布数据项
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Accessors(chain = true)
    public static class UpstreamMsgDistData implements Serializable {

        @Serial
        private static final long serialVersionUID = -89012345L;

        /**
         * 数据的日期，需在begin_date和end_date之间
         */
        private String ref_date;

        /**
         * 当日发送消息量分布的区间，0代表“0”，1代表“1-5”，2代表“6-10”，3代表“10次以上”
         */
        private Integer count_interval;

        /**
         * 上行发送了（向公众号发送了）消息的用户数
         */
        private Integer msg_user;
    }
}