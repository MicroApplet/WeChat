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

package io.github.microapplet.wechat.official.remoting.subscribenotify;

import io.github.microapplet.remote.http.annotation.HttpMapping;
import io.github.microapplet.remote.http.annotation.HttpMethod;
import io.github.microapplet.remote.http.annotation.HttpQuery;
import io.github.microapplet.remote.http.annotation.body.JsonBody;
import io.github.microapplet.remote.net.annotation.Server;
import io.github.microapplet.wechat.constant.WeChatCons;
import io.github.microapplet.wechat.remoting.context.BaseWeChatApiRes;
import io.github.microapplet.wechat.remoting.context.WeChatAccessTokenParam;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * 微信公众号订阅通知API客户端
 *
 * @author Copyright © <a href="mailto:asialjim@hotmail.com">Asial Jim</a>   Co., LTD
 * @version 1.0
 * @since 2023/12/31, &nbsp;&nbsp; <em>version:1.0</em>,  &nbsp;&nbsp;  <em>java version:8</em>
 */
@SuppressWarnings("unused")
@Server(supplier = WeChatCons.Supplier.WECHAT, namespace = WeChatCons.Namespace.COMMON, schema = WeChatCons.Api.DEFAULT_SCHEMA, host = WeChatCons.Api.DEFAULT_HOST, port = WeChatCons.Api.DEFAULT_PORT)
public interface WeChatPaSubscribeNotifyRemoting {

    /**
     * addTemplate选用模板
     * 从公共模板库中选用模板，到私有模板库中
     *
     * @param weChatIndex {@link String weChatIndex}
     * @param body        {@link AddTemplateReq body}
     * @return {@link AddTemplateRes }
     * @since 2023/12/31
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxaapi/newtmpl/addtemplate")
    AddTemplateRes addTemplate(@WeChatAccessTokenParam String weChatIndex, @JsonBody AddTemplateReq body);

    /**
     * deleteTemplate删除模板
     * 删除私有模板库中的模板
     *
     * @param weChatIndex {@link String weChatIndex}
     * @param body        {@link DeleteTemplateReq body}
     * @return {@link BaseWeChatApiRes }
     * @since 2023/12/31
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxaapi/newtmpl/deltemplate")
    BaseWeChatApiRes deleteTemplate(@WeChatAccessTokenParam String weChatIndex, @JsonBody DeleteTemplateReq body);

    /**
     * getCategory获取公众号类目
     * 获取公众号所属类目，可用于查询类目下的公共模板
     *
     * @param weChatIndex {@link String weChatIndex}
     * @return {@link GetCategoryRes }
     * @since 2023/12/31
     */
    @HttpMapping(method = HttpMethod.GET, uri = "/wxaapi/newtmpl/getcategory")
    GetCategoryRes getCategory(@WeChatAccessTokenParam String weChatIndex);

    /**
     * getPubTemplateKeyWordsById获取模板中的关键词
     * 获取公共模板下的关键词列表
     *
     * @param weChatIndex {@link String weChatIndex}
     * @param tid         {@link String tid}
     * @return {@link GetPubTemplateKeywordsRes}
     * @since 2023/12/31
     */
    @HttpMapping(method = HttpMethod.GET, uri = "/wxaapi/newtmpl/getpubtemplatekeywords")
    GetPubTemplateKeywordsRes getPubTemplateKeywordsRes(@WeChatAccessTokenParam String weChatIndex, @HttpQuery(name = "tid") String tid);

    /**
     * getPubTemplateTitleList获取类目下的公共模板
     * 获取类目下的公共模板，可从中选用模板使用
     *
     * @param weChatIndex {@link String weChatIndex}
     * @param start       {@link Long start}
     * @param number      {@link Long number}
     * @return {@link GetPubTemplateTitleListRes }
     * @since 2023/12/31
     */
    @HttpMapping(method = HttpMethod.GET, uri = "/wxaapi/newtmpl/getpubtemplatetitles")
    GetPubTemplateTitleListRes getPubTemplateTitleList(@WeChatAccessTokenParam String weChatIndex, @HttpQuery(name = "ids") String ids, @HttpQuery(name = "start") Long start, @HttpQuery(name = "limit") Long number);


    @Data
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    class GetPubTemplateTitleListRes extends BaseWeChatApiRes {
        @Serial
        private static final long serialVersionUID = 4756755496267943915L;

        private Long count;
        private List<GetPubTemplateTitleListData> data;
    }

    @Data
    class GetPubTemplateTitleListData {
        private Long tid;
        private String title;
        private Long type;
        private Long categoryId;
    }

    @Data
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    class GetPubTemplateKeywordsRes extends BaseWeChatApiRes {
        @Serial
        private static final long serialVersionUID = 2314889574367857951L;

        private Long count;
        private List<GetPubTemplateKeywordsData> data;
    }

    @Data
    class GetPubTemplateKeywordsData {
        private Long kid;
        private String name;
        private String example;
        private String rule;
    }

    @Data
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    class GetCategoryRes extends BaseWeChatApiRes {

        @Serial
        private static final long serialVersionUID = 1167408052198683353L;
        private List<GetCategoryData> data;
    }

    @Data
    class GetCategoryData {
        private Long id;
        private String name;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    class DeleteTemplateReq implements Serializable {
        @Serial
        private static final long serialVersionUID = 3021922187829863323L;
        private String priTmplId;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    class AddTemplateReq implements Serializable {
        @Serial
        private static final long serialVersionUID = 7077008714059354327L;
        private String tid;
        private List<Integer> kidList;
        private String sceneDesc;
    }

    @Data
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    class AddTemplateRes extends BaseWeChatApiRes {
        @Serial
        private static final long serialVersionUID = -2919822704267536946L;

        private String priTmplId;
    }
}