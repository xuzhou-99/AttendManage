/**
 * @projectName 员工考勤
 * @package com.thunisoft.ygkq.ygkq.service
 * @className com.thunisoft.ygkq.ygkq.service.KqxxService
 * @copyright Copyright 2020 Thunisoft, Inc. All rights reserved.
 */
package com.thunisoft.ygkq.ygkq.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thunisoft.artery.util.uuid.UUIDHelper;
import com.thunisoft.ygkq.ygkq.common.Kqxx;
import com.thunisoft.ygkq.ygkq.mapper.KqxxMapper;


/**
 * 人员考勤信息表service接口实现类
 * 
 * @description 人员考勤信息表service接口实现
 * @author xuzhou
 * @date 2020年08月07日 17:21:37
 * @version 1.0.0
 */
@Service
public class KqxxService{

    /**
     * kqxxMapper
     */
    @Autowired
    private KqxxMapper kqxxMapper;

    /**
     * KqxxService
     * 
     * @description 插入一条人员考勤信息表数据
     * @param kqxx 人员考勤信息表
     * @return 影响行数
     * @author xuzhou
     * @date 2020年08月07日 17:21:37
     * @version 1.0.0
     */
    public int insert(Kqxx kqxx) {
        if (StringUtils.isBlank(kqxx.getBh())) {
            kqxx.setBh(UUIDHelper.getUuid());
        }
        return kqxxMapper.insert(kqxx);
    }

    /**
     * KqxxService
     * 
     * @description 通过主键删除人员考勤信息表数据
     * @param cbh 主键编号
     * @return 影响行数
     * @author xuzhou
     * @date 2020年08月07日 17:21:37
     * @version 1.0.0
     */
    public int delete(String cbh) {
        return kqxxMapper.deleteByPrimaryKey(cbh);
    }

    /**
     * KqxxService
     * 
     * @description 通过主键修改Kqxx数据
     * @param kqxx 更新实体
     * @return 影响行数
     * @author xuzhou
     * @date 2020年08月07日 17:21:37
     * @version 1.0.0
     */
    public int update(Kqxx kqxx) {
        //updateByPrimaryKeySelective：为null的字段不会受影响
        //updateByPrimaryKey：字段为null时，会将数据库对应字段置空
        return kqxxMapper.updateByPrimaryKeySelective(kqxx);
    }

    /**
     * KqxxService
     * 
     * @description 查询所有数据
     * @return List<Kqxx>
     * @author xuzhou
     * @date 2020年08月07日 17:21:37
     * @version 1.0.0
     */
    public List<Kqxx> selectAll() {
        return kqxxMapper.selectAll();
    }

    /**
     * KqxxService
     * 
     * @description 通过条件查询多条数据
     * @param args 参数
     * @return List<Kqxx>
     * @author xuzhou
     * @date 2020年08月07日 17:21:37
     * @version 1.0.0
     */
    public List<Kqxx> select(Kqxx args) {
        return kqxxMapper.select(args);
    }

    /**
     * KqxxService
     * 
     * @description 通过主键查询人员考勤信息表信息
     * @param cbh 主键编号
     * @return Kqxx
     * @author xuzhou
     * @date 2020年08月07日 17:21:37
     * @version 1.0.0
     */
    public Kqxx selectOne(String cbh) {
        return kqxxMapper.selectByPrimaryKey(cbh);
    }
}