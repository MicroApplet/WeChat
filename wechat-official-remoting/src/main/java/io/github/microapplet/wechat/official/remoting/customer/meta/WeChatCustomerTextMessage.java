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

package io.github.microapplet.wechat.official.remoting.customer.meta;

import io.github.microapplet.wechat.official.remoting.customer.meta.item.CustomerService;
import io.github.microapplet.wechat.official.remoting.customer.meta.item.Text;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;


/**
 *  we-chat text customer message
 *
 * @author Asial Jim &nbsp;&nbsp; <span>Email:<a href="mailto:asialjim@hotmail.com">asialjim@hotmail.com</a> &nbsp;&nbsp; <a href="asialjim@qq.com">asialjim@qq.com</a></span>
 * @version 1.0.0
 * @since 2021/3/8   &nbsp;&nbsp; JDK 8
 */
@Data
@SuppressWarnings("unused")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class WeChatCustomerTextMessage extends WeChatCustomerMessage {

    @Serial
    private static final long serialVersionUID = -7415665351819058394L;

    public WeChatCustomerTextMessage() {
        super();
        setMsgtype("text");
    }

    public WeChatCustomerTextMessage(Text text, CustomerService customservice) {
        super();
        setMsgtype("text");
        this.text = text;
        this.customservice = customservice;
    }

    private Text text;
    private CustomerService customservice;
}