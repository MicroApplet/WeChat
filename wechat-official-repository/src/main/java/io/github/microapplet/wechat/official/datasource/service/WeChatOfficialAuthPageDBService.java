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

package io.github.microapplet.wechat.official.datasource.service;

import com.mybatisflex.core.util.LambdaGetter;
import io.github.microapplet.wechat.official.authpage.WeChatOfficialAuthPage;
import io.github.microapplet.wechat.official.datasource.po.authpage.WeChatOfficialAuthPagePO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.redisson.codec.JsonJacksonCodec;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * 微信公众号数据仓库服务
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0.0
 * @since 2024 04 09, &nbsp;&nbsp; <em>version:1.0.0</em>
 */
@Slf4j
@Component
public class WeChatOfficialAuthPageDBService {
    private static final String CACHE_PREFIX = "wx:off:auth-page:%s";

    @Resource
    private RedissonClient redissonClient;

    public WeChatOfficialAuthPage add(WeChatOfficialAuthPage page) {
        WeChatOfficialAuthPagePO po = WeChatOfficialAuthPagePO.pageOf(page);
        if (Objects.isNull(po))
            return null;

        boolean save = po.save();
        log.info("新增公众号授权网页链接：{} 结果：{}", po, save);
        return page;
    }

    public WeChatOfficialAuthPage stateOf(String state) {
        WeChatOfficialAuthPage page = doStateOf(state);
        if (Objects.isNull(page))
            return null;

        LocalDateTime expiresAt = page.getExpiresAt();
        LocalDateTime now = LocalDateTime.now();

        // 当前时间在过期时间之后，表示授权链接已过期
        if (now.isAfter(expiresAt)) {
            delete(state);
            return null;
        }

        return page;
    }

    public void delete(String state) {
        if (StringUtils.isBlank(state))
            return;

        boolean remove = WeChatOfficialAuthPagePO.create()
                .where((LambdaGetter<WeChatOfficialAuthPagePO>) WeChatOfficialAuthPagePO::getId).eq(state)
                .where((LambdaGetter<WeChatOfficialAuthPagePO>) WeChatOfficialAuthPagePO::getExpiresAt).gt(LocalDateTime.now())
                .remove();
        if (!remove)
            return;

        redissonClient.getKeys().deleteAsync(String.format(CACHE_PREFIX, state));
    }

    private WeChatOfficialAuthPage doStateOf(String state) {
        if (StringUtils.isBlank(state))
            return null;

        String key = String.format(CACHE_PREFIX, state);
        RBucket<WeChatOfficialAuthPage> bucket = redissonClient.getBucket(key, JsonJacksonCodec.INSTANCE);
        WeChatOfficialAuthPage page = bucket.get();
        if (Objects.nonNull(page))
            return page;

        WeChatOfficialAuthPagePO condition = WeChatOfficialAuthPagePO.create().setId(state);
        WeChatOfficialAuthPagePO target = condition.select();
        if (Objects.isNull(target))
            return null;

        page = target.authPage();
        bucket.set(page, Duration.ofHours(2));
        return page;
    }

    public void deleteBatch(List<String> authPageIds) {
        if (CollectionUtils.isEmpty(authPageIds))
            return;

        int deleteBatch = WeChatOfficialAuthPagePO.create().baseMapper().deleteBatchByIds(authPageIds);
        if (deleteBatch <= 0)
            return;

        redissonClient.getKeys().deleteAsync(authPageIds.stream()
                .map(item -> String.format(CACHE_PREFIX, item))
                .distinct().toArray(String[]::new));
    }
}