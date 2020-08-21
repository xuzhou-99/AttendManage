/**
 * @projectName 员工考勤
 * @package com.thunisoft.ygkq.ygkq.model
 * @className com.thunisoft.ygkq.ygkq.model.Ryzh
 * @copyright Copyright 2020 Thunisoft, Inc. All rights reserved.
 */
package com.thunisoft.ygkq.ygkq.model;

import javax.persistence.Column;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import com.thunisoft.ygkq.ygkq.common.BaseEntity;
import javax.validation.constraints.Size;
import com.thunisoft.ygkq.ygkq.validate.Validate;
import java.math.BigDecimal;


/**
 * Ryzh
 *
 * @description 人员帐号信息表实体
 * @author xuzhou
 * @date 2020年08月07日 17:21:37
 * @version 1.0.0
 **/
@ApiModel("人员帐号信息表")
@Table(name=".T_RYZH")    
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ryzh extends BaseEntity{

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 有效，代码：0无效、1有效
     */
    @ApiModelProperty("有效，代码：0无效、1有效")
    @Column(name = "N_YX")
    private BigDecimal yx;

    /**
     * 部门，代码：corp
     */
    @ApiModelProperty("部门，代码：corp")
    @Column(name = "C_BM")
    @Size(max = 300, groups = {Validate.class}, message = "部门，代码：corp的最大长度为300")
    private String corp;

    /**
     * 显示顺序，用于排序展示
     */
    @ApiModelProperty("显示顺序，用于排序展示")
    @Column(name = "N_XSSX")
    @Size(max = 300, groups = {Validate.class}, message = "显示顺序的最大长度为300")
    private String xssx;

    /**
     * 姓名
     */
    @ApiModelProperty("姓名")
    @Column(name = "C_XM")
    @Size(max = 300, groups = {Validate.class}, message = "姓名的最大长度为300")
    private String name;

    /**
     * 标识
     */
    @ApiModelProperty("标识")
    @Column(name = "C_BS")
    @Size(max = 300, groups = {Validate.class}, message = "标识的最大长度为300")
    private String bs;

    /**
     * 密码
     */
    @ApiModelProperty("密码")
    @Column(name = "C_MM")
    @Size(max = 300, groups = {Validate.class}, message = "密码的最大长度为300")
    private String password;

}