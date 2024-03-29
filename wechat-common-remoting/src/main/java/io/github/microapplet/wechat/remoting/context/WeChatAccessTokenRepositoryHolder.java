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

 import java.util.Objects;

 /**
  * 微信基础API 令牌仓库
  *
  * @author Copyright ? <a href="mailto:asialjim@hotmail.com">Asial Jim</a>   Co., LTD
  * @version 4.0
  * @since 2023/4/24, &nbsp;&nbsp; <em>version:4.0</em>, &nbsp;&nbsp; <em>java version:8</em>
  */
 public class WeChatAccessTokenRepositoryHolder {
     private static WeChatAccessTokenRepository tokenRepository;

     public static void repository(WeChatAccessTokenRepository repository) {
         tokenRepository = repository;
     }

     public static WeChatAccessTokenRepository repository() {
         if (Objects.isNull(tokenRepository))
             throw new IllegalStateException("微信接口令牌数据仓库未初始化");
         return tokenRepository;
     }
 }