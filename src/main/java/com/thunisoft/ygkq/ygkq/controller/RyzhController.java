/**
 * @projectName 员工考勤
 * @package com.thunisoft.ygkq.ygkq.controller
 * @className com.thunisoft.ygkq.ygkq.controller.RyzhController
 * @copyright Copyright 2020 Thunisoft, Inc. All rights reserved.
 */
package com.thunisoft.ygkq.ygkq.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.thunisoft.artery.data.QueryManager;
import com.thunisoft.artery.data.annotation.DataTranslate;
import com.thunisoft.artery.data.model.ArteryPageableData;
import com.thunisoft.artery.data.model.IQueryInfo;

import com.thunisoft.ygkq.ygkq.common.Ryzh;
import com.thunisoft.ygkq.ygkq.service.RyzhService;
import com.thunisoft.ygkq.ygkq.validate.Validate;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * RyzhController
 * 
 * @description 人员帐号信息表
 * @author xuzhou
 * @date 2020年08月07日 17:21:37
 * @version 1.0.0
 */
@Api(value = "人员帐号信息表", tags = "人员帐号信息表")
@RequestMapping(value = "ryzh")
@Controller
public class RyzhController {

    /**
     * ryzhService
     */
    @Autowired
    private RyzhService ryzhService;

    /**
     * html模板入口
     * @return 'resources/templates'下的html模板
     */
    @GetMapping()
    public String index(HttpServletRequest request) {
        return "ryzh";
    }

    /**
     * 获取用户信息
     * @param bh
     * @return
     */
    @ResponseBody
    @RequestMapping("/getUserInfo")
    public Ryzh getUserInfo(@RequestParam("bh")String bh){
        return ryzhService.getUserInfo(bh);
    }
    /**
     * 
     * RyzhController
     * 
     * @description 创建人员帐号信息表
     * @param ryzh 人员帐号信息表
     * @return 影响行数
     * @author xuzhou
     * @date 2020年08月07日 17:21:37
     * @version 1.0.0
     */
    @ApiOperation(value = "创建人员帐号信息表", response = Integer.class)
    @PostMapping(value = "/ryzh", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> insert(@Validated({Validate.class}) @RequestBody Ryzh ryzh) {
        Integer count = ryzhService.insert(ryzh);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    /**
     * 
     * RyzhController
     * 
     * @description 删除人员帐号信息表
     * @param id 主键
     * @return 影响行数
     * @author xuzhou
     * @date 2020年08月07日 17:21:37
     * @version 1.0.0
     */
    @ApiOperation(value = "删除人员帐号信息表", response = Integer.class)
    @DeleteMapping(value = "/ryzh/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> delete(@ApiParam(name = "id", required = true) @PathVariable("id") String id) {
        Integer count = ryzhService.delete(id);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    /**
     * 
     * RyzhController
     * 
     * @description 修改人员帐号信息表
     * @param ryzh 人员帐号信息表
     * @return 影响行数
     * @author xuzhou
     * @date 2020年08月07日 17:21:37
     * @version 1.0.0
     */
    @ApiOperation(value = "修改人员帐号信息表", response = Integer.class)
    @PutMapping(value = "/ryzh", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> update(@Validated({Validate.class}) @RequestBody Ryzh ryzh) {
        Integer count = ryzhService.update(ryzh);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    /**
     * 
     * RyzhController
     * 
     * @description 分页查询人员帐号信息表
     * @param info 查询条件
     * @return PageBeanVO<Ryzh>
     * @author xuzhou
     * @date 2020年08月07日 17:21:37
     * @version 1.0.0
     */
    @ApiOperation(value = "分页查询人员帐号信息表", response = Ryzh.class)
    @PostMapping(value = "/ryzh/page", produces = MediaType.APPLICATION_JSON_VALUE)
    @DataTranslate
    public ResponseEntity<ArteryPageableData<List<Ryzh>>> selectAll(IQueryInfo info) {
        ArteryPageableData<List<Ryzh>> pageData = QueryManager.datas(info, Ryzh.class, ryzhService::selectAll);
        return new ResponseEntity<>(pageData, HttpStatus.OK);
    }

    /**
     * 
     * RyzhController
     * 
     * @description 查询人员帐号信息表
     * @param id 主键
     * @return Ryzh
     * @author xuzhou
     * @date 2020年08月07日 17:21:37
     * @version 1.0.0
     */
    @ApiOperation(value = "查询人员帐号信息表", response = Ryzh.class)
    @GetMapping(value = "/ryzh/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @DataTranslate
    public ResponseEntity<Ryzh> selectOne(@ApiParam(name = "id", required = true) @PathVariable("id") String id) {
        Ryzh result = ryzhService.selectOne(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}