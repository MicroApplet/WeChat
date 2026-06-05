package com.asialjim.microapplet.wechat.applet.message.request;

import lombok.Data;

import java.util.List;

/**
 * 修改小程序聊天工具的动态卡片消息请求参数
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0
 * @since 2025/10/30, &nbsp;&nbsp; <em>version:1.0</em>
 */
@Data
public class SetChatToolMsgRequest {

    /**
     * 动态消息的ID，通过createActivityId接口获取
     */
    private String activity_id;

    /**
     * 动态消息修改后的状态
     */
    private Integer target_state;

    /**
     * 模板id
     */
    private String template_id;

    /**
     * 更新后的聊天室成员状态
     */
    private List<ParticipatorInfo> participator_info_list;

    /**
     * 聊天室成员信息类
     */
    @Data
    public static class ParticipatorInfo {
        
        /**
         * 聊天室用户的GroupOpenID，仅允许传入动态卡片所在聊天室内的GroupOpenID
         */
        private String group_openid;
        
        /**
         * 用户对卡片事件的完成状态。0：未完成（初始状态），1：已完成。目前只支持设置为1
         */
        private Integer state;
        
        /**
         * 版本类型
         * 0: 正式版
         * 1: 开发版
         * 2: 体验版
         */
        private Integer version_type;
    }
}