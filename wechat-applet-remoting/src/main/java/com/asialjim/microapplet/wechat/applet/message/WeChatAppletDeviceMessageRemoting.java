/*
 * Copyright 2025 Asial Jim.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.asialjim.microapplet.wechat.applet.message;

import com.asialjim.microapplet.wechat.applet.message.meta.AddIotGroupDeviceRes;
import com.asialjim.microapplet.wechat.applet.message.meta.CreateIotGroupIdRes;
import com.asialjim.microapplet.wechat.applet.message.meta.GetIotGroupInfoRes;
import com.asialjim.microapplet.wechat.applet.message.meta.ActiveLicenseDeviceRes;
import com.asialjim.microapplet.wechat.applet.message.meta.GetLicenseDeviceInfoRes;
import com.asialjim.microapplet.wechat.applet.message.meta.GetLicensePkgListRes;
import com.asialjim.microapplet.wechat.applet.message.meta.GetSnTicketRes;
import com.asialjim.microapplet.wechat.applet.message.meta.RemoveIotGroupDeviceRes;
import com.asialjim.microapplet.wechat.applet.message.meta.SendHardwareDeviceMessageRes;
import com.asialjim.microapplet.wechat.applet.message.request.AddIotGroupDeviceRequest;
import com.asialjim.microapplet.wechat.applet.message.request.CreateIotGroupIdRequest;
import com.asialjim.microapplet.wechat.applet.message.request.ActiveLicenseDeviceRequest;
import com.asialjim.microapplet.wechat.applet.message.request.GetIotGroupInfoRequest;
import com.asialjim.microapplet.wechat.applet.message.request.GetLicenseDeviceInfoRequest;
import com.asialjim.microapplet.wechat.applet.message.request.GetLicensePkgListRequest;
import com.asialjim.microapplet.wechat.applet.message.request.GetSnTicketRequest;
import com.asialjim.microapplet.wechat.applet.message.request.RemoveIotGroupDeviceRequest;
import com.asialjim.microapplet.wechat.applet.message.request.SendHardwareDeviceMessageRequest;
import com.asialjim.microapplet.remote.http.annotation.HttpMapping;
import com.asialjim.microapplet.remote.http.annotation.HttpMethod;
import com.asialjim.microapplet.remote.http.annotation.body.JsonBody;
import com.asialjim.microapplet.remote.net.annotation.Server;
import com.asialjim.microapplet.wechat.constant.WeChatCons;
import com.asialjim.microapplet.wechat.remoting.context.WeChatAccessTokenParam;

/**
 * 微信小程序设备消息相关接口
 *
 * @author <a href="mailto:asialjim@qq.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/11/02, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Server(
        supplier = WeChatCons.Supplier.WECHAT,
        namespace = WeChatCons.Namespace.COMMON,
        schema = WeChatCons.Api.DEFAULT_SCHEMA,
        host = WeChatCons.Api.DEFAULT_HOST,
        port = WeChatCons.Api.DEFAULT_PORT
)
public interface WeChatAppletDeviceMessageRemoting {


    /**
     * 发送设备消息
     * 接口说明：通过该接口向用户发送设备消息
     * 调用次数限制：1kw/日
     *
     * @param weChatIndex 微信索引标识
     * @param requestParam 请求参数
     * @return SendHardwareDeviceMessageRes 响应结果
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/hardware-device/sendHardwareDeviceMessage.html">发送设备消息</a>
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/cgi-bin/message/device/subscribe/send")
    SendHardwareDeviceMessageRes sendHardwareDeviceMessage(
            @WeChatAccessTokenParam String weChatIndex,
            @JsonBody SendHardwareDeviceMessageRequest requestParam
    );

    /**
     * 获取设备票据
     * 接口说明：通过该接口可获取设备票据，5分钟内有效
     * 该接口所属的权限集id为：118
     *
     * @param weChatIndex 微信索引标识
     * @param requestParam 请求参数
     * @return GetSnTicketRes 响应结果，包含设备票据
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/hardware-device/getSnTicket.html">获取设备票据</a>
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxa/getsnticket")
    GetSnTicketRes getSnTicket(
            @WeChatAccessTokenParam String weChatIndex,
            @JsonBody GetSnTicketRequest requestParam
    );

    /**
     * 创建设备组
     * 接口说明：本接口用于创建设备组，便于用户一次性订阅多个设备
     * 创建的设备组只能添加与传入 model_id 同一类型的设备
     *
     * @param weChatIndex 微信索引标识
     * @param requestParam 请求参数
     * @return CreateIotGroupIdRes 响应结果，包含设备组ID
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/hardware-device/createIotGroupId.html">创建设备组</a>
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxa/business/group/createid")
    CreateIotGroupIdRes createIotGroupId(
            @WeChatAccessTokenParam String weChatIndex,
            @JsonBody CreateIotGroupIdRequest requestParam
    );

    /**
     * 查询设备组信息
     * 接口说明：本接口用于查询设备组的信息
     *
     * @param weChatIndex 微信索引标识
     * @param requestParam 请求参数，包含设备组ID
     * @return GetIotGroupInfoRes 响应结果，包含设备组名称和设备列表
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/hardware-device/getIotGroupInfo.html">查询设备组信息</a>
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxa/business/group/getinfo")
    GetIotGroupInfoRes getIotGroupInfo(
            @WeChatAccessTokenParam String weChatIndex,
            @JsonBody GetIotGroupInfoRequest requestParam
    );
    
    /**
     * 设备组添加设备
     * 接口说明：本接口用于为设备组添加设备
     * 一个设备组最多添加 50 个设备
     * 一个设备同一时间只能被添加到一个设备组中
     *
     * @param weChatIndex 微信索引标识
     * @param requestParam 请求参数，包含设备组ID和设备列表
     * @return AddIotGroupDeviceRes 响应结果，包含添加成功的设备列表
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/hardware-device/addIotGroupDevice.html">设备组添加设备</a>
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxa/business/group/adddevice")
    AddIotGroupDeviceRes addIotGroupDevice(
            @WeChatAccessTokenParam String weChatIndex,
            @JsonBody AddIotGroupDeviceRequest requestParam
    );
    
    /**
     * 设备组删除设备
     * 接口说明：本接口为设备组删除已添加的设备
     *
     * @param weChatIndex 微信索引标识
     * @param requestParam 请求参数，包含设备组ID和设备列表
     * @return RemoveIotGroupDeviceRes 响应结果，包含删除成功的设备列表
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/hardware-device/removeIotGroupDevice.html">设备组删除设备</a>
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxa/business/group/removedevice")
    RemoveIotGroupDeviceRes removeIotGroupDevice(
            @WeChatAccessTokenParam String weChatIndex,
            @JsonBody RemoveIotGroupDeviceRequest requestParam
    );
    
    /**
     * 查询license资源包列表
     * 接口说明：本接口用于查询小程序已购买的 license 资源包列表信息
     * 注意：开发者需要先在小程序管理后台购买设备 license 的套餐包后，方可查询到对应的资源包
     * 该接口所属的权限集id为：118
     * 注：本接口将于2024年12月31日正式回收，请开发者及时进行调整适配
     *
     * @param weChatIndex 微信索引标识
     * @param requestParam 请求参数，包含资源包类型
     * @return GetLicensePkgListRes 响应结果，包含资源包列表信息
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/hardware-device/getLicensePkgList.html">查询license资源包列表</a>
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxa/business/license/getpkglist")
    GetLicensePkgListRes getLicensePkgList(
            @WeChatAccessTokenParam String weChatIndex,
            @JsonBody GetLicensePkgListRequest requestParam
    );
    
    /**
     * 激活设备license
     * 接口说明：本接口用于批量绑定设备，并消耗相应的资源包中的激活码序号
     * 该接口所属的权限集id为：118
     * 注：自2024年9月9日15时起，激活操作不再消耗license，本接口将于2024年12月31日正式回收
     *
     * @param weChatIndex 微信索引标识
     * @param requestParam 请求参数，包含待激活的设备列表
     * @return ActiveLicenseDeviceRes 响应结果，包含设备激活结果列表
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/hardware-device/activeLicenseDevice.html">激活设备license</a>
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxa/business/license/activedevice")
    ActiveLicenseDeviceRes activeLicenseDevice(
            @WeChatAccessTokenParam String weChatIndex,
            @JsonBody ActiveLicenseDeviceRequest requestParam
    );
    
    /**
     * 查询设备激活详情
     * 接口说明：本接口用于批量查询设备剩余有效期
     * 该接口所属的权限集id为：118
     * 注：自2024年9月9日15时起，为确保兼容性，本接口均返回无实际意义的「已激活」，将于2024年12月31日正式回收
     *
     * @param weChatIndex 微信索引标识
     * @param requestParam 请求参数，包含设备列表
     * @return GetLicenseDeviceInfoRes 响应结果，包含设备激活详情列表
     * @see <a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/hardware-device/getLicenseDeviceInfo.html">查询设备激活详情</a>
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxa/business/license/getdeviceinfo")
    GetLicenseDeviceInfoRes getLicenseDeviceInfo(
            @WeChatAccessTokenParam String weChatIndex,
            @JsonBody GetLicenseDeviceInfoRequest requestParam
    );
}