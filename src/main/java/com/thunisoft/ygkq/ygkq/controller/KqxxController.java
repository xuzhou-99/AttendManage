/**
 * @projectName 员工考勤
 * @package com.thunisoft.ygkq.ygkq.controller
 * @className com.thunisoft.ygkq.ygkq.controller.KqxxController
 * @copyright Copyright 2020 Thunisoft, Inc. All rights reserved.
 */
package com.thunisoft.ygkq.ygkq.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thunisoft.artery.data.QueryManager;
import com.thunisoft.artery.data.annotation.DataTranslate;
import com.thunisoft.artery.data.model.ArteryPageableData;
import com.thunisoft.artery.data.model.IQueryInfo;
import com.thunisoft.ygkq.ygkq.common.Kqxx;
import com.thunisoft.ygkq.ygkq.service.KqxxService;
import com.thunisoft.ygkq.ygkq.validate.Validate;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * KqxxController
 * 
 * @description 人员考勤信息表
 * @author xuzhou
 * @date 2020年08月07日 17:21:37
 * @version 1.0.0
 */
@Api(value = "人员考勤信息表", tags = "人员考勤信息表")
@RequestMapping(value = "kqxx")
@Controller
public class KqxxController {

    /**
     * kqxxService
     */
    @Autowired
    private KqxxService kqxxService;

    /**
     * html模板入口
     * @return 'resources/templates'下的html模板
     */
    @GetMapping()
    public String index(HttpServletRequest request) {
        return "kqxx";
    }
    /**
     * 
     * KqxxController
     * 
     * @description 创建人员考勤信息表
     * @param kqxx 人员考勤信息表
     * @return 影响行数
     * @author xuzhou
     * @date 2020年08月07日 17:21:37
     * @version 1.0.0
     */
    @ApiOperation(value = "创建人员考勤信息表", response = Integer.class)
    @PostMapping(value = "/kqxx", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> insert(@Validated({Validate.class}) @RequestBody Kqxx kqxx) {
        Integer count = kqxxService.insert(kqxx);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    /**
     * 
     * KqxxController
     * 
     * @description 删除人员考勤信息表
     * @param id 主键
     * @return 影响行数
     * @author xuzhou
     * @date 2020年08月07日 17:21:37
     * @version 1.0.0
     */
    @ApiOperation(value = "删除人员考勤信息表", response = Integer.class)
    @DeleteMapping(value = "/kqxx/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> delete(@ApiParam(name = "id", required = true) @PathVariable("id") String id) {
        Integer count = kqxxService.delete(id);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    /**
     * 
     * KqxxController
     * 
     * @description 修改人员考勤信息表
     * @param kqxx 人员考勤信息表
     * @return 影响行数
     * @author xuzhou
     * @date 2020年08月07日 17:21:37
     * @version 1.0.0
     */
    @ApiOperation(value = "修改人员考勤信息表", response = Integer.class)
    @PutMapping(value = "/kqxx", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> update(@Validated({Validate.class}) @RequestBody Kqxx kqxx) {
        Integer count = kqxxService.update(kqxx);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    /**
     * 
     * KqxxController
     * 
     * @description 分页查询人员考勤信息表
     * @param info 查询条件
     * @return PageBeanVO<Kqxx>
     * @author xuzhou
     * @date 2020年08月07日 17:21:37
     * @version 1.0.0
     */
    @ApiOperation(value = "分页查询人员考勤信息表", response = Kqxx.class)
    @PostMapping(value = "/kqxx/page", produces = MediaType.APPLICATION_JSON_VALUE)
    @DataTranslate
    public ResponseEntity<ArteryPageableData<List<Kqxx>>> selectAll(IQueryInfo info) {
        ArteryPageableData<List<Kqxx>> pageData = QueryManager.datas(info, Kqxx.class, kqxxService::selectAll);
        return new ResponseEntity<>(pageData, HttpStatus.OK);
    }

    /**
     * 
     * KqxxController
     * 
     * @description 查询人员考勤信息表
     * @param id 主键
     * @return Kqxx
     * @author xuzhou
     * @date 2020年08月07日 17:21:37
     * @version 1.0.0
     */
    @ApiOperation(value = "查询人员考勤信息表", response = Kqxx.class)
    @GetMapping(value = "/kqxx/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @DataTranslate
    public ResponseEntity<Kqxx> selectOne(@ApiParam(name = "id", required = true) @PathVariable("id") String id) {
        Kqxx result = kqxxService.selectOne(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}