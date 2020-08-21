/**
 * @projectName 员工考勤
 * @package com.thunisoft.ygkq.ygkq.mapper
 * @className com.thunisoft.ygkq.ygkq.mapper.RyzhMapper
 * @copyright Copyright 2020 Thunisoft, Inc. All rights reserved.
 */
package com.thunisoft.ygkq.ygkq.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.alibaba.fastjson.JSONObject;
import com.thunisoft.artery.data.mybatis.page.BaseMapper;
import com.thunisoft.ygkq.ygkq.common.Ryzh;


/**
 * RyzhMapper
 * 
 * @description 人员帐号信息表
 * @author xuzhou
 * @date 2020年08月07日 17:21:37
 * @version 1.0.0
 */
@Mapper
public interface RyzhMapper extends BaseMapper<Ryzh, String> {
    /**
     * 更新密码
     * @param json
     */
    void updatePassword(JSONObject json);

    Ryzh getUserInfo(String bh);

    void addUser(Ryzh ryzh);

    List<Ryzh> getUserList(String name, String bh);


}