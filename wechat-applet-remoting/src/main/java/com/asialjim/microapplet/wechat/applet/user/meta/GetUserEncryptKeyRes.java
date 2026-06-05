/*
 * Copyright 2014-2025 <a href="mailto:asialjim@qq.com">Asial Jim</a>
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

package com.asialjim.microapplet.wechat.applet.user.meta;

import com.asialjim.microapplet.wechat.remoting.context.BaseWeChatApiRes;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;
import java.util.List;

/**
 * 获取用户encryptKey响应
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/10/30
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class GetUserEncryptKeyRes extends BaseWeChatApiRes {

    @Serial
    private static final long serialVersionUID = -5850123456789012345L;

    /**
     * 用户最近三次的加密key列表
     */
    private List<KeyInfo> keyInfoList;

    /**
     * 加密key信息
     */
    @Data
    public static class KeyInfo {
        /**
         * 加密key
         */
        private String encryptKey;

        /**
         * key的版本号
         */
        private Integer version;

        /**
         * 剩余有效时间
         */
        private Integer expireIn;

        /**
         * 加密iv
         */
        private String iv;

        /**
         * 创建key的时间戳
         */
        private Long createTime;
    }
}