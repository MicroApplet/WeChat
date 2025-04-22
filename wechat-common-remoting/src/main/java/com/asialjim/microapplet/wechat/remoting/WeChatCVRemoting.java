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

package com.asialjim.microapplet.wechat.remoting;

import com.asialjim.microapplet.remote.http.annotation.HttpMapping;
import com.asialjim.microapplet.remote.http.annotation.HttpMethod;
import com.asialjim.microapplet.remote.http.annotation.HttpQuery;
import com.asialjim.microapplet.remote.http.annotation.body.FormData;
import com.asialjim.microapplet.remote.net.annotation.Server;
import com.asialjim.microapplet.wechat.constant.WeChatCons;
import com.asialjim.microapplet.wechat.remoting.context.WeChatAccessTokenParam;
import com.asialjim.microapplet.wechat.remoting.meta.cv.IdCardCVOcrRes;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * 微信公众平台计算机视觉相关接口
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/3/13, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Server(
        supplier = WeChatCons.Supplier.WECHAT,
        namespace = WeChatCons.Namespace.COMMON,
        schema = WeChatCons.Api.DEFAULT_SCHEMA,
        host = WeChatCons.Api.DEFAULT_HOST,
        port = WeChatCons.Api.DEFAULT_PORT
)
public interface WeChatCVRemoting {

    /**
     * 身份证OCR
     *
     * @param accessToken {@link String accessToken}
     * @param file        {@link MultipartFile file}
     * @return {@link IdCardCVOcrRes }
     * @since 2025/3/13
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cv/ocr/idcard")
    IdCardCVOcrRes idCard(@WeChatAccessTokenParam String accessToken, @FormData(name = "img") MultipartFile file);

    /**
     * 身份证OCR
     *
     * @param accessToken {@link String accessToken}
     * @param file        {@link File file}
     * @return {@link IdCardCVOcrRes}
     * @since 2025/3/13
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cv/ocr/idcard")
    IdCardCVOcrRes idCard(@WeChatAccessTokenParam String accessToken, @FormData(name = "img") File file);

    /**
     * 身份证OCR
     *
     * @param url  {@link String url}
     * @param file {@link MultipartFile file}
     * @return {@link IdCardCVOcrRes }
     * @since 2025/3/13
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cv/ocr/idcard")
    IdCardCVOcrRes idCardUrl(@HttpQuery(name = "img_url") String url, @FormData(name = "img") MultipartFile file);

    /**
     * 身份证OCR
     *
     * @param url  {@link String url}
     * @param file {@link File file}
     * @return {@link IdCardCVOcrRes}
     * @since 2025/3/13
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cv/ocr/idcard")
    IdCardCVOcrRes idCardUrl(@HttpQuery(name = "img_url") String url, @FormData(name = "img") File file);
}