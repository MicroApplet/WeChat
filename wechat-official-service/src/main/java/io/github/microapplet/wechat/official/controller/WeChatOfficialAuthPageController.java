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

import io.github.microapplet.wechat.official.service.authpage.WeChatOfficialAuthPageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static io.github.microapplet.wechat.official.controller.WeChatOfficialAuthPageController.URI;


/**
 * 微信公众号授权网页链接API
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0.0
 * @since 2024 04 09, &nbsp;&nbsp; <em>version:1.0.0</em>
 */
@RestController
@RequestMapping(URI)
public class WeChatOfficialAuthPageController {
    public static final String URI = "/wechat/official/authpage";

    @Resource private WeChatOfficialAuthPageService authPageService;

}