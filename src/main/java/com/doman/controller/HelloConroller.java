package com.doman.controller;

import com.doman.pojo.Resource;
import com.doman.pojo.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.RequestWrapper;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: Doman
 * @Date: 2020/4/14
 */

@RestController //@RestController=@Controller+@ResponseBody
public class HelloConroller {

    @Autowired
    Resource resource;

    @RequestMapping("/hello")
   // @ResponseBody
    public String hello(){
        return "hello spring boot";
    }


    @RequestMapping("/getMap")
    public Map<String,Object> getMap(){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("aa","q111");
        map.put("ab","ccc");
        return  map;
    }

    @RequestMapping("/getUser")
    public User getUser(){
        User u = new User();
        u.setName("zs1");
        u.setPassword("11111e111");
        u.setBirthday(new Date());
        u.setDesc("用户测试");
        System.out.println(u);
        return  u;
    }

    @RequestMapping("/getResource")
    public Resource getResource(){
        Resource bean = new Resource();
        BeanUtils.copyProperties(resource,bean);
        return bean;
    }

}
