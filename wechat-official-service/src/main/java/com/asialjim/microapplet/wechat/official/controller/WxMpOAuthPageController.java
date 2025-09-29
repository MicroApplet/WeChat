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

import com.asialjim.microapplet.wechat.official.service.oauth.WeChatMpOAuthPageService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(WxMpOAuthPageController.path)
public class WxMpOAuthPageController  {
    public static final String path = "/{appid}/oauth/page";

    @Resource
    private WeChatMpOAuthPageService weChatMpOAuthPageService;

    @GetMapping("/{handler}")
    public Object handle(@PathVariable("appid") String appid,
                         @PathVariable("handler") String handler,
                         @RequestParam String code,
                         @RequestParam String state, Model model) {

        return this.weChatMpOAuthPageService.page(appid, handler, code, state, model);
    }
}