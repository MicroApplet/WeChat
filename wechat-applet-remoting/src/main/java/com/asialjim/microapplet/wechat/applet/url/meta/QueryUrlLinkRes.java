package com.asialjim.microapplet.wechat.applet.url.meta;

import com.asialjim.microapplet.wechat.remoting.context.BaseWeChatApiRes;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 查询小程序加密URL Link配置响应
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/10/30, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class QueryUrlLinkRes extends BaseWeChatApiRes {

    /**
     * url_link配置信息
     */
    private UrlLinkInfo url_link_info;

    /**
     * 配额配置信息
     */
    private QuotaInfo quota_info;

    /**
     * URL Link配置信息
     */
    @Data
    public static class UrlLinkInfo {
        
        /**
         * 小程序appid
         */
        private String appid;

        /**
         * 小程序页面路径
         */
        private String path;

        /**
         * 小程序页面query
         */
        private String query;

        /**
         * 创建时间，为Unix时间戳
         */
        private Long create_time;

        /**
         * 到期失效时间，为Unix时间戳，0表示永久生效
         */
        private Long expire_time;

        /**
         * 要打开的小程序版本。正式版为"release"，体验版为"trial"，开发版为"develop"
         */
        private String env_version;
    }

    /**
     * 配额信息
     */
    @Data
    public static class QuotaInfo {
        
        /**
         * URL Scheme（加密+明文）/加密URL Link单天剩余访问次数
         */
        private Integer remain_visit_quota;
    }
}