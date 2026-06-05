package com.asialjim.microapplet.wechat.applet.live.request;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 删除主播副号请求参数
 * 接口文档：<a href="https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/livebroadcast/studio-management/deleteSubAnchor.html">...</a>
 *
 * @author Asial Jim
 * @version 1.0
 * @since 2025/10/30
 */
@Data
public class DeleteSubAnchorRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /**
     * 主播副号ID列表
     */
    private List<Integer> subAnchorIds;
}