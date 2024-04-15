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
import io.github.microapplet.wechat.official.remoting.menu.meta.create.WeChatOfficialMenuMatchRule;
import lombok.*;
import lombok.experimental.Accessors;
import org.apache.ibatis.type.JdbcType;

import java.io.Serializable;
import java.util.Date;

/**
 * 微信公众号菜单个性化菜单匹配规则持久化服务
 *
 * @author Copyright © <a href="mailto:asialjim@hotmail.com">Asial Jim</a>   Co., LTD
 * @version 1.0
 * @since 2023/2/10, &nbsp;&nbsp; <em>version:1.0</em>, &nbsp;&nbsp; <em>java version:17</em>
 */
@Accessors(chain = true)
@ToString(callSuper = true)
@Table("wx_official_menu_rule")
@Data(staticConstructor = "create")
@EqualsAndHashCode(callSuper = true)
public class WeChatOfficialMenuMatchRulePO extends Model<WeChatOfficialMenuMatchRulePO> implements Serializable {
    private static final long serialVersionUID = 6338040172747917652L;

    @Id
    private String id;
    private String appid;
    @Column("rule_name")
    private String name;


    /**
     * 客户标签id
     */
    private String tagId;

    /**
     * 性别1男2女，空则不匹配
     */
    private String gender;

    /**
     * 国籍
     */
    private String land;

    /**
     * 省份
     */
    @Column("pro")
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 客户端版本，当前只具体到系统型号：IOS(1), Android(2),Others(3)，不填则不做匹配
     */
    @Column("cli_type")
    private String clientType;

    /**
     * 语言
     */
    private String lang;

    @Column(jdbcType = JdbcType.TIMESTAMP)
    private Date cTime;

    public WeChatOfficialMenuMatchRule weChatMenuMatchRule(){
        WeChatOfficialMenuMatchRule rule = new WeChatOfficialMenuMatchRule();
        rule.setTag_id(this.getTagId());
        rule.setCity(this.getCity());
        rule.setSex(this.getGender());
        rule.setCountry(this.getLand());
        rule.setProvince(this.getProvince());
        rule.setClient_platform_type(this.getClientType());
        rule.setLanguage(this.getLang());
        return rule;
    }

    public static WeChatOfficialMenuMatchRulePO weChatPaMenuMatchRulePO(String appid, String name,
                                                                        WeChatOfficialMenuMatchRule rule){
        WeChatOfficialMenuMatchRulePO po = new WeChatOfficialMenuMatchRulePO();
        po.setAppid(appid);
        po.setName(name);
        po.setTagId(rule.getTag_id());
        po.setCity(rule.getCity());
        po.setGender(rule.getSex());
        po.setLand(rule.getCountry());
        po.setProvince(rule.getProvince());
        po.setClientType(rule.getClient_platform_type());
        po.setLang(rule.getLanguage());
        return po;
    }
}