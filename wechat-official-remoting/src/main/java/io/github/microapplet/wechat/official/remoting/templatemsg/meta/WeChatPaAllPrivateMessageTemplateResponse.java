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
package io.github.microapplet.wechat.official.remoting.templatemsg.meta;

import io.github.microapplet.wechat.remoting.context.BaseWeChatApiRes;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 *  微信公众号查询所有消息模板响应
 * @author Copyright © <a href="mailto:asialjim@hotmail.com">Asial Jim</a>   Co., LTD
 * @version 1.0
 * @since 2022/3/29   &nbsp;&nbsp; JDK 8
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class WeChatPaAllPrivateMessageTemplateResponse extends BaseWeChatApiRes {
    private static final long serialVersionUID = 8370961983874006452L;

    private List<TemplateInfo> template_list;

    @Data
    public static class TemplateInfo implements Serializable {
        private static final long serialVersionUID = 8000265497424503341L;

        private String template_id;
        private String title;
        private String primary_industry;
        private String deputy_industry;
        private String content;
        private String example;
    }
}