package com.atguigu.schedule.controller;

import com.atguigu.schedule.common.Result;
import com.atguigu.schedule.common.ResultCodeEnum;
import com.atguigu.schedule.pojo.SysUser;
import com.atguigu.schedule.service.SysUserService;
import com.atguigu.schedule.service.impl.SysUserServiceImpl;
import com.atguigu.schedule.util.MD5Util;
import com.atguigu.schedule.util.WebUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/user/*")
public class SysUserController extends BaseController {

    private SysUserService userService = new SysUserServiceImpl();

    protected void checkUsernameUsed(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        SysUser sysUser = userService.findByUsername(username);

        Result result = Result.ok(null);


        if(null != sysUser){
            result = Result.build(null, ResultCodeEnum.USERNAME_USED);
        }
        //将result对象转换成JSON串响应给客户端
        WebUtil.writeJson(resp,result);
    }

    //登录功能问题：密码为空
    //https://www.bilibili.com/video/BV1UN411x7xe/?p=102&spm_id_from=pageDriver&vd_source=14551025f000a7403c153e5a0e5f8140
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String userPwd = req.getParameter("userPwd");


        SysUser loginUser = userService.findByUsername(username);
        if(null == loginUser){
            resp.sendRedirect("/loginUsernameError.html");
        }else if(! MD5Util.encrypt(userPwd).equals(loginUser.getUserPwd())){
            resp.sendRedirect("/loginUserPwdError.html");
        }else{
            HttpSession session = req.getSession();
            session.setAttribute("sysUser",loginUser);
            resp.sendRedirect("/showSchedule.html");
        }
    }



    //https://www.bilibili.com/video/BV1UN411x7xe/?p=101&spm_id_from=pageDriver&vd_source=14551025f000a7403c153e5a0e5f8140
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username= req.getParameter("username");
        String userPwd = req.getParameter("userPwd");

        SysUser sysUser = new SysUser(null,username,userPwd);
        int rows = userService.regist(sysUser);

        if(rows > 0 ){
            resp.sendRedirect("/registSuccess.html");
        }else{
            resp.sendRedirect("/registFail.html");
        }
    }
}
