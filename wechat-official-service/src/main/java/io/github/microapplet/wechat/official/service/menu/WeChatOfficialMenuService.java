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
package io.github.microapplet.wechat.official.service.menu;

import io.github.microapplet.wechat.application.WeChatApplication;
import io.github.microapplet.wechat.application.WeChatApplicationRepository;
import io.github.microapplet.wechat.official.authpage.WeChatOfficialAuthPage;
import io.github.microapplet.wechat.official.datasource.po.menu.WeChatOfficialMenuMatchRulePO;
import io.github.microapplet.wechat.official.datasource.service.WeChatOfficialMenuRepository;
import io.github.microapplet.wechat.official.menu.WeChatOfficialMenu;
import io.github.microapplet.wechat.official.remoting.menu.WeChatPublicAccountMenuRemoting;
import io.github.microapplet.wechat.official.remoting.menu.meta.create.WeChatMenuButtonType;
import io.github.microapplet.wechat.official.remoting.menu.meta.create.WeChatOfficialMenuMatchRule;
import io.github.microapplet.wechat.official.remoting.menu.meta.create.WeChatPublicAccountCreateMenuReq;
import io.github.microapplet.wechat.official.remoting.menu.meta.create.WeChatPublicAccountMenuButton;
import io.github.microapplet.wechat.official.service.authpage.WeChatOfficialAuthPageService;
import io.github.microapplet.wechat.remoting.context.WeChatApiRes;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 微信公众号菜单服务
 *
 * @author Copyright © <a href="mailto:asialjim@hotmail.com">Asial Jim</a>   Co., LTD
 * @version 1.0
 * @since 2023/2/8, &nbsp;&nbsp; <em>version:1.0</em>, &nbsp;&nbsp; <em>java version:17</em>
 */
@Slf4j
@Component
public class WeChatOfficialMenuService {
    private static final List<String> OLD_KEYS = Stream.of(
            "%s_menu_1_0_%s", "%s_menu_1_1_%s", "%s_menu_1_2_%s", "%s_menu_1_3_%s", "%s_menu_1_4_%s", "%s_menu_1_5_%s",
            "%s_menu_2_0_%s", "%s_menu_2_1_%s", "%s_menu_2_2_%s", "%s_menu_2_3_%s", "%s_menu_2_4_%s", "%s_menu_2_5_%s",
            "%s_menu_3_0_%s", "%s_menu_3_1_%s", "%s_menu_3_2_%s", "%s_menu_3_3_%s", "%s_menu_3_4_%s", "%s_menu_3_5_%s"
    ).collect(Collectors.toList());

    @Resource
    private WeChatOfficialMenuRepository menuRepository;
    @Resource
    private WeChatOfficialAuthPageService authPageService;
    @Resource
    private WeChatPublicAccountMenuRemoting weChatPublicAccountMenuRemoting;
    @Resource
    private WeChatApplicationRepository.Aggregator applicationRepository;

    /**
     * 获取所有的微信公众号菜单类型
     *
     * @return {@link List<WeChatMenuButtonType> 所有菜单类型}
     * @since 2023/2/8
     */
    public List<WeChatMenuButtonType> menuButtonTypes() {
        return Arrays.stream(WeChatMenuButtonType.values()).collect(Collectors.toList());
    }

    /**
     * 查询指定公众号，指定匹配规则下的公众号菜单配置
     *
     * @param weChatId  {@link String weChatId}
     * @param matchRule {@link String matchRule}
     * @return {@link List<WeChatOfficialMenu> 公众号菜单列表}
     * @since 2023/2/8
     */
    public List<WeChatOfficialMenu> findWeChatMenus(String weChatId, String matchRule) {
        if (StringUtils.isBlank(matchRule)) matchRule = WeChatOfficialMenuRepository.DEFAULT_MATCH_RULE;
        return menuRepository.findWeChatOfficialMenus(weChatId, matchRule);
    }

