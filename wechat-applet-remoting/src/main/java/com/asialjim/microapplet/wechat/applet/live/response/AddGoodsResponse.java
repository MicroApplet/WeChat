package com.asialjim.microapplet.wechat.applet.live.response;

import com.asialjim.microapplet.wechat.applet.message.meta.BaseWeChatMessageRes;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * 添加并提审商品响应结果类
 * <p>
 * 接口文档：<a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/livebroadcast/commodity-management/addGoods.html">...</a>
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/10/30, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class AddGoodsResponse extends BaseWeChatMessageRes implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 商品ID
     */
    @JsonProperty("goodsId")
    private Integer goodsId;

    /**
     * 审核单ID
     */
    @JsonProperty("auditId")
    private Integer auditId;
}