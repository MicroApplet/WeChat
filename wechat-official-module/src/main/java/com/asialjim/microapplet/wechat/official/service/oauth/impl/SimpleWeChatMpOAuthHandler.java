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

package com.asialjim.microapplet.wechat.official.service.oauth.impl;

import cn.hutool.core.net.url.UrlBuilder;
import com.asialjim.microapplet.wechat.official.context.WeChatMpCode;
import com.asialjim.microapplet.wechat.official.infrastructure.repository.oauthpage.OAuthPageRepository;
import com.asialjim.microapplet.wechat.official.module.oauthpage.OAuthPageVo;
import com.asialjim.microapplet.wechat.official.module.oauthpage.WxStateUtil;
import com.asialjim.microapplet.wechat.official.service.oauth.WeChatMpOAuthHandler;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.List;

/**
 * 简单授权网页链接处理器
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/9/5, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Slf4j
@Component
public class SimpleWeChatMpOAuthHandler implements WeChatMpOAuthHandler {

    @Resource
    private OAuthPageRepository oAuthPageRepository;

    @Override
    public String handler() {
        return "simple";
    }

    @Override
    public String description() {
        return "简单授权网页处理器";
    }


    @Override
    public URI page(String appid, String state) {

        boolean verify = WxStateUtil.verify(state);
        if (!verify)
            WeChatMpCode.OAuthPageStateIllegal.thr();

        OAuthPageVo po = this.oAuthPageRepository.pageOf(appid, state);
        String url = po.getUrl();
        return UrlBuilder.of(url).toURI();
    }

    public void deleteAuthPage(List<String> authPageIds) {
        this.oAuthPageRepository.delete(authPageIds);
    }

    public OAuthPageVo create(OAuthPageVo authPage) {
        return this.oAuthPageRepository.create(authPage);
    }
}