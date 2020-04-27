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
@RequestMapping("th")
public class ThymeleafController {

    @RequestMapping("index")
    public String  index(ModelMap map){
        map.addAttribute("name","Thymeleaf");
        return "thymeleaf/index";
    }
}
