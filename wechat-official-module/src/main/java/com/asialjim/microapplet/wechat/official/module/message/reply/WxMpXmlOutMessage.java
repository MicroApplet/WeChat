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

package com.asialjim.microapplet.wechat.official.module.message.reply;

import com.asialjim.microapplet.remote.net.jackson.AbstractJacksonUtil;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 被动回复消息
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/9/25, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Data
@Accessors(chain = true)
@JacksonXmlRootElement(localName = "xml")
public class WxMpXmlOutMessage implements Serializable {
    @Serial
    private static final long serialVersionUID = 6920442425097742418L;

    @JacksonXmlProperty(localName = "ToUserName")
    @JacksonXmlCData
    protected String toUserName;

    @JacksonXmlProperty(localName = "FromUserName")
    @JacksonXmlCData
    protected String fromUserName;

    @JacksonXmlProperty(localName = "CreateTime")
    protected Long createTime;

    @JacksonXmlProperty(localName = "Content")
    @JacksonXmlCData
    private String content;

    @JacksonXmlProperty(localName = "DeviceType")
    @JacksonXmlCData
    private String deviceType;

    @JacksonXmlProperty(localName = "DeviceID")
    @JacksonXmlCData
    private String deviceId;

    @JacksonXmlProperty(localName = "SessionID")
    @JacksonXmlCData
    private String sessionId;
    @JacksonXmlProperty(localName = "MsgType")
    @JacksonXmlCData
    protected String msgType;

    @JacksonXmlProperty(localName = "Music")
    protected Music music = new Music();


    @JacksonXmlRootElement(localName = "Music")
    @Data
    public static class Music implements Serializable {
        @Serial
        private static final long serialVersionUID = -5492592401691895334L;

        @JacksonXmlProperty(localName = "Title")
        @JacksonXmlCData
        private String title;

        @JacksonXmlProperty(localName = "Description")
        @JacksonXmlCData
        private String description;

        @JacksonXmlProperty(localName = "ThumbMediaId")
        @JacksonXmlCData
        private String thumbMediaId;

        @JacksonXmlProperty(localName = "MusicUrl")
        @JacksonXmlCData
        private String musicUrl;

        @JacksonXmlProperty(localName = "HQMusicUrl")
        @JacksonXmlCData
        private String hqMusicUrl;
    }

    /**
     * 图文消息信息.
     * 注意，如果图文数超过限制，则将只发限制内的条数
     */
    @JacksonXmlElementWrapper
    @JacksonXmlProperty(localName = "Articles")
    protected final List<Item> articles = new ArrayList<>();
    /**
     * 图文消息个数.
     * 当用户发送文本、图片、视频、图文、地理位置这五种消息时，开发者只能回复1条图文消息；其余场景最多可回复8条图文消息
     */
    @JacksonXmlProperty(localName = "ArticleCount")
    protected int articleCount;

    @JacksonXmlRootElement(localName = "item")
    @Data
    public static class Item implements Serializable {
        @Serial
        private static final long serialVersionUID = -4971456355028904754L;

        /**
         * 图文消息标题.
         */
        @JacksonXmlProperty(localName = "Title")
        @JacksonXmlCData
        private String title;

        /**
         * 图文消息描述.
         */
        @JacksonXmlProperty(localName = "Description")
        @JacksonXmlCData
        private String description;

        /**
         * 图片链接.
         * 支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
         */
        @JacksonXmlProperty(localName = "PicUrl")
        @JacksonXmlCData
        private String picUrl;

        /**
         * 点击图文消息跳转链接.
         */
        @JacksonXmlProperty(localName = "Url")
        @JacksonXmlCData
        private String url;

    }

    @JacksonXmlCData
    @JacksonXmlProperty(localName = "Image")
    private Image image;

    @JacksonXmlProperty(localName = "TransInfo")
    protected TransInfo transInfo;

    @Data
    @JacksonXmlRootElement(localName = "Image")
    public static class Image {

        @JacksonXmlProperty(localName = "MediaId")
        private String mediaId;
    }

    @Data
    @JacksonXmlRootElement(localName = "TransInfo")
    public static class TransInfo implements Serializable {
        @Serial
        private static final long serialVersionUID = -6317885617135706056L;

        @JacksonXmlProperty(localName = "KfAccount")
        @JacksonXmlCData
        private String kfAccount;

    }

    @Data
    @JacksonXmlRootElement(localName = "Video")
    public static class Video implements Serializable {
        @Serial
        private static final long serialVersionUID = -6445448977569651183L;

        @JacksonXmlProperty(localName = "MediaId")
        @JacksonXmlCData
        private String mediaId;

        @JacksonXmlProperty(localName = "Title")
        @JacksonXmlCData
        private String title;

        @JacksonXmlProperty(localName = "Description")
        @JacksonXmlCData
        private String description;

    }


    @JacksonXmlProperty(localName = "Video")
    protected Video video = new Video();

    public String toXml() {
        return AbstractJacksonUtil.writeValueAsXmlString(this);
    }
}