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

package com.asialjim.microapplet.wechat.common.infrastructure.repository.user;

import com.asialjim.microapplet.common.event.BaseAsyncListener;
import com.asialjim.microapplet.wechat.user.WeChatUserLoginEvent;
import com.asialjim.microapplet.wechat.user.WeChatUserRepository;
import com.asialjim.microapplet.wechat.user.WeChatUserVo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * 微信用户登录监听器
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/10/20, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Component
public class WeChatUserLoginListener extends BaseAsyncListener<WeChatUserLoginEvent> {
    @Resource
    private WeChatUserRepository weChatUserRepository;

    @Override
    public void doOnEvent(WeChatUserLoginEvent event) throws Throwable {
        if (Objects.isNull(event))
            return;
        WeChatUserVo weChatUser = event.getWeChatUser();
        if (Objects.isNull(weChatUser))
            return;
        String openid = weChatUser.getOpenid();
        String appid = weChatUser.getAppid();
        WeChatUserVo exist = this.weChatUserRepository.queryByOpenidOfAppid(openid, appid);
        if (Objects.isNull(exist))
            return;
        this.weChatUserRepository.save(weChatUser);
    }
}