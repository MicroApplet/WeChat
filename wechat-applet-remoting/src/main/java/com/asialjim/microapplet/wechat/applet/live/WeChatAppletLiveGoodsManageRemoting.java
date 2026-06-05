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
 * 微信小程序直播商品管理远程调用接口
 * 接口文档：<a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/livebroadcast/commodity-management/addGoods.html">商品管理接口</a>
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
public interface WeChatAppletLiveGoodsManageRemoting {

    /**
     * 添加并提审商品
     * 调用此接口上传并提审需要直播的商品信息，审核通过后商品录入【小程序直播】商品库
     * <p>
     * 接口英文名: addGoods
     * 调用方式: HTTPS调用
     * 请求地址: <a href="https://api.weixin.qq.com/wxaapi/broadcast/goods/add">...</a>
     *
     * @param request 添加并提审商品请求参数
     * @return 添加并提审商品响应结果
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxaapi/broadcast/goods/add")
    AddGoodsResponse addGoods(@WeChatAccessTokenParam String weChatIndex, @JsonBody AddGoodsRequest request);
    
    /**
     * 重新提交商品审核
     * 调用此接口可以对已撤回提审的商品再次发起提审申请
     * <p>
     * 接口英文名: resubmitAudit
     * 调用方式: HTTPS调用
     * 请求地址: <a href="https://api.weixin.qq.com/wxaapi/broadcast/goods/audit">...</a>
     *
     * @param request 重新提交商品审核请求参数
     * @return 重新提交商品审核响应结果
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxaapi/broadcast/goods/audit")
    ResubmitAuditResponse resubmitAudit(@WeChatAccessTokenParam String weChatIndex, @JsonBody ResubmitAuditRequest request);
    
    /**
     * 获取商品的信息与审核状态
     * 该接口用于获取商品的信息与审核状态
     * <p>
     * 接口英文名: getGoodsAuditInfo
     * 调用方式: HTTPS调用
     * 请求地址: <a href="https://api.weixin.qq.com/wxa/business/getgoodswarehouse">...</a>
     *
     * @param request 获取商品的信息与审核状态请求参数
     * @return 获取商品的信息与审核状态响应结果
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxa/business/getgoodswarehouse")
    GetGoodsAuditInfoResponse getGoodsAuditInfo(@WeChatAccessTokenParam String weChatIndex, @JsonBody GetGoodsAuditInfoRequest request);

    /**
     * 撤回商品审核
     * 该接口用于撤回商品审核，消耗的提审次数不返还
     * <p>
     * 接口英文名: resetAudit
     * 调用方式: HTTPS调用
     * 请求地址: <a href="https://api.weixin.qq.com/wxaapi/broadcast/goods/resetaudit">...</a>
     *
     * @param request 撤回商品审核请求参数
     * @return 撤回商品审核响应结果
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxaapi/broadcast/goods/resetaudit")
    BaseWeChatMessageRes resetAudit(@WeChatAccessTokenParam String weChatIndex, @JsonBody ResetAuditRequest request);
    
    /**
     * 更新商品
     * 调用此接口可以更新商品信息，审核通过的商品仅允许更新价格类型与价格，审核中的商品不允许更新，未审核的商品允许更新所有字段
     * <p>
     * 接口英文名: updateGoodsinfo
     * 调用方式: HTTPS调用
     * 请求地址: <a href="https://api.weixin.qq.com/wxaapi/broadcast/goods/update">...</a>
     *
     * @param request 更新商品请求参数
     * @return 更新商品响应结果
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxaapi/broadcast/goods/update")
    BaseWeChatMessageRes updateGoodsinfo(@WeChatAccessTokenParam String weChatIndex, @JsonBody UpdateGoodsinfoRequest request);
    
    /**
     * 获取商品列表
     * 该接口用户获取不同审核状态的商品信息
     * <p>
     * 接口英文名: getGoodsInfo
     * 调用方式: HTTPS调用
     * 请求地址: <a href="https://api.weixin.qq.com/wxaapi/broadcast/goods/getapproved">...</a>
     *
     * @param request 获取商品列表请求参数
     * @return 获取商品列表响应结果
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxaapi/broadcast/goods/getapproved")
    GetGoodsListResponse getGoodsInfo(@WeChatAccessTokenParam String weChatIndex, @JsonBody GetGoodsListRequest request);
    
    /**
     * 删除商品
     * 调用此接口，可删除【小程序直播】商品库中的商品，删除后直播间上架的该商品也将被同步删除，不可恢复
     * <p>
     * 接口英文名: deleteGoodsInfo
     * 调用方式: HTTPS调用
     * 请求地址: <a href="https://api.weixin.qq.com/wxaapi/broadcast/goods/delete">...</a>
     *
     * @param request 删除商品请求参数
     * @return 删除商品响应结果
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxaapi/broadcast/goods/delete")
    BaseWeChatMessageRes deleteGoodsInfo(@WeChatAccessTokenParam String weChatIndex, @JsonBody DeleteGoodsInfoRequest request);
}