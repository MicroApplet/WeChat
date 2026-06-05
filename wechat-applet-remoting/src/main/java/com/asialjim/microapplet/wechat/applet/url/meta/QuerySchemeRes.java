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

package com.asialjim.microapplet.wechat.applet.url.meta;

import com.asialjim.microapplet.wechat.remoting.context.BaseWeChatApiRes;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 查询小程序scheme码响应结果
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/10/30
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class QuerySchemeRes extends BaseWeChatApiRes {
    
    /**
     * scheme信息
     */
    private SchemeInfo schemeInfo;
    
    /**
     * quota配置
     */
    private QuotaInfo quotaInfo;
    
    /**
     * scheme信息
     */
    @Data
    @Accessors(chain = true)
    public static class SchemeInfo {
        
        /**
         * 小程序appid
         */
        private String appid;
        
        /**
         * 小程序页面路径
         */
        private String path;
        
        /**
         * 小程序页面query
         */
        private String query;
        
        /**
         * 创建时间，为Unix时间戳
         */
        private Long createTime;
        
        /**
         * 到期失效时间，为Unix时间戳，0表示永久生效
         */
        private Long expireTime;
        
        /**
         * 要打开的小程序版本。正式版为"release"，体验版为"trial"，开发版为"develop"
         */
        private String envVersion;
    }
    
    /**
     * quota配置
     */
    @Data
    @Accessors(chain = true)
    public static class QuotaInfo {
        
        /**
         * URL Scheme（加密+明文）/加密URL Link单天剩余访问次数
         */
        private Integer remainVisitQuota;
    }
}