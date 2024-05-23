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
package io.github.microapplet.wechat.remoting.context;

import io.github.microapplet.remote.annotation.RemoteLifeCycle;
import io.github.microapplet.remote.context.*;
import io.github.microapplet.remote.http.annotation.lifecycle.AbstractHttpQueryLifeCycle;
import io.github.microapplet.remote.lifecycle.callback.*;
import org.apache.commons.lang3.StringUtils;

import java.lang.annotation.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import static io.github.microapplet.remote.annotation.Retryable.RETRY_ABLE_KEY;


/**
 * 微信公众号平台应用编号 *
 * <p/>
 * 根据微信应用索引，获取微信接口令牌，并负载到查询参数
 *
 * @author Copyright © <a href="mailto:asialjim@hotmail.com">Asial Jim</a>   Co., LTD
 * @version 1.0
 * @since 2023/1/28, &nbsp;&nbsp; <em>version:1.0</em>, &nbsp;&nbsp; <em>java version:17</em>
 */
@Documented
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@RemoteLifeCycle(WeChatAccessTokenParam.WeChatAccessTokenLifeCycle.class)
public @interface WeChatAccessTokenParam {

    final class WeChatAccessTokenLifeCycle implements  Before, SuccessWhen, RetryWhen, OnRetry, RemoteLifeCycle.LifeCycleHandler<WeChatAccessTokenParam> {
        private static final GenericKey<RemoteMethodParameter> ACCESS_TOKEN_CONFIG_KEY = GenericKey.keyOf("ACCESS_TOKEN_CONFIG");

        @Override
        public void doInit(RemoteMethodConfig methodConfig, RemoteMethodParameter methodParameter, WeChatAccessTokenParam annotation) {
            methodConfig.config(ACCESS_TOKEN_CONFIG_KEY, methodParameter);
        }

        @Override
        public void before(Object data, RemoteMethodConfig methodConfig, RemoteReqContext req, RemoteResContext res, Object[] args) {
            req.put(RETRY_ABLE_KEY, Boolean.TRUE);
            RemoteMethodParameter parameter = methodConfig.config(ACCESS_TOKEN_CONFIG_KEY);
            String wechatIndex = (String) args[parameter.getIndex()];
            String accessToken = doQueryAccessToken(wechatIndex);

            Map<String, String> query = Optional.ofNullable(req.get(AbstractHttpQueryLifeCycle.HTTP_QUERY_VALUE)).orElseGet(HashMap::new);
            query.put("access_token", accessToken);

            req.put(AbstractHttpQueryLifeCycle.HTTP_QUERY_VALUE, query);
        }

        @Override
        public void onRetry(Object data, RemoteMethodConfig methodConfig, RemoteReqContext req, RemoteResContext res, Object[] args) {
            RemoteMethodParameter parameter = methodConfig.config(ACCESS_TOKEN_CONFIG_KEY);
            String wechatIndex = (String) args[parameter.getIndex()];

            WeChatAccessTokenRepositoryHolder.repository().refreshAccessToken(wechatIndex);
        }

        @Override
        public boolean retryWhen(Object data, RemoteMethodConfig methodConfig, RemoteReqContext req, RemoteResContext res, Object[] args) {
            if (Objects.isNull(data) || !(data instanceof WeChatApiRes))
                return false;
            WeChatApiRes apiRes = (WeChatApiRes) data;
            RemoteMethodParameter parameter = methodConfig.config(ACCESS_TOKEN_CONFIG_KEY);
            String weChatIndex = (String) args[parameter.getIndex()];
            String accessToken = doQueryAccessToken(weChatIndex);
            // access token 即用户传入的值
            if (StringUtils.equals(weChatIndex, accessToken))
                return false;

            // access token 错误：过期，或者错误等
            switch (apiRes.apiResultEnumeration()){
                case CODE_40001:
                case CODE_40014:
                case CODE_42001:
                    return true;
                default:
                    return false;
            }
        }

        @Override
        public boolean success(Object data, RemoteMethodConfig methodConfig, RemoteReqContext req, RemoteResContext res, Object[] args) {
            if (Objects.isNull(data) || !(data instanceof WeChatApiRes))
                return false;

            WeChatApiRes apiRes = (WeChatApiRes) data;
            return apiRes.success();
        }

        private String doQueryAccessToken(final String weChatIndex) {
            try {
                String accessToken = WeChatAccessTokenRepositoryHolder.repository().accessToken(weChatIndex);
                if (StringUtils.isNotBlank(accessToken))
                    return accessToken;
            } catch (Throwable t) {
                log.warn("获取微信：【{}】AccessToken失败：{}", weChatIndex, t.getMessage(), t);
            }

            return weChatIndex;
        }
    }
}