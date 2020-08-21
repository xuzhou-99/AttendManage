/**
 * @projectName 员工考勤
 * @package com.thunisoft.ygkq.ygkq.util
 * @className com.thunisoft.ygkq.ygkq.util.OrganUtil
 * @copyright Copyright 2020 Thunisoft, Inc. All rights reserved.
 */
package com.thunisoft.ygkq.ygkq.util;

import java.util.Optional;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.thunisoft.artery.organ.IOrganService;
import com.thunisoft.artery.organ.model.ICorp;
import com.thunisoft.artery.organ.model.IDept;
import com.thunisoft.artery.organ.model.IUser;
import com.thunisoft.artery.security.ISecurityService;

/**
 * OrganUtil
 *
 * @description 组织机构工具类
 * @author xuzhou
 * @date 2020年08月07日 17:21:37
 * @version 1.0.0
 */
@Component
public class OrganUtil implements ApplicationContextAware {

    /**
     * organService
     */
    private static IOrganService organService;

    /**
     * securityService
     */
    private static ISecurityService securityService;

    /**
     * OrganUtil
     *
     * @description 根据单位id获取单位名称
     * @param corpId 单位id
     * @return 单位名称
     * @author xuzhou
     * @date 2020年08月07日 17:21:37
     * @version 1.0.0
     */
    public static String getCorpName(String corpId) {
        return Optional.ofNullable(organService.getCorp(corpId)).map(ICorp::getName).orElse("");
    }

    /**
     * OrganUtil
     *
     * @description 根据userId获取corpId
     * @param userId 用户编号
     * @return corpId
     * @author xuzhou
     * @date 2020年08月07日 17:21:37
     * @version 1.0.0
     */
    public static String getCorpIdByUserId(String userId) {
        return Optional
            .ofNullable(organService
                .getCorp(Optional.ofNullable(organService.getUser(userId)).map(IUser::getCorpId).orElse("")))
            .map(ICorp::getId).orElse("");

    }

    /**
     * OrganUtil
     *
     * @description 根据userId获取corp
     * @param userId 用户编号
     * @return corp
     * @author xuzhou
     * @date 2020年08月07日 17:21:37
     * @version 1.0.0
     */
    public static ICorp getCorpByUserId(String userId) {
        return organService.getCorp(Optional.ofNullable(organService.getUser(userId)).map(IUser::getCorpId).orElse(""));
    }

    /**
     * OrganUtil
     *
     * @description 根据部门id获取部门名称
     * @param deptId 部门id
     * @return 部门名称
     * @author xuzhou
     * @date 2020年08月07日 17:21:37
     * @version 1.0.0
     */
    public static String getDeptName(String deptId) {
        return Optional.ofNullable(organService.getDept(deptId)).map(IDept::getName).orElse("");
    }

    /**
     * OrganUtil
     *
     * @description 根据用户id获取用户名称
     * @param userId 用户id
     * @return 用户名称
     * @author xuzhou
     * @date 2020年08月07日 17:21:37
     * @version 1.0.0
     */
    public static String getUserName(String userId) {
        return Optional.ofNullable(organService.getUser(userId)).map(IUser::getName).orElse("");
    }

    /**
     * OrganUtil
     *
     * @description 根据用户id获取用户实体
     * @param userId 用户id
     * @return 部门名称
     * @author xuzhou
     * @date 2020年08月07日 17:21:37
     * @version 1.0.0
     */
    public static IUser getUserByUserId(String userId) {
        return organService.getUser(userId);
    }

    /**
     * OrganUtil
     *
     * @description 获取当前用户
     * @return 当前用户
     * @author xuzhou
     * @date 2020年08月07日 17:21:37
     * @version 1.0.0
     */
    public static IUser getCurrentUser() {
        return securityService.getCurrUserInfo();
    }

    /**
     * OrganUtil
     *
     * @description 获取当前用户id
     * @return 当前用户的id
     * @author xuzhou
     * @date 2020年08月07日 17:21:37
     * @version 1.0.0
     */
    public static String getCurrentUserId() {
        return Optional.ofNullable(getCurrentUser()).map(IUser::getId).orElse("");
    }

    /**
     * OrganUtil
     *
     * @description 根据UserId获取扩展字段值
     * @param userId 用户id
     * @param extField 扩展字段名称
     * @return 扩展字段值
     * @author xuzhou
     * @date 2020年08月07日 17:21:37
     * @version 1.0.0
     */
    public static String getExtendFiledValueByUserId(String userId, String extField) {
        return Optional.ofNullable(organService.getUser(userId)).map(user -> String.valueOf(user.getExtField(extField)))
            .orElse(null);
    }

    /**
     * OrganUtil
     *
     * @description 根据corpId获取单位扩展字段值
     * @param corpId 单位id
     * @param extField 扩展字段名称
     * @param isTranslate 是否翻译
     * @return 身份证号
     * @author xuzhou
     * @date 2020年08月07日 17:21:37
     * @version 1.0.0
     */
    public static String getCorpExtendFiledValueByCorpId(String corpId, String extField, boolean isTranslate) {
        String ext = isTranslate ? "TranslateText" : "";
        return Optional.ofNullable(organService.getCorp(corpId))
            .map(corp -> String.valueOf(corp.getExtField(extField + ext))).orElse("");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        OrganUtil.init(applicationContext.getBean(IOrganService.class),
            applicationContext.getBean(ISecurityService.class));
    }

    /**
     * 
     * OrganUtil
     * @description 实例化
     * @param organservice organservice
     * @param securityservice securityservice
     * @author xuzhou
     * @date 2020年08月07日 17:21:37
     * @version 1.0.0
     */
    private static void init(IOrganService organservice, ISecurityService securityservice) {
        organService = organservice;
        securityService = securityservice;
    }
}