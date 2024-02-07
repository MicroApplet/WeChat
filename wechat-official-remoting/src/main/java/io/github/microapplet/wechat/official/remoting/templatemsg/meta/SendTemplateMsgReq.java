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

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.Map;

/**
 *  发送微信公众平台模板消息请求体
 * @author Copyright © <a href="mailto:asialjim@hotmail.com">Asial Jim</a>   Co., LTD
 * @version 1.0
 * @since 2022/3/1   &nbsp;&nbsp; JDK 8
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SendTemplateMsgReq implements Serializable {
    @Serial
    private static final long serialVersionUID = 3699372623879706365L;

    private String touser;
    private String template_id;
    private String url;
    private String page;

    @JsonProperty("miniprogram_state")
    private String miniprogramState;

    private String lang;

    private MiniProgramInfo miniprogram;
    private Map<String,MessageContent> data;
}
