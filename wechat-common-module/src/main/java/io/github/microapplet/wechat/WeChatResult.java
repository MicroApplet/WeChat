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

package io.github.microapplet.wechat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 微信响应结果
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0.0
 * @since 2024 04 09, &nbsp;&nbsp; <em>version:1.0.0</em>
 */
@Data
@ApiModel("微信响应")
@Accessors(chain = true)
public class WeChatResult<T> implements Serializable {
    private static final long serialVersionUID = 4700371977208642274L;

    @ApiModelProperty("响应代码")
    private String code;
    @ApiModelProperty("错误消息")
    private String msg;
    @ApiModelProperty("响应载体")
    private T data;
    @ApiModelProperty("分页参数:总记录条数")
    private Integer total;
    @ApiModelProperty("分页参数:当前页")
    private Integer page;
    @ApiModelProperty("分页参数:总页数")
    private Integer pages;
    @ApiModelProperty("分页参数:页宽度")
    private Integer size;
}