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
import java.util.Objects;

/**
 * 公众号接口分析API
 * <pre>
 * 向所有认证公众号开发者开放数据接口。通过数据接口，开发者可以获取与公众平台官网统计模块类似但更灵活的数据，还可根据需要进行高级处理。
 * 在公众号登录授权机制的权限集划分中，接口分析数据接口属于账号服务权限。
 *
 * 请注意：
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
public interface WeChatPublicInterfaceAnalysisRemoting {


    /**
     * 获取接口分析数据
     *
     * @param weChatIndex {@link String weChatIndex}
     * @param body        {@link SummaryReq body}
     * @return {@link SummaryRes }
     * @since 2024 04 15
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/datacube/getinterfacesummary")
    SummaryRes summary(@WeChatAccessTokenParam String weChatIndex, @JsonBody SummaryReq body);


    /**
     * 获取接口分析分时数据
     *
     * @param weChatIndex {@link String weChatIndex}
     * @param body        {@link SummaryReq body}
     * @return {@link SummaryRes }
     * @since 2024 04 15
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/datacube/getinterfacesummaryhour")
    SummaryRes summaryHour(@WeChatAccessTokenParam String weChatIndex, @JsonBody SummaryReq body);

    @Accessors(chain = true)
    @Data(staticConstructor = "create")
    class SummaryReq implements Serializable {
        private static final long serialVersionUID = -4891917558158900528L;
        private String begin_date;
        private String end_date;
    }

    @Data
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    class SummaryRes extends BaseWeChatApiRes {
        private static final long serialVersionUID = 8924777174411182232L;

        private List<SummaryItem> list;
    }

    @Data
    class SummaryItem {
        private String ref_date;
        private Integer ref_hour;
        private Integer callback_count;
        private Integer fail_count;
        private Integer total_time_count;
        private Integer max_time_cost;
    }

    static SummaryReq create(LocalDate beginDate, LocalDate endDate) {
        if (Objects.isNull(beginDate) || Objects.isNull(endDate))
            throw new IllegalArgumentException("Argument Cannot be Null");
        return SummaryReq.create()
                .setBegin_date(beginDate.format(DateTimeFormatter.ISO_LOCAL_DATE))
                .setEnd_date(endDate.format(DateTimeFormatter.ISO_LOCAL_DATE));
    }
}