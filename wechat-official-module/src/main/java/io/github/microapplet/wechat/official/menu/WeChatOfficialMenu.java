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
package io.github.microapplet.wechat.official.menu;

import io.github.microapplet.wechat.official.remoting.menu.meta.create.WeChatMenuButtonType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 单条微信公众号菜单配置
 *
 * @author Copyright © <a href="mailto:asialjim@hotmail.com">Asial Jim</a>   Co., LTD
 * @version 1.0
 * @since 2023/2/8, &nbsp;&nbsp; <em>version:1.0</em>, &nbsp;&nbsp; <em>java version:17</em>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeChatOfficialMenu implements Comparable<WeChatOfficialMenu>, Serializable {
    private static final long serialVersionUID = -8506208410015589131L;

    /**
     * 菜单名称
     */
    @NotBlank(message = "公众号菜单名称不能为空")
    private String name;

    /**
     * 菜单类型,参考：{@link WeChatMenuButtonType 菜单类型}
     */
    @NotBlank(message = "公众号菜单类型不能为空")
    private String type;

    /**
     * 一级菜单编号
     */
    @Range(min = 1,max = 3, message = "一级菜单编号可选值： 1，2，3")
    private int first;

    /**
     * 二级菜单编号
     */
    @Range(min = 0,max = 5, message = "二级菜单编号可选值： 0，1，2，3，4，5")
    private int second;

    /**
     * 页面跳转链接，包括跳转小程序时的备用跳转页面
     */
    private String url;

    /**
     * 跳转小程序的appid
     */
    private String miniAppid;

    /**
     * 跳转小程序的页面路径
     */
    private String miniPath;

    /**
     * 点击类型菜单值：包括：key,media_id, article_id 三个字段值均负载到此字段中
     */
    private String value;

    public int compareTo(WeChatOfficialMenu o) {
        int sub = first - o.getFirst();
        if (sub != 0)
            return sub;

        return second - o.getSecond();
    }
}