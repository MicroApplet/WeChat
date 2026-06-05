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
 * 资源包信息类
 *
 * @author Asial Jim
 * @version 1.0
 * @since 2025/11/02
 */
@Data
public class LicensePkgInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /**
     * 资源包 ID
     */
    private String pkg_id;
    
    /**
     * 资源包类型
     */
    private Integer pkg_type;
    
    /**
     * 资源包下单时间
     */
    private Long start_time;
    
    /**
     * 资源包过期时间
     */
    private Long end_time;
    
    /**
     * 资源包状态
     * 1为已生效
     * 2为未生效
     * 3为已过期
     */
    private Integer pkg_status;
    
    /**
     * 已使用额度
     */
    private Integer used;
    
    /**
     * 资源包总量
     */
    private Integer all;
    
    /**
     * 最大激活码序号，已废弃
     */
    private Integer max_active_number;
}