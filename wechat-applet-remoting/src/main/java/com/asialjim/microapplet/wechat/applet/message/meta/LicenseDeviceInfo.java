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
package com.asialjim.microapplet.wechat.applet.message.meta;

import lombok.Data;

import java.io.Serializable;

/**
 * 用于查询设备激活详情的设备信息类
 *
 * @author <a href="mailto:asialjim@qq.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/11/02, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Data
public class LicenseDeviceInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /**
     * 设备型号 id。通过微信公众平台注册设备获得。
     */
    private String model_id;
    
    /**
     * 设备唯一序列号。由厂商分配。
     */
    private String sn;
}