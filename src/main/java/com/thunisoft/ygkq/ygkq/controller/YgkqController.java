package com.thunisoft.ygkq.ygkq.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * YgkqController Controller
 * 员工考勤
 *
 * @author lenovo
 * @date 2020-08-17
 */
@Controller
@RequestMapping("ygkq")
public class YgkqController {
    /**
     * html模板入口
     * @return 'resources/templates'下的html模板
     */
    @GetMapping()
    public String index(HttpServletRequest request) {
        return "ygkq";
 	}
}