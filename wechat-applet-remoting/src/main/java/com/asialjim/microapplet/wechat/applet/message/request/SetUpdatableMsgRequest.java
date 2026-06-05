package com.asialjim.microapplet.wechat.applet.message.request;

import lombok.Data;

import java.util.List;

/**
 * 修改动态消息请求参数
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/10/30, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Data
public class SetUpdatableMsgRequest {

    /**
     * 动态消息的ID，通过createActivityId接口获取
     */
    private String activity_id;

    /**
     * 动态消息修改后的状态
     * 0: 未开始
     * 1: 已开始
     */
    private Integer target_state;

    /**
     * 动态消息对应的模板信息
     */
    private TemplateInfo template_info;

    /**
     * 模板信息类
     */
    @Data
    public static class TemplateInfo {
        
        /**
         * 模板中需要修改的参数列表
         */
        private List<Parameter> parameter_list;
        
        /**
         * 参数类
         */
        @Data
        public static class Parameter {
            
            /**
             * 要修改的参数名
             * target_state = 0 时：member_count, room_limit
             * target_state = 1 时：path, version_type
             */
            private String name;
            
            /**
             * 修改后的参数值
             */
            private String value;
        }
    }
}