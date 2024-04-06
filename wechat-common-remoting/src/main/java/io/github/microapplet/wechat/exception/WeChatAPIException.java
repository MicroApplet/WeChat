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

package io.github.microapplet.wechat.exception;

import io.github.microapplet.wechat.remoting.context.WeChatApiRes;
import io.github.microapplet.wechat.remoting.context.WeChatApiResultEnumeration;
import lombok.AllArgsConstructor;

/**
 * 微信API异常
 *
 * @author Copyright © <a href="mailto:asialjim@hotmail.com">Asial Jim</a>   Co., LTD
 * @version 1.0
 * @since 2023/12/16, &nbsp;&nbsp; <em>version:1.0</em>,  &nbsp;&nbsp;  <em>java version:8</em>
 */
@AllArgsConstructor
public final class WeChatAPIException extends RuntimeException {
    private final String code;
    private final String msg;


    public WeChatAPIException(WeChatApiRes apiRes) {
        this(apiRes.apiResultEnumeration());
    }

    public WeChatAPIException(WeChatApiResultEnumeration resultEnumeration) {
        this(String.valueOf(resultEnumeration.getErrcode()), resultEnumeration.getErrmsg());
    }

    public String code(){
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.msg;
    }
}