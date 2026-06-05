/*
 *    Copyright 2014-2025 <a href="mailto:asialjim@qq.com">Asial Jim</a>
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.asialjim.microapplet.wechat.official;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 微信公众号相关组件的Spring配置类
 * <p>
 * 此类作为微信公众号功能模块的核心配置类，通过Spring的自动组件扫描机制，
 * 自动发现并注册微信公众号相关的所有组件到Spring容器中。
 * </p>
 * <p>
 * 使用场景：
 * <ul>
 *     <li>启动微信公众号功能模块</li>
 *     <li>自动配置微信公众号相关组件</li>
 *     <li>作为微服务中微信公众号能力的入口点</li>
 * </ul>
 * </p>
 * @author Asial Jim
 * @since 2.0.0
 */
@Configuration
@ComponentScan
public class WeChatOfficialBean {
}