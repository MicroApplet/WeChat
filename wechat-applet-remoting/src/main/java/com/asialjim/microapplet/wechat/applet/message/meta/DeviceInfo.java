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
 * 设备信息
 *
 * @author <a href="mailto:asialjim@qq.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/11/02, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Data
public class DeviceInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 设备型号唯一标识
     */
    private String model_id;

    /**
     * 设备的唯一标识
     */
    private String sn;

    /**
     * 设备型号的唯一标识（文档中重复出现，保留以确保兼容性）
     */
    private String model_id_dup;

    /**
     * 设备类型
     */
    private String model_type;

}