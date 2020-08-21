package com.thunisoft.ygkq.ygkq.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thunisoft.artery.data.QueryManager;
import com.thunisoft.artery.data.model.ArteryPageableData;
import com.thunisoft.artery.data.model.IQueryInfo;
import com.thunisoft.ygkq.ygkq.common.Ryzh;
import com.thunisoft.ygkq.ygkq.service.RyzhService;

/**
 * UserManageController Controller
 * 
 *
 * @author lenovo
 * @date 2020-08-17
 */
@Controller
@RequestMapping("userManage")
public class UserManageController {

    @Autowired
    RyzhService ryzhService;



    /**
     * html模板入口
     * @return 'resources/templates'下的html模板
     */
    @GetMapping()
    public String index(HttpServletRequest request) {
        return "userManage";
 	}

    /**
     * 添加员工
     * @param ryzh 员工信息
     */
 	@ResponseBody
    @RequestMapping("addUser")
 	public String addUser(@RequestBody Ryzh ryzh){
        ryzhService.addUser(ryzh);
        return "ok";
    }


    /**
     * 显示用户列表
     * @param name
     * @param bh
     * @param qp
     * @return
     */
    @ResponseBody
    @RequestMapping("getUserList")
    public ArteryPageableData<List<Ryzh>> getUserList(@RequestParam("name")String name, @RequestParam("bh")String bh, IQueryInfo qp){
        ArteryPageableData<List<Ryzh>> data = QueryManager.datas(qp, Ryzh.class,() -> ryzhService.getUserList(name,bh));
        return  data;
    }

}