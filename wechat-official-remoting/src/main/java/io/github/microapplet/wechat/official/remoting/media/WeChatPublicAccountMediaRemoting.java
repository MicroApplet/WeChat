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
package io.github.microapplet.wechat.official.remoting.media;

import io.github.microapplet.remote.http.annotation.HttpMapping;
import io.github.microapplet.remote.http.annotation.HttpMethod;
import io.github.microapplet.remote.http.annotation.HttpQuery;
import io.github.microapplet.remote.http.annotation.body.FormData;
import io.github.microapplet.remote.http.annotation.body.JsonBody;
import io.github.microapplet.remote.net.annotation.Server;
import io.github.microapplet.wechat.constant.WeChatCons;
import io.github.microapplet.wechat.remoting.context.WeChatAccessTokenParam;
import io.github.microapplet.wechat.remoting.context.BaseWeChatApiRes;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 微信公众号素材相关 API 客户端
 *
 * @author Copyright © <a href="mailto:asialjim@hotmail.com">Asial Jim</a>   Co., LTD
 * @version 1.0
 * @since 2022/3/29   &nbsp;&nbsp; JDK 8
 */
@SuppressWarnings("unused")
@Server(
        supplier = WeChatCons.Supplier.WECHAT,
        namespace = WeChatCons.Namespace.COMMON,
        schema = WeChatCons.Api.DEFAULT_SCHEMA,
        host = WeChatCons.Api.DEFAULT_HOST,
        port = WeChatCons.Api.DEFAULT_PORT
)
public interface WeChatPublicAccountMediaRemoting {

    /**
     * 临时素材文件下载
     *
     * @param subjectId {@link String subjectId}
     * @param mediaId   {@link String mediaId}
     * @return {@link TemporaryMediaFileRes }
     * @since 2024/2/22
     */
    @HttpMapping(method = HttpMethod.GET, uri = "/cgi-bin/media/get")
    TemporaryMediaFileRes downloadMedia(@WeChatAccessTokenParam String subjectId, @HttpQuery(name = "media_id") String mediaId);

    /**
     * 高清语音素材文件下载
     *
     * @param weChatIndexOrAccessToken {@link String weChatIndexOrAccessToken}
     * @param mediaId                  {@link String mediaId}
     * @return {@link TemporaryMediaFileRes }
     * @since 2024/2/22
     */
    @HttpMapping(method = HttpMethod.GET, uri = "/cgi-bin/media/get/jssdk")
    TemporaryMediaFileRes downloadHighDefinitionVoice(@WeChatAccessTokenParam String weChatIndexOrAccessToken, @HttpQuery(name = "media_id") String mediaId);


