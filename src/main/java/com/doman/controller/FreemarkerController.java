package com.doman.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @Author: Doman
 * @Date: 2020/4/20
 */
@Controller
@RequestMapping("ftl")
public class FreemarkerController {

    @RequestMapping("index")
    public String  index(){
        return "freemarker/index";
    }
}
