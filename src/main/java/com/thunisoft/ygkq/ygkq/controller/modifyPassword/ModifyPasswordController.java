package com.thunisoft.ygkq.ygkq.controller.modifyPassword;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.thunisoft.artery.security.ISecurityService;
import com.thunisoft.ygkq.ygkq.service.RyzhService;


@Controller
@RequestMapping("modifyPassword/modifyPassword")
public class ModifyPasswordController {

    @Autowired
    RyzhService ryzhService;


    /**
     * html模板入口
     * @return 'resources/templates'下的html模板
     */
    @GetMapping()
    public String index(HttpServletRequest request) {
        return "modifyPassword/modifyPassword";
    }

    /**
     * 修改用户密码
     * @param json 修改信息
     */
    @RequestMapping("changePwd")
    @ResponseBody
    public void changePwd(@RequestBody JSONObject json){

         ryzhService.updatePassword(json);

    }
}