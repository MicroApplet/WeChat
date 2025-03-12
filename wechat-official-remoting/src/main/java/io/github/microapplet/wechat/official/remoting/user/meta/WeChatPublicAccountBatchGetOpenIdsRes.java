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
import io.github.microapplet.wechat.remoting.context.BaseWeChatApiRes;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


import java.io.Serializable;
import java.util.List;

/**
 * <h1><em>ASIAL JIM JAVA DOC</em></h1><hr/>
 * <h2>CLASS DESCRIPTION <i>[ NAME: WeChatPublicAccountBatchgetOpenIdsRes ]</i> </h2><strong>
 * <p> 批量获取微信公众号关注用户openid
 * @author Copyright © <a href="mailto:asialjim@hotmail.com">Asial Jim</a>   Co., LTD>
 * @version 1.0.0
 * @since 2021/12/29 17:21   &nbsp;&nbsp; JDK 8
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class WeChatPublicAccountBatchGetOpenIdsRes extends BaseWeChatApiRes {
    
    private static final long serialVersionUID = 2501932361761225534L;

    private Integer total;
    private Integer count;
    private GetWeChatUserOpenIdListData data;
    @JsonProperty("next_openid")
    private String nextOpenId;

    @Data
    public static class GetWeChatUserOpenIdListData implements Serializable {
        
        private static final long serialVersionUID = -5165248657534683275L;

        private List<String> openid;
    }
}
