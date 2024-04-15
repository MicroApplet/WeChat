/*
 * Copyright 2014-2024 <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
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

package io.github.microapplet.wechat.official.remoting.analysis;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.microapplet.remote.http.annotation.HttpMapping;
import io.github.microapplet.remote.http.annotation.HttpMethod;
import io.github.microapplet.remote.http.annotation.body.JsonBody;
import io.github.microapplet.remote.net.annotation.Server;
import io.github.microapplet.wechat.constant.WeChatCons;
import io.github.microapplet.wechat.remoting.context.BaseWeChatApiRes;
import io.github.microapplet.wechat.remoting.context.WeChatAccessTokenParam;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * 公众号消息分析API客户端
 * <pre>
 * 向所有认证公众号开发者开放数据接口。通过数据接口，开发者可以获取与公众平台官网统计模块类似但更灵活的数据，还可根据需要进行高级处理。
 * 在公众号登录授权机制的权限集划分中，消息分析数据接口属于消息管理权限。
 *
 * 请注意：
 *
 * 接口侧的公众号数据的数据库中仅存储了2014年12月1日之后的数据，将查询不到在此之前的日期，即使有查到，也是不可信的脏数据；
 * 请开发者在调用接口获取数据后，将数据保存在自身数据库中，即加快下次用户的访问速度，也降低了微信侧接口调用的不必要损耗。
 * 为确保公众号数据已完成统计和处理，请于每天上午8点后查询公众号前一天的数据。
 * </pre>
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0.0
 * @since 2024 04 15, &nbsp;&nbsp; <em>version:1.0.0</em>
 */
@Server(
        supplier = WeChatCons.Supplier.WECHAT,
        namespace = WeChatCons.Namespace.COMMON,
        schema = WeChatCons.Api.DEFAULT_SCHEMA,
        host = WeChatCons.Api.DEFAULT_HOST,
        port = WeChatCons.Api.DEFAULT_PORT
)
public interface WeChatPublicMessageAnalysisRemoting {

    /**
     * 获取消息发送概况数据
     *
     * @param weChatIndex {@link String weChatIndex}
     * @since 2024 04 15
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/datacube/getupstreammsg")
    UpstreamRes getUpstreamMsg(@WeChatAccessTokenParam String weChatIndex, @JsonBody UpstreamReq body);

    /**
     * 获取消息发送分时数据
     *
     * @param weChatIndex {@link String weChatIndex}
     * @since 2024 04 15
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/datacube/getupstreammsghour")
    UpstreamRes getUpstreamMsgHour(@WeChatAccessTokenParam String weChatIndex, @JsonBody UpstreamReq body);

    /**
     * 获取消息发送周数据
     *
     * @param weChatIndex {@link String weChatIndex}
     * @since 2024 04 15
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/datacube/getupstreammsgweek")
    UpstreamRes getUpstreamMsgWeek(@WeChatAccessTokenParam String weChatIndex, @JsonBody UpstreamReq body);

    /**
     * 获取消息发送月数据
     *
     * @param weChatIndex {@link String weChatIndex}
     * @since 2024 04 15
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/datacube/getupstreammsgmonth")
    UpstreamRes getUpstreamMsgMonth(@WeChatAccessTokenParam String weChatIndex, @JsonBody UpstreamReq body);

    /**
     * 获取消息发送分布数据
     *
     * @param weChatIndex {@link String weChatIndex}
     * @since 2024 04 15
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/datacube/getupstreammsgdist")
    UpstreamRes getUpstreamMsgDist(@WeChatAccessTokenParam String weChatIndex, @JsonBody UpstreamReq body);

    /**
     * 获取消息发送分布周数据
     *
     * @param weChatIndex {@link String weChatIndex}
     * @since 2024 04 15
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/datacube/getupstreammsgdistweek")
    UpstreamRes getUpstreamMsgDistWeek(@WeChatAccessTokenParam String weChatIndex, @JsonBody UpstreamReq body);

    /**
     * 获取消息发送分布月数据
     *
     * @param weChatIndex {@link String weChatIndex}
     * @since 2024 04 15
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/datacube/getupstreammsgdistmonth")
    UpstreamRes getUpstreamMsgDistMonth(@WeChatAccessTokenParam String weChatIndex, @JsonBody UpstreamReq body);

    @Accessors(chain = true)
    @Data(staticConstructor = "create")
    class UpstreamReq implements Serializable {
        private static final long serialVersionUID = -8407805894766835685L;

        @JsonProperty("begin_date")
        private String beginDate;
        @JsonProperty("end_date")
        private String endDate;

        public UpstreamReq(LocalDate beginDate, LocalDate endDate) {
            this.beginDate = beginDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
            this.endDate = endDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
        }
    }

    @Data
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    class UpstreamRes extends BaseWeChatApiRes {
        private static final long serialVersionUID = 5408814989513930940L;

        private List<UpstreamResItem> list;
    }

    @Data
    class UpstreamResItem implements Serializable {
        private static final long serialVersionUID = -6740777007579150322L;

        /**
         * 数据的日期，需要在 begin_date 和 end_date 之间
         */
        @JsonProperty("ref_date")
        private String refDate;
        /**
         * 数据的小时，包括从000到2300，分别代表的是[000,100)到[2300,2400)，即每日的第1小时和最后1小时
         */
        private Integer ref_hour;
        /**
         * 消息类型，代表含义如下： 1代表文字 2代表图片 3代表语音 4代表视频 6代表第三方应用消息（链接消息）
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
        /**
         * 当日发送消息量分布的区间，0代表 “0”，1代表“1-5”，2代表“6-10”，3代表“10次以上”
         */
        private Integer count_interval;
        /**
         * 图文页的阅读次数
         */
        private Integer int_page_read_count;

        /**
         * 原文页（点击图文页“阅读原文”进入的页面）的阅读人数，无原文页时此处数据为0
         */
        private Integer ori_page_read_user;
    }

    static UpstreamReq create(LocalDate beginDate, LocalDate endDate) {
        return new UpstreamReq(beginDate, endDate);
    }
}