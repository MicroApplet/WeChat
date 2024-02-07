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

import lombok.AllArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * 微信公众平台应用信息仓库
 *
 * @author Copyright © <a href="mailto:asialjim@hotmail.com">Asial Jim</a>   Co., LTD
 * @version 1.0
 * @since 2023/12/16, &nbsp;&nbsp; <em>version:1.0</em>,  &nbsp;&nbsp;  <em>java version:8</em>
 */
@SuppressWarnings("unused")
public interface WeChatApplicationRepository {

    String PREFIX = "wx:app:all";
    String CACHE = "wx:app:%s";

    /**
     * 获取所有微信应用信息
     * @return {@link List<WeChatApplication>}
     * @since 2023/12/16
     */
    List<WeChatApplication> allApps();

    /**
     * 根据索引查询所有微信应用信息,如果找不到则抛出异常
	 * @param weChatIndex {@link String weChatIndex}
     * @return {@link WeChatApplication}
     * @since 2023/12/16
     */
    default WeChatApplication appByIndexThrowable(String weChatIndex) {
        List<WeChatApplication> apps = allApps();
        WeChatApplication targetById = null;
        WeChatApplication targetByAppId = null;
        WeChatApplication targetBySubjectId = null;
        WeChatApplication targetByName = null;
        for (WeChatApplication app : apps) {
            String id = app.getId();
            if (StringUtils.equalsAnyIgnoreCase(weChatIndex,id)){
                targetById = app;
                break;
            }
            String appid = app.getAppid();
            if (StringUtils.equalsAnyIgnoreCase(weChatIndex,appid)){
                targetByAppId = app;
                break;
            }
            String subjectId = app.getSubjectId();
            if (StringUtils.equalsAnyIgnoreCase(weChatIndex,subjectId)){
                targetBySubjectId = app;
                break;
            }
            String name = app.getName();
            if (StringUtils.equalsAnyIgnoreCase(weChatIndex,name)){
                targetByName = app;
                break;
            }
        }

        if (Objects.nonNull(targetById))
            return targetById;
        if (Objects.nonNull(targetBySubjectId))
            return targetBySubjectId;
        if (Objects.nonNull(targetByAppId))
            return targetByAppId;
        if (Objects.nonNull(targetByName))
            return targetByName;
        throw new IllegalStateException("找不到索引为" + weChatIndex + "的微信应用");
    }

    /**
     * 根据索引查询所有微信应用信息,如果找不到则抛出异常
     *
	 * @param weChatIndex {@link String weChatIndex}
     * @return {@link WeChatApplication}
     * @since 2023/12/16
     */
    default WeChatApplication appByIndex(String weChatIndex){
        try {
            return appByIndexThrowable(weChatIndex);
        } catch (Throwable t){
            return null;
        }
    }

    /**
     * 聚合
     *
     * @author Copyright © <a href="mailto:asialjim@hotmail.com">Asial Jim</a>   Co., LTD
     * @version 1.0
     * @since 2023/12/16, &nbsp;&nbsp; <em>version:1.0</em>,  &nbsp;&nbsp;  <em>java version:8</em>
     */
    @Component
    @AllArgsConstructor
    class Aggregator{
        private final List<WeChatApplicationRepository> repositories;

        /**
         * 获取所有微信应用信息
         * @return {@link List<WeChatApplication>}
         * @since 2023/12/16
         */
        public List<WeChatApplication> allApps(){
            if (CollectionUtils.isNotEmpty(repositories))
                return Collections.emptyList();

            List<WeChatApplication> all = new ArrayList<>();
            for (WeChatApplicationRepository repository : repositories) {
                List<WeChatApplication> apps = repository.allApps();
                all.addAll(apps);
            }

            return all;
        }

        /**
         * 根据索引查询所有微信应用信息,如果找不到则抛出异常
         * @param weChatIndex {@link String weChatIndex}
         * @return {@link WeChatApplication}
         * @since 2023/12/16
         */
        public WeChatApplication appByIndexThrowable(String weChatIndex){
            if (CollectionUtils.isNotEmpty(repositories))
                throw new IllegalStateException("找不到索引为" + weChatIndex + "的微信应用");

            for (WeChatApplicationRepository repository : repositories) {
                try {
                    WeChatApplication weChatApplication = repository.appByIndexThrowable(weChatIndex);
                    if (Objects.nonNull(weChatApplication))
                        return weChatApplication;
                } catch (Throwable ignored){

                }
            }
            throw new IllegalStateException("找不到索引为" + weChatIndex + "的微信应用");
        }

        /**
         * 根据索引查询所有微信应用信息,如果找不到则抛出异常
         *
         * @param weChatIndex {@link String weChatIndex}
         * @return {@link WeChatApplication}
         * @since 2023/12/16
         */
        public WeChatApplication appByIndex(String weChatIndex){
            try {
                return appByIndexThrowable(weChatIndex);
            } catch (Throwable t){
                return null;
            }
        }
    }
}