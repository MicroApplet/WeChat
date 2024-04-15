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
package io.github.microapplet.wechat.official.remoting.menu.meta.create;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * <h1><em>ASIAL JIM JAVA DOC</em></h1><hr/>
 * <h2>CLASS DESCRIPTION <i>[ NAME: WeChatPublicAccountMenuReq ]</i> </h2><strong>
 * <p> 创建公众号菜单请求
 * @author Copyright © <a href="mailto:asialjim@hotmail.com">Asial Jim</a>   Co., LTD
 * @version 1.0.0
 * @since 2021/12/25 15:21   &nbsp;&nbsp; JDK 8
 */
@Data
@Slf4j
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("unused")
public class WeChatPublicAccountCreateMenuReq implements Serializable {
    private static final long serialVersionUID = 8832818737768763475L;

    /**
     * 一级菜单
     */
    private List<WeChatPublicAccountMenuButton> button;

    /**
     * 个性化菜单匹配规则
     */
    @JsonProperty(value = "matchrule")
    protected WeChatOfficialMenuMatchRule matchRule;

    /**
     * <h3>FIELD DESCRIPTION</h3>
     * the response for get we-chat official menu config and there is conditional menu needed
     */
    protected Integer menuid;

    public void buttonNumberCheck() {
        if (button == null)
            return;
        if (button.size() >3)
            throw new IllegalStateException("一级菜单不能超过3个");

        for (WeChatPublicAccountMenuButton weChatMenuButton : button) {
            var subButtons = weChatMenuButton.getSubButtons();
            if (Objects.isNull(subButtons)) return;
            // 二级菜单检查，不能超过五个二级菜单
            if (subButtons.size()>5)
                throw new IllegalStateException("二级菜单不能超过5个");
            log.debug("菜单具有二级菜单");
        }
    }
}