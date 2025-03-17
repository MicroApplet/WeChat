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
package com.asialjim.microapplet.wechat.official.module.authpage.service.impl;

import com.asialjim.microapplet.remote.net.jackson.AbstractJacksonUtil;
import com.asialjim.microapplet.wechat.official.module.authpage.mapper.WeChatOfficialAuthPageBaseMapper;
import com.asialjim.microapplet.wechat.official.module.authpage.po.WeChatOfficialAuthPage;
import com.asialjim.microapplet.wechat.official.module.authpage.service.WeChatOfficialAuthPageMapperService;
import com.mybatisflex.core.query.QueryChain;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.Serializable;
import java.time.Duration;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 授权网页链接数据服务
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0.0
 * @since 2024 07 25, &nbsp;&nbsp; <em>version:1.0.0</em>
 */
@Component
public class WeChatOfficialAuthPageMapperServiceImpl extends ServiceImpl<WeChatOfficialAuthPageBaseMapper, WeChatOfficialAuthPage> implements WeChatOfficialAuthPageMapperService {
    private static final String CACHE_KEY = "wx:official:auth:page:";

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public WeChatOfficialAuthPage getById(Serializable id) {
        String key = CACHE_KEY + id;
        String json = stringRedisTemplate.opsForValue().get(key);
        if (StringUtils.isNotBlank(json)) {
            WeChatOfficialAuthPage page = AbstractJacksonUtil.json2Object(json, WeChatOfficialAuthPage.class);
            if (Objects.nonNull(page))
                return page;
        }

        WeChatOfficialAuthPage page = super.getById(id);
        json = AbstractJacksonUtil.writeValueAsJsonString(page);
        stringRedisTemplate.opsForValue().set(key, json, Duration.ofMinutes(30));
        return page;
    }

    @Override
    public boolean removeById(Serializable id) {
        String key = CACHE_KEY + id;
        stringRedisTemplate.delete(key);
        return super.removeById(id);
    }

    @Override
    public boolean removeById(WeChatOfficialAuthPage entity) {
        if (Objects.nonNull(entity))
            return this.removeById(entity.getId());
        return false;
    }

    @Override
    public boolean removeByIds(Collection<? extends Serializable> ids) {
        List<String> keys = ids.stream().map(item -> CACHE_KEY + item).collect(Collectors.toList());
        ;
        stringRedisTemplate.delete(keys);
        return super.removeByIds(ids);
    }

    @Override
    public void deleteExpiredAuthPage() {
        QueryChain<WeChatOfficialAuthPage> wrapper = queryChain().where(WeChatOfficialAuthPage::getExpireAt).lt(System.currentTimeMillis());
        remove(wrapper);
    }
}