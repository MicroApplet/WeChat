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
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @since 2024/3/19, &nbsp;&nbsp; <em>version:</em>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JacksonXmlRootElement(localName = "xml")
public class WeChatOfficialInputXmlMessage implements Serializable {
    private static final long serialVersionUID = -4677044429096299272L;

    @JacksonXmlCData
    @JacksonXmlProperty(localName = "ToUserName")
    private String toUserName;

    @JacksonXmlCData
    @JacksonXmlProperty(localName = "FromUserName")
    private String fromUserName;

    @JacksonXmlProperty(localName = "CreateTime")
    private Long createTime;

    @JacksonXmlCData
    @JacksonXmlProperty(localName = "MsgType")
    private String msgType;

    @JacksonXmlCData
    @JacksonXmlProperty(localName = "Content")
    private String content;

    @JacksonXmlProperty(localName = "MenuId")
    private Long menuId;

    @JacksonXmlProperty(localName = "MsgId")
    private Long msgId;

    @JacksonXmlCData
    @JacksonXmlProperty(localName = "PicUrl")
    private String picUrl;

    @JacksonXmlCData
    @JacksonXmlProperty(localName = "MediaId")
    private String mediaId;

    @JacksonXmlCData
    @JacksonXmlProperty(localName = "Format")
    private String format;

    @JacksonXmlCData
    @JacksonXmlProperty(localName = "ThumbMediaId")
    private String thumbMediaId;

    @JacksonXmlProperty(localName = "Location_X")
    private Double locationX;

    @JacksonXmlProperty(localName = "Location_Y")
    private Double locationY;

    @JacksonXmlProperty(localName = "Scale")
    private Double scale;

    @JacksonXmlCData
    @JacksonXmlProperty(localName = "Label")
    private String label;

    @JacksonXmlCData
    @JacksonXmlProperty(localName = "Title")
    private String title;

    @JacksonXmlCData
    @JacksonXmlProperty(localName = "Description")
    private String description;

    @JacksonXmlCData
    @JacksonXmlProperty(localName = "Url")
    private String url;

    @JacksonXmlCData
    @JacksonXmlProperty(localName = "Event")
    private String event;

    @JacksonXmlCData
    @JacksonXmlProperty(localName = "EventKey")
    private String eventKey;

    @JacksonXmlCData
    @JacksonXmlProperty(localName = "Ticket")
    private String ticket;

    @JacksonXmlProperty(localName = "Latitude")
    private Double latitude;

    @JacksonXmlProperty(localName = "Longitude")
    private Double longitude;

    @JacksonXmlProperty(localName = "Precision")
    private Double precision;

    @JacksonXmlCData
    @JacksonXmlProperty(localName = "Recognition")
    private String recognition;

    @JacksonXmlCData
    @JacksonXmlProperty(localName = "UnionId")
    private String unionId;

    ///////////////////////////////////////
    // 群发消息返回的结果
    ///////////////////////////////////////
    /**
     * 群发的结果.
     */
    @JacksonXmlCData
    @JacksonXmlProperty(localName = "Status")
    private String status;

    /**
     * group_id下粉丝数；或者openid_list中的粉丝数.
     */
    @JacksonXmlProperty(localName = "TotalCount")
    private Integer totalCount;

    /**
     * 过滤（过滤是指特定地区、性别的过滤、用户设置拒收的过滤，用户接收已超4条的过滤）后，准备发送的粉丝数.
     * 原则上，filterCount = sentCount + errorCount
     */
    @JacksonXmlProperty(localName = "FilterCount")
    private Integer filterCount;

    /**
     * 发送成功的粉丝数.
     */
    @JacksonXmlProperty(localName = "SentCount")
    private Integer sentCount;

    /**
     * 发送失败的粉丝数.
     */
    @JacksonXmlProperty(localName = "ErrorCount")
    private Integer errorCount;

    ///////////////////////////////////////
    // 客服会话管理相关事件推送
    ///////////////////////////////////////
    /**
     * 创建或关闭客服会话时的客服帐号.
     */
    @JacksonXmlProperty(localName = "KfAccount")
    private String kfAccount;

    /**
     * 转接客服会话时的转入客服帐号.
     */
    @JacksonXmlProperty(localName = "ToKfAccount")
    private String toKfAccount;

    /**
     * 转接客服会话时的转出客服帐号.
     */
    @JacksonXmlProperty(localName = "FromKfAccount")
    private String fromKfAccount;

