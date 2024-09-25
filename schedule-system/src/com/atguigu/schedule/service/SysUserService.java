package com.atguigu.schedule.service;

import com.atguigu.schedule.pojo.SysUser;

public interface SysUserService {

    int regist(SysUser sysUser);

    SysUser findByUsername(String username);
}
