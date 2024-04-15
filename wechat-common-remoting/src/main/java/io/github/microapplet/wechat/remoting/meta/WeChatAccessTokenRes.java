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
package io.github.microapplet.wechat.remoting.meta;

import io.github.microapplet.wechat.remoting.context.BaseWeChatApiRes;
import lombok.*;
import lombok.experimental.Accessors;


/**
 * WeChatAccessTokenRes *
 *
 * @author Copyright © <a href="mailto:asialjim@hotmail.com">Asial Jim</a>   Co., LTD
 * @since 2023/1/28, &nbsp;&nbsp; <em>version:</em>, &nbsp;&nbsp; <em>java version:</em>
 */
@Accessors(chain = true)
@ToString(callSuper = true)
@Data(staticConstructor = "create")
@EqualsAndHashCode(callSuper = true)
public class WeChatAccessTokenRes extends BaseWeChatApiRes {
    private static final long serialVersionUID = -8803169692199272138L;

    private String access_token;
    private Integer expires_in;
}