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

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum WeChatMenuButtonType {
    PARENT("parent","一级菜单","一级菜单"),
    CLICK("click","点击菜单","点击菜单"),
    VIEW("view","跳转页面菜单","跳转H5页面的URL"),
    APPLET("miniprogram","小程序菜单","跳转至目标小程序"),
    SCAN_PUSH("scancode_push","扫码菜单","调起扫一扫工具,完成扫码后显示扫描结果，如果是url，将进入url"),
    SCAN_MSG("scancode_waitmsg","扫码弹出消息接受中","扫码并弹出“消息接受中”"),
    PIC_SYS("pic_sysphoto","拍照菜单","弹出系统拍照发图，用户点击后调起系统相机，完成拍照后将照片发送给开发者"),
    PIC_ALBUM("pic_photo_or_album","拍照菜单，或者发送相册图片菜单"," 弹出拍照或者相册发图用户点击按钮后，微信客户端将弹出选择器供用户选择“拍照”或者“从手机相册选择”。用户选择后即走其他两种流程"),
    PIC_WECHAT("pic_weixin","发送相册菜单","弹出微信相册发图器用户点击按钮后，微信客户端将调起微信相册，完成选择操作后，将选择的相片发送给开发者的服务器，并推送事件给开发者，同时收起相册，随后可能会收到开发者下发的消息"),
    LOC_SELECT("location_select","发送地理位置菜单","弹出地理位置选择器用户点击按钮后，微信客户端将调起地理位置选择工具，完成选择操作后，将选择的地理位置发送给开发者的服务器，同时收起位置选择工具，随后可能会收到开发者下发的消息。"),
    MEDIA_ID("media_id","回复媒体文件菜单","下发消息（除文本消息）用户点击media_id类型按钮后，微信服务器会将开发者填写的永久素材id对应的素材下发给用户，永久素材类型可以是图片、音频、视频、图文消息。请注意：永久素材id必须是在“素材管理/新增永久素材”接口上传后获得的合法id"),
    VIEW_LIMITED("view_limited","发送永久媒体文件菜单"," 跳转图文消息URL用户点击view_limited类型按钮后，微信客户端将打开开发者在按钮中填写的永久素材id对应的图文消息URL，永久素材类型只支持图文消息。请注意：永久素材id必须是在“素材管理/新增永久素材”接口上传后获得的合法id。"),
    ARTICLE_ID("article_id","发送图文消息","图文消息发布后，获取到的图文编号"),
    ARTICLE_LIMIT("article_view_limited","发送永久图文消息","图文消息发布后，获取到的图文编号"),
    ILLEGAL("illegal","非法菜单","非法菜单");

    /**
     * 菜单类型编号
     */
    private final String code;

    /**
     * 菜单类型名称
     */
    private final String name;

    /**
     * 菜单类型描述
     */
    private final String desc;

    /**
     * 获取类型
     */
    public static WeChatMenuButtonType nameOf(String name){
        return Arrays.stream(values()).filter(value -> StringUtils.equalsIgnoreCase(value.getCode(), name)).findFirst().orElse(ILLEGAL);
    }
}