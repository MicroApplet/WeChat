/*
 * Copyright 2014-2025 <a href="mailto:asialjim@qq.com">Asial Jim</a>
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

package com.asialjim.microapplet.wechat.remoting.context;

import java.util.Objects;

@SuppressWarnings("unused")
public interface WeChatApiRes {
    Integer getErrcode();

    void setErrcode(Integer errcode);

    String getErrmsg();

    void setErrmsg(String errmsg);

    default Boolean success() {
        return Objects.isNull(getErrcode()) || 0 == getErrcode();
    }

    default Boolean notSuccess() {
        return !success();
    }

    default WeChatApiResultEnumeration apiResultEnumeration(){
        return WeChatApiResultEnumeration.codeOf(getErrcode());
    }

    static boolean success(WeChatApiRes apiRes) {
        return Objects.nonNull(apiRes) && apiRes.success();
    }

    static boolean notSuccess(WeChatApiRes apiRes) {
        return !success(apiRes);
    }
}