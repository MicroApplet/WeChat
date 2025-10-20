/*
 *    Copyright 2014-2025 <a href="mailto:asialjim@qq.com">Asial Jim</a>
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.asialjim.microapplet.wechat.common.infrastructure.repository.application.po;

import com.asialjim.microapplet.wechat.application.WeChatApplication;
import com.asialjim.microapplet.wechat.application.WeChatApplicationType;
import lombok.Data;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import org.springframework.beans.BeanUtils;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

/**
 * 微信用户应用信息
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/10/20, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Data
@Table("wechat_app")
public class WeChatApplicationPo implements Serializable {
    @Serial
    private static final long serialVersionUID = 6906701807020184318L;
    /**
     * 微信公众平台应用微信号,除应用类型为企业微信，一般情况下，与 {@link #getSubjectId()} 相同
     */
    @Id
    private String id;

    /**
     * 微信公众平台应用名
     */
    private String name;
    /**
     * 企业微信时：   corid
     */
    private String subjectId;
    /**
     * 企业微信时：   agentId
     */
    private String agentId;

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

    public static WeChatApplication fromPo(WeChatApplicationPo po){
        if (Objects.isNull(po))
            return null;
        WeChatApplication vo = new WeChatApplication();
        BeanUtils.copyProperties(po,vo);
        return vo;
    }

    public static WeChatApplicationPo from(WeChatApplication vo){
        if (Objects.isNull(vo))
            return null;

        WeChatApplicationPo po = new WeChatApplicationPo();
        BeanUtils.copyProperties(vo,po);
        return po;
    }
}