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
package com.asialjim.microapplet.wechat.official.infrastructure.repository.menu;


import com.asialjim.microapplet.wechat.official.module.menu.WeChatPaMenu;
import com.asialjim.microapplet.wechat.official.remoting.menu.meta.create.WeChatMenuMatchRule;

import java.util.List;

/**
 * 微信公众号菜单仓库
 *
 * @author Copyright © <a href="mailto:asialjim@hotmail.com">Asial Jim</a>   Co., LTD
 * @version 1.0
 * @since 2023/2/8, &nbsp;&nbsp; <em>version:1.0</em>, &nbsp;&nbsp; <em>java version:17</em>
 */
public interface WeChatPaMenuRepository {

    String DEFAULT_MATCH_RULE = "DEFAULT";


    List<WeChatPaMenu> findWeChatPaMenus(String weChatId, String matchRule);

    WeChatMenuMatchRule findWeChatPaMatchRule(String weChatId, String matchRule);

    void replaceWeChatPaMenus(String weChatId, String matchRule, List<WeChatPaMenu> paMenus);

    void addWeChatPaMatchRule(String weChatId, String name, WeChatMenuMatchRule matchRule);

    List<WeChatMenuMatchRule> findWeChatPaMatchRules(String weChatId);


}