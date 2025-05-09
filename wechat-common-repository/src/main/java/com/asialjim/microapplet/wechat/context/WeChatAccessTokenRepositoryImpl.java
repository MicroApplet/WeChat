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

package com.asialjim.microapplet.wechat.context;

import com.asialjim.microapplet.wechat.application.WeChatApplication;
import com.asialjim.microapplet.wechat.application.WeChatApplicationRepository;
import com.asialjim.microapplet.wechat.exception.WeChatAPIException;
import com.asialjim.microapplet.wechat.remoting.WeChatAccessTokenRemoting;
import com.asialjim.microapplet.wechat.remoting.context.WeChatAccessTokenCache;
import com.asialjim.microapplet.wechat.remoting.context.WeChatAccessTokenRepository;
import com.asialjim.microapplet.wechat.remoting.context.WeChatApiRes;
import com.asialjim.microapplet.wechat.remoting.meta.WeChatAccessTokenRes;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.stream.Stream;

@Slf4j
@Component
public class WeChatAccessTokenRepositoryImpl implements WeChatAccessTokenRepository {
    @Resource
    private WeChatApplicationRepository.Aggregator aggregator;
    @Resource
    private WeChatAccessTokenRemoting remoting;
    @Resource
    private WeChatAccessTokenCache accessTokenCache;
    @Resource
    private List<Executor> executors;

    @Override
    public String accessToken(String weChatIndex) {
        return accessToken(weChatIndex, null);
    }

    @Override
    public String accessToken(String appid, String secret) {
        WeChatApplication weChatApplication = aggregator.appByIndex(appid);
        String targetAppid, targetSecret, accessToken;
        if (Objects.nonNull(weChatApplication)) {
            targetAppid = weChatApplication.getAppid();
            targetSecret = weChatApplication.getSecret();
        } else {
            targetAppid = appid;
            targetSecret = secret;
        }

        if (StringUtils.isAnyBlank(targetAppid, targetSecret))
            throw new IllegalStateException("索引为[" + appid + "]的微信应用应用编号/密码存在空值");
        accessToken = accessTokenCache.get(targetAppid);
        if (StringUtils.isNotBlank(accessToken))
            return accessToken;

        accessToken = accessTokenCache.cached(targetAppid);
        if (StringUtils.isNotBlank(accessToken))
            return accessToken;

        Lock lock = accessTokenCache.getLock(targetAppid);
        lock.lock();
        try {
            accessToken = accessTokenCache.get(appid);
            if (StringUtils.isNotBlank(accessToken))
                return accessToken;

            WeChatAccessTokenRes accessTokenRes = remoting.accessToken(targetAppid, targetSecret);
            if (WeChatApiRes.notSuccess(accessTokenRes))
                throw new WeChatAPIException(accessTokenRes);

            accessToken = accessTokenRes.getAccess_token();
            accessTokenCache.set(appid, accessToken);
        } finally {
            lock.unlock();
        }
        return accessToken;
    }

    @Override
    public void refreshAccessToken(String weChatIndex) {
        refreshAccessToken(weChatIndex, null);
    }

    @Override
    public void refreshAccessToken(String appid, String secret) {
        final String targetAppid, targetSecret;
        WeChatApplication weChatApplication = aggregator.appByIndex(appid);
        if (Objects.nonNull(weChatApplication)) {
            targetAppid = weChatApplication.getAppid();
            targetSecret = weChatApplication.getSecret();
        } else {
            targetAppid = appid;
            targetSecret = secret;
        }

        accessTokenCache.remove(targetAppid);
        Executor executor =  Optional.ofNullable(this.executors).map(Collection::stream).orElseGet(Stream::empty).findAny().orElse(null);

        if (Objects.nonNull(executor)) {
            executor.execute(() -> accessToken(targetAppid, targetSecret));
        } else {
            new Thread(() -> accessToken(targetAppid, targetSecret)).start();
        }
    }
}