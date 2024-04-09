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

package io.github.microapplet.wechat.official.controller;

import io.github.microapplet.wechat.official.service.message.WeChatOfficialCallbackMessageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static io.github.microapplet.wechat.official.controller.WeChatOfficialMessageController.URI;

/**
 * 微信公众号消息API
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0.0
 * @since 2024 04 07, &nbsp;&nbsp; <em>version:1.0.0</em>
 */
@RestController
@RequestMapping(URI)
public class WeChatOfficialMessageController {
    public static final String URI = "/wechat/official/message";
    @Resource
    private WeChatOfficialCallbackMessageService weChatPaCallbackMessageService;

    @GetMapping
    public void message(@RequestParam(required = false) final String signature,
                        @RequestParam(required = false) final String timestamp,
                        @RequestParam(required = false) final String nonce,
                        @RequestParam(required = false) final String echostr,
                        @RequestParam(required = false) final String code,
                        @RequestParam(required = false) final String state,
                        final HttpServletResponse response) {

        this.weChatPaCallbackMessageService.message(signature, timestamp, nonce, echostr, code, state, response);
    }

    @PostMapping
    public void paCallback(@RequestParam(required = false) final String signature,
                           @RequestParam(required = false) final String timestamp,
                           @RequestParam(required = false) final String nonce,
                           @RequestParam(required = false) final String openid,
                           @RequestParam(required = false) final String echoStr,
                           @RequestParam(required = false) final String encrypt_type,
                           @RequestParam(required = false) final String msg_signature,
                           final HttpServletRequest request,
                           final HttpServletResponse response) {

        this.weChatPaCallbackMessageService.message(signature, timestamp, nonce, openid, echoStr, encrypt_type, msg_signature, request, response);
    }
}