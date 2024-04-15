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

package io.github.microapplet.wechat.official.authpage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 微信公众号授权网页链接信息
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0.0
 * @since 2024 04 08, &nbsp;&nbsp; <em>version:1.0.0</em>
 */
@Data
@Accessors(chain = true)
@ApiModel("公众号授权网页链接信息")
public final class WeChatOfficialAuthPage implements Serializable {
    private static final long serialVersionUID = -9004055865537875474L;

    /**
     * 授权网页链接编号，对应PO主键， 对应接口的 state 字段
     */
    @ApiModelProperty("业务编号")
    private String id;

    @ApiModelProperty("应用编号")
    private String appid;

    /**
     * 目标链接
     */
    @ApiModelProperty("目标跳转链接")
    private String url;

    @ApiModelProperty("查询参数")
    private Map<String,String> param;

    @ApiModelProperty("过期时间")
    private Integer expiresTime;

    @ApiModelProperty("过期时间单位")
    private TimeUnit expiresUnit;

    @ApiModelProperty("到期时间")
    private LocalDateTime expiresAt;

    /**
     * men
     * 是否显示授权，数据库中存在此字段
     */
    @ApiModelProperty("是否显示授权")
    private Boolean manual;

    @ApiModelProperty("授权网页链接")
    private String authUrl;
}