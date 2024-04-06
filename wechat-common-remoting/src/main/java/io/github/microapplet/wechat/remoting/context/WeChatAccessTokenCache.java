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

import java.util.concurrent.locks.Lock;

/**
 * 微信API访问令牌缓存
 *
 * @author Copyright © <a href="mailto:asialjim@hotmail.com">Asial Jim</a>   Co., LTD
 * @version 1.0
 * @since 2023/2/2, &nbsp;&nbsp; <em>version:1.0</em>, &nbsp;&nbsp; <em>java version:17</em>
 */
public interface WeChatAccessTokenCache {
    /**
     * 添加缓存：
     * <br/> 注意要求： 最大缓存时间不能超过两个小时
     * <br/> 同时，当设置缓存后，保证 {@link #cached(String) 判断是否响应结果} 在5秒内，必须有最新的缓存值
     *
     * @param appid       {@link String appid}
     * @param accessToken {@link String accessToken}
     * @since 2023/2/2
     */
    void set(String appid, String accessToken);

    /**
     * 查询 WeChat Access Token 缓存
     *
     * @param appid {@link String appid}
     * @since 2023/2/2
     */
    String get(String appid);

    /**
     * 删除 WeChat Access Token 缓存
     *
     * @param appid {@link String appid}
     * @since 2023/2/2
     */
    void remove(String appid);

    /**
     * 判断 appid 对应的微信公众平台应用是否已经缓存了 API 访问令牌
     *
     * @param appid {@link String appid}
     * @return {@link String 已添加缓存的 AccessToken}
     * @since 2023/2/2
     */
    String cached(String appid);

    /**
     * 获取从网络更新 access_token 的权限锁
     *
     * @param appid {@link String appid}
     * @return {@link Lock 获取从腾讯服务器更新 AccessToken 的权限锁}
     * @since 2023/2/2
     */
    Lock getLock(String appid);
}