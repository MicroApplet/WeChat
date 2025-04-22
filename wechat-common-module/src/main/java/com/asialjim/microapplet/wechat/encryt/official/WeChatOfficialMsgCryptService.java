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

package com.asialjim.microapplet.wechat.encryt.official;

import com.asialjim.microapplet.wechat.application.WeChatApplication;
import com.asialjim.microapplet.wechat.encryt.official.aes.AesException;
import com.asialjim.microapplet.wechat.encryt.official.aes.WeChatOfficialMsgCrypt;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 微信公众号消息加解密服务
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0.0
 * @since 2024 07 25, &nbsp;&nbsp; <em>version:1.0.0</em>
 */
@Component
public class WeChatOfficialMsgCryptService {
    private static final Map<String, WeChatOfficialMsgCrypt> CRYPT_MAP = new HashMap<>();

    public WeChatOfficialMsgCrypt cryptOf(final WeChatApplication app) {
        if (Objects.isNull(app))
            throw new IllegalStateException("WeChat Application is Null");
        String appid = app.getAppid();
        if (StringUtils.isBlank(appid))
            throw new IllegalStateException("WeChat Application AppId is Null");
        WeChatOfficialMsgCrypt crypt = CRYPT_MAP.get(appid);
        if (Objects.nonNull(crypt))
            return crypt;
        try {
            crypt = new WeChatOfficialMsgCrypt(app.getToken(), app.getAesKey(), app.getAppid());
            CRYPT_MAP.put(appid, crypt);
            return crypt;
        } catch (AesException e) {
            throw new IllegalStateException(e);
        }
    }


    public boolean verify(WeChatApplication weChatApplication, String signature, String timestamp, String nonce, String echostr) {
        try {
            if (Objects.isNull(weChatApplication))
                throw new IllegalStateException("WeChat Application is Null");
            if (StringUtils.isAnyBlank(signature, timestamp, nonce))
                throw new IllegalStateException("Signature, timestamp or nonce is Blank");

            WeChatOfficialMsgCrypt crypt = cryptOf(weChatApplication);
            crypt.verifyUrl(signature, timestamp, nonce, echostr);
            return true;
        } catch (AesException e) {
            return false;
        }
    }
}