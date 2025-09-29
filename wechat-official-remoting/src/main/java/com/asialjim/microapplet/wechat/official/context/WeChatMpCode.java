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

package com.asialjim.microapplet.wechat.official.context;

import com.asialjim.microapplet.common.context.ResCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum WeChatMpCode implements ResCode {

    OAuthPageStateUnknown(400,false,"WECHAT-MP:OAUTH-PAGE:UNKNOWN","业务不存在"),
    OAuthPageStateIllegal(400,false,"WECHAT-MP:OAUTH-PAGE:STATE-ILLEGAL","非法的业务编号"),
    CryptError(400,true,"WECHAT-MP:MSG-CRYPT:EXCEPTION","公众号消息加解密服务异常");

    private final int status;
    private final boolean thr;
    private final String code;
    private final String msg;

}