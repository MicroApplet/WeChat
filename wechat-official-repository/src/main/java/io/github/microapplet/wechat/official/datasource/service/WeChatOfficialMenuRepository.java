/*
 *  Copyright 2022/5/25 <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
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
 *  limitations under the License.
 */
package io.github.microapplet.wechat.official.datasource.service;

import io.github.microapplet.wechat.official.remoting.menu.meta.create.*;
import io.github.microapplet.wechat.official.datasource.po.menu.WeChatOfficialMenuMatchRulePO;
import io.github.microapplet.wechat.official.datasource.po.menu.WeChatOfficialMenuPO;
import io.github.microapplet.wechat.official.menu.WeChatOfficialMenu;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 微信公众号菜单仓库
 *
 * @author Copyright © <a href="mailto:asialjim@hotmail.com">Asial Jim</a>   Co., LTD
 * @version 1.0
 * @since 2023/2/8, &nbsp;&nbsp; <em>version:1.0</em>, &nbsp;&nbsp; <em>java version:17</em>
 */
@Slf4j
@Component
public class WeChatOfficialMenuRepository implements Serializable {
    public static final String DEFAULT_MATCH_RULE = "DEFAULT";

    /**
     * 查询微信公众号菜单列表
     *
     * @param weChatId    {@link String 公众号应用索引}
     * @param matchRuleId {@link String 个性化菜单编号}
     * @return {@link List<WeChatOfficialMenu> 菜单列表}
     * @since 2023/2/8
     */
    public List<WeChatOfficialMenu> findWeChatOfficialMenus(String weChatId, String matchRuleId) {
        if (StringUtils.isBlank(matchRuleId)) matchRuleId = DEFAULT_MATCH_RULE;
        WeChatOfficialMenuPO menuOption = WeChatOfficialMenuPO.create().setAppid(weChatId).setRuleId(matchRuleId);
        List<WeChatOfficialMenuPO> weChatMenuPOS = menuOption.list();
        return Optional.ofNullable(weChatMenuPOS).orElse(Collections.emptyList()).stream().map(WeChatOfficialMenuPO::weChatPaMenu).collect(Collectors.toList());
    }

    public List<WeChatOfficialMenuMatchRulePO> findWeChatPaMatchRules(String weChatId) {
        WeChatOfficialMenuMatchRulePO matchRuleOption = WeChatOfficialMenuMatchRulePO.create().setAppid(weChatId);
        return matchRuleOption.list();
    }

    public WeChatOfficialMenuMatchRule findWeChatPaMatchRule(String weChatId, String matchRuleId) {
        WeChatOfficialMenuMatchRulePO matchRuleOption = WeChatOfficialMenuMatchRulePO.create().setAppid(weChatId).setId(matchRuleId);
        WeChatOfficialMenuMatchRulePO weChatOfficialMenuMatchRulePO = matchRuleOption.one();
        if (Objects.isNull(weChatOfficialMenuMatchRulePO))
            return null;
        return weChatOfficialMenuMatchRulePO.weChatMenuMatchRule();
    }

    public void replaceWeChatPaMenus(String weChatId, String matchRule, List<WeChatOfficialMenu> menus) {
        if (CollectionUtils.isEmpty(menus))
            return;

        if (StringUtils.isBlank(matchRule)) matchRule = DEFAULT_MATCH_RULE;
        WeChatOfficialMenuPO menuOption = WeChatOfficialMenuPO.create().setAppid(weChatId).setRuleId(matchRule);
        boolean remove = menuOption.remove();
        log.info("删除公众号：{}，匹配规则：{} 删除结果： {}", weChatId, matchRule, remove);
        final String finalMatchRule = matchRule;
        List<WeChatOfficialMenuPO> pos = menus.stream().map(item -> WeChatOfficialMenuPO.weChatPaMenuPO(weChatId, finalMatchRule, item)).collect(Collectors.toList());
        int batchInsert = WeChatOfficialMenuPO.create().baseMapper().insertBatch(pos);
        log.info("新增公众号：{}, 匹配规则：{}, 替换结果：{}", weChatId, matchRule, batchInsert);
    }

    public void addWeChatPaMatchRule(String weChatId, String name, WeChatOfficialMenuMatchRule matchRule) {
        WeChatOfficialMenuMatchRulePO matchRulePO = WeChatOfficialMenuMatchRulePO.weChatPaMenuMatchRulePO(weChatId, name, matchRule);
        boolean save = matchRulePO.save();
        log.info("添加公众号:{} 菜单自定义规则：{} 结果：{}", weChatId, matchRule, save);
    }
}