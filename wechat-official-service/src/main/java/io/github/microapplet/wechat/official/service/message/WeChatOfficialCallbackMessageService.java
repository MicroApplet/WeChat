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
package io.github.microapplet.wechat.official.service.message;


import io.github.microapplet.wechat.official.controller.WeChatOfficialMessageController;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;


import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * 微信公众号消息服务
 *
 * @author Copyright © <a href="mailto:asialjim@hotmail.com">Asial Jim</a>   Co., LTD
 * @version 4.0
 * @since 2023/4/11, &nbsp;&nbsp; <em>version:4.0</em>, &nbsp;&nbsp; <em>java version:8</em>
 */
@Slf4j
@Component
public class WeChatOfficialCallbackMessageService {
    @Resource private WeChatOfficialCallBackMsgService weChatOfficialCallBackMsgService;

    public void message(String signature,
                        String timestamp,
                        String nonce,
                        String echoStr,
                        String code,
                        String state,
                        HttpServletResponse response) {

        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            // verify
            if (StringUtils.isNoneBlank(signature, timestamp, nonce, echoStr)) {
                log.info("腾讯服务器连接地址验签，参数：signature:" + signature + ",timestamp:" + timestamp + ",nonce:" + nonce + ",echostr:" + echoStr);
                String result = weChatOfficialCallBackMsgService.check(signature, timestamp, nonce) ? echoStr : "false";
                response.addHeader("Content-Type", "text/plain; charset=UTF-8");
                outputStream.write(result.getBytes(StandardCharsets.UTF_8));
                outputStream.flush();
                return;
            }

            // auth page
            if (StringUtils.isNoneBlank(code, state)) {
                String redirect = weChatOfficialCallBackMsgService.redirect(code, state);
                response.sendRedirect(redirect);
                return;
            }
            throw new IllegalStateException("非法访问：GET >>> " + WeChatOfficialMessageController.URI);
        } catch (Throwable t) {
            response.addHeader("Content-Type", "text/plain; charset=UTF-8");
            response.setCharacterEncoding(StandardCharsets.UTF_8.name());
            byte[] res = ("UnSupport Operation: " + t.getMessage()).getBytes(StandardCharsets.UTF_8);
            try {
                if (Objects.nonNull(outputStream)) outputStream.write(res);
                if (Objects.nonNull(outputStream)) outputStream.flush();
            } catch (Throwable ignore) {

            }
        }
    }

    public void message(String signature,
                        String timestamp,
                        String nonce,
                        String openid,
                        String echoStr,
                        String encryptType,
                        String msgSignature,
                        HttpServletRequest request,
                        HttpServletResponse response) {

        log.info("\r\n\tWeChat Pa Callback Msg in, signature：{}，timestamp：{}，nonce：{}，openid:{}，echoStr:{}, encryptType:{}, msgSignature:{}", signature, timestamp, nonce, openid, echoStr, encryptType, msgSignature);

        try {
            String xml = IOUtils.toString(request.getInputStream(), request.getCharacterEncoding());
            String replyMsg = weChatOfficialCallBackMsgService.event(xml, signature, timestamp, nonce, encryptType);
            writeBack(replyMsg, response);
        } catch (Throwable t) {
            log.info("Event for Message: {} Exception: {}", timestamp, t.getMessage());
        }
    }

    private void writeBack(String msg, HttpServletResponse response) {
        ServletOutputStream outputStream;
        try {
            outputStream = response.getOutputStream();
            response.setContentType("text/plain;charset=UTF-8");
            outputStream.write(msg.getBytes(StandardCharsets.UTF_8));
            outputStream.flush();
        } catch (Throwable t) {
            log.info("Write for Message: {} Exception: {}", msg, t.getMessage());
        }
    }
}