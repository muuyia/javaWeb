package com.atguigu.schedule.dao;


import com.atguigu.schedule.pojo.SysUser;

/**
 * Data access Object 数据访问对象
 *定义针对表格的CRUD方法
 *
 */

public interface SysUserDao {

    int addSysUser(SysUser sysUser);

    SysUser findByUsername(String username);
}
