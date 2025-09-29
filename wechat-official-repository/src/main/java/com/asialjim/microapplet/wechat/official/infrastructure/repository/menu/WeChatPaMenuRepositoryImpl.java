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

package com.asialjim.microapplet.wechat.official.infrastructure.repository.menu;

import com.asialjim.microapplet.wechat.application.WeChatApplication;
import com.asialjim.microapplet.wechat.application.WeChatApplicationRepository;
import com.asialjim.microapplet.wechat.official.infrastructure.repository.menu.po.WeChatOfficialMenu;
import com.asialjim.microapplet.wechat.official.infrastructure.repository.menu.po.WeChatOfficialMenuRule;
import com.asialjim.microapplet.wechat.official.infrastructure.repository.menu.service.WeChatOfficialMenuMapperService;
import com.asialjim.microapplet.wechat.official.infrastructure.repository.menu.service.WeChatOfficialMenuRuleMapperService;
import com.asialjim.microapplet.wechat.official.module.menu.WeChatPaMenu;
import com.asialjim.microapplet.wechat.official.remoting.menu.meta.create.WeChatMenuMatchRule;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

/**
 * 公众号菜单仓库
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/9/29, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class WeChatPaMenuRepositoryImpl implements WeChatPaMenuRepository {
    private final WeChatOfficialMenuRuleMapperService weChatOfficialMenuRuleMapperService;
    private final WeChatOfficialMenuMapperService weChatOfficialMenuMapperService;
    private final WeChatApplicationRepository.Aggregator aggregator;

    @Override
    public List<WeChatPaMenu> findWeChatPaMenus(String weChatId, String matchRule) {
        if (StringUtils.isBlank(matchRule)) matchRule = DEFAULT_MATCH_RULE;
        WeChatApplication app = this.aggregator.appByIndexThrowable(weChatId);

        List<WeChatOfficialMenu> list = this.weChatOfficialMenuMapperService.queryChain()
                .where(WeChatOfficialMenu::getAppid).eq(app.getAppid())
                .where(WeChatOfficialMenu::getRuleId).eq(matchRule)
                .list();

        return list.stream()
                .map(WeChatOfficialMenu::menu)
                .filter(Objects::nonNull)
                .sorted()
                .toList();
    }

    @Override
    public WeChatMenuMatchRule findWeChatPaMatchRule(String weChatId, String matchRule) {
        if (StringUtils.isBlank(matchRule)) matchRule = DEFAULT_MATCH_RULE;
        WeChatApplication app = this.aggregator.appByIndexThrowable(weChatId);
        WeChatOfficialMenuRule one = this.weChatOfficialMenuRuleMapperService.queryChain()
                .where(WeChatOfficialMenuRule::getAppid).eq(app.getAppid())
                .where(WeChatOfficialMenuRule::getRuleId).eq(matchRule)
                .one();
        return WeChatOfficialMenuRule.voOf(one);
    }

    @Override
    public void replaceWeChatPaMenus(String weChatId, String matchRule, List<WeChatPaMenu> paMenus) {
        if (StringUtils.isBlank(matchRule)) matchRule = DEFAULT_MATCH_RULE;
        WeChatApplication app = this.aggregator.appByIndexThrowable(weChatId);
        boolean remove = this.weChatOfficialMenuMapperService.updateChain()
                .where(WeChatOfficialMenu::getAppid).eq(app.getAppid())
                .where(WeChatOfficialMenu::getRuleId).eq(matchRule)
                .remove();
        log.info("删除公众号：{}，匹配规则：{} 删除结果： {}", weChatId, matchRule, remove);
        String finalMatchRule1 = matchRule;
        paMenus.stream()
                .map(item -> WeChatOfficialMenu.po(app.getAppid(), finalMatchRule1, item))
                .forEach(this.weChatOfficialMenuMapperService::save);
    }

    @Override
    public void addWeChatPaMatchRule(String weChatId, String name, WeChatMenuMatchRule matchRule) {
        WeChatApplication app = this.aggregator.appByIndexThrowable(weChatId);
        WeChatOfficialMenuRule po = WeChatOfficialMenuRule.poOf(app.getAppid(), name, matchRule);
        this.weChatOfficialMenuRuleMapperService.save(po);
    }

    @Override
    public List<WeChatMenuMatchRule> findWeChatPaMatchRules(String weChatId) {
        WeChatApplication app = this.aggregator.appByIndexThrowable(weChatId);
        return this.weChatOfficialMenuRuleMapperService.queryChain()
                .where(WeChatOfficialMenuRule::getAppid).eq(app.getAppid())
                .list().stream()
                .map(WeChatOfficialMenuRule::voOf)
                .toList();
    }
}
