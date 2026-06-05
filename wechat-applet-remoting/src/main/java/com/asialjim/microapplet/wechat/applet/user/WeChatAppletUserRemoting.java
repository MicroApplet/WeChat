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

package com.asialjim.microapplet.wechat.applet.user;

import com.asialjim.microapplet.remote.http.annotation.HttpMapping;
import com.asialjim.microapplet.remote.http.annotation.HttpMethod;
import com.asialjim.microapplet.remote.http.annotation.HttpQuery;
import com.asialjim.microapplet.remote.http.annotation.body.JsonBody;
import com.asialjim.microapplet.remote.net.annotation.Server;
import com.asialjim.microapplet.remote.net.response.JsonResult;
import com.asialjim.microapplet.wechat.applet.meta.UserAuthorizationCode;
import com.asialjim.microapplet.wechat.applet.user.meta.CheckEncryptedDataRes;
import com.asialjim.microapplet.wechat.applet.user.meta.GetPaidUnionidRes;
import com.asialjim.microapplet.wechat.applet.user.meta.GetPluginOpenPIdRes;
import com.asialjim.microapplet.wechat.applet.user.meta.GetUserEncryptKeyRes;
import com.asialjim.microapplet.wechat.applet.user.meta.GetUserPhoneNumberRes;
import com.asialjim.microapplet.wechat.applet.user.meta.ResetUserSessionKeyRes;
import com.asialjim.microapplet.wechat.applet.user.meta.WeChatAppletUserLoginRes;
import com.asialjim.microapplet.wechat.constant.WeChatCons;
import com.asialjim.microapplet.wechat.remoting.context.BaseWeChatApiRes;
import com.asialjim.microapplet.wechat.remoting.context.WeChatAccessTokenParam;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 微信小程序用户相关服务API客户端
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/2/25, &nbsp;&nbsp; <em>version:1.0</em>
 */
@JsonResult
@Server(
        supplier = WeChatCons.Supplier.WECHAT,
        namespace = WeChatCons.Namespace.COMMON,
        schema = WeChatCons.Api.DEFAULT_SCHEMA,
        host = WeChatCons.Api.DEFAULT_HOST,
        port = WeChatCons.Api.DEFAULT_PORT
)
public interface WeChatAppletUserRemoting {

    /**
     * 小程序用户登录
     *
     * @param appid  应用编号
     * @param secret 密码
     * @param code   授权码
     */
    @HttpMapping(method = HttpMethod.GET, uri = "/sns/jscode2session", queries = @HttpQuery(name = "grant_type", value = "client_credential"))
    WeChatAppletUserLoginRes login(@HttpQuery(name = "appid") String appid, @HttpQuery(name = "secret") String secret, @HttpQuery(name = "js_code") String code);

