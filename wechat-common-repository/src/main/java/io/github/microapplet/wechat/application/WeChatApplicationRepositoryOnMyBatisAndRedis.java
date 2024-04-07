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

package io.github.microapplet.wechat.application;

import io.github.microapplet.wechat.application.db.WeChatApplicationMapperService;
import io.github.microapplet.wechat.application.mapper.WeChatApplicationBaseMapper;
import org.apache.commons.collections4.CollectionUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.redisson.codec.JsonJacksonCodec;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.List;
import java.util.Objects;

/**
 * 基于MyBatis 与 Redis 的微信公众平台应用信息仓库
 *
 * @author Copyright © <a href="mailto:asialjim@hotmail.com">Asial Jim</a>   Co., LTD
 * @version 1.0
 * @since 2023/12/18, &nbsp;&nbsp; <em>version:1.0</em>,  &nbsp;&nbsp;  <em>java version:8</em>
 */
@Configuration
@MapperScan(basePackageClasses = WeChatApplicationBaseMapper.class)
public class WeChatApplicationRepositoryOnMyBatisAndRedis {
    @Resource
    private RedissonClient redissonClient;
    @Resource
    private WeChatApplicationMapperService weChatApplicationMapperService;

    @Bean
    public WeChatApplicationRepository weChatApplicationRepositoryOnMyBatisAndRedis() {
        return () -> {
            String key = WeChatApplicationRepository.PREFIX;
            RBucket<List<WeChatApplication>> bucket = redissonClient.getBucket(key, JsonJacksonCodec.INSTANCE);
            List<WeChatApplication> weChatApplications = bucket.get();
            if (Objects.nonNull(weChatApplications))
                return weChatApplications;
            weChatApplications = weChatApplicationMapperService.list();
            if (CollectionUtils.isNotEmpty(weChatApplications))
                bucket.set(weChatApplications, Duration.ofDays(30));
            return weChatApplications;
        };
    }
}