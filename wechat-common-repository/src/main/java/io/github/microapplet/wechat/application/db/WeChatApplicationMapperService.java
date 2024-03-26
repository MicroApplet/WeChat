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

package io.github.microapplet.wechat.application.db;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.microapplet.wechat.application.WeChatApplication;
import io.github.microapplet.wechat.application.mapper.WeChatApplicationBaseMapper;
import org.springframework.stereotype.Component;

/**
 * 微信公众平台应用信息数据服务
 *
 * @author Copyright © <a href="mailto:asialjim@hotmail.com">Asial Jim</a>   Co., LTD
 * @version 1.0
 * @since 2023/12/18, &nbsp;&nbsp; <em>version:1.0</em>,  &nbsp;&nbsp;  <em>java version:8</em>
 */
public interface WeChatApplicationMapperService extends IService<WeChatApplication> {

    @Component
    class  WeChatApplicationMapperServiceImpl extends ServiceImpl<WeChatApplicationBaseMapper,WeChatApplication> implements WeChatApplicationMapperService{

    }
}