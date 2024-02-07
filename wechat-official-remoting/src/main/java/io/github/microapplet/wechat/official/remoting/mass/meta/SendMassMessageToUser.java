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

package io.github.microapplet.wechat.official.remoting.mass.meta;


import io.github.microapplet.wechat.official.remoting.mass.meta.type.MassMessageType;

import java.util.List;

/**
 * 根据openid列表，向所有用户群发消息
 *
 * @author Copyright © <a href="mailto:asialjim@hotmail.com">Asial Jim</a>   Co., LTD
 * @version 1.0
 * @since 2023/12/27, &nbsp;&nbsp; <em>version:1.0</em>,  &nbsp;&nbsp;  <em>java version:8</em>
 */
@SuppressWarnings("unused")
public interface SendMassMessageToUser extends MassMessageType {
    List<String> getTouser();
    SendNewsMassMessage2UserReq.SendNewsMassMessage2UserReqBuilder newsBuilder = SendNewsMassMessage2UserReq.builder();
    SendTextMassMessage2UserReq.SendTextMassMessage2UserReqBuilder textBuilder = SendTextMassMessage2UserReq.builder();
    SendImageMassMessage2UserReq.SendImageMassMessage2UserReqBuilder imageBuilder = SendImageMassMessage2UserReq.builder();
    SendVideoMassMessage2UserReq.SendVideoMassMessage2UserReqBuilder videoBuilder = SendVideoMassMessage2UserReq.builder();
    SendVoiceMassMessage2UserReq.SendVoiceMassMessage2UserReqBuilder voiceBuilder = SendVoiceMassMessage2UserReq.builder();
    SendWxCardMassMessage2UserReq.SendWxCardMassMessage2UserReqBuilder wxCardBuilder = SendWxCardMassMessage2UserReq.builder();
}