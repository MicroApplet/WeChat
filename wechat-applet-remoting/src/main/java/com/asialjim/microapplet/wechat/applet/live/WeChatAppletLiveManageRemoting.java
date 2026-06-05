package com.asialjim.microapplet.wechat.applet.live;

import com.asialjim.microapplet.remote.http.annotation.HttpMethod;
import com.asialjim.microapplet.remote.http.annotation.HttpMapping;
import com.asialjim.microapplet.remote.http.annotation.body.JsonBody;
import com.asialjim.microapplet.remote.net.annotation.Server;
import com.asialjim.microapplet.wechat.applet.live.request.*;
import com.asialjim.microapplet.wechat.applet.live.response.*;
import com.asialjim.microapplet.wechat.applet.message.meta.BaseWeChatMessageRes;
import com.asialjim.microapplet.wechat.constant.WeChatCons;
import com.asialjim.microapplet.wechat.remoting.context.WeChatAccessTokenParam;

/**
 * 微信小程序直播管理远程调用接口
 * 接口文档：<a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/livebroadcast/studio-management/createRoom.html">...</a>
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/10/30, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Server(
        supplier = WeChatCons.Supplier.WECHAT,
        namespace = WeChatCons.Namespace.COMMON,
        schema = WeChatCons.Api.DEFAULT_SCHEMA,
        host = WeChatCons.Api.DEFAULT_HOST,
        port = WeChatCons.Api.DEFAULT_PORT
)
public interface WeChatAppletLiveManageRemoting {

    /**
     * 创建直播间
     * 调用此接口创建直播间，创建成功后将在直播间列表展示
     * <p>
     * 接口英文名: createRoom
     * 调用方式: HTTPS调用
     * 请求地址: <a href="https://api.weixin.qq.com/wxaapi/broadcast/room/create">...</a>
     *
     * @param request 创建直播间请求参数
     * @return 创建直播间响应结果
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxaapi/broadcast/room/create")
    CreateRoomResponse createRoom(@WeChatAccessTokenParam String weChatIndex, @JsonBody CreateRoomRequest request);
    
    /**
     * 获取直播间列表
     * 获取直播间信息列表
     * <p>
     * 接口英文名: getLiveInfo
     * 调用方式: HTTPS调用
     * 请求地址: <a href="https://api.weixin.qq.com/wxa/business/getliveinfo">...</a>
     *
     * @param request 获取直播间信息请求参数
     * @return 获取直播间信息响应结果
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxa/business/getliveinfo")
    GetLiveInfoResponse getLiveInfo(@WeChatAccessTokenParam String weChatIndex, @JsonBody GetLiveInfoRequest request);
    
    /**
     * 删除直播间
     * 删除直播间
     * <p>
     * 接口英文名: deleteRoom
     * 调用方式: HTTPS调用
     * 请求地址: <a href="https://api.weixin.qq.com/wxaapi/broadcast/room/deleteroom">...</a>
     *
     * @param request 删除直播间请求参数
     * @return 删除直播间响应结果
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxaapi/broadcast/room/deleteroom")
    BaseWeChatMessageRes deleteRoom(@WeChatAccessTokenParam String weChatIndex, @JsonBody DeleteRoomRequest request);

    
    /**
     * 编辑直播间
     * 编辑直播间
     * <p>
     * 接口英文名: editRoom
     * 调用方式: HTTPS调用
     * 请求地址: <a href="https://api.weixin.qq.com/wxaapi/broadcast/room/editroom">...</a>
     *
     * @param request 编辑直播间请求参数
     * @return 编辑直播间响应结果
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxaapi/broadcast/room/editroom")
    BaseWeChatMessageRes editRoom(@WeChatAccessTokenParam String weChatIndex, @JsonBody EditRoomRequest request);
    
    /**
     * 获取推流地址
     * 获取推流地址
     * <p>
     * 接口英文名: getPushUrl
     * 调用方式: HTTPS调用
     * 请求地址: <a href="https://api.weixin.qq.com/wxaapi/broadcast/room/getpushurl">...</a>
     *
     * @param request 获取推流地址请求参数
     * @return 获取推流地址响应结果
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxaapi/broadcast/room/getpushurl")
    GetPushUrlResponse getPushUrl(@WeChatAccessTokenParam String weChatIndex, @JsonBody GetPushUrlRequest request);
    
    /**
     * 获取分享二维码
     * 获取分享二维码
     * <p>
     * 接口英文名: getSharedCode
     * 调用方式: HTTPS调用
     * 请求地址: <a href="https://api.weixin.qq.com/wxaapi/broadcast/room/getsharedcode">...</a>
     *
     * @param request 获取分享二维码请求参数
     * @return 获取分享二维码响应结果
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxaapi/broadcast/room/getsharedcode")
    GetSharedCodeResponse getSharedCode(@WeChatAccessTokenParam String weChatIndex, @JsonBody GetSharedCodeRequest request);
    
    /**
     * 获取主播副号列表
     * 获取主播副号列表
     * <p>
     * 接口英文名: getSubAnchor
     * 调用方式: HTTPS调用
     * 请求地址: <a href="https://api.weixin.qq.com/wxaapi/broadcast/room/getsubanchor">...</a>
     *
     * @param request 获取主播副号列表请求参数
     * @return 获取主播副号列表响应结果
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxaapi/broadcast/room/getsubanchor")
    GetSubAnchorResponse getSubAnchor(@WeChatAccessTokenParam String weChatIndex, @JsonBody GetSubAnchorRequest request);
    
    /**
     * 添加主播副号
     * 添加主播副号
     * <p>
     * 接口英文名: addSubAnchor
     * 调用方式: HTTPS调用
     * 请求地址: <a href="https://api.weixin.qq.com/wxaapi/broadcast/room/addsubanchor">...</a>
     *
     * @param request 添加主播副号请求参数
     * @return 添加主播副号响应结果
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxaapi/broadcast/room/addsubanchor")
    BaseWeChatMessageRes addSubAnchor(@WeChatAccessTokenParam String weChatIndex, @JsonBody AddSubAnchorRequest request);
    
    /**
     * 修改主播副号
     * 修改主播副号
     * <p>
     * 接口英文名: modifySubAnchor
     * 调用方式: HTTPS调用
     * 请求地址: <a href="https://api.weixin.qq.com/wxaapi/broadcast/room/modifysubanchor">...</a>
     *
     * @param request 修改主播副号请求参数
     * @return 修改主播副号响应结果
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxaapi/broadcast/room/modifysubanchor")
    BaseWeChatMessageRes modifySubAnchor(@WeChatAccessTokenParam String weChatIndex, @JsonBody ModifySubAnchorRequest request);
    
    /**
     * 删除主播副号
     * 删除主播副号
     * <p>
     * 接口英文名: deleteSubAnchor
     * 调用方式: HTTPS调用
     * 请求地址: <a href="https://api.weixin.qq.com/wxaapi/broadcast/room/deletesubanchor">...</a>
     *
     * @param request 删除主播副号请求参数
     * @return 删除主播副号响应结果
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxaapi/broadcast/room/deletesubanchor")
    BaseWeChatMessageRes deleteSubAnchor(@WeChatAccessTokenParam String weChatIndex, @JsonBody DeleteSubAnchorRequest request);
    
    /**
     * 导入商品
     * 导入商品
     * <p>
     * 接口英文名: importGoods
     * 调用方式: HTTPS调用
     * 请求地址: <a href="https://api.weixin.qq.com/wxaapi/broadcast/room/addgoods">...</a>
     *
     * @param request 导入商品请求参数
     * @return 导入商品响应结果
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxaapi/broadcast/room/addgoods")
    BaseWeChatMessageRes importGoods(@WeChatAccessTokenParam String weChatIndex, @JsonBody ImportGoodsRequest request);
    
    /**
     * 删除商品
     * 删除商品
     * <p>
     * 接口英文名: deleteDoods
     * 调用方式: HTTPS调用
     * 请求地址: <a href="https://api.weixin.qq.com/wxaapi/broadcast/goods/deleteInRoom">...</a>
     *
     * @param request 删除商品请求参数
     * @return 删除商品响应结果
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxaapi/broadcast/goods/deleteInRoom")
    BaseWeChatMessageRes deleteGoods(@WeChatAccessTokenParam String weChatIndex, @JsonBody DeleteDoodsRequest request);
    
    /**
     * 上架商品
     * 上架商品
     * <p>
     * 接口英文名: pushGoods
     * 调用方式: HTTPS调用
     * 请求地址: <a href="https://api.weixin.qq.com/wxaapi/broadcast/goods/push">...</a>
     *
     * @param request 上架商品请求参数
     * @return 上架商品响应结果
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxaapi/broadcast/goods/push")
    BaseWeChatMessageRes pushGoods(@WeChatAccessTokenParam String weChatIndex, @JsonBody PushGoodsRequest request);
    
    /**
     * 商品上下架
     * 商品上下架
     * <p>
     * 接口英文名: SaleGoods
     * 调用方式: HTTPS调用
     * 请求地址: <a href="https://api.weixin.qq.com/wxaapi/broadcast/goods/onsale">...</a>
     *
     * @param request 商品上下架请求参数
     * @return 商品上下架响应结果
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxaapi/broadcast/goods/onsale")
    BaseWeChatMessageRes saleGoods(@WeChatAccessTokenParam String weChatIndex, @JsonBody SaleGoodsRequest request);
    
    /**
     * 商品排序
     * 商品排序
     * <p>
     * 接口英文名: sortGoods
     * 调用方式: HTTPS调用
     * 请求地址: <a href="https://api.weixin.qq.com/wxaapi/broadcast/goods/sort">...</a>
     *
     * @param request 商品排序请求参数
     * @return 商品排序响应结果
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxaapi/broadcast/goods/sort")
    BaseWeChatMessageRes sortGoods(@WeChatAccessTokenParam String weChatIndex, @JsonBody SortGoodsRequest request);
    
    /**
     * 添加直播助手
     * 添加直播助手
     * <p>
     * 接口英文名: addveAssistant
     * 调用方式: HTTPS调用
     * 请求地址: <a href="https://api.weixin.qq.com/wxaapi/broadcast/room/addassistant">...</a>
     *
     * @param request 添加直播助手请求参数
     * @return 添加直播助手响应结果
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxaapi/broadcast/room/addassistant")
    BaseWeChatMessageRes addAssistant(@WeChatAccessTokenParam String weChatIndex, @JsonBody AddveAssistantRequest request);
    
    /**
     * 删除直播助手
     * 删除直播助手
     * <p>
     * 接口英文名: removeAssistant
     * 调用方式: HTTPS调用
     * 请求地址: <a href="https://api.weixin.qq.com/wxaapi/broadcast/room/removeassistant">...</a>
     *
     * @param request 删除直播助手请求参数
     * @return 删除直播助手响应结果
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxaapi/broadcast/room/removeassistant")
    BaseWeChatMessageRes removeAssistant(@WeChatAccessTokenParam String weChatIndex, @JsonBody RemoveAssistantRequest request);
    
    /**
     * 修改直播助手
     * 修改直播助手
     * <p>
     * 接口英文名: modifyAssistant
     * 调用方式: HTTPS调用
     * 请求地址: <a href="https://api.weixin.qq.com/wxaapi/broadcast/room/modifyassistant">...</a>
     *
     * @param request 修改直播助手请求参数
     * @return 修改直播助手响应结果
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxaapi/broadcast/room/modifyassistant")
    BaseWeChatMessageRes modifyAssistant(@WeChatAccessTokenParam String weChatIndex, @JsonBody ModifyAssistantRequest request);
    
    /**
     * 获取直播助手列表
     * 获取直播助手列表
     * <p>
     * 接口英文名: getAssistantList
     * 调用方式: HTTPS调用
     * 请求地址: <a href="https://api.weixin.qq.com/wxaapi/broadcast/room/getassistantlist">...</a>
     *
     * @param request 获取直播助手列表请求参数
     * @return 获取直播助手列表响应结果
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxaapi/broadcast/room/getassistantlist")
    GetAssistantListResponse getAssistantList(@WeChatAccessTokenParam String weChatIndex, @JsonBody GetAssistantListRequest request);
    
    /**
     * 开关直播间评论
     * 开关直播间评论
     * <p>
     * 接口英文名: updateComment
     * 调用方式: HTTPS调用
     * 请求地址: <a href="https://api.weixin.qq.com/wxaapi/broadcast/room/updatecomment">...</a>
     *
     * @param request 开关直播间评论请求参数
     * @return 开关直播间评论响应结果
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxaapi/broadcast/room/updatecomment")
    BaseWeChatMessageRes updateComment(@WeChatAccessTokenParam String weChatIndex, @JsonBody UpdateCommentRequest request);
    
    /**
     * 开关直播回放功能
     * 开关直播回放功能
     * <p>
     * 接口英文名: updateFeedPublic
     * 调用方式: HTTPS调用
     * 请求地址: <a href="https://api.weixin.qq.com/wxaapi/broadcast/room/updatefeedpublic">...</a>
     *
     * @param request 开关直播回放功能请求参数
     * @return 开关直播回放功能响应结果
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxaapi/broadcast/room/updatefeedpublic")
    BaseWeChatMessageRes updateFeedPublic(@WeChatAccessTokenParam String weChatIndex, @JsonBody UpdateFeedPublicRequest request);
    
    /**
     * 设置客服微信号
     * 设置客服微信号
     * <p>
     * 接口英文名: updateKF
     * 调用方式: HTTPS调用
     * 请求地址: <a href="https://api.weixin.qq.com/wxaapi/broadcast/room/updatekf">...</a>
     *
     * @param request 设置客服微信号请求参数
     * @return 设置客服微信号响应结果
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxaapi/broadcast/room/updatekf")
    BaseWeChatMessageRes updateKF(@WeChatAccessTokenParam String weChatIndex, @JsonBody UpdateKFRequest request);
    
    /**
     * 修改回放状态
     * 修改回放状态
     * <p>
     * 接口英文名: updateReplay
     * 调用方式: HTTPS调用
     * 请求地址: <a href="https://api.weixin.qq.com/wxaapi/broadcast/room/updatereplay">...</a>
     *
     * @param request 修改回放状态请求参数
     * @return 修改回放状态响应结果
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxaapi/broadcast/room/updatereplay")
    BaseWeChatMessageRes updateReplay(@WeChatAccessTokenParam String weChatIndex, @JsonBody UpdateReplayRequest request);
    
    /**
     * 下载商品视频
     * 下载商品视频
     * <p>
     * 接口英文名: downloadGoodsVideo
     * 调用方式: HTTPS调用
     * 请求地址: https://api.weixin.qq.com/wxaapi/broadcast/goods/getVideo
     * 
     * @param request 下载商品视频请求参数
     * @return 下载商品视频响应结果
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxaapi/broadcast/goods/getVideo")
    DownloadGoodsVideoResponse downloadGoodsVideo(@WeChatAccessTokenParam String weChatIndex, @JsonBody DownloadGoodsVideoRequest request);
}