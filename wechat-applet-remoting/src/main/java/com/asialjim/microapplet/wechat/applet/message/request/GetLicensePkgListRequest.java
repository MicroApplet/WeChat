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

/**
 * 查询license资源包列表请求类
 *
 * @author Asial Jim
 * @version 1.0
 * @since 2025/11/02
 */
@Data
public class GetLicensePkgListRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /**
     * 资源包类型
     * 0：测试体验包
     * 1：A 类设备
     * 2：B 类设备
     * 3：C 类设备
     * 4：D 类设备
     * 5：E类设备
     */
    private Integer pkg_type;
}