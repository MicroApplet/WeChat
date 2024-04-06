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
package io.github.microapplet.wechat.official.remoting.qrcode.meta;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.microapplet.wechat.remoting.context.BaseWeChatApiRes;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


/**
 * 创建公众号二维码服务相应
 *
 * @author Copyright © <a href="mailto:asialjim@hotmail.com">Asial Jim</a>   Co., LTD
 * @version 1.0
 * @since 2022/2/23   &nbsp;&nbsp; JDK 8
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class CreateQrCodeResponse extends BaseWeChatApiRes {
    private static final long serialVersionUID = 6818875578723840455L;

    private String ticket;

    @JsonProperty("expire_seconds")
    private Integer expireSeconds;

    private String url;
}
