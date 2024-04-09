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

package io.github.microapplet.wechat.official.service.message;

import io.github.microapplet.wechat.official.message.WeChatOfficialInputXmlMessage;
import org.apache.commons.lang3.StringUtils;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.Duration;

/**
 * 微信公众号消息重复检查服务
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0.0
 * @since 2024 04 09, &nbsp;&nbsp; <em>version:1.0.0</em>
 */
@Component
public class WeChatOfficialInputMessageRepeatService {
    private static final String PREFIX= "wx:off:msg:input:%s:%s";
    @Resource private RedissonClient redissonClient;

    public boolean repeat(WeChatOfficialInputXmlMessage xmlMessage){
        String openid = xmlMessage.getFromUserName();
        Long createTime = xmlMessage.getCreateTime();
        String key = String.format(PREFIX, openid, createTime);
        RBucket<String> bucket = redissonClient.getBucket(key, StringCodec.INSTANCE);
        String handle = bucket.get();
        if (StringUtils.isNotBlank(handle))
            return true;
        bucket.set(handle, Duration.ofSeconds(30));
        return false;
    }
}