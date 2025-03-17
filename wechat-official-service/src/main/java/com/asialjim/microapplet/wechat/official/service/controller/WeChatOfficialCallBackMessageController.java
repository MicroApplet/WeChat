/*
 *  Copyright 2014-2025 <a href="mailto:asialjim@qq.com">Asial Jim</a>
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package com.asialjim.microapplet.wechat.official.service.controller;

import com.asialjim.microapplet.wechat.official.module.message.WeChatOfficialCallBackVerifyService;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * 微信公众号消息、事件回调服务
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0.0
 * @since 2024 07 25, &nbsp;&nbsp; <em>version:1.0.0</em>
 */
@RestController
@RequestMapping("/wechat/official/callback/message")
public class WeChatOfficialCallBackMessageController {
    private static final Logger log = LoggerFactory.getLogger("WeChatOfficialCallBackMessageController");
    @Resource
    private WeChatOfficialCallBackVerifyService verifyService;

    @GetMapping
    @SneakyThrows
    public void get(@RequestParam(required = false) String signature,
                    @RequestParam(required = false) String timestamp,
                    @RequestParam(required = false) String nonce,
                    @RequestParam(required = false) String echostr,
                    @RequestParam(required = false) String code,
                    @RequestParam(required = false) String state,
                    HttpServletResponse response) {

        if (StringUtils.isNoneBlank(timestamp, nonce, signature, echostr)) {
            log.info("公众号服务器配置：Timestamp:{},nonce:{},Signature:{},Echostr:{}", timestamp, nonce, signature, echostr);
            String res = this.verifyService.checkService(signature, timestamp, nonce, echostr) ? echostr : "fail";
            log.info("公众号服务器配置：Timestamp:{},nonce:{},Signature:{},Echostr:{}, Result:{}", timestamp, nonce, signature, echostr, res);
            writeSuccessTextResponse(response, res);
            return;
        }

        if (StringUtils.isAnyBlank(code, state)) {
            String res = StringUtils.EMPTY;
            writeSuccessTextResponse(response, res);
            return;
        }

    }

    @PostMapping
    public void post(@RequestParam(required = false) String signature,
                     @RequestParam(required = false) String timestamp,
                     @RequestParam(required = false) String nonce,
                     @RequestParam(required = false) String openid,
                     @RequestParam(required = false) String encrypt_type,
                     @RequestParam(required = false) String msg_signature,
                     HttpServletRequest request,
                     HttpServletResponse response) {

    }

    private static void writeSuccessTextResponse(HttpServletResponse response, String res) throws IOException {
        response.setStatus(200);
        response.setHeader("Content-Type", "text/plain;charset=UTF-8");
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        PrintWriter writer = response.getWriter();
        writer.write(res);
        writer.flush();
    }
}