    /**
     * 声明微信公众号菜单
     *
     * @param weChatId  {@link String 公众号索引}
     * @param matchRule {@link String 个性化菜单索引}
     * @param paMenus   {@link List<WeChatOfficialMenu> 菜单列表}
     * @since 2023/2/8
     */
    public List<WeChatOfficialMenu> statementMenus(String weChatId, String matchRule, List<WeChatOfficialMenu> paMenus) {
        if (StringUtils.isBlank(matchRule)) matchRule = WeChatOfficialMenuRepository.DEFAULT_MATCH_RULE;
        if (!StringUtils.equals(WeChatOfficialMenuRepository.DEFAULT_MATCH_RULE, matchRule)) {
            WeChatOfficialMenuMatchRule weChatOfficialMatchRule = menuRepository.findWeChatPaMatchRule(weChatId, matchRule);
            if (Objects.isNull(weChatOfficialMatchRule)) {
                throw new IllegalStateException("找不到编号为：" + matchRule + " 的定制化菜单声明");
            }
        }

        menuRepository.replaceWeChatPaMenus(weChatId, matchRule, paMenus);
        return menuRepository.findWeChatOfficialMenus(weChatId, matchRule);
    }

    /**
     * 声明微信公众号菜单个性化匹配规则
     *
     * @param weChatId  {@link String 微信公众号索引}
     * @param matchRule {@link WeChatOfficialMenuMatchRule 匹配规则}
     * @return {@link List< WeChatOfficialMenuMatchRule > 该微信公众号匹配规则列表}
     * @since 2023/2/8
     */
    public List<WeChatOfficialMenuMatchRule> statementMatchRule(String weChatId, String name, WeChatOfficialMenuMatchRule matchRule) {
        menuRepository.addWeChatPaMatchRule(weChatId, name, matchRule);
        List<WeChatOfficialMenuMatchRulePO> rules = menuRepository.findWeChatPaMatchRules(weChatId);
        if (CollectionUtils.isEmpty(rules))
            return Collections.emptyList();
        return rules.stream().map(WeChatOfficialMenuMatchRulePO::weChatMenuMatchRule).collect(Collectors.toList());
    }

    /**
     * 查询个性化匹配规则列表
     *
     * @param weChatId {@link String 公众号索引}
     * @return {@link List< WeChatOfficialMenuMatchRule > 匹配规则列表}
     * @since 2023/2/8
     */
    public List<WeChatOfficialMenuMatchRule> findWeChatMatchRules(String weChatId) {
        List<WeChatOfficialMenuMatchRulePO> rules = menuRepository.findWeChatPaMatchRules(weChatId);
        if (CollectionUtils.isEmpty(rules))
            return Collections.emptyList();
        return rules.stream().map(WeChatOfficialMenuMatchRulePO::weChatMenuMatchRule).collect(Collectors.toList());
    }

    /**
     * 创建公众号菜单
     *
     * @param weChatId  {@link String 公众号索引}
     * @param matchRule {@link String 匹配规则编号}
     * @since 2023/2/8
     */
    public void create(String weChatId, String matchRule) {
        WeChatApplication weChatApplication = this.applicationRepository.appByIndexThrowable(weChatId);
        final String appid = weChatApplication.getAppid();
        if (StringUtils.isBlank(matchRule)) matchRule = WeChatOfficialMenuRepository.DEFAULT_MATCH_RULE;

        String finalMatchRule = matchRule;
        List<String> authPageIds = OLD_KEYS.stream().map(item -> String.format(item, appid, finalMatchRule)).collect(Collectors.toList());
        authPageService.deleteAuthPage(authPageIds);

        List<WeChatOfficialMenu> menus = menuRepository.findWeChatOfficialMenus(appid, matchRule);

        WeChatOfficialMenuMatchRule menuMatchRule = menuRepository.findWeChatPaMatchRule(appid, matchRule);
        WeChatPublicAccountCreateMenuReq req = weChatMenu(appid, matchRule, menus);
        req.setMatchRule(menuMatchRule);

        WeChatApiRes weChatApiRes = StringUtils.equals(matchRule, WeChatOfficialMenuRepository.DEFAULT_MATCH_RULE)
                ? weChatPublicAccountMenuRemoting.create(appid, req)
                : weChatPublicAccountMenuRemoting.addConditionalMenu(appid, req);

        log.info("\r\n\t创建微信公众号菜单：{}结果：{}", weChatId, weChatApiRes);
    }

