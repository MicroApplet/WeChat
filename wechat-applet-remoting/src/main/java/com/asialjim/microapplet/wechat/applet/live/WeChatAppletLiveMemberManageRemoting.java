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
 * 微信小程序直播成员管理远程调用接口
 * 接口文档：<a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/livebroadcast/role-management/getRoleListdw.html">...</a>
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
public interface WeChatAppletLiveMemberManageRemoting {

    /**
     * 设置成员角色
     * 调用此接口设置小程序直播成员的管理员、运营者和主播角色
     * <p>
     * 接口英文名: addRole
     * 调用方式: HTTPS调用
     * 请求地址: <a href="https://api.weixin.qq.com/wxaapi/broadcast/role/addrole">...</a>
     *
     * @param request 设置成员角色请求参数
     * @return 设置成员角色响应结果
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxaapi/broadcast/role/addrole")
    AddRoleResponse addRole(@WeChatAccessTokenParam String weChatIndex, @JsonBody AddRoleRequest request);

    /**
     * 移除成员角色
     * 调用此接口可移除小程序直播成员的管理员、运营者和主播角色
     * <p>
     * 接口英文名: deleteRole
     * 调用方式: HTTPS调用
     * 请求地址: <a href="https://api.weixin.qq.com/wxaapi/broadcast/role/deleterole">...</a>
     *
     * @param request 移除成员角色请求参数
     * @return 移除成员角色响应结果
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxaapi/broadcast/role/deleterole")
    BaseWeChatMessageRes deleteRole(@WeChatAccessTokenParam String weChatIndex, @JsonBody DeleteRoleRequest request);

    /**
     * 查询成员列表
     * 该接口用于查询小程序直播成员列表
     * <p>
     * 接口英文名: getRoleList
     * 调用方式: HTTPS调用
     * 请求地址: <a href="https://api.weixin.qq.com/wxaapi/broadcast/role/getrolelist">...</a>
     *
     * @param request 查询成员列表请求参数
     * @return 查询成员列表响应结果
     */
    @HttpMapping(method = HttpMethod.GET, uri = "/wxaapi/broadcast/role/getrolelist")
    GetRoleListResponse getRoleList(@WeChatAccessTokenParam String weChatIndex, @JsonBody GetRoleListRequest request);
}