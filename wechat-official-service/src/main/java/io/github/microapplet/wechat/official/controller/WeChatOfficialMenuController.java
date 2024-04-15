package io.github.microapplet.wechat.official.controller;

import io.github.microapplet.wechat.context.WeChatResult;
import io.github.microapplet.wechat.official.menu.WeChatOfficialMenu;
import io.github.microapplet.wechat.official.remoting.menu.meta.create.WeChatMenuButtonType;
import io.github.microapplet.wechat.official.remoting.menu.meta.create.WeChatOfficialMenuMatchRule;
import io.github.microapplet.wechat.official.service.menu.WeChatOfficialMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

/**
 * 微信公众号菜单管理服务
 *
 * @author Copyright © <a href="mailto:asialjim@hotmail.com">Asial Jim</a>   Co., LTD
 * @version 1.0
 * @since 2023/12/5, &nbsp;&nbsp; <em>version:1.0</em>,  &nbsp;&nbsp;  <em>java version:8</em>
 */
@Validated
@RestController
@Api(tags = "公众号菜单API")
@RequestMapping("/admin/wechat/official/menu")
public class WeChatOfficialMenuController {
    @Resource private WeChatOfficialMenuService menuService;

    /**
     * 获取微信公众号支持的菜单类型列表
     *
     * @since 2023/2/8
     */
    @GetMapping("/types/")
    @ApiOperation(value = "获取公众号菜单类型")
    public WeChatResult<List<WeChatMenuButtonTypeVO>> types() {
        List<WeChatMenuButtonType> types = menuService.menuButtonTypes();
        List<WeChatMenuButtonTypeVO> vos =
                Optional.ofNullable(types)
                        .orElse(Collections.emptyList())
                        .stream()
                        .filter(item -> !StringUtils.equals(item.getCode(),WeChatMenuButtonType.ILLEGAL.getCode()))
                        .map(item -> new WeChatMenuButtonTypeVO(item.getCode(), item.getName(), item.getDesc()))
                        .collect(toList());
        return WeChatResult.successList(vos);
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class WeChatMenuButtonTypeVO{
        private String code,name,desc;
    }

    /**
     * 查询指定微信公众号，指定匹配规则的微信公众号菜单列表
     *
     * @param weChatId  {@link String 公众号索引}
     * @param matchRule {@link String 匹配规则索引}
     * @since 2023/2/8
     */
    @GetMapping("/{weChatId}/")
    @ApiOperation(value = "获取公众号菜单列表")
    public WeChatResult<List<WeChatOfficialMenu>> findWeChatPaMenus(@PathVariable String weChatId, @RequestParam(required = false) String matchRule) {
        List<WeChatOfficialMenu> menus = menuService.findWeChatMenus(weChatId, matchRule);
        return WeChatResult.successList(menus);
    }

    /**
     * 查询指定微信公众号的所有个性化菜单匹配规则列表
     *
     * @param weChatId {@link String 公众号索引}
     * @since 2023/2/8
     */
    @GetMapping("/matchRule/{weChatId}/")
    @ApiOperation(value = "获取个性化公众号菜单匹配规则")
    public WeChatResult<List<WeChatOfficialMenuMatchRule>> findWeChatMatchRules(@PathVariable String weChatId) {
        List<WeChatOfficialMenuMatchRule> rules = menuService.findWeChatMatchRules(weChatId);
        return WeChatResult.successList(rules);
    }

    /**
     * 声明微信公众号菜单
     *
     * @param weChatId  {@link String 公众号索引}
     * @param matchRule {@link String 匹配规则编号}
     * @param menus     {@link List<WeChatOfficialMenu> 菜单}
     * @since 2023/2/8
     */
    @PostMapping("/{weChatId}/")
    @ApiOperation(value = "声明公众号菜单")
    public WeChatResult<List<WeChatOfficialMenu>> statementWeChatMenus(@PathVariable String weChatId, @RequestParam(required = false) String matchRule, @RequestBody List<WeChatOfficialMenu> menus) {
        List<WeChatOfficialMenu> weChatPaMenus = menuService.statementMenus(weChatId, matchRule, menus);
        return WeChatResult.successList(weChatPaMenus);
    }

    /**
     * 声明个性化微信公众号菜单匹配规则
     *
     * @param weChatId  {@link String 公众号索引}
     * @param vo {@link WeChatOfficialMenuMatchRule 匹配规则}
     * @since 2023/2/8
     */
    @PostMapping("/matchRule/{weChatId}/")
    @ApiOperation(value = "声明个性化微信公众号菜单匹配规则")
    public WeChatResult<List<WeChatOfficialMenuMatchRule>> statementWeChatMatchRules(@PathVariable String weChatId, @RequestBody WeChatMenuMatchRuleVO vo) {
        List<WeChatOfficialMenuMatchRule> rules = menuService.statementMatchRule(weChatId, vo.getName(),vo.weChatMenuMatchRule());
        return WeChatResult.successList(rules);
    }

    @Data
    public static class WeChatMenuMatchRuleVO implements Serializable {
        private static final long serialVersionUID = -5897713462466382909L;

        private String name;

        /**
         * 客户标签id
         */
        private String tag_id;

        /**
         * 性别1男2女，空则不匹配
         */
        private String sex;

        /**
         * 国籍
         */
        private String country;

        /**
         * 省份
         */
        private String province;

        /**
         * 城市
         */
        private String city;

        /**
         * 客户端版本，当前只具体到系统型号：IOS(1), Android(2),Others(3)，不填则不做匹配
         */
        private String client_platform_type;

        /**
         * 语言
         */
        private String language;

        public WeChatOfficialMenuMatchRule weChatMenuMatchRule(){
            WeChatOfficialMenuMatchRule rule = new WeChatOfficialMenuMatchRule();
            rule.setTag_id(this.tag_id);
            rule.setSex(this.sex);
            rule.setCountry(this.country);
            rule.setProvince(this.province);
            rule.setCity(this.city);
            rule.setClient_platform_type(this.client_platform_type);
            rule.setLanguage(this.language);
            return rule;
        }
    }

    /**
     * 创建通用微信公众号菜单
     *
     * @param weChatId {@link String 公众号索引}
     * @since 2023/2/8
     */
    @ApiOperation("创建通用微信公众号菜单")
    @GetMapping("/create/{weChatId}/")
    public WeChatResult<Void> create(@PathVariable String weChatId) {
        menuService.create(weChatId, null);
        return WeChatResult.success();
    }

    /**
     * 创建微信公众号个性化菜单
     *
     * @param weChatId  {@link String 公众号索引}
     * @param matchRule {@link String 个性化菜单匹配规则编号}
     * @since 2023/2/8
     */
    @ApiOperation("创建微信公众号个性化菜单")
    @GetMapping("/create/{weChatId}/{matchRule}/")
    public WeChatResult<Void> createAdditional(@PathVariable String weChatId, @PathVariable String matchRule) {
        menuService.create(weChatId, matchRule);
        return WeChatResult.success();
    }
}