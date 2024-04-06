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
package io.github.microapplet.wechat.constant;

/**
 * 微信常量池 *
 *
 * @author Copyright © <a href="mailto:asialjim@hotmail.com">Asial Jim</a>   Co., LTD
 * @version 1.0
 * @since 2023/1/28, &nbsp;&nbsp; <em>version:1.0</em>, &nbsp;&nbsp; <em>java version:17</em>
 */
public interface WeChatCons {

    /**
     * 微信公众平台供应商常量池
     */
    interface Supplier {
        String WECHAT = "wechat";
    }

    /**
     * 微信公众平台业务命名空间
     */
    interface Namespace {
        /**
         * 微信公众平台通用业务（包含：公众号，小程序等绝大部分业务，域名为：api.weixin.qq.com)
         */
        String COMMON = "common";

        /**
         * 企业微信
         */
        String ENTERPRISE = "enterprise";
        /**
         * 微信支付
         */
        String PAY = "pay";
    }

    /**
     * 微信公众平台API服务器信息
     */
    interface Api {
        String DEFAULT_SCHEMA = "https";
        String DEFAULT_HOST = "api.weixin.qq.com";
        String MP_HOST = "mp.weixin.qq.com";
        /**
         * 通用异地容灾域名
         */
        String API2_HOST = "api2.weixin.qq.com";
        /**
         * 上海域名
         */
        String SHANGHAI_HOST = "sh.api.weixin.qq.com";
        /**
         * 深圳域名
         */
        String SHENZHEN_HOST = "sz.api.weixin.qq.com";
        /**
         * 香港域名
         */
        String HONkONG_HOST = "hk.api.weixin.qq.com";
        /**
         * 企业微信域名
         */
        String ENTERPRISE_HOST = "qyapi.weixin.qq.com";
        /**
         * 微信支付域名
         */
        String PAY_HOST = "api.mch.weixin.qq.com";
        int DEFAULT_PORT = 443;
    }
}