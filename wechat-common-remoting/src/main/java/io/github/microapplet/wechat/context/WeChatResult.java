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

package io.github.microapplet.wechat.context;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.commons.collections4.CollectionUtils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 微信响应结果
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0.0
 * @since 2024 04 09, &nbsp;&nbsp; <em>version:1.0.0</em>
 */
@ApiModel("微信响应")
@Accessors(chain = true)
@Data(staticConstructor = "create")
public class WeChatResult<T> implements APIResult<T>, Serializable {
    private static final long serialVersionUID = 4700371977208642274L;
    public static final String SUCCESS_CODE = "0";
    public static final String SUCCESS_MSG = "SUCCESS";

    @ApiModelProperty("响应代码")
    private String code;

    @ApiModelProperty("错误消息")
    private String msg;

    @ApiModelProperty("响应载体")
    private T data;

    @ApiModelProperty("附加信息")
    private Map<String,Object> extra;

    @ApiModelProperty("分页参数:当前页")
    private Integer page;

    @ApiModelProperty("分页参数:页宽度")
    private Integer size;

    @ApiModelProperty("分页参数:总页数")
    private Integer pages;

    @ApiModelProperty("分页参数:总记录条数")
    private Integer total;

    public WeChatResult<T> extraOf(String key, Object value){
        if (Objects.isNull(this.extra))
            this.extra = new HashMap<>();
        this.extra.put(key,value);
        return this;
    }

    public static<T> WeChatResult<T> codeOf(Code apiCode){
        return WeChatResult.<T>create()
                .setCode(apiCode.getCode())
                .setMsg(apiCode.getMsg());
    }

    public static<T> WeChatResult<T> success(){
        return WeChatResult.success(SUCCESS_MSG);
    }

    public static<T> WeChatResult<T> success(String msg){
        return WeChatResult.success(msg,null);
    }

    public static<T> WeChatResult<T> success(String msg, T data){
        return WeChatResult.<T>create().setCode(SUCCESS_CODE).setMsg(msg).setData(data);
    }

    public static<T> WeChatResult<List<T>> successList(List<T> list){
        return successList(1, 1, CollectionUtils.size(list), list);
    }

    public static<T> WeChatResult<List<T>> successList(Integer page, Integer pages, Integer total, List<T> list){
        return WeChatResult.<List<T>>create()
                .setCode(SUCCESS_CODE).setMsg(SUCCESS_MSG)
                .setPage(page).setSize(CollectionUtils.size(list))
                .setPages(pages).setTotal(total).setData(list);
    }
}