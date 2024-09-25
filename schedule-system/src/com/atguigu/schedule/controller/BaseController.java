package com.atguigu.schedule.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.Method;

public class BaseController extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String[] split = requestURI.split("/");
        String methodName = split[split.length - 1];

        /**   URL与方法映射 方式一

         if(methodName.equals("add")){
         add(req,resp);
         }else if (methodName.equals("find")){
         find(req,resp);
         }else if ( methodName.equals("update")){
         update(req,resp);
         }else if ( methodName.equals("remove")){
         remove(req,resp);
         }
         */



        //URL与方法映射方式二
        /**
         * https://www.bilibili.com/video/BV1UN411x7xe/?p=98&spm_id_from=pageDriver&vd_source=14551025f000a7403c153e5a0e5f8140
         */
        Class aClass = this.getClass();
        try {
            Method declaredMethod = aClass.getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this,req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
