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
package com.asialjim.microapplet.wechat.official.remoting.user.meta;

import com.asialjim.microapplet.wechat.remoting.context.BaseWeChatApiRes;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class WeChatPublicAccountUserInfo extends BaseWeChatApiRes {
    
    private static final long serialVersionUID = -1162752012211929256L;

    private String openid;
    private String nickname;
    private Integer sex;
    private String province;
    private String city;
    private String country;

    @JsonProperty("headimgurl")
    private String headImgUrl;

    private List<String> privilege;
    private String unionid;

    /**是否关注  1关注 0 未关注*/
    private Integer subscribe;
    private String language;
    @JsonProperty("subscribe_time")
    private Long subscribeTime;
    private String remark;
    @JsonProperty("groupid")
    private Integer groupId;
    @JsonProperty("tagid_list")
    private List<Integer> tagIdList;
    @JsonProperty("subscribe_scene")
    private String subscribeScene;
    @JsonProperty("qr_scene")
    private Integer qrScene;
    @JsonProperty("qr_scene_str")
    private String qrSceneStr;
    private String subjectId;
}