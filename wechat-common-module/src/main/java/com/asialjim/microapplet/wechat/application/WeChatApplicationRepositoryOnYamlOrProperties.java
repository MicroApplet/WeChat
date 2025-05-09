/*
 * Copyright 2014-2025 <a href="mailto:asialjim@qq.com">Asial Jim</a>
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

package com.asialjim.microapplet.wechat.application;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class WeChatApplicationRepositoryOnYamlOrProperties implements WeChatApplicationRepository {
    @Resource
    private WeChatApplicationConfigProperty weChatApplicationConfigProperty;


    @Override
    public List<WeChatApplication> allApps() {
        List<WeChatApplicationConfigProperty.WeChatApplicationProperty> list = weChatApplicationConfigProperty.getApplications();
        if (CollectionUtils.isEmpty(list))
            return Collections.emptyList();
        return list.stream().map(WeChatApplicationConfigProperty.WeChatApplicationProperty::weChatApplication).collect(Collectors.toList());
    }
}