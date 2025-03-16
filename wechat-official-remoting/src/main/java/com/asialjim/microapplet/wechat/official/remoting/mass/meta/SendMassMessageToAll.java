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

package com.asialjim.microapplet.wechat.official.remoting.mass.meta;


import com.asialjim.microapplet.wechat.official.remoting.mass.meta.type.MassMessageType;

@SuppressWarnings("unused")
public interface SendMassMessageToAll extends MassMessageType {
    Filter getFilter();
    String getClientmsgid();

    /*
    SendNewsMassMessage2AllReq.SendNewsMassMessage2AllReqBuilder newsBuilder = SendNewsMassMessage2AllReq.builder();
    SendTextMassMessage2AllReq.SendTextMassMessage2AllReqBuilder textBuilder = SendTextMassMessage2AllReq.builder();
    SendImageMassMessage2AllReq.SendImageMassMessage2AllReqBuilder imageBuilder = SendImageMassMessage2AllReq.builder();
    SendVideoMassMessage2AllReq.SendVideoMassMessage2AllReqBuilder videoBuilder = SendVideoMassMessage2AllReq.builder();
    SendVoiceMassMessage2AllReq.SendVoiceMassMessage2AllReqBuilder voiceBuilder = SendVoiceMassMessage2AllReq.builder();
    SendWxCardMassMessage2AllReq.SendWxCardMassMessage2AllReqBuilder wxCardBuilder = SendWxCardMassMessage2AllReq.builder();
    */
}