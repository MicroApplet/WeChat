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

package com.asialjim.microapplet.wechat.official.infrastructure.repository.authpage.service;

import com.asialjim.microapplet.wechat.official.infrastructure.repository.authpage.po.OAuthPagePo;
import com.mybatisflex.core.service.IService;

/**
 * 简单授权网页信息仓库
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/9/11, &nbsp;&nbsp; <em>version:1.0</em>
 */
public interface OAuthPageMapperService extends IService<OAuthPagePo> {

    OAuthPagePo pageOf(String appid,String state);

    boolean create(OAuthPagePo vo);
}