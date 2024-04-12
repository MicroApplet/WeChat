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

import io.github.microapplet.wechat.context.Code;

import java.util.Objects;

/**
 * 微信公众平台响应结果
 *
 * @author Copyright © <a href="mailto:asialjim@hotmail.com">Asial Jim</a>   Co., LTD
 * @version 1.0
 * @since 2023/12/16, &nbsp;&nbsp; <em>version:1.0</em>,  &nbsp;&nbsp;  <em>java version:8</em>
 */
public interface WeChatApiRes extends Code {
    static boolean success(WeChatApiRes apiRes) {
        return Objects.nonNull(apiRes) && apiRes.success();
    }

    static boolean notSuccess(WeChatApiRes apiRes) {
        return !success(apiRes);
    }

    @SuppressWarnings("SpellCheckingInspection")
    Integer getErrcode();

    @SuppressWarnings("SpellCheckingInspection")
    void setErrcode(Integer errcode);

    @SuppressWarnings("SpellCheckingInspection")
    String getErrmsg();

    @SuppressWarnings("SpellCheckingInspection")
    void setErrmsg(String errmsg);

    default String getCode() {
        return String.valueOf(getErrcode());
    }

    default String getMsg() {
        return getErrmsg();
    }

    default Boolean success() {
        return Objects.isNull(getErrcode()) || 0 == getErrcode();
    }

    @SuppressWarnings("unused")
    default Boolean notSuccess() {
        return !success();
    }

    default WeChatApiResultEnumeration apiResultEnumeration() {
        return WeChatApiResultEnumeration.codeOf(getErrcode());
    }
}