    private WeChatPublicAccountCreateMenuReq weChatMenu(String appid, String matchRule, List<WeChatOfficialMenu> menus) {
        menus.sort(WeChatOfficialMenu::compareTo);

        val weChatMenu = new WeChatPublicAccountCreateMenuReq();
        List<WeChatPublicAccountMenuButton> buttons = new LinkedList<>();

        // 检查菜单配置
        final Map<Integer, List<WeChatOfficialMenu>> menuMap = menuConfigureCheck(menus);

        // 一级菜单配置个数不正确
        final int size = menuMap.keySet().size();
        if (size > 3)
            throw new IllegalArgumentException("一级菜单个数不能超过3个");

        for (int i = 1; i <= 3; i++) {
            final List<WeChatOfficialMenu> paMenus = menuMap.get(i);
            if (Objects.isNull(paMenus))
                continue;

            final WeChatOfficialMenu parentMenu = paMenus.stream().filter(item -> "parent".equals(item.getType())).findFirst().orElse(null);

            final WeChatOfficialMenu firstLevelMenu = Objects.isNull(parentMenu) ? paMenus.get(0) : parentMenu;

            // 创建一级菜单
            WeChatPublicAccountMenuButton button = weChatMenuButton(appid, matchRule, firstLevelMenu);

            // 创建二级菜单
            if (StringUtils.isBlank(button.getType()))
                paMenus.stream().filter(item -> !"parent".equals(item.getType())).sorted(WeChatOfficialMenu::compareTo).map(menu -> this.weChatMenuButton(appid, matchRule, menu)).forEach(button::addSubButton);

            buttons.add(button);
        }

        weChatMenu.setButton(buttons);
        weChatMenu.buttonNumberCheck();
        // 非普通菜单
        if (!StringUtils.equals(matchRule, WeChatOfficialMenuRepository.DEFAULT_MATCH_RULE)) {
            WeChatOfficialMenuMatchRule weChatPaMatchRule = menuRepository.findWeChatPaMatchRule(appid, matchRule);
            if (Objects.isNull(weChatPaMatchRule))
                throw new IllegalStateException("微信公众号： " + appid + " 找不到编号为： " + matchRule + " 的个性化菜单匹配规则");
            weChatMenu.setMatchRule(weChatPaMatchRule);
        }
        return weChatMenu;
    }


    private WeChatPublicAccountMenuButton weChatMenuButton(String appid, String matchRule, WeChatOfficialMenu officialMenu) {
        WeChatPublicAccountMenuButton button = new WeChatPublicAccountMenuButton();

        String type = officialMenu.getType();
        switch (type) {
            case "parent":
                break;
            case "view":
                String url = officialMenu.getUrl();
                if (url.startsWith("https://open.weixin.qq.com")) {
                    button.setUrl(url);
                } else {
                    WeChatOfficialAuthPage authPage = new WeChatOfficialAuthPage();
                    authPage.setId(appid + "_menu_" + officialMenu.getFirst() + "_" + officialMenu.getSecond() + "_" + matchRule);
                    authPage.setUrl(url);
                    authPage.setAppid(appid);
                    authPage.setExpiresAt(LocalDateTime.MAX);
                    authPage = authPageService.addAuthPage(authPage);
                    button.setUrl(authPage.getAuthUrl());
                }
                break;
            case "miniprogram":
                button.setAppId(officialMenu.getMiniAppid());
                button.setPagePath(officialMenu.getMiniPath());
                if (officialMenu.getUrl().startsWith("https://open.weixin.qq.com")) {
                    button.setUrl(officialMenu.getUrl());
                } else {
                    WeChatOfficialAuthPage authPage = new WeChatOfficialAuthPage();
                    authPage.setId(appid + "_menu_" + officialMenu.getFirst() + "_" + officialMenu.getSecond() + "_" + matchRule);
                    authPage.setUrl(officialMenu.getUrl());
                    authPage.setAppid(appid);
                    authPage.setExpiresAt(LocalDateTime.MAX);
                    authPage = authPageService.addAuthPage(authPage);
                    button.setUrl(authPage.getAuthUrl());
                }
                break;
            case "click":
            case "scancode_waitmsg":
            case "scancode_push":
            case "pic_sysphoto":
            case "pic_photo_or_album":
            case "pic_weixin":
            case "location_select":
                button.setKey(officialMenu.getValue());
                break;
            case "media_id":
            case "view_limited":
                button.setMediaId(officialMenu.getValue());
                break;
            case "article_id":
            case "article_view_limited":
                button.setArticleId(officialMenu.getValue());
            default:
        }
        if (!"parent".equals(type))
            button.setType(type);

        button.setName(officialMenu.getName());
        return button;
    }

