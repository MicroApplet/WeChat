/*
 *    Copyright 2014-2025 <a href="mailto:asialjim@qq.com">Asial Jim</a>
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.asialjim.microapplet.wechat.annotation.access_token;

import com.asialjim.microapplet.remote.annotation.RemoteLifeCycle;
import com.asialjim.microapplet.remote.context.RemoteMethodConfig;
import com.asialjim.microapplet.remote.context.RemoteMethodParameter;
import com.asialjim.microapplet.remote.context.RemoteReqContext;
import com.asialjim.microapplet.remote.context.RemoteResContext;
import com.asialjim.microapplet.remote.lifecycle.callback.Before;
import com.asialjim.microapplet.remote.net.annotation.ServerLifeCycle;
import com.asialjim.microapplet.remote.net.context.RemoteNetNodeKey;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Objects;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@RemoteLifeCycle(AccessTokenProxy.AccessTokenProxyHandler.class)
public @interface AccessTokenProxy {

    class AccessTokenProxyHandler implements RemoteLifeCycle.LifeCycleHandler<AccessTokenProxy>, Before {

        @Override
        public int order() {
            return Integer.MIN_VALUE + 5;
        }


        @Override
        public void doInit(RemoteMethodConfig methodConfig, RemoteMethodParameter methodParameter, AccessTokenProxy annotation) {

        }

        @Override
        public void before(Object data, RemoteMethodConfig methodConfig, RemoteReqContext req, RemoteResContext res, Object[] args) {
            RemoteNetNodeKey node = req.get(ServerLifeCycle.NET_NODE_KEY_GENERIC_KEY);
            Assert.notNull(node,"服务器环境未配置");
            RemoteNetNodeKey proxy = AccessTokenProxyConfiguration.proxy();
            if (Objects.isNull(proxy))
                return;

            if (StringUtils.isNotBlank(proxy.getSchema())) node.setSchema(proxy.getSchema());
            if (StringUtils.isNotBlank(proxy.getHost())) node.setHost(proxy.getHost());
            if (proxy.getPort() != 0) node.setPort(proxy.getPort());
        }
    }
}