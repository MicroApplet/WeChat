/*
 * Copyright 2014 - 2024 <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.microapplet.wechat.official.module.menu.po;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 微信公众号菜单配置
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0.0
 * @since 2024 07 25, &nbsp;&nbsp; <em>version:1.0.0</em>
 */
@Data
@Accessors(chain = true)
@Table("wechat_official_menu")
public class WeChatOfficialMenuProperty implements Comparable<WeChatOfficialMenuProperty>, Serializable {
    @Serial
    private static final long serialVersionUID = -8621561297684751280L;

    @Id
    private String id;
    private String appid;
    private String ruleId;
    private Integer first;
    private Integer second;
    private String name;
    private String type;
    private String value;
    private String url;
    private String applet;
    private String path;
    @Column(ignore = true)
    private LocalDateTime createTime;

    public String getRuleId() {
        if (StringUtils.isBlank(ruleId))
            return "DEFAULT";
        return ruleId;
    }

    public int compareTo(WeChatOfficialMenuProperty o) {
        int sub = first - o.getFirst();
        if (sub != 0)
            return sub;

        return second - o.getSecond();
    }
}