    ///////////////////////////////////////
    // 卡券相关事件推送
    ///////////////////////////////////////
    @JacksonXmlCData
    @JacksonXmlProperty(localName = "CardId")
    private String cardId;

    @JacksonXmlCData
    @JacksonXmlProperty(localName = "FriendUserName")
    private String friendUserName;

    /**
     * 是否为转赠，1代表是，0代表否.
     */
    @JacksonXmlProperty(localName = "IsGiveByFriend")
    private Integer isGiveByFriend;

    @JacksonXmlCData
    @JacksonXmlProperty(localName = "UserCardCode")
    private String userCardCode;

    @JacksonXmlCData
    @JacksonXmlProperty(localName = "OldUserCardCode")
    private String oldUserCardCode;

    @JacksonXmlProperty(localName = "OuterId")
    private Integer outerId;

    /**
     * 用户删除会员卡后可重新找回，当用户本次操作为找回时，该值为1，否则为0.
     */
    @JacksonXmlProperty(localName = "IsRestoreMemberCard")
    private String isRestoreMemberCard;

    /**
     * <pre>
     * 领取场景值，用于领取渠道数据统计。可在生成二维码接口及添加Addcard接口中自定义该字段的字符串值.
     * 核销卡券时：开发者发起核销时传入的自定义参数，用于进行核销渠道统计
     * 另外：
     * 官网文档中，微信卡券>>卡券事件推送>>2.7 进入会员卡事件推送 user_view_card
     * OuterStr：商户自定义二维码渠道参数，用于标识本次扫码打开会员卡来源来自于某个渠道值的二维码
     * </pre>
     */
    @JacksonXmlProperty(localName = "OuterStr")
    private String outerStr;

    /**
     * 是否转赠退回，0代表不是，1代表是.
     */
    @JacksonXmlProperty(localName = "IsReturnBack")
    private String isReturnBack;

    /**
     * 是否是群转赠，0代表不是，1代表是.
     */
    @JacksonXmlProperty(localName = "IsChatRoom")
    private String isChatRoom;

    /**
     * 核销来源.
     * 支持开发者统计API核销（FROM_API）、公众平台核销（FROM_MP）、卡券商户助手核销（FROM_MOBILE_HELPER）（核销员微信号）
     */
    @JacksonXmlProperty(localName = "ConsumeSource")
    private String consumeSource;

    /**
     * 门店名称.
     * 当前卡券核销的门店名称（只有通过自助核销和买单核销时才会出现该字段）
     */
    @JacksonXmlProperty(localName = "LocationName")
    private String locationName;

    /**
     * 核销该卡券核销员的openid（只有通过卡券商户助手核销时才会出现）.
     */
    @JacksonXmlProperty(localName = "StaffOpenId")
    private String staffOpenId;

    /**
     * 自助核销时，用户输入的验证码.
     */
    @JacksonXmlProperty(localName = "VerifyCode")
    private String verifyCode;

    /**
     * 自助核销时，用户输入的备注金额.
     */
    @JacksonXmlProperty(localName = "RemarkAmount")
    private String remarkAmount;

    /**
     * <pre>
     * 官网文档中，微信卡券>>卡券事件推送>>2.10 库存报警事件card_sku_remind
     * Detail：报警详细信息.
     * </pre>
     */
    @JacksonXmlProperty(localName = "Detail")
    private String detail;

    /**
     * <pre>
     * 官网文档中，微信卡券>>卡券事件推送>>2.9 会员卡内容更新事件 update_member_card
     * ModifyBonus：变动的积分值.
     * </pre>
     */
    @JacksonXmlProperty(localName = "ModifyBonus")
    private String modifyBonus;

    /**
     * <pre>
     * 官网文档中，微信卡券>>卡券事件推送>>2.9 会员卡内容更新事件 update_member_card
     * ModifyBalance：变动的余额值.
     * </pre>
     */
    @JacksonXmlProperty(localName = "ModifyBalance")
    private String modifyBalance;

    /**
     * <pre>
     * 官网文档中，微信卡券>>卡券事件推送>>2.6 买单事件推送 User_pay_from_pay_cell
     * TransId：微信支付交易订单号（只有使用买单功能核销的卡券才会出现）.
     * </pre>
     */
    @JacksonXmlProperty(localName = "TransId")
    private String transId;

    /**
     * <pre>
     * 官网文档中，微信卡券>>卡券事件推送>>2.6 买单事件推送 User_pay_from_pay_cell
     * LocationId：门店ID，当前卡券核销的门店ID（只有通过卡券商户助手和买单核销时才会出现）
     * </pre>
     */
    @JacksonXmlProperty(localName = "LocationId")
    private String locationId;

