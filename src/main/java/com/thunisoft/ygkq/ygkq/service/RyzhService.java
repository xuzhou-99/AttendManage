/**
 * @projectName 员工考勤
 * @package com.thunisoft.ygkq.ygkq.service
 * @className com.thunisoft.ygkq.ygkq.service.RyzhService
 * @copyright Copyright 2020 Thunisoft, Inc. All rights reserved.
 */
package com.thunisoft.ygkq.ygkq.service;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.thunisoft.artery.data.model.ArteryPageableData;
import com.thunisoft.artery.util.uuid.UUIDHelper;
import com.thunisoft.ygkq.ygkq.common.Ryzh;
import com.thunisoft.ygkq.ygkq.common.RyzhConsts;
import com.thunisoft.ygkq.ygkq.mapper.RyzhMapper;


/**
 * 人员帐号信息表service接口实现类
 * 
 * @description 人员帐号信息表service接口实现
 * @author xuzhou
 * @date 2020年08月07日 17:21:37
 * @version 1.0.0
 */
@Service
public class RyzhService{

    /**
     * ryzhMapper
     */
    @Autowired
    private RyzhMapper ryzhMapper;

    /**
     * RyzhService
     * 
     * @description 插入一条人员帐号信息表数据
     * @param ryzh 人员帐号信息表
     * @return 影响行数
     * @author xuzhou
     * @date 2020年08月07日 17:21:37
     * @version 1.0.0
     */
    public int insert(Ryzh ryzh) {
        if (StringUtils.isBlank(ryzh.getBh())) {
            ryzh.setBh(UUIDHelper.getUuid());
        }
        return ryzhMapper.insert(ryzh);
    }

    /**
     * RyzhService
     * 
     * @description 通过主键删除人员帐号信息表数据
     * @param cbh 主键编号
     * @return 影响行数
     * @author xuzhou
     * @date 2020年08月07日 17:21:37
     * @version 1.0.0
     */
    public int delete(String cbh) {
        return ryzhMapper.deleteByPrimaryKey(cbh);
    }

    /**
     * RyzhService
     * 
     * @description 通过主键修改Ryzh数据
     * @param ryzh 更新实体
     * @return 影响行数
     * @author xuzhou
     * @date 2020年08月07日 17:21:37
     * @version 1.0.0
     */
    public int update(Ryzh ryzh) {
        //updateByPrimaryKeySelective：为null的字段不会受影响
        //updateByPrimaryKey：字段为null时，会将数据库对应字段置空
        return ryzhMapper.updateByPrimaryKeySelective(ryzh);
    }

    /**
     * RyzhService
     * 
     * @description 查询所有数据
     * @return List<Ryzh>
     * @author xuzhou
     * @date 2020年08月07日 17:21:37
     * @version 1.0.0
     */
    public List<Ryzh> selectAll() {
        return ryzhMapper.selectAll();
    }

    /**
     * RyzhService
     * 
     * @description 通过条件查询多条数据
     * @param args 参数
     * @return List<Ryzh>
     * @author xuzhou
     * @date 2020年08月07日 17:21:37
     * @version 1.0.0
     */
    public List<Ryzh> select(Ryzh args) {
        return ryzhMapper.select(args);
    }

    /**
     * RyzhService
     * 
     * @description 通过主键查询人员帐号信息表信息
     * @param cbh 主键编号
     * @return Ryzh
     * @author xuzhou
     * @date 2020年08月07日 17:21:37
     * @version 1.0.0
     */
    public Ryzh selectOne(String cbh) {
        return ryzhMapper.selectByPrimaryKey(cbh);
    }

    /**
     * 更改密码
     * @param json 用户密码信息
     */
    public void updatePassword(JSONObject json){
        ryzhMapper.updatePassword(json);
    }

    public Ryzh getUserInfo(String bh) {
        return ryzhMapper.getUserInfo(bh);
    }

    public void addUser(Ryzh ryzh) {
        //主键生成
        String uuid = UUID.randomUUID().toString();
        String id = uuid.replace("-","");
        ryzh.setId(id);
        //账号置为有效
        ryzh.setYx(RyzhConsts.YX);
        ryzhMapper.addUser(ryzh);
    }

    public List<Ryzh> getUserList(String name, String bh) {
        return ryzhMapper.getUserList(name,bh);
    }
}