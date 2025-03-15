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
package io.github.microapplet.wechat.remoting.context;

import lombok.*;


import java.io.Serializable;

/**
 * 微信API响应结果 *
 * @author Copyright © <a href="mailto:asialjim@hotmail.com">Asial Jim</a>   Co., LTD
 * @version 1.0
 * @since 2023/1/3, &nbsp;&nbsp; <em>version:1.0</em>, &nbsp;&nbsp; <em>java version:8</em>
 */
@Data
public class BaseWeChatApiRes implements WeChatApiRes, Serializable {
    
    private static final long serialVersionUID = -3722640486042138626L;

    /**
     * 微信服务器响应业务代码
     */
    private Integer errcode;
    /**
     * 微信服务器响应业务消息
     */
    private String errmsg;
}