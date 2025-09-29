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

import com.asialjim.microapplet.wechat.official.infrastructure.repository.authpage.po.MenuOAuthPagePo;
import com.asialjim.microapplet.wechat.official.infrastructure.repository.authpage.service.MenuOAuthPageMapperService;
import com.asialjim.microapplet.wechat.official.infrastructure.repository.oauthpage.MenuOAuthPageRepository;
import com.asialjim.microapplet.wechat.official.module.oauthpage.OAuthPageVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 公众号菜单授权网页仓库
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/9/28, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class MenuOAuthPageRepositoryImpl implements MenuOAuthPageRepository {
    private final MenuOAuthPageMapperService menuOAuthPageMapperService;

    @Override
    public OAuthPageVo pageOf(String appid, String state) {
        MenuOAuthPagePo po = menuOAuthPageMapperService.pageOf(appid, state);
        OAuthPageVo vo = new OAuthPageVo();
        vo.setState(po.getState());
        vo.setAppid(po.getAppid());
        vo.setUrl(po.getUrl());
        vo.setManual(po.getManual());
        vo.setExpiresAt(LocalDateTime.of(2199, 12, 31, 0, 0, 0));
        vo.setMaxClickTimes(Long.MAX_VALUE);
        return vo;
    }

    @Override
    public void delete(List<String> authPageIds) {
        this.menuOAuthPageMapperService.removeByIds(authPageIds);
    }

    @Override
    public void deleteCache(String appid, String state) {
        this.menuOAuthPageMapperService.deleteCache(appid, state);
    }

    @Override
    public OAuthPageVo create(OAuthPageVo authPage) {
        MenuOAuthPagePo po = MenuOAuthPagePo.voOf(authPage);
        boolean b = this.menuOAuthPageMapperService.create(po);
        log.info("创建微信菜单授权网页页面:{} 结果: {}", authPage, b);
        return MenuOAuthPagePo.toVo(po);
    }
}