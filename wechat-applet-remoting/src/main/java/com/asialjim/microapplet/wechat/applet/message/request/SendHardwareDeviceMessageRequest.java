/*
 * Copyright 2025 Asial Jim.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.asialjim.microapplet.wechat.applet.message.request;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 发送设备消息请求参数
 *
 * @author <a href="mailto:asialjim@qq.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/11/02, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Data
public class SendHardwareDeviceMessageRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 所需下发的订阅模板id
     */
    private String template_id;

    /**
     * 设备唯一序列号。由厂商分配，长度不能超过128字节。字符只接受数字，大小写字母，下划线（_）和连字符（-）
     */
    private String sn;

    /**
     * 点击模板卡片后的跳转页面，仅限本小程序内的页面。支持带参数,（示例index?foo=bar）。该字段不填则模板无跳转
     */
    private String page;

    /**
     * 接收者（用户）的 openid 列表
     */
    private List<String> to_openid_list;

    /**
     * 跳转小程序类型：developer为开发版；trial为体验版；formal为正式版；默认为正式版
     */
    private String miniprogram_state;

    /**
     * 设备型号 id ，通过注册设备获得
     */
    private String modelId;

    /**
     * 模板内容，格式形如 { "key1": { "value": "xxx" }, "key2": { "value": "xxx" } }
     */
    private Map<String, TemplateData> data;

    /**
     * 进入小程序查看”的语言类型，支持zh_CN(简体中文)、en_US(英文)、zh_HK(繁体中文)、zh_TW(繁体中文)，默认为zh_CN
     */
    private String lang;

    /**
     * 模板数据项
     */
    @Data
    public static class TemplateData implements Serializable {
        private static final long serialVersionUID = 1L;

        /**
         * 模板数据值
         */
        private String value;
    }
}