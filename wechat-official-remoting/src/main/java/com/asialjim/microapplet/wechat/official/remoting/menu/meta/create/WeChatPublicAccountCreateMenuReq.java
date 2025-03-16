/*
 *  Copyright 2014-2025 <a href="mailto:asialjim@qq.com">Asial Jim</a>
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
 *   limitations under the License.
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

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
    protected WeChatMenuMatchRule matchRule;

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