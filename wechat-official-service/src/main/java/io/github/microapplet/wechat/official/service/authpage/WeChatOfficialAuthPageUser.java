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

package io.github.microapplet.wechat.official.service.authpage;

import io.github.microapplet.wechat.official.remoting.user.meta.WeChatPublicAccountUserAccessTokenRes;
import io.github.microapplet.wechat.official.remoting.user.meta.WeChatPublicAccountUserInfo;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;

/**
 * 微信公众号授权网页链接用户信息
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0.0
 * @since 2024 04 09, &nbsp;&nbsp; <em>version:1.0.0</em>
 */
@Data
@Accessors(chain = true)
public class WeChatOfficialAuthPageUser {
    private String redirectUrl;
    private WeChatPublicAccountUserInfo userInfo;
    private WeChatPublicAccountUserAccessTokenRes accessTokenRes;

    public static WeChatOfficialAuthPageUser create(String redirectUrl,
                                                    WeChatPublicAccountUserInfo userInfo,
                                                    WeChatPublicAccountUserAccessTokenRes accessTokenRes){

        WeChatOfficialAuthPageUser user = new WeChatOfficialAuthPageUser();
        user.setUserInfo(userInfo);
        user.setAccessTokenRes(accessTokenRes);
        String accessToken = accessTokenRes.getAccessToken();
        redirectUrl = redirectUrl + "&AToken=" + accessToken;
        if (!StringUtils.contains(redirectUrl, "?"))
            redirectUrl = redirectUrl.replaceFirst("&","?");

        return user.setRedirectUrl(redirectUrl);
    }
}