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
package com.asialjim.microapplet.wechat.official.remoting.templatemsg;

import com.asialjim.microapplet.remote.http.annotation.HttpMapping;
import com.asialjim.microapplet.remote.http.annotation.HttpMethod;
import com.asialjim.microapplet.remote.http.annotation.body.JsonBody;
import com.asialjim.microapplet.remote.net.annotation.Server;
import com.asialjim.microapplet.wechat.constant.WeChatCons;
import com.asialjim.microapplet.wechat.official.remoting.templatemsg.meta.*;
import com.asialjim.microapplet.wechat.remoting.context.BaseWeChatApiRes;
import com.asialjim.microapplet.wechat.remoting.context.WeChatAccessTokenParam;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("unused")
@Server(supplier = WeChatCons.Supplier.WECHAT, namespace = WeChatCons.Namespace.COMMON, schema = WeChatCons.Api.DEFAULT_SCHEMA, host = WeChatCons.Api.DEFAULT_HOST, port = WeChatCons.Api.DEFAULT_PORT)
public interface WeChatPaTemplateMsgRemoting {

    /**
     * 设置行业可在微信公众平台后台完成，每月可修改行业1次，账号仅可使用所属行业中相关的模板，为方便第三方开发者，提供通过接口调用的方式来修改账号所属行业
     *
     * @param weChatIndex {@link String weChatIndex}
     * @param body        {@link WeChatPaTemplateMsgApiSetIndustryReq body}
     * @return {@link BaseWeChatApiRes}
     * @since 2023/12/14
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/template/api_set_industry")
    BaseWeChatApiRes apiSetIndustry(@WeChatAccessTokenParam String weChatIndex, @JsonBody WeChatPaTemplateMsgApiSetIndustryReq body);

    /**
     * 获取账号设置的行业信息。可登录微信公众平台，在公众号后台中查看行业信息。为方便第三方开发者，提供通过接口调用的方式来获取账号所设置的行业信息，
     *
     * @param weChatIndex {@link String weChatIndex}
     * @return {@link BaseWeChatApiRes }
     * @since 2023/12/26
     */
    @HttpMapping(method = HttpMethod.GET, uri = "/cgi-bin/template/get_industry")
    GetTemplateIndustryRes queryIndustry(@WeChatAccessTokenParam String weChatIndex);

    /**
     * 从行业模板库选择模板到账号后台，获得模板ID的过程可在微信公众平台后台完成。为方便第三方开发者，提供通过接口调用的方式来获取模板ID*
     *
     * @param weChatIndex {@link String weChatIndex}
     * @param body        {@link QueryTemplateIdReq body}
     * @return {@link BaseWeChatApiRes}
     * @since 2023/12/26
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/template/api_add_template")
    QueryTemplateIdRes queryTemplateId(@WeChatAccessTokenParam String weChatIndex, @JsonBody QueryTemplateIdReq body);

    /**
     * 发送订阅消息
     *
     * @param subjectId {@link String 微信公众平台应用编号}
     * @param body      {@link SubscribeTemplateMsgReq 消息}
     * @return {@link BaseWeChatApiRes 发送结果}
     * @since 2022/2/21 17:49
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/message/template/subscribe")
    BaseWeChatApiRes subscribe(@WeChatAccessTokenParam String subjectId, @JsonBody SubscribeTemplateMsgReq body);

    /**
     * 发送模板消息
     *
     * @param subjectId {@link String 公众平台应用编号}
     * @param body      {@link SendTemplateMsgReq 模板消息内容}
     * @return {@link SendTemplateMsgRes 发送结果}
     * @since 2022/3/1 16:26
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/message/template/send")
    SendTemplateMsgRes sendFromPublicAccount(@WeChatAccessTokenParam String subjectId, @JsonBody SendTemplateMsgReq body);

    /**
     * 查询微信公众号所有的消息模板
     *
     * @param subjectId {@link String 公众平台应用编号}
     * @return {@link WeChatPaAllPrivateMessageTemplateResponse 响应结果}
     * @since 2022/3/29 16:33
     */
    @HttpMapping(method = HttpMethod.GET, uri = "/cgi-bin/template/get_all_private_template")
    WeChatPaAllPrivateMessageTemplateResponse allPrivateTemplate(@WeChatAccessTokenParam String subjectId);

    /**
     * 删除模板可在微信公众平台后台完成，为方便第三方开发者，提供通过接口调用的方式来删除某账号下的模板
     *
     * @param weChatId {@link String weChatId}
     * @param body     {@link DeletePrivateTemplateReq body}
     * @return {@link BaseWeChatApiRes}
     * @since 2023/12/26
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/template/del_private_template")
    BaseWeChatApiRes deletePrivateTemplate(@WeChatAccessTokenParam String weChatId, @JsonBody DeletePrivateTemplateReq body);

    /**
     * <a href="https://developers.weixin.qq.com/doc/offiaccount/Message_Management/QueryBlockTmplMsg.html">参考文档</a>
     *
     * @param weChatIndex {@link String weChatIndex}
     * @param req         {@link QueryTemplateIdReq req}
     * @return {@link QueryTemplateIdRes }
     * @since 2023/12/26
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxa/sec/queryblocktmplmsg")
    QueryTemplateIdRes queryBlockTmplMsg(@WeChatAccessTokenParam String weChatIndex, @JsonBody QueryTemplateIdReq req);

    @Data
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    class QueryBlockTmplMsgRes extends BaseWeChatApiRes {
        
        private static final long serialVersionUID = -4365130884733356262L;
        private MsgInfo msginfo;
    }

    @Data
    class MsgInfo {
        private Integer id;
        private String tmpl_msg_id;
        private String title;
        private String content;
        private Integer send_timestamp;
        private String openid;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    class QueryBlockTmplMsgReq implements Serializable {
        
        private static final long serialVersionUID = 3356137541602951179L;

        private String tmpl_msg_id;
        private Integer largest_id;
        private Integer limit;
    }

    @Data
    class DeletePrivateTemplateReq implements Serializable {
        
        private static final long serialVersionUID = -6198480181995475058L;

        private String template_id;
    }

    @Data
    class QueryTemplateIdReq implements Serializable {
        
        private static final long serialVersionUID = -8064682507716097724L;

        private String template_id_short;
        private List<String> keyword_name_list;
    }

    @Data
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    class QueryTemplateIdRes extends BaseWeChatApiRes {
        
        private static final long serialVersionUID = -2734036136662532502L;
        private String template_id;
    }

    @Data
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    class GetTemplateIndustryRes extends BaseWeChatApiRes {
        
        private static final long serialVersionUID = 5318027318348661664L;

        private IndustryItem primary_industry;
        private IndustryItem secondary_industry;
    }

    @Data
    class IndustryItem {
        private String first_class;
        private String second_class;
    }
}