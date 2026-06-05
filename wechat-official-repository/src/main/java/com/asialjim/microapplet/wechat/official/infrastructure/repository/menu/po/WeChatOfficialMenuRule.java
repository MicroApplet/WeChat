/*
 * Copyright 2014-2025 <a href="mailto:asialjim@qq.com">Asial Jim</a>
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
package com.asialjim.microapplet.wechat.official.infrastructure.repository.menu.po;

import com.asialjim.microapplet.wechat.official.remoting.menu.meta.create.WeChatMenuMatchRule;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import com.mybatisflex.core.keygen.KeyGenerators;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Data
@Accessors(chain = true)
@Table("wechat_official_menu_rule")
public class WeChatOfficialMenuRule implements Serializable {

    @Serial
    private static final long serialVersionUID = -173056625620724738L;

    @Id(keyType = KeyType.Generator, value = KeyGenerators.flexId)
    private String id;

    private String appid;
    private String ruleId;

    /**
     * 客户标签id
     */
    private String tag_id;

    /**
     * 性别1男2女，空则不匹配
     */
    private String sex;

    /**
     * 国籍
     */
    private String country;

    /**
     * 省份
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 客户端版本，当前只具体到系统型号：IOS(1), Android(2),Others(3)，不填则不做匹配
     */
    private String client_platform_type;

    /**
     * 语言
     */
    private String language;

    public static WeChatMenuMatchRule voOf(WeChatOfficialMenuRule po) {
        if (Objects.isNull(po))
            return null;
        WeChatMenuMatchRule vo = new WeChatMenuMatchRule();
        vo.setTag_id(po.getTag_id());
        vo.setSex(po.getSex());
        vo.setCountry(po.getCountry());
        vo.setProvince(po.getProvince());
        vo.setCity(po.getCity());
        vo.setClient_platform_type(po.getClient_platform_type());
        vo.setLanguage(po.getLanguage());
        return vo;
    }

    public static WeChatOfficialMenuRule poOf(String appid,String name,WeChatMenuMatchRule vo) {
        if (Objects.isNull(vo))
            return null;
        WeChatOfficialMenuRule po = new WeChatOfficialMenuRule();
        po.setId("");//todo
        po.setAppid(appid);
        po.setRuleId(name);
        po.setTag_id(vo.getTag_id());
        po.setSex(vo.getSex());
        po.setCountry(vo.getCountry());
        po.setProvince(vo.getProvince());
        po.setCity(vo.getCity());
        po.setClient_platform_type(vo.getClient_platform_type());
        po.setLanguage(vo.getLanguage());

        return po;
    }
}