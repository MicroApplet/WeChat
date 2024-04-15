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

package io.github.microapplet.wechat.official.service.authpage;

import io.github.microapplet.wechat.application.WeChatApplication;
import io.github.microapplet.wechat.application.WeChatApplicationRepository;
import io.github.microapplet.wechat.official.authpage.WeChatOfficialAuthPage;
import io.github.microapplet.wechat.official.datasource.service.WeChatOfficialAuthPageDBService;
import io.github.microapplet.wechat.official.remoting.user.WeChatPublicAccountUserRemoting;
import io.github.microapplet.wechat.official.remoting.user.meta.WeChatPublicAccountUserAccessTokenRes;
import io.github.microapplet.wechat.official.remoting.user.meta.WeChatPublicAccountUserInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * 微信公众号授权网页链接服务
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0.0
 * @since 2024 04 09, &nbsp;&nbsp; <em>version:1.0.0</em>
 */
@Slf4j
@Component
public class WeChatOfficialAuthPageService {
    public static final String GET_AUTH_PAGE_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=snsapi_base&state=%s#wechat_redirect";
    public static final String GET_USER_INFO_AUTH_PAGE_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=snsapi_userinfo&state=%s#wechat_redirect";

    @Resource
    private WeChatPublicAccountUserRemoting weChatPublicAccountUserRemoting;
    @Resource
    private WeChatOfficialAuthPageDBService weChatOfficialAuthPageDBService;
    @Resource
    private WeChatApplicationRepository.Aggregator aggregator;

    /**
     * 添加授权网页链接
     *
     * @param page {@link WeChatOfficialAuthPage page}
     * @return {@link WeChatOfficialAuthPage }
     * @since 2024 04 09
     */
    public WeChatOfficialAuthPage addAuthPage(WeChatOfficialAuthPage page) {
        String state = StringUtils.isBlank(page.getId()) ? genState() : page.getId();
        page.setId(state);
        String appid = page.getAppid();
        String redirectUrl = page.getUrl();
        Boolean manualNeed = Optional.ofNullable(page.getManual()).orElse(false);
        Integer expiresTime = page.getExpiresTime();
        TimeUnit expiresUnit = page.getExpiresUnit();
        LocalDateTime expiresAt = page.getExpiresAt();
        Map<String, String> param = Optional.ofNullable(page.getParam()).orElseGet(HashMap::new);
        if (MapUtils.isNotEmpty(param)) {
            StringJoiner joiner = new StringJoiner("&");
            for (Map.Entry<String, String> entry : param.entrySet()) {
                String k = entry.getKey();
                String v = entry.getValue();
                try {
                    String key = URLEncoder.encode(k, StandardCharsets.UTF_8.name());
                    String value = URLEncoder.encode(v, StandardCharsets.UTF_8.name());
                    joiner.add(key + "=" + value);
                } catch (Throwable t) {
                    joiner.add(k + "=" + v);
                }
            }

            String query = joiner.toString();
            if (StringUtils.isNotBlank(query)) {
                redirectUrl = redirectUrl + "&" + query;
            }
        }
        if (StringUtils.contains(redirectUrl, "&") && StringUtils.contains(redirectUrl, "?"))
            redirectUrl = redirectUrl.replaceFirst("&", "?");
        page.setUrl(redirectUrl);

        LocalDateTime now = LocalDateTime.now();
        if (Objects.isNull(expiresAt)) {
            expiresAt = Objects.nonNull(expiresTime) && Objects.nonNull(expiresUnit)
                    ? now.plusSeconds(expiresUnit.toSeconds(expiresTime))
                    : LocalDateTime.of(2099, Month.DECEMBER, 31, 23, 59, 59);
            page.setExpiresAt(expiresAt);
        }

        if (now.isAfter(expiresAt))
            throw new IllegalArgumentException("过期时间" + expiresAt + "在当前时间之前");

        WeChatApplication application = aggregator.appByIndexThrowable(appid);
        String handlerUrl = application.getUrl();
        String format = manualNeed ? GET_USER_INFO_AUTH_PAGE_URL : GET_AUTH_PAGE_URL;
        String authUrl = String.format(format, appid, handlerUrl, state);
        page.setAuthUrl(authUrl);
        return this.weChatOfficialAuthPageDBService.add(page);
    }

    /**
     * 根据授权网页编号，查询授权网页链接信息
     *
     * @param state {@link String state}
     * @return {@link WeChatOfficialAuthPage }
     * @since 2024 04 09
     */
    public WeChatOfficialAuthPage pageOfState(String state) {
        return this.weChatOfficialAuthPageDBService.stateOf(state);
    }

    public WeChatOfficialAuthPageUser userOfCodeAndState(String code, String state){
        WeChatOfficialAuthPage page = pageOfState(state);
        if (Objects.isNull(page))
            throw new IllegalStateException("微信授权网页业务：[" + state + "]不存在或已过期");
        String appid = page.getAppid();
        WeChatApplication application = aggregator.appByIndexThrowable(appid);
        WeChatPublicAccountUserAccessTokenRes userAccessToken = this.weChatPublicAccountUserRemoting.userAccessToken(application.getAppid(), application.getSecret(), code);
        WeChatPublicAccountUserInfo result = this.weChatPublicAccountUserRemoting.weChatUserInfo(userAccessToken.getAccessToken(), userAccessToken.getOpenid());
        String url = page.getUrl();
        return WeChatOfficialAuthPageUser.create(url, result, userAccessToken);
    }


    private String genState() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    public void deleteAuthPage(List<String> authPageIds) {
        this.weChatOfficialAuthPageDBService.deleteBatch(authPageIds);
    }
}