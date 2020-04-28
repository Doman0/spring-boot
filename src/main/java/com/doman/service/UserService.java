package com.doman.service;

import com.doman.pojo.SysUser;

import java.util.List;

/**
 * @Description:
 * @Author: Doman
 * @Date: 2020/4/28
 */
public interface UserService {

    public void saveUser(SysUser user) throws Exception;

    public void updateUser(SysUser user);

    public void deleteUser(String userId);

    public SysUser queryUserById(String userId);

    public List<SysUser> queryUserList(SysUser user);

    public List<SysUser> queryUserListPaged(SysUser user, Integer page, Integer pageSize);

    public SysUser queryUserByIdCustom(String userId);

    public SysUser queryZdyUserById(String userId);

    public void saveUserTransactional(SysUser user);
}
