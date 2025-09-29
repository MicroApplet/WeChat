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

package com.asialjim.microapplet.wechat.official.infrastructure.repository.authpage;

import com.asialjim.microapplet.wechat.official.infrastructure.repository.authpage.po.OAuthPagePo;
import com.asialjim.microapplet.wechat.official.infrastructure.repository.authpage.service.OAuthPageMapperService;
import com.asialjim.microapplet.wechat.official.infrastructure.repository.oauthpage.OAuthPageRepository;
import com.asialjim.microapplet.wechat.official.module.oauthpage.OAuthPageVo;
import com.asialjim.microapplet.wechat.official.module.oauthpage.WxStateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 授权网页链接仓库
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/9/28, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class OAuthPageRepositoryImpl implements OAuthPageRepository {
    private final OAuthPageMapperService oAuthPageMapperService;

    @Override
    public OAuthPageVo pageOf(String appid, String state) {
        OAuthPagePo oAuthPagePo = this.oAuthPageMapperService.pageOf(appid, state);
        return OAuthPagePo.toVo(oAuthPagePo);
    }

    @Override
    public OAuthPageVo create(OAuthPageVo vo) {
        OAuthPagePo po = OAuthPagePo.voOf(vo.setState(WxStateUtil.create()));
        boolean b = this.oAuthPageMapperService.create(po);
        log.info("创建授权网页信息:{} 结果:{}",po,b);
        return OAuthPagePo.toVo(po);
    }

    @Override
    public void delete(List<String> authPageIds) {
        this.oAuthPageMapperService.removeByIds(authPageIds);
    }
}