    /**
     * <pre>
     * 官网文档中，微信卡券>>卡券事件推送>>2.6 买单事件推送 User_pay_from_pay_cell
     * Fee：实付金额，单位为分
     * </pre>
     */
    @JacksonXmlProperty(localName = "Fee")
    private String fee;

    /**
     * <pre>
     * 官网文档中，微信卡券>>卡券事件推送>>2.6 买单事件推送 User_pay_from_pay_cell
     * OriginalFee：应付金额，单位为分
     * </pre>
     */
    @JacksonXmlProperty(localName = "OriginalFee")
    private String originalFee;

    @JacksonXmlProperty(localName = "ScanCodeInfo")
    private ScanCodeInfo scanCodeInfo = new ScanCodeInfo();

    @JacksonXmlProperty(localName = "SendPicsInfo")
    private SendPicsInfo sendPicsInfo = new SendPicsInfo();

    @JacksonXmlProperty(localName = "SendLocationInfo")
    private SendLocationInfo sendLocationInfo = new SendLocationInfo();

    /**
     * 审核不通过原因
     */
    @JacksonXmlProperty(localName = "RefuseReason")
    private String refuseReason;

    /**
     * 是否为朋友推荐，0代表否，1代表是
     */
    @JacksonXmlProperty(localName = "IsRecommendByFriend")
    private String isRecommendByFriend;

    /**
     * 购买券点时，实际支付成功的时间
     */
    @JacksonXmlProperty(localName = "PayFinishTime")
    private String payFinishTime;

    /**
     * 购买券点时，支付二维码的生成时间
     */
    @JacksonXmlProperty(localName = "CreateOrderTime")
    private String createOrderTime;

    /**
     * 购买券点时，支付二维码的生成时间
     */
    @JacksonXmlProperty(localName = "Desc")
    private String desc;

    /**
     * 剩余免费券点数量
     */
    @JacksonXmlProperty(localName = "FreeCoinCount")
    private String freeCoinCount;

    /**
     * 剩余付费券点数量
     */
    @JacksonXmlProperty(localName = "PayCoinCount")
    private String payCoinCount;

    /**
     * 本次变动的免费券点数量
     */
    @JacksonXmlProperty(localName = "RefundFreeCoinCount")
    private String refundFreeCoinCount;

    /**
     * 本次变动的付费券点数量
     */
    @JacksonXmlProperty(localName = "RefundPayCoinCount")
    private String refundPayCoinCount;

    /**
     * <pre>
     *    所要拉取的订单类型 ORDER_TYPE_SYS_ADD 平台赠送券点 ORDER_TYPE_WXPAY 充值券点 ORDER_TYPE_REFUND 库存未使用回退券点
     *    ORDER_TYPE_REDUCE 券点兑换库存 ORDER_TYPE_SYS_REDUCE 平台扣减
     * </pre>
     */
    @JacksonXmlProperty(localName = "OrderType")
    private String orderType;

    /**
     * 系统备注，说明此次变动的缘由，如开通账户奖励、门店奖励、核销奖励以及充值、扣减。
     */
    @JacksonXmlProperty(localName = "Memo")
    private String memo;

    /**
     * 所开发票的详情
     */
    @JacksonXmlProperty(localName = "ReceiptInfo")
    private String receiptInfo;


    ///////////////////////////////////////
    // 门店审核事件推送
    ///////////////////////////////////////
    /**
     * 商户自己内部ID，即字段中的sid.
     */
    @JacksonXmlProperty(localName = "UniqId")
    private String storeUniqId;

    /**
     * 微信的门店ID，微信内门店唯一标示ID.
     */
    @JacksonXmlProperty(localName = "PoiId")
    private String poiId;

    /**
     * 审核结果，成功succ 或失败fail.
     * <p>
     * 在商品审核结果推送时，verify_ok表示审核通过，verify_not_pass表示审核未通过。
     */
    @JacksonXmlProperty(localName = "Result")
    private String result;

    /**
     * 成功的通知信息，或审核失败的驳回理由.
     */
    @JacksonXmlProperty(localName = "msg")
    private String msg;

