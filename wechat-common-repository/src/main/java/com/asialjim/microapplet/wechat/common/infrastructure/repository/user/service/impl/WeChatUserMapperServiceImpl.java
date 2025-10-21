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

package com.asialjim.microapplet.wechat.common.infrastructure.repository.user.service.impl;

import com.asialjim.microapplet.wechat.common.infrastructure.repository.user.WeChatUserCache;
import com.asialjim.microapplet.wechat.common.infrastructure.repository.user.mapper.WeChatUserBaseMapper;
import com.asialjim.microapplet.wechat.common.infrastructure.repository.user.po.WeChatUserPo;
import com.asialjim.microapplet.wechat.common.infrastructure.repository.user.service.WeChatUserMapperService;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Repository;

/**
 * 微信用户持久化服务
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/10/20, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Repository
public class WeChatUserMapperServiceImpl extends ServiceImpl<WeChatUserBaseMapper, WeChatUserPo> implements WeChatUserMapperService {

    @Override
    @Cacheable(value = WeChatUserCache.Name.wechatUser, key = "#appid + ':' + #openid")
    public WeChatUserPo queryByOpenidOfAppid(String openid, String appid) {
        return queryChain()
                .where(WeChatUserPo::getAppid).eq(appid)
                .where(WeChatUserPo::getOpenid).eq(openid)
                .one();
    }

    @Override
    @Cacheable(value = WeChatUserCache.Name.wechatUser, key = "#openid")
    public WeChatUserPo queryByOpenid(String openid) {
        return queryChain()
                .where(WeChatUserPo::getOpenid).eq(openid)
                .one();
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value = WeChatUserCache.Name.wechatUser, key = "#po.appid + ':' + #po.openid"),
            @CacheEvict(value = WeChatUserCache.Name.wechatUser, key = "#po.openid")
    })
    public void clearCache(WeChatUserPo po) {
    }
}