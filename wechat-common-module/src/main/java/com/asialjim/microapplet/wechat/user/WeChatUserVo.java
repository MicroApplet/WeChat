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

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 微信用户视图
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/10/20, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Data
@Accessors(chain = true)
public class WeChatUserVo implements Serializable {
    @Serial
    private static final long serialVersionUID = -8324992163599446098L;

    private String id;
    private String openid;
    private String unionId;
    private String appid;
    private String nickname;
    private String gender;
    private String language;
    private String country;
    private String province;
    private String city;
    private String avatar;
    private LocalDateTime subscribeTime;
    private String remark;
    private String groupId;
    private String tags;
    private String subscribeScene;
    private String qrScene;
    private String qrSceneStr;
    private Boolean deleted;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}