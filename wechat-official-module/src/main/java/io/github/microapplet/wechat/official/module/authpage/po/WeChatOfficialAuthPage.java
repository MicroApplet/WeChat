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

package io.github.microapplet.wechat.official.module.authpage.po;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import io.github.microapplet.wechat.application.WeChatApplication;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.Serial;
import java.io.Serializable;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * 微信公众号授权网页链接
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0.0
 * @since 2024 07 25, &nbsp;&nbsp; <em>version:1.0.0</em>
 */
@Data
@Accessors(chain = true)
@Table("wechat_official_auth_page")
public class WeChatOfficialAuthPage implements Serializable {
    @Serial
    private static final long serialVersionUID = 363677825168545694L;
    public static final String SNS_API_BASE = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=snsapi_base&state=%s#wechat_redirect";
    public static final String SNS_API_USERINFO = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=snsapi_userinfo&state=%s#wechat_redirect";
    /**
     * 业务编号
     */
    @Id
    private String id;
    /**
     * 公众号编号
     */
    private String appid;
    /**
     * 是否显式授权
     */
    private Boolean manual;
    /**
     * 跳转目标链接，数据库存储的应该是添加了参数后的链接
     */
    private String url;
    /**
     * 过期时间毫秒值
     */
    private Long expireAt;

    /**
     * 创建时间
     */
    @Column(onInsertValue = "now()")
    private LocalDateTime createTime;

    /**
     * 过期时间
     */
    @Column(ignore = true)
    private Long expireTime;
    /**
     * 过期时间单位
     */
    @Column(ignore = true)
    private TimeUnit expireUnit;

    /**
     * 参数
     */
    @Column(ignore = true)
    private Map<String, String> parameter;

    /**
     * 授权链接
     */
    @Column(ignore = true)
    private String authUrl;

    /**
     * 判断授权网页链接是否过期
     *
     * @since 2024 07 25
     */
    public boolean authPageHasExpired() {
        return System.currentTimeMillis() > Optional.ofNullable(getExpireAt()).orElse(0L);
    }

    /**
     * 构建授权网页链接
     *
     * @param weChatApplication {@link WeChatApplication weChatApplication}
     * @since 2024 07 25
     */
    public void buildAuthUrl(WeChatApplication weChatApplication) {
        if (!StringUtils.equals(getAppid(), weChatApplication.getAppid()))
            throw new IllegalArgumentException("WeChatApplication's appid and appid must match");
        // 构建参数
        if (MapUtils.isNotEmpty(getParameter())) {
            StringJoiner sj = new StringJoiner("&");
            getParameter().forEach((k, v) -> {
                String key = URLEncoder.encode(k, StandardCharsets.UTF_8);
                String value = URLEncoder.encode(v, StandardCharsets.UTF_8);
                sj.add(key + "=" + value);
            });
            String parameterUrl = sj.toString();
            if (StringUtils.isNotBlank(parameterUrl)) {
                this.url += "&" + parameterUrl;
            }
            if (StringUtils.contains(this.url, "&") && !StringUtils.contains(this.url, "?")) {
                this.url = this.url.replaceFirst("&", "?");
            }
            setParameter(null);
        }

        // 处理过期时间
        if (Objects.isNull(getExpireTime()) || Objects.isNull(getExpireUnit())) {
            this.setExpireAt(Long.MAX_VALUE);
        } else {
            long expireAt = getExpireUnit().toMillis(getExpireTime()) + System.currentTimeMillis();
            setExpireAt(expireAt);
        }

        // 创建业务编号
        if (StringUtils.isBlank(getId())) {
            setId(UUID.randomUUID().toString().replaceAll("-", StringUtils.EMPTY));
        }

        // 构建授权链接
        boolean manual = Boolean.TRUE.equals(getManual());
        if (manual)
            this.authUrl = String.format(SNS_API_USERINFO, getAppid(), weChatApplication.getUrl(), getId());
        else
            this.authUrl = String.format(SNS_API_BASE, getAppid(), weChatApplication.getUrl(), getId());
    }
}