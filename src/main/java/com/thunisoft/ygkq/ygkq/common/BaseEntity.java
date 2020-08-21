/**
 * @projectName 员工考勤
 * @package com.thunisoft.ygkq.ygkq.common
 * @className com.thunisoft.ygkq.ygkq.common.BaseEntity
 * @copyright Copyright 2020 Thunisoft, Inc. All rights reserved.
 */
package com.thunisoft.ygkq.ygkq.common;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Size;
import com.thunisoft.ygkq.ygkq.validate.Validate;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * BaseEntity
 *
 * @description 基础类
 * @author xuzhou
 * @date 2020年08月07日 17:21:37
 * @version 1.0.0
 */
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseEntity implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键，主键
     */
    @ApiModelProperty("主键，主键")
    @Column(name = "C_BH")
    @Size(max = 32, groups = {Validate.class}, message = "主键，主键的最大长度为32")
    private String bh;

}