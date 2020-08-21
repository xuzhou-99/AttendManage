/**
 * @projectName 员工考勤
 * @package com.thunisoft.ygkq.ygkq.vo
 * @className com.thunisoft.ygkq.ygkq.vo.ExampleVO
 * @copyright Copyright 2020 Thunisoft, Inc. All rights reserved.
 */
package com.thunisoft.ygkq.ygkq.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * ExampleVO
 *
 * @description vo示例-用于页面展示-请删除
 * @author xuzhou
 * @date 2020年08月07日 17:21:37
 * @version v1.0.0
 */
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("示例展示用vo-返回给前端，用于渲染数据")
public class ExampleVO {

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;
}