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
public interface SendMassMessageToPreview extends MassMessageType {
    String getTouser();
    String getTowxname();
   /*
    SendNewsMassMessage2PreviewReq.SendNewsMassMessage2PreviewReqBuilder newsBuilder = SendNewsMassMessage2PreviewReq.builder();
    SendTextMassMessage2PreviewReq.SendTextMassMessage2PreviewReqBuilder textBuilder = SendTextMassMessage2PreviewReq.builder();
    SendImageMassMessage2PreviewReq.SendImageMassMessage2PreviewReqBuilder imageBuilder = SendImageMassMessage2PreviewReq.builder();
    SendVideoMassMessage2PreviewReq.SendVideoMassMessage2PreviewReqBuilder videoBuilder = SendVideoMassMessage2PreviewReq.builder();
    SendVoiceMassMessage2PreviewReq.SendVoiceMassMessage2PreviewReqBuilder voiceBuilder = SendVoiceMassMessage2PreviewReq.builder();
    SendWxCardMassMessage2PreviewReq.SendWxCardMassMessage2PreviewReqBuilder wxCardBuilder = SendWxCardMassMessage2PreviewReq.builder();
    */
}