    ///////////////////////////////////////
    // 微信认证事件推送
    ///////////////////////////////////////
    /**
     * 资质认证成功/名称认证成功: 有效期 (整形)，指的是时间戳，将于该时间戳认证过期.
     * 年审通知: 有效期 (整形)，指的是时间戳，将于该时间戳认证过期，需尽快年审
     * 认证过期失效通知: 有效期 (整形)，指的是时间戳，表示已于该时间戳认证过期，需要重新发起微信认证
     */
    @JacksonXmlProperty(localName = "ExpiredTime")
    private Long expiredTime;
    /**
     * 失败发生时间 (整形)，时间戳.
     */
    @JacksonXmlProperty(localName = "FailTime")
    private Long failTime;
    /**
     * 认证失败的原因.
     */
    @JacksonXmlProperty(localName = "FailReason")
    private String failReason;

    ///////////////////////////////////////
    // 微信小店 6.1订单付款通知
    ///////////////////////////////////////
    /**
     * 订单ID.
     */
    @JacksonXmlProperty(localName = "OrderId")
    @JacksonXmlCData
    private String orderId;

    /**
     * 订单状态.
     */
    @JacksonXmlProperty(localName = "OrderStatus")
    private String orderStatus;

    /**
     * 商品ID.
     */
    @JacksonXmlProperty(localName = "ProductId")
    @JacksonXmlCData
    private String productId;

    /**
     * 商品SKU信息.
     */
    @JacksonXmlProperty(localName = "SkuInfo")
    @JacksonXmlCData
    private String skuInfo;

    ///////////////////////////////////////
    // 微信硬件平台相关事件推送
    ///////////////////////////////////////
    /**
     * 设备类型.
     * 目前为"公众账号原始ID"
     */
    @JacksonXmlProperty(localName = "DeviceType")
    @JacksonXmlCData
    private String deviceType;

    /**
     * 设备ID.
     * 第三方提供
     */
    @JacksonXmlProperty(localName = "DeviceID")
    @JacksonXmlCData
    private String deviceId;

    /**
     * 微信客户端生成的session id，用于request和response对应，
     * 因此响应中该字段第三方需要原封不变的带回
     */
    @JacksonXmlProperty(localName = "SessionID")
    @JacksonXmlCData
    private String sessionId;

    /**
     * 微信用户账号的OpenID.
     */
    @JacksonXmlProperty(localName = "OpenID")
    @JacksonXmlCData
    private String openId;

    @JacksonXmlProperty(localName = "HardWare")
    private HardWare hardWare = new HardWare();

    /**
     * 请求类型.
     * 0：退订设备状态；
     * 1：心跳；（心跳的处理方式跟订阅一样）
     * 2：订阅设备状态
     */
    @JacksonXmlProperty(localName = "OpType")
    private Integer opType;

    /**
     * 设备状态.
     * 0：未连接；1：已连接
     */
    @JacksonXmlProperty(localName = "DeviceStatus")
    private Integer deviceStatus;

    ///////////////////////////////////////
    // 小程序 审核事件
    ///////////////////////////////////////
    /**
     * 审核成功时的时间（整形），时间戳
     */
    @JacksonXmlProperty(localName = "SuccTime")
    private Long successTime;

    /**
     * 审核失败的原因
     */
    @JacksonXmlProperty(localName = "Reason")
    private String reason;

    ///////////////////////////////////////
    // 扫一扫事件推送
    ///////////////////////////////////////
    /**
     * 商品编码标准
     */
    @JacksonXmlProperty(localName = "KeyStandard")
    private String keyStandard;
    /**
     * 商品编码内容
     */
    @JacksonXmlProperty(localName = "KeyStr")
    private String keyStr;

    /**
     * 用户在微信内设置的国家
     */
    @JacksonXmlProperty(localName = "Country")
    private String country;

    /**
     * 用户在微信内设置的省份
     */
    @JacksonXmlProperty(localName = "Province")
    private String province;

    /**
     * 用户在微信内设置的城市
     */
    @JacksonXmlProperty(localName = "City")
    private String city;

    /**
     * 用户的性别，1为男性，2为女性，0代表未知
     */
    @JacksonXmlProperty(localName = "Sex")
    private String sex;

    /**
     * 打开商品主页的场景，1为扫码，2为其他打开场景（如会话、收藏或朋友圈）
     */
    @JacksonXmlProperty(localName = "Scene")
    private String scene;

    /**
     * 调用“获取商品二维码接口”时传入的extinfo，为标识参数
     */
    @JacksonXmlProperty(localName = "ExtInfo")
    private String extInfo;

