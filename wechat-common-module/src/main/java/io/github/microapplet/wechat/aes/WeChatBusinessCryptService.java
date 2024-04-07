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

package io.github.microapplet.wechat.aes;

import io.github.microapplet.remote.net.jackson.AbstractJacksonUtil;
import io.github.microapplet.wechat.application.WeChatApplication;
import io.github.microapplet.wechat.application.WeChatApplicationRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 微信后台应用加解密服务组建
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 3.0.0
 * @since 2024 04 07, &nbsp;&nbsp; <em>version:3.0.0</em>
 */
@Slf4j
@Component
public class WeChatBusinessCryptService {
    private static final Map<String, WeChatBusinessCrypt> CRYPT_CACHE = new ConcurrentHashMap<>();
    @Resource
    private WeChatApplicationRepository.Aggregator aggregator;

    /**
     * <h3>METHOD DESCRIPTION <i>[ NAME: wxBizMsgCrypt ]</i></h3>
     * 根据微信公众平台账号获取加解密实体
     *
     * @param accountId {@link String account id}
     * @return {@link WeChatBusinessCrypt crypt}
     * @author Asial Jim &nbsp;&nbsp;<span>Email:asialjim@hotmail.com &nbsp;&nbsp; asialjim@qq.com</span>
     * @since 2021/3/16 14:58
     */
    public WeChatBusinessCrypt wxBizMsgCrypt(String accountId) {
        WeChatBusinessCrypt wxBizMsgCrypt = CRYPT_CACHE.get(accountId);
        if (Objects.nonNull(wxBizMsgCrypt))
            return wxBizMsgCrypt;

        WeChatApplication account = aggregator.appByIndexThrowable(accountId);
        wxBizMsgCrypt = wxBizMsgCrypt(account);
        if (Objects.nonNull(wxBizMsgCrypt)) {
            CRYPT_CACHE.put(accountId, wxBizMsgCrypt);
            return wxBizMsgCrypt;
        }

        return null;
    }

    public WeChatBusinessCrypt wxBizMsgCrypt(WeChatApplication weChatAccount) {
        String appid = Optional.ofNullable(weChatAccount).map(WeChatApplication::getAppid).orElse(StringUtils.EMPTY);
        if (StringUtils.isBlank(appid))
            return null;
        WeChatBusinessCrypt wxBizMsgCrypt = CRYPT_CACHE.get(appid);
        if (Objects.nonNull(wxBizMsgCrypt))
            return wxBizMsgCrypt;

        wxBizMsgCrypt = doWxBizMsgCrypt(weChatAccount);
        if (Objects.nonNull(wxBizMsgCrypt)){
            CRYPT_CACHE.put(appid,wxBizMsgCrypt);
        }
        return wxBizMsgCrypt;
    }

    public WeChatBusinessCrypt doWxBizMsgCrypt(WeChatApplication weChatAccount) {
        if (Objects.isNull(weChatAccount))
            return null;
        try {
            String encType = weChatAccount.getEncType();
            String aesKey = weChatAccount.getAesKey();
            // 明文通讯
            if (StringUtils.equalsIgnoreCase(encType, "plaintext") || StringUtils.isBlank(aesKey))
                return new WeChatBusinessCrypt(weChatAccount.getToken(), StringUtils.EMPTY, weChatAccount.getAppid());

                // 混合加密或密文通讯
            else
                return new WeChatBusinessCrypt(weChatAccount.getToken(), weChatAccount.getAesKey(), weChatAccount.getAppid());
        } catch (AesException e) {
            log.error("生成微信消息加解密器出现异常:{}", e.getMessage());
            return null;
        }
    }

    public String decrypt(String source, String msg_signature, String timestamp, String nonce) {
        try {
            Map<String, Object> xmlMap = AbstractJacksonUtil.xml2map(source, Object.class);
            WeChatBusinessCrypt crypt = this.wxBizMsgCrypt(String.valueOf(xmlMap.get("ToUserName")));
            String xml = crypt.decryptMsg(msg_signature, timestamp, nonce, String.valueOf(xmlMap.get("Decrypt")));
            log.info("解密消息:\r\n密文：{}\r\n解密后 >>> \r\n明文：{}", xmlMap, xml);
            return xml;
        } catch (Throwable t) {
            log.error("解密错误:{}", t.getMessage(), t);
        }

        return source;
    }

    public String encrypt(String xml, String fromUserName, String timestamp, String nonce) {
        WeChatBusinessCrypt crypt = this.wxBizMsgCrypt(fromUserName);
        String encryptMsg;
        try {
            encryptMsg = crypt.encryptMsg(xml, timestamp, nonce);
            log.info("加密消息：\r\n明文：{} 加密 >>> \r\n密文：{}", xml, encryptMsg);
        } catch (AesException e) {
            log.info("加密消息：{} 异常：{}", xml, e.getMessage(), e);
            encryptMsg = xml;
        }
        return encryptMsg;
    }
}