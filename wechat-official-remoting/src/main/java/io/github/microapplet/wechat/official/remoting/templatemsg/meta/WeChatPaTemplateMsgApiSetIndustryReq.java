/*
 * Copyright 2014-2024 <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.microapplet.wechat.official.remoting.templatemsg.meta;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;


import java.io.Serializable;

/**
 * 设置行业可在微信公众平台后台完成，每月可修改行业1次，账号仅可使用所属行业中相关的模板，为方便第三方开发者，提供通过接口调用的方式来修改账号所属行业
 *
 * @author Copyright © <a href="mailto:asialjim@hotmail.com">Asial Jim</a>   Co., LTD
 * @version 1.0
 * @since 2023/12/14, &nbsp;&nbsp; <em>version:1.0</em>,  &nbsp;&nbsp;  <em>java version:8</em>
 */
@Data
public class WeChatPaTemplateMsgApiSetIndustryReq implements Serializable {

    private static final long serialVersionUID = -6500649806758834638L;

    @JsonProperty("industry_id1")
    private String industryId1;

    @JsonProperty("industry_id2")
    private String industryId2;

    @Getter
    @AllArgsConstructor
    public enum Industry{
        Internet_E_commerce("IT科技",	"互联网/电子商务",	1),
        IT_Software_and_Services("IT科技",	"IT软件与服务",	2),
        IT_hardware_and_equipment("IT科技",	"IT硬件与设备",	3),
        electronic_technique(    "IT科技",	"电子技术",	4),
        Communication_and_operator("IT科技",	"通信与运营商",	5),
        Network_Game("IT科技", "网络游戏", 6),
        Bank("金融业", "银行", 7),
        Fund_Finance_Trust("金融业", "基金理财信托", 8),
        Insurance("金融业", "保险", 9),
        Catering("餐饮", "餐饮", 10),
        Hotel("酒店旅游", "酒店", 11),
        Travel("酒店旅游", "旅游", 12),
        Express_Delivery("运输与仓储", "快递", 13),
        Logistics("运输与仓储", "物流", 14),
        Warehousing("运输与仓储", "仓储", 15),
        Training("教育", "培训", 16),
        College("教育", "院校", 17),
        Academic_research("政府与公共事业", "学术科研", 18),
        Traffic_Police("政府与公共事业", "交警", 19),
        Museum("政府与公共事业", "博物馆", 20),
        Public_Nonprofit_Organization("政府与公共事业", "公共事业非盈利机构", 21),
        Medicine_Nursing("医药护理", "医药医疗", 22),
        Nursing_Beauty("医药护理", "护理美容", 23),
        Health_Care("医药护理", "保健与卫生", 24),
        Vehicle("交通工具", "汽车相关", 25),
        Motorcycle("交通工具", "摩托车相关", 26),
        Train("交通工具", "火车相关", 27),
        Airplane("交通工具", "飞机相关", 28),
        Building("房地产", "建筑", 29),
        Property_Management("房地产", "物业", 30),
        Consumer_Goods("消费品", "消费品", 31),
        Law_Services("商业服务", "法律", 32),
        Exhibition("商业服务", "会展", 33),
        Intermediary_Service("商业服务", "中介服务", 34),
        Certification("商业服务", "认证", 35),
        Audit("商业服务", "审计", 36),
        Culture_Entertainment("文体娱乐", "传媒", 37),
        physical_culture("文体娱乐", "体育", 38),
        Entertainment_Leisure("文体娱乐", "娱乐休闲", 39),
        Printing("印刷", "印刷", 40),
        Others("其它", "其它", 41);

        private final String mainName;
        private final String subName;
        private final int code;
    }
}