    /**
     * 用户的实时地理位置信息（目前只精确到省一级），可在国家统计局网站查到对应明细： http://www.stats.gov.cn/tjsj/tjbz/xzqhdm/201504/t20150415_712722.html
     */
    @JacksonXmlProperty(localName = "RegionCode")
    private String regionCode;

    /**
     * 审核未通过的原因.
     */
    @JacksonXmlProperty(localName = "ReasonMsg")
    private String reasonMsg;

    /**
     * 给用户发菜单消息类型的客服消息后，用户所点击的菜单ID.
     */
    @JacksonXmlProperty(localName = "bizmsgmenuid")
    private String bizMsgMenuId;

    /*------------------ 电子发票 ------------------*/
    /**
     * 授权成功的订单号，与失败订单号两者必显示其一
     */
    @JacksonXmlProperty(localName = "SuccOrderId")
    private String succOrderId;

    /**
     * 授权失败的订单号，与成功订单号两者必显示其一
     */
    @JacksonXmlProperty(localName = "FailOrderId")
    private String failOrderId;

    /**
     * 获取授权页链接的AppId
     */
    @JacksonXmlProperty(localName = "AuthorizeAppId")
    private String authorizeAppId;

    /**
     * 授权来源，web：公众号开票，app：app开票，wxa：小程序开票，wap：h5开票
     */
    @JacksonXmlProperty(localName = "source")
    private String source;

    /**
     * 发票请求流水号，唯一识别发票请求的流水号
     */
    @JacksonXmlProperty(localName = "fpqqlsh")
    private String fpqqlsh;

    /**
     * 纳税人识别码
     */
    @JacksonXmlProperty(localName = "nsrsbh")
    private String nsrsbh;


    public static WeChatOfficialInputXmlMessage fromXml(String xml) {
        //修改微信变态的消息内容格式，方便解析
        return AbstractJacksonUtil.xml2Object(xml, WeChatOfficialInputXmlMessage.class);
    }

    @Data
    @JacksonXmlRootElement(localName = "ScanCodeInfo")
    public static class ScanCodeInfo implements Serializable {
        private static final long serialVersionUID = 4745181270645050122L;

        /**
         * 扫描类型，一般是qrcode.
         */
        @JacksonXmlCData
        @JacksonXmlProperty(localName = "ScanType")
        private String scanType;

        /**
         * 扫描结果，即二维码对应的字符串信息.
         */
        @JacksonXmlCData
        @JacksonXmlProperty(localName = "ScanResult")
        private String scanResult;
    }

    @Data
    @JacksonXmlRootElement(localName = "SendPicsInfo")
    public static class SendPicsInfo implements Serializable {
        private static final long serialVersionUID = 5464782993240831707L;
        @JacksonXmlElementWrapper
        @JacksonXmlProperty(localName = "PicList")
        protected final List<Item> picList = new ArrayList<>();

        @JacksonXmlProperty(localName = "Count")
        private Long count;
    }

    @Data
    @JacksonXmlRootElement(localName = "item")
    public static class Item implements Serializable {
        private static final long serialVersionUID = 7706235740094081194L;

        @JacksonXmlProperty(localName = "PicMd5Sum")
        @JacksonXmlCData
        private String picMd5Sum;

    }

    @Data
    @JacksonXmlRootElement(localName = "SendLocationInfo")
    public static class SendLocationInfo implements Serializable {
        private static final long serialVersionUID = -7554288262851640519L;

        @JacksonXmlProperty(localName = "Location_X")
        @JacksonXmlCData
        private String locationX;

        @JacksonXmlProperty(localName = "Location_Y")
        @JacksonXmlCData
        private String locationY;

        @JacksonXmlProperty(localName = "Scale")
        @JacksonXmlCData
        private String scale;

        @JacksonXmlProperty(localName = "Label")
        @JacksonXmlCData
        private String label;

        @JacksonXmlProperty(localName = "Poiname")
        @JacksonXmlCData
        private String poiName;

    }

    @Data
    @JacksonXmlRootElement(localName = "HardWare")
    public static class HardWare implements Serializable {
        private static final long serialVersionUID = -7234398940757498310L;

        /**
         * 消息展示，目前支持myrank(排行榜)
         */
        @JacksonXmlProperty(localName = "MessageView")
        @JacksonXmlCData
        private String messageView;
        /**
         * 消息点击动作，目前支持ranklist(点击跳转排行榜)
         */
        @JacksonXmlProperty(localName = "MessageAction")
        @JacksonXmlCData
        private String messageAction;


    }
}