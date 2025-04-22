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
package com.asialjim.microapplet.wechat.official.module.message;

import com.asialjim.microapplet.wechat.application.WeChatApplication;
import com.asialjim.microapplet.wechat.application.WeChatApplicationRepository;
import com.asialjim.microapplet.wechat.encryt.official.WeChatOfficialMsgCryptService;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 微信公众号回调验签服务
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0.0
 * @since 2024 07 25, &nbsp;&nbsp; <em>version:1.0.0</em>
 */
@Component
public class WeChatOfficialCallBackVerifyService {
    private static final Logger log = LoggerFactory.getLogger(WeChatOfficialCallBackVerifyService.class.getSimpleName());

    @Resource
    private WeChatApplicationRepository.Aggregator aggregator;
    @Resource
    private WeChatOfficialMsgCryptService weChatOfficialMsgCryptService;

    /**
     * 回调地址验签
     *
     * @param signature {@link String signature}
     * @param timestamp {@link String timestamp}
     * @param nonce     {@link String nonce}
     * @param echostr   {@link String echostr}
     * @return {@link Boolean }
     * @since 2024 07 25
     */
    public boolean checkService(String signature, String timestamp, String nonce, String echostr) {
        List<WeChatApplication> weChatApplications = aggregator.allApps();
        if (CollectionUtils.isEmpty(weChatApplications))
            return false;
        for (WeChatApplication weChatApplication : weChatApplications) {
            try {
                boolean verify = weChatOfficialMsgCryptService.verify(weChatApplication, signature, timestamp, nonce, echostr);
                if (verify)
                    return true;
            } catch (Exception ignored) {
                // do nothing here
            }
            log.error("使用：{} 验签失败", weChatApplication);
        }
        return false;
    }
}