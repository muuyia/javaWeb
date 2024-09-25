package com.atguigu.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

//P66
public class UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo02-servlet01-User");
        String username = request.getParameter("username");
        String info = "YES";
        if("atguigu".equals(username)){
            info = "NO";
        }

        //将要相应的数据放入response
        //设置Content-Type响应头 P68
        response.setHeader("Content-Type","text/html");
        PrintWriter writer = response.getWriter();
        writer.write(info);
    }
}
