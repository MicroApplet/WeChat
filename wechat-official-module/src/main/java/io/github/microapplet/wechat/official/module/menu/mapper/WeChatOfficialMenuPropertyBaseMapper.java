/*
 * Copyright 2014 - 2024 <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.microapplet.wechat.official.module.menu.mapper;

import com.mybatisflex.core.BaseMapper;
import io.github.microapplet.wechat.official.module.menu.po.WeChatOfficialMenuProperty;
import org.springframework.stereotype.Repository;

/**
 * 微信公众号菜单配置持久化服务
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0.0
 * @since 2024 07 25, &nbsp;&nbsp; <em>version:1.0.0</em>
 */
@Repository
public interface WeChatOfficialMenuPropertyBaseMapper extends BaseMapper<WeChatOfficialMenuProperty> {
}