    private Map<Integer, List<WeChatOfficialMenu>> menuConfigureCheck(List<WeChatOfficialMenu> officialMenus) {
        officialMenus.forEach(menu -> {
            final int first = menu.getFirst();
            final int second = menu.getSecond();

            if (first < 1 || first > 3 || second < 0 || second > 5)
                throw new IllegalArgumentException("错误的一二级菜单编号，一级菜单取值范围：1，2，3; 二级菜单取值范围: 0,1,2,3,4,5");

            if ("parent".equals(menu.getType()) && second != 0)
                throw new IllegalArgumentException("错误的二级菜单编号： 父级菜单配置 second 取值必须为 0");
        });

        // 按照一级菜单配置分类
        final Map<Integer, List<WeChatOfficialMenu>> menuMap = officialMenus.stream().collect(Collectors.groupingBy(WeChatOfficialMenu::getFirst));

        // 一级菜单配置个数不正确
        final int size = menuMap.keySet().size();
        if (size > 3)
            throw new IllegalArgumentException("一级菜单个数不能超过3个");

        menuMap.forEach((key, value) -> {
            // 菜单配置个数不正确
            // 注意：因按照一级菜单分类后，一级菜单配置和子菜单配置在一个列表中，所以列表的最大size应该是6，而不是5
            final int subSize = value.size();
            if (subSize > 6 || subSize == 0)
                throw new IllegalArgumentException("二级菜单个数不能超过6个");

            value.sort(WeChatOfficialMenu::compareTo);

            final long parentNums = value.stream().filter(item -> "parent".equals(item.getType())).count();

            // 存在多个 parent 父级菜单配置
            if (parentNums > 1)
                throw new IllegalArgumentException("一级菜单编号" + key + "中存在多个 type 为 parent 的菜单配置");

            // 不存在二级菜单，但找到父级菜单配置
            if (subSize == 1 && parentNums == 1)
                throw new IllegalArgumentException("一级菜单编号" + key + "不存在子菜单，但存在父级菜单");

            // 存在二级菜单，但未配置父级菜单
            if (subSize > 1 && parentNums < 1)
                throw new IllegalArgumentException("一级菜单编号" + key + "存在子菜单，但未找到父级菜单");

            value.forEach(item -> {
                String type = item.getType();
                if (("view".equals(type) || "miniprogram".equals(type)) && StringUtils.isBlank(item.getUrl()))
                    throw new IllegalArgumentException("VIEW/MINIPROGRAM 菜单必须指定跳转链接");
            });

            final Set<Integer> secondKeys = value.stream().map(WeChatOfficialMenu::getSecond).collect(Collectors.toSet());
            if (secondKeys.size() < subSize) {
                for (int i = 0; i < subSize; i++) {
                    WeChatOfficialMenu officialMenu = value.get(i);
                    officialMenu.setSecond(i);
                }
            }
        });

        return menuMap;
    }
}