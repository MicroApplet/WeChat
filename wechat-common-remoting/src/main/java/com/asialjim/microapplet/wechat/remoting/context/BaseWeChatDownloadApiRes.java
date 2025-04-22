/*
 * Copyright 2014-2025 <a href="mailto:asialjim@qq.com">Asial Jim</a>
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

package com.asialjim.microapplet.wechat.remoting.context;

import com.asialjim.microapplet.remote.net.response.BufferResponse;
import com.asialjim.microapplet.remote.net.response.ResWithHeader;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.activation.MimeType;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 下载文件API基础响应类型
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0.0
 * @since 2024/2/22, &nbsp;&nbsp; <em>version:1.0.0</em>
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BaseWeChatDownloadApiRes extends BaseWeChatApiRes implements BufferResponse, ResWithHeader {


    private static final long serialVersionUID = -3151047355012345095L;
    private String fileName;
    private String contentType;
    private MimeType mimeType;
    private Long contentLength;
    private byte[] buffer;
    private Map<String,String> headers;

    @Override
    public void addHeader(String name, String value) {
        if (Objects.isNull(this.headers)){
            synchronized (this){
                if (Objects.isNull(this.headers))
                    this.headers = new HashMap<>();
            }
        }

        this.headers.put(name,value);
    }
}