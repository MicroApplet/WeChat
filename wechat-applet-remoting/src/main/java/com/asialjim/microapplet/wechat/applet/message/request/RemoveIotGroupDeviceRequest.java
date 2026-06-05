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

import com.asialjim.microapplet.wechat.applet.message.meta.DeviceListItem;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 设备组删除设备请求参数
 *
 * @author <a href="mailto:asialjim@qq.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/11/02
 */
@Data
public class RemoveIotGroupDeviceRequest implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    /**
     * 设备组的唯一标识
     */
    private String group_id;
    
    /**
     * 设备列表
     */
    private List<DeviceListItem> device_list;
}