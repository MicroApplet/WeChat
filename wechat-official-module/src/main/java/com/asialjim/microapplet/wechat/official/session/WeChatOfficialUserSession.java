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

import com.asialjim.microapplet.wechat.user.WeChatUserSession;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * 公众号用户会话信息
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/3/13, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class WeChatOfficialUserSession extends WeChatUserSession implements Serializable {
    private static final long serialVersionUID = 7066981381160893496L;

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("refresh_token")
    private String refreshToken;

    @JsonProperty("is_snapshotuser")
    private Long isSnapshotUser;

    @JsonProperty("expires_in")
    private Long expiresIn;

    private String scope;
}