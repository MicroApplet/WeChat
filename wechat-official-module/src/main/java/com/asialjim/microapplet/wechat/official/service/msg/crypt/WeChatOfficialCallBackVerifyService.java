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
package com.asialjim.microapplet.wechat.official.service.msg.crypt;

import com.asialjim.microapplet.wechat.application.WeChatApplication;
import com.asialjim.microapplet.wechat.application.WeChatApplicationRepository;
import com.asialjim.microapplet.wechat.encryt.official.WeChatOfficialMsgCryptService;
import jakarta.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

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


    public boolean checkService(String appid, String signature, String timestamp, String nonce, String echostr) {
        WeChatApplication app = aggregator.appByIndex(appid);
        return checkService(app, signature, timestamp, nonce, echostr);
    }

    public boolean checkService(WeChatApplication app, String signature, String timestamp, String nonce, String echostr) {
        log.info("微信应用：{} 回调服务进入, 参数表：{} {} {} {}", app, signature, timestamp, nonce, echostr);
        if (Objects.isNull(app))
            return false;

        try {
            return weChatOfficialMsgCryptService.verify(app, signature, timestamp, nonce, echostr);
        } catch (Throwable t) {
            return false;
        }
    }

    public ResponseEntity<String> get(String appid,
                                      String signature,
                                      String timestamp,
                                      String nonce,
                                      String echostr) {

        boolean success = checkService(appid, signature, timestamp, nonce, echostr);
        String res = success ? echostr : "false";
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.TEXT_PLAIN).body(res);
    }
}