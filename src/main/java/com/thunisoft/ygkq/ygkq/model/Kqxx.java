/**
 * @projectName 员工考勤
 * @package com.thunisoft.ygkq.ygkq.model
 * @className com.thunisoft.ygkq.ygkq.model.Kqxx
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
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.Size;
import com.thunisoft.ygkq.ygkq.validate.Validate;
import java.math.BigDecimal;


/**
 * Kqxx
 *
 * @description 人员考勤信息表实体
 * @author xuzhou
 * @date 2020年08月07日 17:21:37
 * @version 1.0.0
 **/
@ApiModel("人员考勤信息表")
@Table(name=".T_KQXX")    
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Kqxx extends BaseEntity{
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * 人员编号，对应于人员表中的人员的主键（C_BH）
     */
    @ApiModelProperty("人员编号，对应于人员表中的人员的主键（C_BH）")
    @Column(name = "C_BH_RYZH")
    @Size(max = 32, groups = {Validate.class}, message = "人员编号，对应于人员表中的人员的主键（C_BH）的最大长度为32")
    private String bhRyzh;

    /**
     * 上班时间
     */
    @ApiModelProperty("上班时间")
    @Column(name = "DT_SBSJ")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime sbsj;

    /**
     * 下班时间
     */
    @ApiModelProperty("下班时间")
    @Column(name = "DT_XBSJ")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime xbsj;

    /**
     * 考勤状态，代码：正常、迟到、早退
     */
    @ApiModelProperty("考勤状态，代码：正常、迟到、早退")
    @Column(name = "N_KQZT")
    private BigDecimal kqzt;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    @Column(name = "C_BZ")
    @Size(max = 300, groups = {Validate.class}, message = "备注的最大长度为300")
    private String bz;

}