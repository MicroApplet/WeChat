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


import com.asialjim.microapplet.remote.net.context.RemoteNetNodeKey;
import lombok.Setter;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccessTokenProxyConfiguration implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    public static RemoteNetNodeKey proxy(){

        String[] beanNamesForType = applicationContext.getBeanNamesForType(AccessTokenProxyRepository.class);
        if (ArrayUtils.isEmpty(beanNamesForType))
            return null;

        if (ArrayUtils.getLength(beanNamesForType) > 1)
            throw new IllegalStateException("存在多个 AccessToken 代理仓库实例");

        return applicationContext.getBean(beanNamesForType[0], AccessTokenProxyRepository.class).proxy();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        AccessTokenProxyConfiguration.applicationContext = applicationContext;
    }
}