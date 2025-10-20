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

package com.asialjim.microapplet.wechat.common.infrastructure.repository.user.po;

import com.asialjim.microapplet.wechat.user.WeChatUserVo;
import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import com.mybatisflex.core.keygen.KeyGenerators;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * 微信用户ORM对象
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/10/20, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Data
@Table("wechat_user")
@Accessors(chain = true)
public class WeChatUserPo implements Serializable {
    @Serial
    private static final long serialVersionUID = 317666968069802076L;

    @Id(keyType = KeyType.None,value = KeyGenerators.snowFlakeId)
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
    @Column(onInsertValue = "NOW()")
    private LocalDateTime createTime;
    @Column(onInsertValue = "NOW()", onUpdateValue = "NOW()")
    private LocalDateTime updateTime;

    public static WeChatUserVo toVo(WeChatUserPo po){
        if (Objects.isNull(po))
            return null;

        WeChatUserVo vo = new WeChatUserVo();
        BeanUtils.copyProperties(po,vo);
        return vo;
    }

    public static WeChatUserPo fromVo(WeChatUserVo vo){
        if (Objects.isNull(vo))
            return null;
        WeChatUserPo po = new WeChatUserPo();
        BeanUtils.copyProperties(vo,po);
        return po;
    }
}