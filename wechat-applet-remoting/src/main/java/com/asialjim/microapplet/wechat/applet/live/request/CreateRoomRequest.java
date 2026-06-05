package com.asialjim.microapplet.wechat.applet.live.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 创建直播间请求参数类
 * <p>
 * 接口文档：<a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/livebroadcast/studio-management/createRoom.html">...</a>
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/10/30, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Data
public class CreateRoomRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 直播间名字，最短3个汉字，最长17个汉字，1个汉字相当于2个字符
     */
    @JsonProperty("name")
    private String name;

    /**
     * 背景图，填入mediaID（mediaID获取后，三天内有效）
     * 图片规则：建议像素1080*1920，大小不超过2M
     */
    @JsonProperty("cover_img")
    private String coverImg;

    /**
     * 直播计划开始时间（开播时间需要在当前时间的10分钟后 并且 开始时间不能在 6 个月后）
     */
    @JsonProperty("start_time")
    private Long startTime;

    /**
     * 直播计划结束时间（开播时间和结束时间间隔不得短于30分钟，不得超过24小时）
     */
    @JsonProperty("end_time")
    private Long endTime;

    /**
     * 主播昵称，最短2个汉字，最长15个汉字，1个汉字相当于2个字符
     */
    @JsonProperty("anchor_name")
    private String anchorName;

    /**
     * 主播微信号，如果未实名认证，需要先前往"小程序直播"小程序进行实名验证
     */
    @JsonProperty("anchor_wechat")
    private String anchorWechat;

    /**
     * 主播副号微信号，如果未实名认证，需要先前往"小程序直播"小程序进行实名验证
     */
    @JsonProperty("sub_anchor_wechat")
    private String subAnchorWechat;

    /**
     * 创建者微信号，不传入则此直播间所有成员可见
     * 传入则此房间仅创建者、管理员、超管、直播间主播可见
     */
    @JsonProperty("creater_wechat")
    private String createrWechat;

    /**
     * 分享图，填入mediaID（mediaID获取后，三天内有效）
     * 图片规则：建议像素800*640，大小不超过1M
     */
    @JsonProperty("share_img")
    private String shareImg;

    /**
     * 购物直播频道封面图，填入mediaID（mediaID获取后，三天内有效）
     * 图片规则：建议像素800*800，大小不超过100KB
     */
    @JsonProperty("feeds_img")
    private String feedsImg;

    /**
     * 是否开启官方收录 【1: 开启，0：关闭】，默认开启收录
     */
    @JsonProperty("is_feeds_public")
    private Integer isFeedsPublic;

    /**
     * 直播间类型 【1: 推流，0：手机直播】
     */
    @JsonProperty("type")
    private Integer type;

    /**
     * 是否关闭点赞 【0：开启，1：关闭】（若关闭，观众端将隐藏点赞按钮，直播开始后不允许开启）
     */
    @JsonProperty("close_like")
    private Integer closeLike;

    /**
     * 是否关闭货架 【0：开启，1：关闭】（若关闭，观众端将隐藏商品货架，直播开始后不允许开启）
     */
    @JsonProperty("close_goods")
    private Integer closeGoods;

    /**
     * 是否关闭评论 【0：开启，1：关闭】（若关闭，观众端将隐藏评论入口，直播开始后不允许开启）
     */
    @JsonProperty("close_comment")
    private Integer closeComment;

    /**
     * 是否关闭回放 【0：开启，1：关闭】默认关闭回放（直播开始后允许开启）
     */
    @JsonProperty("close_replay")
    private Integer closeReplay;

    /**
     * 是否关闭分享 【0：开启，1：关闭】默认开启分享（直播开始后不允许修改）
     */
    @JsonProperty("close_share")
    private Integer closeShare;

    /**
     * 是否关闭客服 【0：开启，1：关闭】 默认关闭客服（直播开始后允许开启）
     */
    @JsonProperty("close_kf")
    private Integer closeKf;
    
    /**
     * 直播间商品列表，最多添加100个商品
     */
    @JsonProperty("goods")
    private List<GoodsItem> goods;
    
    /**
     * 客服微信号
     */
    @JsonProperty("kf_wechat")
    private String kfWechat;
    
    /**
     * 直播间简介，最长100个字符
     */
    @JsonProperty("introduction")
    private String introduction;
    
    /**
     * 商品类，用于直播间商品列表
     */
    @Data
    public static class GoodsItem implements Serializable {
        
        private static final long serialVersionUID = 1L;
        
        /**
         * 商品ID
         */
        @JsonProperty("goods_id")
        private Long goodsId;
    }
}