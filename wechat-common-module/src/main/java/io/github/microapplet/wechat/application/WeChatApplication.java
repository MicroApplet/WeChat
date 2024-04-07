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

package io.github.microapplet.wechat.application;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 微信公众平台应用信息
 *
 * @author Copyright © <a href="mailto:asialjim@hotmail.com">Asial Jim</a>   Co., LTD
 * @version 1.0
 * @since 2023/12/16, &nbsp;&nbsp; <em>version:1.0</em>,  &nbsp;&nbsp;  <em>java version:8</em>
 */
@Data
@TableName("wx_app")
@Accessors(chain = true)
public class WeChatApplication implements Serializable {
    private static final long serialVersionUID = 4412693788847340328L;

    /**
     * 微信公众平台应用微信号,除应用类型为企业微信，一般情况下，与 {@link #getSubjectId()} 相同
     */
    @TableId(type = IdType.INPUT)
    private String id;

    /**
     * 微信公众平台应用名
     */
    private String name;
    private String subjectId;

    /**
     * 微信公众平台 appid
     */
    private String appid;

    /**
     * 微信公众平台 secret
     */
    private String secret;

    /**
     * 开发者配置的令牌
     */
    private String token;

    /**
     * 加密密钥
     */
    private String aesKey;

    /**
     * 加密方式：
     */
    private String encType;

    /**
     * 应用类型
     * {@link WeChatApplicationType#getName()}
     */
    private String appType;

    /**
     * 处理器链接, 即： redirectUrl
     */
    private String url;

    /**
     * 管理者 OpenId 列表, 以 ‘，’ 分隔
     */
    private String manager;

    /**
     * 描述
     */
    private String description;
}