    /**
     * 获取用户手机号
     *
     * @param weChatIndex {@link String weChatIndex}
     * @param code        {@link UserAuthorizationCode code}
     * @return {@link GetUserPhoneNumberRes }
     * @since 2025/10/30
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxa/business/getuserphonenumber")
    GetUserPhoneNumberRes userPhoneNumber(@WeChatAccessTokenParam String weChatIndex, @JsonBody UserAuthorizationCode code);

    /**
     * 检验登录态
     *
     * @param weChatIndex {@link String weChatIndex}
     * @param openid      用户唯一标识符
     * @param signature   用户登录态签名，用session_key对空字符串签名得到的结果
     * @param sigMethod   用户登录态签名的哈希方法，目前只支持hmac_sha256
     * @return {@link BaseWeChatApiRes}
     * @since 2025/10/30
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxa/checksessionkey")
    BaseWeChatApiRes checkSessionKey(@WeChatAccessTokenParam String weChatIndex,
                                       @HttpQuery(name = "openid") String openid,
                                       @HttpQuery(name = "signature") String signature,
                                       @HttpQuery(name = "sig_method") String sigMethod);
    
    /**
     * 重置登录态
     *
     * @param weChatIndex {@link String weChatIndex}
     * @param openid      用户唯一标识符
     * @param signature   用户登录态签名，用session_key对空字符串签名得到的结果
     * @param sigMethod   用户登录态签名的哈希方法，目前只支持hmac_sha256
     * @return {@link ResetUserSessionKeyRes}
     * @since 2025/10/30
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxa/resetusersessionkey")
    ResetUserSessionKeyRes resetUserSessionKey(@WeChatAccessTokenParam String weChatIndex,
                                       @HttpQuery(name = "openid") String openid,
                                       @HttpQuery(name = "signature") String signature,
                                       @HttpQuery(name = "sig_method") String sigMethod);
    
    /**
     * 获取插件用户openpid
     *
     * @param weChatIndex {@link String weChatIndex}
     * @param code        通过wx.pluginLogin获得的插件用户标志凭证code，有效时间为5分钟，一个code只能获取一次openpid
     * @return {@link GetPluginOpenPIdRes}
     * @since 2025/10/30
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxa/getpluginopenpid")
    GetPluginOpenPIdRes getPluginOpenPId(@WeChatAccessTokenParam String weChatIndex,
                                       @HttpQuery(name = "code") String code);
    
    /**
     * 检查加密信息
     * <p>
     * 检验数据的有效性，包括用户信息、手机号、收货地址等加密数据
     *
     * @param weChatIndex   微信索引
     * @param encryptedData 加密数据
     * @param iv            加密算法的初始向量
     * @param signature     数据签名，用于验证数据的完整性
     * @param sigMethod     签名方法，如：HMAC-SHA256
     * @return {@link CheckEncryptedDataRes}
     * @since 2025/10/30
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxa/checkencrypteddata")
    CheckEncryptedDataRes checkEncryptedData(@WeChatAccessTokenParam String weChatIndex,
                                        @HttpQuery(name = "encryptedData") String encryptedData,
                                        @HttpQuery(name = "iv") String iv,
                                        @HttpQuery(name = "signature") String signature,
                                        @HttpQuery(name = "sig_method") String sigMethod);

    /**
     * 支付后获取Unionid
     * <p>
     * 该接口用于在用户支付完成后，获取该用户的UnionId，无需用户授权
     * 调用前需要用户完成支付，且在支付后的五分钟内有效
     * <p>
     * 使用微信支付订单号（transaction_id）和微信支付商户订单号和微信支付商户号（out_trade_no 及 mch_id），二选一
     *
     * @param weChatIndex    微信索引
     * @param openid         支付用户唯一标识
     * @param transactionId  微信支付订单号（与mchId和outTradeNo二选一）
     * @param mchId          微信支付分配的商户号（与outTradeNo配合使用）
     * @param outTradeNo     微信支付商户订单号（与mchId配合使用）
     * @return {@link GetPaidUnionidRes}
     * @since 2025/10/30
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxa/getpaidunionid")
    GetPaidUnionidRes getPaidUnionid(@WeChatAccessTokenParam String weChatIndex,
                                      @HttpQuery(name = "openid") String openid,
                                      @HttpQuery(name = "transaction_id") String transactionId,
                                      @HttpQuery(name = "mch_id") String mchId,
                                      @HttpQuery(name = "out_trade_no") String outTradeNo);

    /**
     * 获取用户encryptKey
     * <p>
     * 该接口用于获取用户encryptKey，会获取用户最近3次的key，每个key的存活时间为3600s
     *
     * @param weChatIndex 微信索引
     * @param openid      用户的openid
     * @param signature   用sessionkey作为密钥对空字符串签名得到的结果，session_key可通过code2Session接口获得
     * @param sigMethod   签名方法，只支持hmac_sha256
     * @return {@link GetUserEncryptKeyRes}
     * @since 2025/10/30
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxa/getuserencryptkey")
    GetUserEncryptKeyRes getUserEncryptKey(@WeChatAccessTokenParam String weChatIndex,
                                         @HttpQuery(name = "openid") String openid,
                                         @HttpQuery(name = "signature") String signature,
                                         @HttpQuery(name = "sig_method") String sigMethod);
    
    /**
     * 获取用户安全等级
     * <p>
     * 该接口用于根据提交的用户信息数据获取用户的安全等级 risk_rank（无需用户授权）
     * 官方文档：<a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/sec-center/safety-control-capability/getUserRiskRank.html">...</a>
     *
     * @param weChatIndex 微信索引
     * @param req         用户安全等级请求参数
     * @return {@link GetUserRiskRankRes}
     * @since 2025/11/01
     */
    @HttpMapping(method = HttpMethod.POST, uri = "/wxa/getuserriskrank")
    GetUserRiskRankRes getUserRiskRank(@WeChatAccessTokenParam String weChatIndex, @JsonBody GetUserRiskRankReq req);
    
    /**
     * 获取用户安全等级请求参数
     */
    @Data
    @Accessors(chain = true)
    class GetUserRiskRankReq implements Serializable {
        /**
         * 小程序appid
         */
        private String appid;
        
        /**
         * 用户的openid
         */
        private String openid;
        
        /**
         * 场景值，0:注册，1:营销作弊
         */
        private Integer scene;
        
        /**
         * 用户手机号（可选）
         */
        private String mobile_no;
        
        /**
         * 用户访问源ip（必填）
         */
        private String client_ip;
        
        /**
         * 用户邮箱地址（可选）
         */
        private String email_address;
        
        /**
         * 额外补充信息（可选）
         */
        private String extended_info;
        
        /**
         * 是否测试调用，默认false
         */
        private Boolean is_test;
    }
    
    /**
     * 获取用户安全等级响应结果
     */
    @Data
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    class GetUserRiskRankRes extends BaseWeChatApiRes {
        /**
         * 用户风险等级，合法值为0,1,2,3,4，数字越大风险越高
         */
        private Integer risk_rank;
        
        /**
         * 唯一请求标识，标记单次请求
         */
        private String unoin_id;
    }
}