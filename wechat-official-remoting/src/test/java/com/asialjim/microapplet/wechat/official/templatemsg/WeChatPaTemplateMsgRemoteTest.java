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

package com.asialjim.microapplet.wechat.official.templatemsg;

import com.asialjim.microapplet.remote.proxy.RemoteProxy;
import com.asialjim.microapplet.wechat.official.remoting.templatemsg.WeChatPaTemplateMsgRemoting;
import com.asialjim.microapplet.wechat.official.remoting.templatemsg.meta.WeChatPaAllPrivateMessageTemplateResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

/**
 * 微信公众平台模板消息测试
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0.0
 * @since 2024/3/5, &nbsp;&nbsp; <em>version:1.0.0</em>
 */
@Slf4j
public class WeChatPaTemplateMsgRemoteTest {
    private WeChatPaTemplateMsgRemoting remoting;
    private static final String token = "78_Jn-jDraFyZ7h1xJCI07OtMNMB9zGE0bAfAnes4v0q2BjFUu5MLyG0BI0AQOo_s-923SZn611_moUYitFaCpYXqt9ttGyyhtKBHH2n6Vi5TE8T3uek9E43PuHhdgVNUaAAALDK";
    @Before public void before(){
        this.remoting = RemoteProxy.create(WeChatPaTemplateMsgRemoting.class);
    }

    @Test public void test(){
        WeChatPaAllPrivateMessageTemplateResponse res = remoting.allPrivateTemplate(token);
        System.out.println(res);
    }
}