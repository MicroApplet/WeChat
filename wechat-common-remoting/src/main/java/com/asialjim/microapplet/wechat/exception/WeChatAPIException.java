/*
 *  Copyright 2014-2025 <a href="mailto:asialjim@qq.com">Asial Jim</a>
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.asialjim.microapplet.wechat.exception;

import com.asialjim.microapplet.wechat.remoting.context.WeChatApiRes;
import com.asialjim.microapplet.wechat.remoting.context.WeChatApiResultEnumeration;

@SuppressWarnings("unused")
public final class WeChatAPIException extends RuntimeException {
    @SuppressWarnings("FieldCanBeLocal")
    private final String code;
    private final String msg;

    public WeChatAPIException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public WeChatAPIException(WeChatApiRes apiRes) {
        this(apiRes.apiResultEnumeration());
    }

    public WeChatAPIException(WeChatApiResultEnumeration resultEnumeration) {
        this(String.valueOf(resultEnumeration.getErrcode()), resultEnumeration.getErrmsg());
    }

    @Override
    public String getMessage() {
        return this.msg;
    }
}