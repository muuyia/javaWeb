package com.atguigu.schedule.test;

import com.atguigu.schedule.dao.BaseDao;
import com.atguigu.schedule.dao.SysUserDao;
import com.atguigu.schedule.pojo.SysUser;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

//https://www.bilibili.com/video/BV1UN411x7xe/?p=96&spm_id_from=333.880.my_history.page.click&vd_source=14551025f000a7403c153e5a0e5f8140
public class TestBaseDao {
    private static BaseDao baseDao;

    @BeforeClass
    public static void initBaseDao(){
        baseDao = new BaseDao();
    }
    @Test
    public void testBaseQueryObject(){
        String sql = "select count(1) from sys_user";
        Long count = baseDao.baseQueryObject(Long.class, sql);
        System.out.println(count);
    }

    // 18:44
    @Test
    public void testBaseQuery(){
        String sql = "select uid,username,`user _pwd` userPwd from sys_user";
        List<Object> sysUserList = baseDao.baseQuery(SysUser.class, sql);
        sysUserList.forEach(System.out::println);
    }

    @Test
    public void testBaseUpdate(){
        String sql = "insert into sys_schedule values(DEFAULT,?,?,?)";

        int rows = baseDao.baseUpdate(sql, 1, "学习Java", 0);
        System.out.println(rows);
    }
}
