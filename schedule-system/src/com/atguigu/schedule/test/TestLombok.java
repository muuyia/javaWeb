package com.atguigu.schedule.test;

import com.atguigu.schedule.pojo.SysUser;

public class TestLombok {

    public static  void testAnnotation(){
        SysUser sysUser = new SysUser(1, "", "");
        String string = sysUser.toString();
        String userPwd = sysUser.getUserPwd();
        System.out.println(string + userPwd);
    }


}
