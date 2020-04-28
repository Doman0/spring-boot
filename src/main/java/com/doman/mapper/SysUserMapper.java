package com.doman.mapper;

import com.doman.pojo.SysUser;
import com.doman.utils.MyMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserMapper extends MyMapper<SysUser> {
    List<SysUser> queryUserById(String id);
}