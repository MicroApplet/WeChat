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

package com.asialjim.microapplet.wechat.common.infrastructure.repository.application.service.impl;

import com.asialjim.microapplet.wechat.application.WeChatApplication;
import com.asialjim.microapplet.wechat.common.infrastructure.repository.application.WxAppCache;
import com.asialjim.microapplet.wechat.common.infrastructure.repository.application.mapper.WeChatAppBaseMapper;
import com.asialjim.microapplet.wechat.common.infrastructure.repository.application.po.WeChatApplicationPo;
import com.asialjim.microapplet.wechat.common.infrastructure.repository.application.service.WeChatApplicationMapperService;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 微信应用持久化服务
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/10/20, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Repository
public class WeChatApplicationMapperServiceImpl extends ServiceImpl<WeChatAppBaseMapper, WeChatApplicationPo> implements WeChatApplicationMapperService {

    @Override
    @Cacheable(WxAppCache.Name.wxAppAll)
    public List<WeChatApplication> all() {
        List<WeChatApplication> target = new ArrayList<>();
        List<WeChatApplicationPo> list = list();
        if (CollectionUtils.isNotEmpty(list)){
            for (WeChatApplicationPo po : list) {
                WeChatApplication vo = WeChatApplicationPo.fromPo(po);
                if (Objects.isNull(vo))
                    continue;
                target.add(vo);
            }
        }
        return target;
    }
}
