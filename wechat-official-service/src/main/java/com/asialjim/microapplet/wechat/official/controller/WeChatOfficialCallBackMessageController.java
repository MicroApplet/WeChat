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
package com.asialjim.microapplet.wechat.official.controller;

import com.asialjim.microapplet.wechat.official.service.msg.crypt.WeChatOfficialCallBackVerifyService;
import com.asialjim.microapplet.wechat.official.service.msg.WxMpMsgCallbackService;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;

/**
 * 微信公众号消息、事件回调服务
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0.0
 * @since 2024 07 25, &nbsp;&nbsp; <em>version:1.0.0</em>
 */
@Controller
@RequestMapping("/{appid}/msg/callback")
public class WeChatOfficialCallBackMessageController {
    @Resource
    private WeChatOfficialCallBackVerifyService weChatOfficialCallBackVerifyService;
    @Resource
    private WxMpMsgCallbackService wxMpMsgCallbackService;

    @GetMapping
    public ResponseEntity<String> get(@PathVariable("appid") String appid,
                                      @RequestParam(required = false) String signature,
                                      @RequestParam(required = false) String timestamp,
                                      @RequestParam(required = false) String nonce,
                                      @RequestParam(required = false) String echostr) {
        return this.weChatOfficialCallBackVerifyService.get(appid, signature, timestamp, nonce, echostr);
    }


    @PostMapping
    public ResponseEntity<String> post(@PathVariable("appid") String appid,
                                       @RequestParam(required = false) String signature,
                                       @RequestParam(required = false) String timestamp,
                                       @RequestParam(required = false) String nonce,
                                       @RequestParam(required = false) String openid,
                                       @RequestParam(required = false) String encrypt_type,
                                       @RequestParam(required = false) String msg_signature,
                                       RequestEntity<String> requestEntity) {

        return this.wxMpMsgCallbackService.post(appid, signature, timestamp, nonce, openid, encrypt_type, msg_signature, requestEntity);
    }
}