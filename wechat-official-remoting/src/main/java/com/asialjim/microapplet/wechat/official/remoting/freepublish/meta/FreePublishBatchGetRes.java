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

package com.asialjim.microapplet.wechat.official.remoting.freepublish.meta;

import com.asialjim.microapplet.wechat.remoting.context.BaseWeChatApiRes;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

/**
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @since 2024/2/23, &nbsp;&nbsp; <em>version:</em>
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class FreePublishBatchGetRes extends BaseWeChatApiRes {

    
    private static final long serialVersionUID = 3528241390648962886L;

    private Long total_count;
    private Long item_count;
    private List<FreePublishBatchGetItem> item;


    @Data
    public static class FreePublishBatchGetItem {
        private String article_id;
        private Long update_time;
        private FreePublishBatchGetContent content;
    }

    @Data
    public static class FreePublishBatchGetContent {
        private List<FreePublishArticle> news_item;
    }
}