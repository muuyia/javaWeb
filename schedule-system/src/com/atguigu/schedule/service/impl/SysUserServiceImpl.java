package com.atguigu.schedule.service.impl;

import com.atguigu.schedule.dao.SysUserDao;
import com.atguigu.schedule.dao.impl.SysUserDaoImpl;
import com.atguigu.schedule.pojo.SysUser;
import com.atguigu.schedule.service.SysUserService;
import com.atguigu.schedule.util.MD5Util;

public class SysUserServiceImpl implements SysUserService {

    private SysUserDao userDao = new SysUserDaoImpl();


    @Override
    public int regist(SysUser sysUser) {

        sysUser.setUserPwd(MD5Util.encrypt(sysUser.getUserPwd()));
        return userDao.addSysUser(sysUser);
    }

    @Override
    public SysUser findByUsername(String username) {

        return userDao.findByUsername(username);
    }
}
