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

package com.asialjim.microapplet.wechat.applet.url.request;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 获取小程序scheme码请求参数
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/10/30
 */
@Data
@Accessors(chain = true)
public class GenerateSchemeRequest {
    
    /**
     * 跳转到的目标小程序信息
     */
    private JumpWxa jumpWxa;
    
    /**
     * 到期失效的scheme码的失效时间，为Unix时间戳。生成的到期失效scheme码在该时间前有效。最长有效期为30天。
     * is_expire为true且expire_type为0时必填
     */
    private Long expireTime;
    
    /**
     * 默认值0，到期失效的scheme码失效类型
     * 0: 失效时间
     * 1: 失效间隔天数
     */
    private Integer expireType = 0;
    
    /**
     * 到期失效的scheme码的失效间隔天数。生成的到期失效scheme码在该间隔时间到达前有效。最长间隔天数为30天。
     * is_expire为true且expire_type为1时必填
     */
    private Integer expireInterval;
    
    /**
     * 跳转到的目标小程序信息
     */
    @Data
    @Accessors(chain = true)
    public static class JumpWxa {
        
        /**
         * 通过scheme码进入的小程序页面路径，必须是已经发布的小程序存在的页面，不可携带query。
         * path为空时会跳转小程序主页
         */
        private String path;
        
        /**
         * 通过scheme码进入小程序时的query，最大1024个字符，只支持数字，大小写英文以及部分特殊字符：!#$&'()*+,/:;=?@-._~%
         */
        private String query;
        
        /**
         * 默认值"release"。要打开的小程序版本。正式版为"release"，体验版为"trial"，开发版为"develop"，仅在微信外打开时生效
         */
        private String envVersion = "release";
    }
}