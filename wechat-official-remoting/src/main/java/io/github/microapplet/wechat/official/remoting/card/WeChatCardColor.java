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

package io.github.microapplet.wechat.official.remoting.card;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * 微信卡券颜色
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0.0
 * @since 2024 04 15, &nbsp;&nbsp; <em>version:1.0.0</em>
 */
@Getter
@AllArgsConstructor
public enum WeChatCardColor {
    Color010("#63b359"),
    Color020("#2c9f67"),
    Color030("#509fc9"),
    Color040("#5885cf"),
    Color050("#9062c0"),
    Color060("#d09a45"),
    Color070("#e4b138"),
    Color080("#ee903c"),
    Color081("#f08500"),
    Color082("#a9d92d"),
    Color090("#dd6549"),
    Color100("#cc463d"),
    Color101("#cf3e36"),
    Color102("#5E6671");

    private final String type;

    public static WeChatCardColor colorOf(String color){
        return Arrays.stream(values())
                .filter(item -> StringUtils.equalsAnyIgnoreCase(color, item.getType()))
                .findAny()
                .orElse(Color010);
    }
}