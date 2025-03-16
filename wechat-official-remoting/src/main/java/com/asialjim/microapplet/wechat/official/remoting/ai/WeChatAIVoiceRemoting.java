/*
 *  Copyright 2014-2025 <a href="mailto:asialjim@qq.com">Asial Jim</a>
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.asialjim.microapplet.wechat.official.remoting.ai;

import com.asialjim.microapplet.remote.http.annotation.HttpMapping;
import com.asialjim.microapplet.remote.http.annotation.HttpMethod;
import com.asialjim.microapplet.remote.http.annotation.HttpQuery;
import com.asialjim.microapplet.remote.http.annotation.body.FormData;
import com.asialjim.microapplet.remote.net.annotation.Server;
import com.asialjim.microapplet.wechat.constant.WeChatCons;
import com.asialjim.microapplet.wechat.official.remoting.ai.meta.WeChatQueryRecoResultForTextRes;
import com.asialjim.microapplet.wechat.official.remoting.ai.meta.WeChatTranslateContentRes;
import com.asialjim.microapplet.wechat.remoting.context.BaseWeChatApiRes;
import com.asialjim.microapplet.wechat.remoting.context.WeChatAccessTokenParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@SuppressWarnings("unused")
@Server(
        supplier = WeChatCons.Supplier.WECHAT,
        namespace = WeChatCons.Namespace.COMMON,
        schema = WeChatCons.Api.DEFAULT_SCHEMA,
        host = WeChatCons.Api.DEFAULT_HOST,
        port = WeChatCons.Api.DEFAULT_PORT
)
public interface WeChatAIVoiceRemoting {

    /**
     * 新增语音识别任务
     *
     * @param weChatIndex {@link String weChatIndex}
     * @param format      {@link String format}
     * @param file        {@link File file}
     * @return {@link BaseWeChatApiRes }
     * @since 2023/12/14
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/media/voice/addvoicetorecofortext", queries = @HttpQuery(name = "lang", value = "zh_CN"))
    BaseWeChatApiRes addVoiceToRecoForText(@WeChatAccessTokenParam String weChatIndex, @HttpQuery(name = "format") String format, @HttpQuery(name = "voice_id") String voice, @FormData File file);

    /**
     * 新增语音识别任务
     *
     * @param weChatIndex {@link String weChatIndex}
     * @param format      {@link String format}
     * @param file        {@link MultipartFile file}
     * @return {@link BaseWeChatApiRes}
     * @since 2023/12/14
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/media/voice/addvoicetorecofortext", queries = @HttpQuery(name = "lang", value = "zh_CN"))
    BaseWeChatApiRes addVoiceToRecoForText(@WeChatAccessTokenParam String weChatIndex, @HttpQuery(name = "format") String format, @HttpQuery(name = "voice_id") String voice, @FormData MultipartFile file);

    /**
     * 获取语音识别结果
     *
     * @param weChatIndex {@link String weChatIndex}
     * @param voice       {@link String format}
     * @return {@link BaseWeChatApiRes}
     * @since 2023/12/14
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/media/voice/queryrecoresultfortext", queries = @HttpQuery(name = "lang", value = "zh_CN"))
    WeChatQueryRecoResultForTextRes queryRecoResultForText(@WeChatAccessTokenParam String weChatIndex, @HttpQuery(name = "voice_id") String voice);

    /**
     * 语音翻译
     *
     * @param weChatIndex {@link String weChatIndex}
     * @param from        {@link String from}
     * @param to          {@link String to}
     * @param file        {@link File file}
     * @return {@link WeChatTranslateContentRes}
     * @since 2023/12/14
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/media/voice/translatecontent")
    WeChatTranslateContentRes translateContent(@WeChatAccessTokenParam String weChatIndex, @HttpQuery(name = "lfrom") String from, @HttpQuery(name = "lto") String to, @FormData File file);

    /**
     * 语音翻译
     *
     * @param weChatIndex {@link String weChatIndex}
     * @param from        {@link String from}
     * @param to          {@link String to}
     * @param file        {@link File file}
     * @return {@link WeChatTranslateContentRes}
     * @since 2023/12/14
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/media/voice/translatecontent")
    WeChatTranslateContentRes translateContent(@WeChatAccessTokenParam String weChatIndex, @HttpQuery(name = "lfrom") String from, @HttpQuery(name = "lto") String to, @FormData MultipartFile file);

}