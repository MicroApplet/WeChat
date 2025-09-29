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

package com.asialjim.microapplet.wechat.official.service.oauth;

import com.asialjim.microapplet.wechat.official.module.oauthpage.OAuthHandlerVo;
import jakarta.validation.constraints.NotBlank;

import java.net.URI;
import java.util.List;

/**
 * 公众号授权链接处理器
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/9/5, &nbsp;&nbsp; <em>version:1.0</em>
 */
public interface WeChatMpOAuthHandler {

    @NotBlank
    String handler();

    @NotBlank
    String description();

    default OAuthHandlerVo handlerVo(){
        return new OAuthHandlerVo().setHandlerName(handler()).setHandlerDesc(description());
    }

    /**
     * 获取链接
     *
     * @param appid {@link String appid}
     * @param state {@link String state}
     * @return {@link URI }
     * @since 2025/9/5
     */
    URI page(String appid, String state);


}