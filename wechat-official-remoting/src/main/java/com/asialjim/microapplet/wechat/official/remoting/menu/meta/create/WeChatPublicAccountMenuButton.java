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

package com.asialjim.microapplet.wechat.official.remoting.menu.meta.create;

import com.asialjim.microapplet.wechat.official.remoting.menu.meta.create.WeChatMenuButtonType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@SuppressWarnings("unused")
public class WeChatPublicAccountMenuButton implements Serializable {

    private static final long serialVersionUID = -6574684521349956445L;


    /**
     * <b>菜单的响应动作类型.</b>
     * <ul>
     *     <li>view<pre>表示网页类型</pre></li>
     *     <li>click<pre>表示点击类型</pre></li>
     *     <li>miniprogram<pre>表示小程序类型</pre></li>
     *     <li>scancode_push<pre>表示用户点击后调起微信客户端扫码工具，如果扫描结果为url则跳转到url</pre></li>
     *     <li>scancode_waitmsg<pre>表示扫码后弹起消息接受中提示框，并向开发者下发用户扫码事件</pre></li>
     *     <li>pic_sysphoto<pre>表示系统调用相机拍摄图片，并向开发者服务器发送图片消息</pre></li>
     *     <li>pic_photo_or_album<pre>表示用户拍照或者从系统选择照片发送到开发者服务器</pre></li>
     *     <li>pic_weixin<pre>调起微信相册，并选择图片发送到开发者服务器</pre></li>
     *     <li>location_select<pre>上报地理位置，用户选择地理位置发送，并推送到开发者服务器</pre></li>
     *     <li>media_id<pre>下发消息给用户，media_id鄙俗是开发者填写的永久素材id</pre></li>
     *     <li>view_limited<pre>跳转图文消息</pre></li>
     *     <li>article_id<pre>发布后获得合法article_id</pre></li>
     *     <li>article_view_limited<pre>发布后获得合法的ARTICLE_ID</pre></li>
     * </ul>
     */
    private WeChatMenuButtonType type;
    public void setType(String type){this.type = WeChatMenuButtonType.nameOf(type); }
    public String getType(){ return Objects.nonNull(this.type) ? this.type.getName() : ""; }

    /**
     * 菜单标题，不超过16个字节，子菜单不超过60个字节.
     */
    private String name;

    /**
     * <p>菜单KEY值，用于消息接口推送，不超过128字节.
     * <p>click等点击类型必须
     */
    private String key;

    /**
     * <p>网页链接.
     * <p>用户点击菜单可打开链接，不超过1024字节。<p>type为miniprogram时，不支持小程序的老版本客户端将打开本url。
     * <p>view、miniprogram类型必须
     */
    private String url;

    /**
     * <p>调用新增永久素材接口返回的合法media_id.
     * <p>media_id类型和view_limited类型必须
     */
    @JsonProperty("media_id")
    private String mediaId;

    /**
     * <p>小程序的appid.
     * <p>miniprogram类型必须
     */
    @JsonProperty("appid")
    private String appId;

    /**
     * <p>小程序的页面路径.
     * <p>miniprogram类型必须
     */
    @JsonProperty("pagepath")
    private String pagePath;

    /**
     * 查询官方菜单所需字段
     */
    private String value;

    @JsonProperty("article_id")
    private String articleId;

    /**
     * 图文消息
     */
    @JsonProperty("news_info")
    private WeChatMenuNewsInfo newsInfo;

    /**
     * 适用于微信公众号二级菜单
     */
    @JsonProperty("sub_button")
    private List<WeChatPublicAccountMenuButton> subButtons = new ArrayList<>();

    public void addSubButton(WeChatPublicAccountMenuButton weChatPublicAccountMenuButton) {
        if (Objects.isNull(subButtons))
            this.subButtons = new ArrayList<>();

        this.subButtons.add(weChatPublicAccountMenuButton);
    }
}