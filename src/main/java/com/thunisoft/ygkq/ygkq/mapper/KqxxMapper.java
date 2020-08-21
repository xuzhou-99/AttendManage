/**
 * @projectName 员工考勤
 * @package com.thunisoft.ygkq.ygkq.mapper
 * @className com.thunisoft.ygkq.ygkq.mapper.KqxxMapper
 * @copyright Copyright 2020 Thunisoft, Inc. All rights reserved.
 */
package com.thunisoft.ygkq.ygkq.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.thunisoft.artery.data.mybatis.page.BaseMapper;
import com.thunisoft.ygkq.ygkq.common.Kqxx;


/**
 * KqxxMapper
 * 
 * @description 人员考勤信息表
 * @author xuzhou
 * @date 2020年08月07日 17:21:37
 * @version 1.0.0
 */
@Mapper
public interface KqxxMapper extends BaseMapper<Kqxx, String> {

}