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
package io.github.microapplet.wechat.official.remoting.menu.meta;

import lombok.Data;

import java.io.Serializable;

/**
 * <p> 个性化菜单测试请求
 * @author Copyright © <a href="mailto:asialjim@hotmail.com">Asial Jim</a>   Co., LTD
 * @version 1.0.0
 * @since 2021/12/25 15:56   &nbsp;&nbsp; JDK 8
 */
@Data
public class WeChatPublicAccountMenuTryMatchReq implements Serializable {
    private static final long serialVersionUID = 1593280257262618441L;

    private String user_id;
}
