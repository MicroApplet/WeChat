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

package io.github.microapplet.wechat.official.remoting.draft.meta;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;

/**
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @since 2024/2/22, &nbsp;&nbsp; <em>version:</em>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DraftArticle implements Serializable {

    
    private static final long serialVersionUID = -5232829056873416683L;
    private String title;
    private String author;
    /**
     * 图文消息的摘要，仅有单图文消息才有摘要，多图文此处为空。如果本字段为没有填写，则默认抓取正文前54个字。
     */
    private String digest;
    /**
     * 图文消息的具体内容，支持HTML标签，必须少于2万字符，小于1M，且此处会去除JS,涉及图片url必须来源 "上传图文消息内的图片获取URL"接口获取。外部图片url将被过滤。
     */
    private String content;
    /**
     * 图文消息的原文地址，即点击“阅读原文”后的URL
     */
    private String content_source_url;
    /**
     * 图文消息的封面图片素材id（必须是永久MediaID）
     */
    private String thumb_media_id;
    private Integer show_cover_pic;
    /**
     * Uint32 是否打开评论，0不打开(默认)，1打开
     */
    private Integer need_open_comment;
    /**
     * Uint32 是否粉丝才可评论，0所有人可评论(默认)，1粉丝才可评论
     */
    private Integer only_fans_can_comment;
    private String url;
    /**
     * 封面裁剪为2.35:1规格的坐标字段。以原始图片（thumb_media_id）左上角（0,0），右下角（1,1）建立平面坐标系，经过裁剪后的图片，其左上角所在的坐标即为（X1,Y1）,右下角所在的坐标则为（X2,Y2），用分隔符_拼接为X1_Y1_X2_Y2，每个坐标值的精度为不超过小数点后6位数字。示例见下图，图中(X1,Y1) 等于（0.1945,0）,(X2,Y2)等于（1,0.5236），所以请求参数值为0.1945_0_1_0.5236。
     */
    private String pic_crop_235_1;
    /**
     * 封面裁剪为1:1规格的坐标字段，裁剪原理同pic_crop_235_1，裁剪后的图片必须符合规格要求。
     */
    private String pic_crop_1_1;
}