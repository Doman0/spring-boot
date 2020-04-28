package com.doman.controller;

import com.doman.pojo.SysUser;
import com.doman.service.UserService;
import com.doman.utils.JSONResult;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Author: Doman
 * @Date: 2020/4/28
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private Sid sid;


    @RequestMapping("/saveUser")
    public JSONResult getUser() throws Exception {
        String userId = sid.nextShort();

        SysUser user = new SysUser();
        user.setId(userId);
        user.setUsername("doman" + new Date());
        user.setNickname("doman" + new Date());
        user.setPassword("abc123");
        user.setIsDelete(0);
        user.setRegistTime(new Date());

        userService.saveUser(user);

        return JSONResult.ok("保存成功");
    }

    @RequestMapping("/updateUser")
    public JSONResult updateUser() {

        SysUser user = new SysUser();
        user.setId("200428APHAYS9G2W");
        user.setUsername("2-updated" + new Date());
        user.setNickname("2-updated" + new Date());
        user.setPassword("2-updated");
        user.setAge(null);
        user.setIsDelete(0);
        user.setRegistTime(new Date());

        userService.updateUser(user);

        return JSONResult.ok("保存成功");
    }

    @RequestMapping("/deleteUser")
    public JSONResult deleteUser(String userId) {

        userService.deleteUser(userId);

        return JSONResult.ok("删除成功");
    }

    @RequestMapping("/queryUserById")
    public JSONResult queryUserById(String userId) {

        return JSONResult.ok(userService.queryUserById(userId));
    }

    @RequestMapping("/queryUserList")
    public JSONResult queryUserList() {

        SysUser user = new SysUser();
        user.setUsername("imooc");
        user.setNickname("lee");

        List<SysUser> userList = userService.queryUserList(user);

        return JSONResult.ok(userList);
    }

    @RequestMapping("/queryUserListPaged")
    public JSONResult queryUserListPaged(Integer page) {

        if (page == null) {
            page = 1;
        }

        int pageSize = 3;

        SysUser user = new SysUser();
//		user.setNickname("lee");

        List<SysUser> userList = userService.queryUserListPaged(user, page, pageSize);

        return JSONResult.ok(userList);
    }

    @RequestMapping("/queryUserByIdCustom")
    public JSONResult queryUserByIdCustom(String userId) {
        //自定义mapper
        return JSONResult.ok(userService.queryUserByIdCustom(userId));
    }

    @RequestMapping("/queryZdyUserById")
    public JSONResult queryZdyUserById(String userId) {
        return JSONResult.ok(userService.queryZdyUserById(userId));
    }

    //事务控制
    @RequestMapping("/saveUserTransactional")
    public JSONResult saveUserTransactional() {

        String userId = sid.nextShort();

        SysUser user = new SysUser();
        user.setId(userId);
        user.setUsername("lee" + new Date());
        user.setNickname("lee" + new Date());
        user.setPassword("abc123");
        user.setIsDelete(0);
        user.setRegistTime(new Date());

        userService.saveUserTransactional(user);

        return JSONResult.ok("保存成功");
    }
}
