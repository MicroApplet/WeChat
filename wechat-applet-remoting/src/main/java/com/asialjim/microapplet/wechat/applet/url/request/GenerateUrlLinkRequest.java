package com.asialjim.microapplet.wechat.applet.url.request;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * 获取小程序URL Link请求参数
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/10/30, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Data
@Accessors(chain = true)
public class GenerateUrlLinkRequest {

    /**
     * 通过URL Link进入的小程序页面路径，必须是已经发布的小程序存在的页面，不可携带query。path为空时会跳转小程序主页
     */
    private String path;

    /**
     * 通过URL Link进入小程序时的query，最大1024个字符，只支持数字，大小写英文以及部分特殊字符：!#$&'()*+,/:;=?@-._~%
     */
    private String query;

    /**
     * 小程序URL Link失效类型，失效时间：0，失效间隔天数：1
     */
    private Integer expireType;

    /**
     * 到期失效的URL Link的失效时间，为Unix时间戳。生成的到期失效URL Link在该时间前有效。最长有效期为30天。expire_type为0必填
     */
    private Long expireTime;

    /**
     * 到期失效的URL Link的失效间隔天数。生成的到期失效URL Link在该间隔时间到达前有效。最长间隔天数为30天。expire_type为1必填
     */
    private Integer expireInterval;

    /**
     * 云开发静态网站自定义H5配置参数，可配置中转的云开发H5页面。不填默认用官方H5页面
     */
    private CloudBase cloudBase;

    /**
     * 要打开的小程序版本。正式版为"release"，体验版为"trial"，开发版为"develop"，仅在微信外打开时生效
     */
    private String envVersion;

    /**
     * 云开发静态网站自定义H5配置参数
     */
    @Data
    @ToString
    @EqualsAndHashCode
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @Accessors(chain = true)
    public static class CloudBase {
        
        /**
         * 云开发环境
         */
        private String env;
        
        /**
         * 静态网站自定义域名，不填则使用默认域名
         */
        private String domain;
        
        /**
         * 云开发静态网站H5页面路径，不可携带query
         */
        private String path;
        
        /**
         * 云开发静态网站H5页面query参数，最大1024个字符，只支持数字，大小写英文以及部分特殊字符：!#$&'()*+,/:;=?@-._~%
         */
        private String query;
        
        /**
         * 第三方批量代云开发时必填，表示创建该env的appid（小程序/第三方平台）
         */
        private String resourceAppid;
    }
}