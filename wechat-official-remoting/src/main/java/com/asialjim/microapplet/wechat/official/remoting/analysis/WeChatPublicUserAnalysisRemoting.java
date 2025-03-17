/*
 *  Copyright 2014-2025 <a href="mailto:asialjim@qq.com">Asial Jim</a>
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package com.asialjim.microapplet.wechat.official.remoting.analysis;

import com.asialjim.microapplet.remote.http.annotation.HttpMapping;
import com.asialjim.microapplet.remote.http.annotation.HttpMethod;
import com.asialjim.microapplet.remote.net.annotation.Server;
import com.asialjim.microapplet.wechat.constant.WeChatCons;
import com.asialjim.microapplet.wechat.official.remoting.analysis.user.GetUserCumulateRes;
import com.asialjim.microapplet.wechat.official.remoting.analysis.user.GetUserSummaryReq;
import com.asialjim.microapplet.wechat.official.remoting.analysis.user.GetUserSummaryRes;
import com.asialjim.microapplet.wechat.remoting.context.WeChatAccessTokenParam;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * <pre>
 * 用户分析
 * WeChat Public Account User Analysis API Remoting
 * 向所有认证公众号开发者开放数据接口。通过数据接口，开发者可以获取与公众平台官网统计模块类似但更灵活的数据，还可根据需要进行高级处理。使用数据接口过程中有任何问题，可以前往微信开放社区 #公众号 专区发帖交流。
 * 在公众号登录授权机制的权限集划分中，用户分析数据接口属于用户管理权限。
 * 请注意：
 * 接口侧的公众号数据的数据库中仅存储了2014年12月1日之后的数据，将查询不到在此之前的日期，即使有查到，也是不可信的脏数据；
 * 请开发者在调用接口获取数据后，将数据保存在自身数据库中，即加快下次用户的访问速度，也降低了微信侧接口调用的不必要损耗。
 * 为确保公众号数据已完成统计和处理，请于每天上午8点后查询公众号前一天的数据。
 * 2020年4月起，新增关注渠道增加'他人转载'，之前合并在“其他合计”中。
 * 2020年6月起，新增关注渠道增加'微信广告'、'专辑内账号名称'，之前合并在“其他合计”中。
 * 2023年6月起，支付后关注合并在“其他合计”中。
 * </pre>
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0.0
 * @since 2024/3/1, &nbsp;&nbsp; <em>version:1.0.0</em>
 */
@Server(
        supplier = WeChatCons.Supplier.WECHAT,
        namespace = WeChatCons.Namespace.COMMON,
        schema = WeChatCons.Api.DEFAULT_SCHEMA,
        host = WeChatCons.Api.DEFAULT_HOST,
        port = WeChatCons.Api.DEFAULT_PORT
)
@SuppressWarnings({"unused", "SpellCheckingInspection"})
public interface WeChatPublicUserAnalysisRemoting {

    /**
     * 获取用户增减数据
     *
     * @param weChatIndexOrAccessToken {@link String weChatIndexOrAccessToken}
     * @param body                     {@link GetUserSummaryReq body}
     * @return {@link GetUserSummaryRes }
     * @since 2024/3/1
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/datacube/getusersummary")
    GetUserSummaryRes userSummary(@WeChatAccessTokenParam String weChatIndexOrAccessToken, @JsonProperty GetUserSummaryReq body);

    /**
     * 获取累计用户数据
     *
     * @param weChatIndexOrAccessToken {@link String weChatIndexOrAccessToken}
     * @param body                     {@link GetUserCumulateRes body}
     * @return {@link GetUserCumulateRes }
     * @since 2024/3/1
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/datacube/getusercumulate")
    GetUserCumulateRes userCumulate(@WeChatAccessTokenParam String weChatIndexOrAccessToken, @JsonProperty GetUserCumulateRes body);
}