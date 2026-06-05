package com.asialjim.microapplet.wechat.applet.live.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 获取主播副号列表请求参数
 * 接口文档：<a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/livebroadcast/studio-management/getSubAnchor.html">...</a>
 *
 * @author Asial Jim
 * @version 1.0
 * @since 2025/10/30
 */
@Data
public class GetSubAnchorRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /**
     * 分页起始页
     */
    private Integer start;
    
    /**
     * 每页数量
     */
    private Integer limit;
}