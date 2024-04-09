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

package io.github.microapplet.wechat.official.datasource.po;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import com.mybatisflex.core.activerecord.Model;
import io.github.microapplet.wechat.official.authpage.WeChatOfficialAuthPage;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.apache.ibatis.type.JdbcType;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * 微信公众号授权网页ORM对象
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0.0
 * @since 2024 04 09, &nbsp;&nbsp; <em>version:1.0.0</em>
 */
@Accessors(chain = true)
@Table("wx_off_auth_page")
@ToString(callSuper = true)
@Data(staticConstructor = "create")
@EqualsAndHashCode(callSuper = true)
public class WeChatOfficialAuthPagePO extends Model<WeChatOfficialAuthPagePO> {
    private static final long serialVersionUID = -4532444300938387412L;

    /**
     * 授权网页链接编号，对应PO主键， 对应接口的 state 字段
     */
    @Id(keyType = KeyType.None)
    private String id;

    private String appid;

    /**
     * 目标链接
     */
    private String url;

    @Column(jdbcType = JdbcType.DATETIMEOFFSET)
    private LocalDateTime expiresAt;

    /**
     * 是否显示授权，数据库中存在此字段
     */
    private Boolean manual;
    private String authUrl;

    @Column(jdbcType = JdbcType.DATETIMEOFFSET)
    private LocalDateTime createTime;

    public WeChatOfficialAuthPage authPage(){
        return new WeChatOfficialAuthPage()
                .setId(getId())
                .setAppid(getAppid())
                .setUrl(getUrl())
                .setExpiresAt(getExpiresAt())
                .setManual(getManual())
                .setAuthUrl(getAuthUrl());
    }

    public static WeChatOfficialAuthPagePO pageOf(WeChatOfficialAuthPage page){
        if (Objects.isNull(page))
            return null;
        return WeChatOfficialAuthPagePO.create()
                .setId(page.getId())
                .setAppid(page.getAppid())
                .setUrl(page.getUrl())
                .setExpiresAt(page.getExpiresAt())
                .setManual(page.getManual())
                .setAuthUrl(page.getAuthUrl());
    }
}