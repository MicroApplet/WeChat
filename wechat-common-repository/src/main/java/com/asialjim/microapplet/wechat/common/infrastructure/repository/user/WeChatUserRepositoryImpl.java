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

import com.asialjim.microapplet.wechat.user.WeChatUserRepository;
import com.asialjim.microapplet.wechat.user.WeChatUserVo;
import com.asialjim.microapplet.wechat.common.infrastructure.repository.user.po.WeChatUserPo;
import com.asialjim.microapplet.wechat.common.infrastructure.repository.user.service.WeChatUserMapperService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * 微信用户仓库
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/10/20, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Slf4j
@Component
public class WeChatUserRepositoryImpl implements WeChatUserRepository {
    @Resource
    private WeChatUserMapperService weChatUserMapperService;


    @Override
    public WeChatUserVo queryByOpenidOfAppid(String openid, String appid) {
        WeChatUserPo po = this.weChatUserMapperService.queryByOpenidOfAppid(openid, appid);
        return WeChatUserPo.toVo(po);
    }

    @Override
    public boolean save(WeChatUserVo weChatUser) {
        WeChatUserPo po = WeChatUserPo.fromVo(weChatUser);
        log.info("保存微信用户持久化对象：{}",po);
        if (Objects.isNull(po))
            return false;
        return this.weChatUserMapperService.save(po);
    }

    @Override
    public WeChatUserVo queryByOpenid(String openid) {
        WeChatUserPo po = this.weChatUserMapperService.queryByOpenid(openid);
        return WeChatUserPo.toVo(po);
    }

    @Override
    public WeChatUserVo updateAvatarByOpenid(String id, String avatar) {
        WeChatUserPo po = this.weChatUserMapperService.queryByOpenid(id);
        if (Objects.isNull(po))
            return null;
        po.setAvatar(avatar);
        boolean b = this.weChatUserMapperService.updateById(po);
        log.info("用户：{} 头像：{} 更新结果：{}", id, avatar, b);
        this.weChatUserMapperService.clearCache(po);
        return WeChatUserPo.toVo(po);
    }

    @Override
    public WeChatUserVo updateNicknameByOpenid(String id, String nickname) {
        WeChatUserPo po = this.weChatUserMapperService.queryByOpenid(id);
        if (Objects.isNull(po))
            return null;
        po.setNickname(nickname);
        boolean b = this.weChatUserMapperService.updateById(po);
        log.info("用户：{} 昵称：{} 更新结果：{}", id, nickname, b);
        this.weChatUserMapperService.clearCache(po);
        return WeChatUserPo.toVo(po);
    }
}