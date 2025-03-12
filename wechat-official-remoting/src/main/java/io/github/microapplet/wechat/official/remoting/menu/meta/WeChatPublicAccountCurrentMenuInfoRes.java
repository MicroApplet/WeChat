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
package io.github.microapplet.wechat.official.remoting.menu.meta;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.microapplet.wechat.official.remoting.menu.meta.create.WeChatPublicAccountMenuButton;
import io.github.microapplet.wechat.remoting.context.BaseWeChatApiRes;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


import java.io.Serializable;
import java.util.List;

/**
 * <p> 本接口将会提供公众号当前使用的自定义菜单的配置，如果公众号是通过API调用设置的菜单，则返回菜单的开发配置，而如果公众号是在公众平台官网通过网站功能发布菜单，则本接口返回运营者设置的菜单配置。
 * @author Copyright © <a href="mailto:asialjim@hotmail.com">Asial Jim</a>   Co., LTD
 * @version 1.0.0
 * @since 2021/12/25 15:37   &nbsp;&nbsp; JDK 8
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class WeChatPublicAccountCurrentMenuInfoRes extends BaseWeChatApiRes {

    private static final long serialVersionUID = -3148595272603238535L;

    @JsonProperty("is_menu_open")
    private Integer isMenuOpen;

    @JsonProperty("selfmenu_info")
    private WeChatPublicAccountMenuInfo selfMenuInfo;

    @Data
    public static class WeChatPublicAccountMenuInfo implements Serializable{

        private static final long serialVersionUID = -5734972663514654125L;

        private List<WeChatPublicAccountMenuInfoButton> button;
    }

    @Data
    public static class WeChatPublicAccountMenuInfoButton implements Serializable{

        private static final long serialVersionUID = -1194273465565414178L;

        private String name;
        private WeChatPublicAccountMenuSubButton sub_button;
        private String type;
        private String value;
    }

    @Data
    public static class WeChatPublicAccountMenuSubButton implements Serializable{

        private static final long serialVersionUID = -8989213218029890397L;

        private List<WeChatPublicAccountMenuButton> list;
    }
}