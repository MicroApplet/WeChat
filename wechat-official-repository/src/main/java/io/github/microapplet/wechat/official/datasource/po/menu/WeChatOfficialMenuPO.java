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
package io.github.microapplet.wechat.official.datasource.po.menu;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import com.mybatisflex.core.activerecord.Model;
import io.github.microapplet.wechat.official.menu.WeChatOfficialMenu;
import lombok.*;
import lombok.experimental.Accessors;
import org.apache.ibatis.type.JdbcType;

import java.io.Serializable;
import java.util.Date;

/**
 * 微信公众号菜单配置信息持久化对象
 *
 * @author Copyright © <a href="mailto:asialjim@hotmail.com">Asial Jim</a>   Co., LTD
 * @version 1.0
 * @since 2023/2/10, &nbsp;&nbsp; <em>version:1.0</em>, &nbsp;&nbsp; <em>java version:17</em>
 */
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
@Accessors(chain = true)
@Table("wx_official_menu")
@ToString(callSuper = true)
@Data(staticConstructor = "create")
@EqualsAndHashCode(callSuper = true)
public class WeChatOfficialMenuPO extends Model<WeChatOfficialMenuPO> implements Serializable {
    private static final long serialVersionUID = 3775648157223545929L;

    @Id
    private String id;

    private String appid;
    private String ruleId;
    private Integer first;
    private Integer second;

    @Column("m_name")
    private String menuName;
    @Column("m_type")
    private String menuType;

    /**
     * key, media_id, article_id
     */
    @Column("m_value")
    private String menuValue;
    @Column("m_url")
    private String menuUrl;
    @Column("m_applet")
    private String miniAppid;
    @Column("m_path")
    private String miniPath;
    @Column(value = "c_time", jdbcType = JdbcType.TIMESTAMP)
    private Date cTime;

    public WeChatOfficialMenu weChatPaMenu(){
        WeChatOfficialMenu menu = new WeChatOfficialMenu();
        menu.setName(this.menuName);
        menu.setType(this.menuType);
        menu.setFirst(this.getFirst());
        menu.setSecond(this.getSecond());
        menu.setValue(this.getMenuValue());
        menu.setUrl(this.getMenuUrl());
        menu.setMiniAppid(this.getMiniAppid());
        menu.setMiniPath(this.getMiniPath());
        return menu;
    }

    public static WeChatOfficialMenuPO weChatPaMenuPO(String appid, String matchRuleId, WeChatOfficialMenu menu){
        WeChatOfficialMenuPO po = new WeChatOfficialMenuPO();
        po.setMenuName(menu.getName());
        po.setMenuType(menu.getType());
        po.setFirst(menu.getFirst());
        po.setSecond(menu.getSecond());
        po.setMenuValue(menu.getValue());
        po.setMenuUrl(menu.getUrl());
        po.setMiniAppid(menu.getMiniAppid());
        po.setMiniPath(menu.getMiniPath());
        po.setAppid(appid);
        po.setRuleId(matchRuleId);
        return po;
    }
}