    /**
     * <pre>
     * 在新增了永久素材后，开发者可以分类型获取永久素材的列表。
     * 请注意：
     * 1、获取永久素材的列表，也包含公众号在公众平台官网素材管理模块中新建的图文消息、语音、视频等素材 2、临时素材无法通过本接口获取 3、调用该接口需https协议
     * </pre>
     *
     * @param subjectId {@link String subjectId}
     * @param body      {@link BatchGetMaterialReq body}
     * @return {@link BatchGetMaterialRes }
     * @since 2024/2/22
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/material/batchget_material")
    BatchGetMaterialRes batchGetMaterial(@WeChatAccessTokenParam String subjectId, @JsonBody BatchGetMaterialReq body);

    /**
     * 获取永久素材
     * <pre>
     *     在新增了永久素材后，开发者可以根据media_id通过本接口下载永久素材。公众号在公众平台官网素材管理模块中新建的永久素材，可通过"获取素材列表"获知素材的media_id。
     * </pre>
     *
     * @param weChatIndexOrAccessToken {@link String weChatIndexOrAccessToken}
     * @param body                     {@link PermanentMaterialOperateReq body}
     * @return {@link GetPermanentMaterialRes }
     * @since 2024/2/22
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/material/get_material")
    GetPermanentMaterialRes getMaterial(@WeChatAccessTokenParam String weChatIndexOrAccessToken, @JsonBody PermanentMaterialOperateReq body);

    /**
     * 删除永久素材
     * <pre>
     * 在新增了永久素材后，开发者可以根据本接口来删除不再需要的永久素材，节省空间。
     * 请注意：
     * 1、请谨慎操作本接口，因为它可以删除公众号在公众平台官网素材管理模块中新建的图文消息、语音、视频等素材（但需要先通过获取素材列表来获知素材的media_id） 2、临时素材无法通过本接口删除 3、调用该接口需https协议
     * </pre>
     *
     * @param weChatIndexOrAccessToken {@link String weChatIndexOrAccessToken}
     * @param body                     {@link PermanentMaterialOperateReq body}
     * @return {@link BaseWeChatApiRes }
     * @since 2024/2/22
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/material/del_material")
    BaseWeChatApiRes delMaterial(@WeChatAccessTokenParam String weChatIndexOrAccessToken, @JsonBody PermanentMaterialOperateReq body);

    /**
     * <h1>新增其他类型永久素材</h1>
     * <pre>
     * 接口调用请求说明
     * 通过POST表单来调用接口，表单id为media，包含需要上传的素材内容，有filename、filelength、content-type等信息。请注意：图片素材将进入公众平台官网素材管理模块中的默认分组。
     * <a href="https://developers.weixin.qq.com/doc/offiaccount/Asset_Management/Adding_Permanent_Assets.html">官方文档</a>
     * </pre>
     *
     * @param weChatIndexOrAccessToken {@link String weChatIndexOrAccessToken}
     * @param file                     {@link File file}
     * @param description              {@link AddMaterialDescription description}
     * @return {@link AddMaterialRes }
     * @since 2024/2/22
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/material/add_material")
    AddMaterialRes addMaterial(@WeChatAccessTokenParam String weChatIndexOrAccessToken, @FormData(name = "media") File file, @FormData(name = "description", attr = true) AddMaterialDescription description);

    /**
     * 获取素材总数
     * <pre>
     *     开发者可以根据本接口来获取永久素材的列表，需要时也可保存到本地。
     * 请注意：
     * 1.永久素材的总数，也会计算公众平台官网素材管理中的素材 2.图片和图文消息素材（包括单图文和多图文）的总数上限为100000，其他素材的总数上限为1000 3.调用该接口需https协议
     * </pre>
     *
     * @param weChatIndexOrAccessToken {@link String weChatIndexOrAccessToken}
     * @return {@link GetMaterialCountRes }
     * @since 2024/2/22
     */
    @HttpMapping(method = HttpMethod.GET, uri = "/cgi-bin/material/get_materialcount")
    GetMaterialCountRes getMaterialCount(@WeChatAccessTokenParam String weChatIndexOrAccessToken);

