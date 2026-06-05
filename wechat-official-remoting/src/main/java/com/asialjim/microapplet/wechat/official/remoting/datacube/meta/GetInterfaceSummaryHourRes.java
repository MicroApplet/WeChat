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
import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * 获取被动回复分布数据响应结果
 * <p>
 * 参考文档: <a href="https://developers.weixin.qq.com/doc/subscription/api/wedata/api/api_getinterfacesummaryhour.html">获取被动回复分布数据</a>
 * </p>
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2024-10-31, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class GetInterfaceSummaryHourRes extends BaseWeChatApiRes {

    @Serial
    private static final long serialVersionUID = -56789012L;

    /**
     * 数据列表
     */
    private List<InterfaceSummaryHourData> list;

    /**
     * 接口调用小时数据项
     */
    @Data
    @Accessors(chain = true)
    public static class InterfaceSummaryHourData implements Serializable {

        @Serial
        private static final long serialVersionUID = -67890123L;

        /**
         * 数据的日期
         */
        private String ref_date;

        /**
         * 数据的小时
         */
        private Integer ref_hour;

        /**
         * 通过服务器配置地址获得消息后，被动回复用户消息的次数
         */
        private Long callback_count;

        /**
         * 上述动作的失败次数
         */
        private Long fail_count;

        /**
         * 总耗时，除以callback_count即为平均耗时
         */
        private Long total_time_cost;

        /**
         * 最大耗时
         */
        private Long max_time_cost;
    }
}