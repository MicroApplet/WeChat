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

package com.asialjim.microapplet.wechat.user;

/**
 * 微信用户仓库
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/10/20, &nbsp;&nbsp; <em>version:1.0</em>
 */
public interface WeChatUserRepository {
    /**
     * 根据 openid 查询指定微信应用用户信息
     *
     * @param openid {@link String openid}
     * @param appid  {@link String appid}
     * @return {@link WeChatUserVo }
     * @since 2025/10/20
     */
    WeChatUserVo queryByOpenidOfAppid(String openid, String appid);

    /**
     * 保存新的用户
     *
     * @param weChatUser {@link WeChatUserVo weChatUser}
     * @since 2025/10/20
     */
    boolean save(WeChatUserVo weChatUser);

    /**
     * 根据 openid 查询指定微信应用用户信息
     *
     * @param openid {@link String openid}
     * @return {@link WeChatUserVo }
     * @since 2025/10/20
     */
    WeChatUserVo queryByOpenid(String openid);

    WeChatUserVo updateAvatarByOpenid(String id, String avatar);

    WeChatUserVo updateNicknameByOpenid(String id, String nickname);
}
