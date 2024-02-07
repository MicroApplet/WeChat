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

package io.github.microapplet.wechat.application;

import jakarta.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 基于Spring下yaml/yml或者properties的仓库信息
 *
 * @author Copyright © <a href="mailto:asialjim@hotmail.com">Asial Jim</a>   Co., LTD
 * @version 1.0
 * @since 2023/12/18, &nbsp;&nbsp; <em>version:1.0</em>,  &nbsp;&nbsp;  <em>java version:8</em>
 */
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