    /**
     * <pre>
     * 上传图文消息内的图片获取URL
     * 本接口所上传的图片不占用公众号的素材库中图片数量的100000个的限制。图片仅支持jpg/png格式，大小必须在1MB以下。
     * </pre>
     *
     * @param weChatIndex {@link String weChatIndex}
     * @param file        {@link MultipartFile file}
     * @return {@link UploadMediaRes}
     * @since 2023/12/26
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/media/uploadimg")
    UploadMediaRes upload(@WeChatAccessTokenParam String weChatIndex, @FormData(name = "media") MultipartFile file);

    /**
     * <pre>
     * 上传图文消息内的图片获取URL【订阅号与服务号认证后均可用】
     * 请注意，本接口所上传的图片不占用公众号的素材库中图片数量的5000个的限制。图片仅支持jpg/png格式，大小必须在1MB以下。*
     * </pre>
     *
     * @param weChatIndex {@link String weChatIndex}
     * @param file        {@link File file}
     * @return {@link UploadMediaRes}
     * @since 2023/12/26
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/media/uploadimg")
    UploadMediaRes upload(@WeChatAccessTokenParam String weChatIndex, @FormData(name = "media") File file);

    /**
     * 上传图文消息素材【订阅号与服务号认证后均可用】
     *
     * @param weChatIndex {@link String weChatIndex}
     * @param req         {@link UploadNewsReq req}
     * @return {@link UploadNewsRes }
     * @since 2023/12/26
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/media/uploadnews")
    UploadNewsRes uploadNews(@WeChatAccessTokenParam String weChatIndex, @JsonBody UploadNewsReq req);


    /**
     * 上传媒体文件
     *
     * @param weChatIndexOrAccessToken {@link String weChatIndexOrAccessToken}
     * @param type                     {@link String type}
     * @param file                     {@link File file}
     * @return {@link UploadNewsRes }
     * @since 2024/2/22
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/media/upload")
    UploadNewsRes upload(@WeChatAccessTokenParam String weChatIndexOrAccessToken, @HttpQuery(name = "type") String type, @FormData(name = "media") File file);


    /**
     * 上传媒体文件
     *
     * @param weChatIndexOrAccessToken {@link String weChatIndexOrAccessToken}
     * @param type                     {@link String type}
     * @param file                     {@link MultipartFile file}
     * @return {@link UploadNewsRes }
     * @since 2024/2/22
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/media/upload")
    UploadNewsRes upload(@WeChatAccessTokenParam String weChatIndexOrAccessToken, @HttpQuery(name = "type") String type, @FormData(name = "media") MultipartFile file);

    @Data
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    class GetMaterialCountRes extends BaseWeChatApiRes {
        @Serial
        private static final long serialVersionUID = 7550804730471254114L;

        private Long voice_count;
        private Long video_count;
        private Long image_count;
        private Long news_count;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    class PermanentMaterialOperateReq implements Serializable {
        private String media_id;
    }

    @Data
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    class GetPermanentMaterialRes extends BaseWeChatApiRes {
        @Serial
        private static final long serialVersionUID = 9100971308259284755L;

        private String title;
        private String description;
        private String down_url;
        private List<NewsItem> news_item;
    }

    @Data
    class NewsItem {
        private String title;
        private String thumb_media_id;
        private String show_cover_pic;
        private String author;
        private String digest;
        private String content;
        private String url;
        private String content_source_url;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    class AddMaterialDescription implements Serializable {
        @Serial
        private static final long serialVersionUID = -4709329218582836162L;
        private String title;
        private String introduction;
    }

    @Data
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    class AddMaterialRes extends BaseWeChatApiRes {
        @Serial
        private static final long serialVersionUID = -5187374753924993502L;
        private String media_id;
        private String url;
    }

    @Data
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    class UploadNewsRes extends BaseWeChatApiRes {
        @Serial
        private static final long serialVersionUID = -5520951777093502946L;

        private String type;
        private String media_id;
        private Long create_at;
    }

    @Data
    class UploadNewsReq implements Serializable {
        @Serial
        private static final long serialVersionUID = -6118944236756795684L;
        private List<Article> articles;

        /**
         * 添加图文信息
         *
         * @param article {@link Article article}
         * @return {@link UploadNewsReq }
         * @since 2023/12/26
         */
        public UploadNewsReq withArticle(Article article) {
            if (Objects.isNull(article))
                return this;
            if (Objects.isNull(this.articles)) {
                synchronized (this) {
                    if (Objects.isNull(this.articles))
                        this.articles = new ArrayList<>();
                }
            }
            this.articles.add(article);
            return this;
        }
    }

    @Data
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    class UploadMediaRes extends BaseWeChatApiRes {
        private String url;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    class BatchGetMaterialReq implements Serializable {
        @Serial
        private static final long serialVersionUID = 941027150088371833L;

        private String type;
        private String offset;
        private String count;
    }

    @Data
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    class BatchGetMaterialRes extends BaseWeChatApiRes {
        @Serial
        private static final long serialVersionUID = -400632278705600288L;

        private Integer total_count;
        private Integer item_count;
        private List<Item> item;
    }

    @Data
    class Item implements Serializable {
        @Serial
        private static final long serialVersionUID = 3568780140258963754L;

        private String media_id;
        private String name;
        private String update_time;
        private String url;
        private ItemContent content;
    }

    @Data
    class ItemContent implements Serializable {
        @Serial
        private static final long serialVersionUID = -3800606453336514540L;

        private List<Article> news_item;
    }

    @Data
    @SuppressWarnings("unused")
    class Article implements Serializable {
        @Serial
        private static final long serialVersionUID = 9204685982105664454L;

        /**
         * 标题
         */
        private String title;

        /**
         * 图文消息的封面图片素材id（必须是永久mediaID）
         */
        private String thumb_media_id;

        /**
         * 作者
         */
        private String author;

        /**
         * 图文消息的摘要，仅有单图文消息才有摘要，多图文此处为空。如果本字段为没有填写，则默认抓取正文前54个字
         */
        private String digest;

        /**
         * 是否显示封面，0为false，即不显示，1为true，即显示
         */
        private Integer show_cover_pic;

        /**
         * 图文消息的具体内容，支持HTML标签，必须少于2万字符，小于1M，且此处会去除JS,涉及图片url必须来源 \"上传图文消息内的图片获取URL\"接口获取。外部图片url将被过滤
         */
        private String content;

        /**
         * 图文消息的原文地址，即点击“阅读原文”后的URL
         */
        private String content_source_url;

        /**
         * Uint32 是否打开评论，0不打开，1打开
         */
        private Integer need_open_comment;

        /**
         * Uint32 是否粉丝才可评论，0所有人可评论，1粉丝才可评论
         */
        private Integer only_fans_can_comment;

        /**
         * 图文页的URL，或者，当获取的列表是图片素材列表时，该字段是图片的URL
         */
        private String url;

        /**
         * 设置小程序卡片：
         * <pre>
         * 如果需要在群发图文中插入小程序，则在调用上传图文消息素材接口时，需在content字段中添加小程序跳转链接，有以下三种样式的可供选择。
         * 小程序卡片跳转小程序，代码示例：
         * {@code <mp-common-miniprogram data-miniprogram-appid="wx123123123" data-miniprogram-path="pages/index/index" data-miniprogram-title="小程序示例" data-miniprogram-imageurl="http://example.com/demo.jpg" data-miniprogram-type="card"></mp-common-miniprogram> }
         * </pre>
         *
         * @param appid    {@link String appid}
         * @param path     {@link String path}
         * @param title    {@link String title}
         * @param imageurl {@link String imageurl}
         * @return {@link Article }
         * @since 2023/12/26
         */
        public Article withAppletCard(String appid, String path, String title, String imageurl) {
            String content = String.format("<mp-common-miniprogram data-miniprogram-appid=\"%s\" data-miniprogram-path=\"%s\" data-miniprogram-title=\"%s\" data-miniprogram-imageurl=\"%s\" data-miniprogram-type=\"card\"></mp-common-miniprogram>",
                    appid, path, title, imageurl);
            this.setContent(content);
            return this;
        }

        /**
         * 设置文字跳转小程序
         * <pre>
         * 文字跳转小程序，代码示例：
         * {@code <p><a data-miniprogram-appid="wx123123123" data-miniprogram-path="pages/index" href="">点击文字跳转小程序</a></p>}
         * </pre>
         *
         * @param appid         {@link String appid}
         * @param path          {@link String path}
         * @param text          {@link String text}
         * @param lowVersionUrl {@link String lowVersionUrl}
         * @return {@link Article }
         * @since 2023/12/26
         */

        public Article withAppletText(String appid, String path, String text, String lowVersionUrl) {
            String content = String.format("<p><a data-miniprogram-appid=\"%s\" data-miniprogram-path=\"%s\" href=\"%s\">%s</a></p>",
                    appid, path, lowVersionUrl, text);
            this.setContent(content);
            return this;
        }

        /**
         * 设置图片跳转小程序
         * <pre>
         *     图片跳转小程序，代码示例：
         * {@code <p><a data-miniprogram-appid="wx123123123" data-miniprogram-path="pages/index" href=""><img src="https://mmbiz.qpic.cn/mmbiz_jpg/demo/0?wx_fmt=jpg" alt="" data-width="null" data-ratio="NaN"></a></p>}
         * </pre>
         *
         * @param appid {@link String appid}
         * @param path  {@link String path}
         * @param url   {@link String url}
         * @return {@link Article }
         * @since 2023/12/26
         */
        public Article withAppletImage(String appid, String path, String url) {
            String content = String.format("<p><a data-miniprogram-appid=\"%s\" data-miniprogram-path=\"%s\" href=\"\"><img src=\"%s\" alt=\"\" data-width=\"null\" data-ratio=\"NaN\"></a></p>",
                    appid, path, url);
            this.setContent(content);
            return this;
        }
    }
}