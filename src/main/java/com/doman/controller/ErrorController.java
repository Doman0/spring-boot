package com.doman.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @Author: Doman
 * @Date: 2020/4/20
 */
@Controller
@RequestMapping("err")
public class ErrorController {

    @RequestMapping("/error")
    public String  index(){
        int a = 1/0;
        return "thymeleaf/index";
    }
}
