package com.asialjim.microapplet.wechat.applet.live.response;

import com.asialjim.microapplet.wechat.applet.message.meta.BaseWeChatMessageRes;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * 获取主播副号列表响应结果
 * 接口文档：<a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/livebroadcast/studio-management/getSubAnchor.html">...</a>
 *
 * @author Asial Jim
 * @version 1.0
 * @since 2025/10/30
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class GetSubAnchorResponse extends BaseWeChatMessageRes implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /**
     * 主播副号列表
     */
    private List<SubAnchorInfo> anchorList;
    
    /**
     * 总数
     */
    private Integer total;
}