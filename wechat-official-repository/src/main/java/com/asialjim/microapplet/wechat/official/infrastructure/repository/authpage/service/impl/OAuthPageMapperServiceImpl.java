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

package com.asialjim.microapplet.wechat.official.infrastructure.repository.authpage.service.impl;



import com.asialjim.microapplet.wechat.official.infrastructure.repository.cache.WxMpCache;
import com.asialjim.microapplet.wechat.official.module.oauthpage.WxStateUtil;
import com.asialjim.microapplet.wechat.official.infrastructure.repository.authpage.mapper.OAuthPageBaseMapper;
import com.asialjim.microapplet.wechat.official.infrastructure.repository.authpage.po.OAuthPagePo;
import com.asialjim.microapplet.wechat.official.infrastructure.repository.authpage.service.OAuthPageMapperService;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.Objects;

/**
 * 授权信息仓库
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/9/11, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Repository
public class OAuthPageMapperServiceImpl
        extends ServiceImpl<OAuthPageBaseMapper, OAuthPagePo>
        implements OAuthPageMapperService {

    @Override
    @Cacheable(value = WxMpCache.Name.oauthPageById, key = "#appid+':'+#state")
    public OAuthPagePo pageOf(String appid, String state) {
        return queryChain()
                .where(OAuthPagePo::getAppid).eq(appid)
                .where(OAuthPagePo::getState).eq(state)
                .one();
    }

    @Override
    public boolean create(OAuthPagePo vo) {
        if (Objects.isNull(vo))
            return false;
        String state = WxStateUtil.create();
        vo.setState(state);
        return this.save(vo);
    }
}