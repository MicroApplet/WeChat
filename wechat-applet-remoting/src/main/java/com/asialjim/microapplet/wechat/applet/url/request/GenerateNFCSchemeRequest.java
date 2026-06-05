package com.asialjim.microapplet.wechat.applet.url.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 获取NFC的小程序scheme码请求参数
 * @author 
 * @date 2023-12-01
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GenerateNFCSchemeRequest {

    /**
     * 跳转到的目标小程序信息
     */
    private JumpWxa jumpWxa;
    
    /**
     * scheme对应的设备model_id
     */
    private String modelId;
    
    /**
     * scheme对应的设备sn，仅一机一码时填写
     */
    private String sn;

    /**
     * 跳转到的目标小程序信息
     */
    @Data
    @Accessors(chain = true)
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class JumpWxa {
        
        /**
         * 通过scheme码进入的小程序页面路径，必须是已经发布的小程序存在的页面，不可携带query。path为空时会跳转小程序主页
         */
        private String path;
        
        /**
         * 通过scheme码进入小程序时的query，最大1024个字符，只支持数字，大小写英文以及部分特殊字符：!#$&'()*+,/:;=?@-._~%
         */
        private String query;
        
        /**
         * 要打开的小程序版本。正式版为"release"，体验版为"trial"，开发版为"develop"，仅在微信外打开时生效
         */
        private String envVersion;
    }
}