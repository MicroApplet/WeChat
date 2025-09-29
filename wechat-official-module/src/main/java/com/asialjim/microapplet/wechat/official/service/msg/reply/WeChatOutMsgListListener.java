/*
 *    Copyright 2014-2025 <a href="mailto:asialjim@qq.com">Asial Jim</a>
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.asialjim.microapplet.wechat.official.service.msg.reply;

import com.asialjim.microapplet.common.event.BaseAsyncListener;
import com.asialjim.microapplet.wechat.official.remoting.customer.WeChatPaCustomerMessageRemoting;
import com.asialjim.microapplet.wechat.official.remoting.customer.meta.*;
import com.asialjim.microapplet.wechat.official.remoting.customer.meta.item.*;
import com.asialjim.microapplet.wechat.remoting.context.BaseWeChatApiRes;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * 被动消息改主动消息
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/9/25, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Slf4j
@Component
public class WeChatOutMsgListListener extends BaseAsyncListener<WeChatOutMsgListEvent> {
    @Resource
    private WeChatPaCustomerMessageRemoting weChatPaCustomerMessageRemoting;

    @Override
    public void doOnEvent(WeChatOutMsgListEvent event) {
        if (Objects.isNull(event))
            return;
        List<WxMpXmlOutMessage> source = event.source();
        for (WxMpXmlOutMessage wxMpXmlOutMessage : source) {
            if (Objects.isNull(wxMpXmlOutMessage))
                continue;

            String msgType = wxMpXmlOutMessage.getMsgType();
            String openid = wxMpXmlOutMessage.getToUserName();
            String subjectId = wxMpXmlOutMessage.getFromUserName();
            WeChatCustomerMessage<?> customerMsg = null;
            switch (msgType) {
                case "text" -> {
                    String content = wxMpXmlOutMessage.getContent();
                    WeChatCustomerTextMessage msg = new WeChatCustomerTextMessage();
                    msg.setTouser(openid);
                    msg.setText(Text.builder().content(content).build());
                    customerMsg = msg;
                }
                case "image" -> {
                    String mediaId = Optional.ofNullable(wxMpXmlOutMessage.getImage()).map(WxMpXmlOutMessage.Image::getMediaId).orElse(StringUtils.EMPTY);
                    if (StringUtils.isNotBlank(mediaId)) {
                        WeChatCustomerImageMessage msg = new WeChatCustomerImageMessage();
                        Media media = Media.builder().media_id(mediaId).build();
                        msg.setImage(media);
                        customerMsg = msg;
                    }
                }
                case "voice" -> {
                    String mediaId = Optional.ofNullable(wxMpXmlOutMessage.getVideo()).map(WxMpXmlOutMessage.Video::getMediaId).orElse(StringUtils.EMPTY);
                    if (StringUtils.isNotBlank(mediaId)) {
                        WeChatCustomerVoiceMessage msg = new WeChatCustomerVoiceMessage();
                        Media media = Media.builder().media_id(mediaId).build();
                        msg.setVoice(media);
                        customerMsg = msg;
                    }
                }
                case "video" -> {
                    Media media = new Media();
                    Optional.ofNullable(wxMpXmlOutMessage.getVideo()).ifPresent(video -> {
                        media.setMedia_id(video.getMediaId());
                        media.setTitle(video.getTitle());
                        media.setDescription(video.getDescription());
                    });
                    if (StringUtils.isNotBlank(media.getMedia_id())) {
                        WeChatCustomerVideoMessage msg = new WeChatCustomerVideoMessage();
                        msg.setVideo(media);
                        customerMsg = msg;
                    }
                }
                case "music" -> {
                    Music music = new Music();
                    Optional.ofNullable(wxMpXmlOutMessage.getMusic())
                            .ifPresent(item -> {
                                music.setTitle(item.getTitle());
                                music.setDescription(item.getDescription());
                                music.setMusicurl(item.getMusicUrl());
                                music.setHqmusicurl(item.getHqMusicUrl());
                                music.setThumb_media_id(item.getThumbMediaId());
                            });

                    WeChatCustomerMusicMessage msg = new WeChatCustomerMusicMessage();
                    if (StringUtils.isNotBlank(music.getMusicurl())) {
                        msg.setMusic(music);
                        customerMsg = msg;
                    }

                }
                case "news" -> {
                    List<WxMpXmlOutMessage.Item> articles = wxMpXmlOutMessage.getArticles();
                    for (WxMpXmlOutMessage.Item article : articles) {
                        WeChatCustomerNewsMessage msg = new WeChatCustomerNewsMessage();

                        News news = new News();
                        news.setArticles(
                                Collections.singletonList(
                                        Article.builder()
                                                .title(article.getTitle())
                                                .description(article.getDescription())
                                                .url(article.getUrl())
                                                .picurl(article.getPicUrl())
                                                .build()
                                ));
                        msg.setNews(news);

                        BaseWeChatApiRes res = this.weChatPaCustomerMessageRemoting.sendCustomerMsg(subjectId, msg);
                        log.info("\r\n\t被动回复消息:{}\r\n\t改为发送客服消息：{}\r\n\t结果：{}", wxMpXmlOutMessage, msg, res);
                    }
                }
                default -> {
                }
            }
            if (Objects.isNull(customerMsg))
                return;

            BaseWeChatApiRes res = this.weChatPaCustomerMessageRemoting.sendCustomerMsg(subjectId, customerMsg);
            log.info("\r\n\t被动回复文本消息:{}\r\n\t改为发送客服消息：{}\r\n\t结果：{}", wxMpXmlOutMessage, customerMsg, res);
        }
    }
}