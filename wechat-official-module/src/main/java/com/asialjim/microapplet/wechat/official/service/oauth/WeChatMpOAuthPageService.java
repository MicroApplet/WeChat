/*
 *    Copyright 2014-2025 <a href="mailto:asialjim@qq.com">Asial Jim</a>
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.asialjim.microapplet.wechat.official.service.oauth;

import cn.hutool.core.lang.PatternPool;
import com.asialjim.microapplet.common.cons.Headers;
import com.asialjim.microapplet.common.exception.RsEx;
import com.asialjim.microapplet.wechat.official.context.WeChatMpCode;
import com.asialjim.microapplet.wechat.official.service.oauth.impl.SimpleWeChatMpOAuthHandler;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.net.URI;
import java.time.Duration;
import java.util.List;
import java.util.Objects;

/**
 * 公众号授权页面服务
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/9/5, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Slf4j
@Component
public class WeChatMpOAuthPageService {
    @Resource
    private List<WeChatMpOAuthHandler> oAuthHandlerList;

    @Resource
    private SimpleWeChatMpOAuthHandler simpleWeChatMpOAuthHandler;

    @Resource
    private WeChatMpOAuthLoginService weChatMpOAuthLoginService;

    public Object page(String appid, String handler, String code, String state, Model model) {
        // 查询目标页面
        URI url = queryPageUrl(appid, handler, state, model);
        if (url == null)
            return "oauthPageErr";

        // 登录
        String token = StringUtils.EMPTY;
        RsEx rsEx = null;
        try {
            token = weChatMpOAuthLoginService.login(appid, code);
        } catch (RsEx ex) {
            rsEx = ex;
        } catch (Throwable ex) {
            log.error("oauthPage unexpected error, appid:{}, handler:{}", appid, handler, ex);
            rsEx = new RsEx().setStatus(401).setThr(false).setCode("WECHAT-MP:USER-LOGIN:FAILURE").setMsg("公众号用户登录失败");
        }

        if (Objects.nonNull(rsEx)) {
            model.addAttribute("code", rsEx.getCode());
            model.addAttribute("desc", rsEx.getMsg());
            return "oauthPageErr";
        }

        String host = getTopDomainSimple(url.getHost());

        final ResponseCookie tokenCookie = ResponseCookie.from(Headers.USER_TOKEN, token).domain(host).path("/").maxAge(Duration.ofHours(2)).httpOnly(true).secure(true).sameSite("Lax").build();

        return ResponseEntity.status(HttpStatus.FOUND)
                .location(url)
                .header(HttpHeaders.SET_COOKIE, tokenCookie.toString())
                .build();
    }


    private WeChatMpOAuthHandler handler(String handler) {
        return this.oAuthHandlerList.stream()
                .filter(item -> StringUtils.equals(handler, item.handler()))
                .findAny()
                .orElse(simpleWeChatMpOAuthHandler);
    }

    private URI queryPageUrl(String appid, String handler, String state, Model model) {
        URI url = null;
        RsEx rsEx = null;
        try {
            url = handler(handler).page(appid, state);
        } catch (RsEx ex) {
            rsEx = ex;
        } catch (Throwable ex) {
            log.error("oauthPage unexpected error, appid:{}, handler:{}", appid, handler, ex);
            rsEx = new RsEx().setStatus(200).setThr(false).setCode("UNKNOWN").setMsg("未知错误");
        }

        if (Objects.isNull(url))
            rsEx = WeChatMpCode.OAuthPageStateUnknown.ex();

        if (Objects.nonNull(rsEx)) {
            model.addAttribute("code", rsEx.getCode());
            model.addAttribute("desc", rsEx.getMsg());
            return null;
        }
        return url;
    }


    private static String getTopDomainSimple(String host) {
        if (StringUtils.isBlank(host))
            return ".";

        boolean isIPv4 = PatternPool.IPV4.matcher(host).matches();
        if (isIPv4)
            return host;
        boolean isIPv6 = PatternPool.IPV6.matcher(host).matches();
        if (isIPv6)
            return host;

        String[] parts = host.split("\\.");

        if (parts.length >= 2) {
            return "." + parts[parts.length - 2] + "." + parts[parts.length - 1];
        }
        return host;   // localhost / IP
    }
}