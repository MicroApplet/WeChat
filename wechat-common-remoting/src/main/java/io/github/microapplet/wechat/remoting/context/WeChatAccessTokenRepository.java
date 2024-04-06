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

import javax.annotation.PostConstruct;

/**
 * 微信API访问令牌仓库
 * @author Copyright © <a href="mailto:asialjim@hotmail.com">Asial Jim</a>   Co., LTD
 * @version 1.0
 * @since 2023/1/28, &nbsp;&nbsp; <em>version:1.0</em>, &nbsp;&nbsp; <em>java version:17</em>
 */
public interface WeChatAccessTokenRepository {

    @PostConstruct
    default void init() {
        WeChatAccessTokenRepositoryHolder.repository(this);
    }

    /**
     * 获取微信 API 访问令牌
     *
     * @param weChatIndex {@link String 微信公众号应用编号}
     * @return {@link String API 访问令牌}
     * @since 2023/1/28
     */
    String accessToken(String weChatIndex);

    /**
     * 获取微信 API 访问令牌
     *
     * @param appid  {@link String appid}
     * @param secret {@link String secret}
     * @return {@link String API 访问令牌}
     * @since 2023/1/28
     */
    String accessToken(String appid, String secret);

    /**
     * 刷新微信 API 访问令牌缓存
     * @param weChatIndex {@link String 微信公众号应用编号}
     * @since 2023/1/28
     */
    void refreshAccessToken(String weChatIndex);

    /**
     * 刷新微信 API 访问令牌缓存
     *
	 * @param appid {@link String appid}
	 * @param secret {@link String secret}
     * @since 2023/1/28
     */
    void refreshAccessToken(String appid, String secret);
}