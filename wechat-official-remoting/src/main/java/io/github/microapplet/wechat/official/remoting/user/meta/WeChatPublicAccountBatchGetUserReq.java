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
package io.github.microapplet.wechat.official.remoting.user.meta;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <h1><em>ASIAL JIM JAVA DOC</em></h1><hr/>
 * <h2>CLASS DESCRIPTION <i>[ NAME: WeChatPublicAccountBatchgetUserReq ]</i> </h2><strong>
 * <p> 批量获取微信公众号用户信息请求
 * @author Copyright © <a href="mailto:asialjim@hotmail.com">Asial Jim</a>   Co., LTD
 * @version 1.0.0
 * @since 2021/12/29 17:09   &nbsp;&nbsp; JDK 8
 */
@Data
public class WeChatPublicAccountBatchGetUserReq implements Serializable {
    private static final long serialVersionUID = 5124556807176809338L;

    @JsonProperty("user_list")
    private List<UserReq> userList;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserReq implements Serializable{
        private static final long serialVersionUID = -2262126615274366241L;

        private String openid;

        @Builder.Default
        private String lang = "zh_CN";
    }

    public static WeChatPublicAccountBatchGetUserReq create(List<String> openids){
        final List<UserReq> userReqList = openids.stream().map(i -> UserReq.builder().openid(i).build()).collect(Collectors.toList());

        final WeChatPublicAccountBatchGetUserReq req = new WeChatPublicAccountBatchGetUserReq();
        req.setUserList(userReqList);
        return req;
    }
}
