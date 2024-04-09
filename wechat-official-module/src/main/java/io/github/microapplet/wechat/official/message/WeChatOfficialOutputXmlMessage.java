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

package io.github.microapplet.wechat.official.message;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import io.github.microapplet.remote.net.jackson.AbstractJacksonUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 微信公众号被动回复消息
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0.0
 * @since 2024 04 09, &nbsp;&nbsp; <em>version:1.0.0</em>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JacksonXmlRootElement(localName = "xml")
public class WeChatOfficialOutputXmlMessage implements Serializable {
    private static final long serialVersionUID = 6920442425097742418L;

    @JacksonXmlCData
    @JacksonXmlProperty(localName = "ToUserName")
    protected String toUserName;

    @JacksonXmlCData
    @JacksonXmlProperty(localName = "FromUserName")
    protected String fromUserName;

    @JacksonXmlProperty(localName = "CreateTime")
    protected Long createTime;

    @JacksonXmlCData
    @JacksonXmlProperty(localName = "Content")
    private String content;

    @JacksonXmlCData
    @JacksonXmlProperty(localName = "DeviceType")
    private String deviceType;

    @JacksonXmlCData
    @JacksonXmlProperty(localName = "DeviceID")
    private String deviceId;

    @JacksonXmlCData
    @JacksonXmlProperty(localName = "SessionID")
    private String sessionId;

    @JacksonXmlCData
    @JacksonXmlProperty(localName = "MsgType")
    protected String msgType;

    @JacksonXmlProperty(localName = "Music")
    protected Music music = new Music();

    @Data
    @JacksonXmlRootElement(localName = "Music")
    public static class Music implements Serializable {
        private static final long serialVersionUID = -5492592401691895334L;

        @JacksonXmlCData
        @JacksonXmlProperty(localName = "Title")
        private String title;

        @JacksonXmlCData
        @JacksonXmlProperty(localName = "Description")
        private String description;

        @JacksonXmlCData
        @JacksonXmlProperty(localName = "ThumbMediaId")
        private String thumbMediaId;

        @JacksonXmlCData
        @JacksonXmlProperty(localName = "MusicUrl")
        private String musicUrl;

        @JacksonXmlCData
        @JacksonXmlProperty(localName = "HQMusicUrl")
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

    @Data
    @JacksonXmlRootElement(localName = "item")
    public static class Item implements Serializable {
        private static final long serialVersionUID = -4971456355028904754L;

        /**
         * 图文消息标题.
         */
        @JacksonXmlCData
        @JacksonXmlProperty(localName = "Title")
        private String title;

        /**
         * 图文消息描述.
         */
        @JacksonXmlCData
        @JacksonXmlProperty(localName = "Description")
        private String description;

        /**
         * 图片链接.
         * 支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
         */
        @JacksonXmlCData
        @JacksonXmlProperty(localName = "PicUrl")
        private String picUrl;

        /**
         * 点击图文消息跳转链接.
         */
        @JacksonXmlCData
        @JacksonXmlProperty(localName = "Url")
        private String url;
    }

    @JacksonXmlCData
    @JacksonXmlProperty(localName = "Image")
    private String mediaId;

    @JacksonXmlProperty(localName = "TransInfo")
    protected TransInfo transInfo;

    @Data
    @JacksonXmlRootElement(localName = "TransInfo")
    public static class TransInfo implements Serializable {
        private static final long serialVersionUID = -6317885617135706056L;

        @JacksonXmlCData
        @JacksonXmlProperty(localName = "KfAccount")
        private String kfAccount;
    }

    @Data
    @JacksonXmlRootElement(localName = "Video")
    public static class Video implements Serializable {
        private static final long serialVersionUID = -6445448977569651183L;

        @JacksonXmlCData
        @JacksonXmlProperty(localName = "MediaId")
        private String mediaId;

        @JacksonXmlCData
        @JacksonXmlProperty(localName = "Title")
        private String title;

        @JacksonXmlCData
        @JacksonXmlProperty(localName = "Description")
        private String description;
    }


    @JacksonXmlProperty(localName = "Video")
    protected Video video = new Video();

    public String toXml() {
        return AbstractJacksonUtil.writeValueAsXmlString(this);
    }
}