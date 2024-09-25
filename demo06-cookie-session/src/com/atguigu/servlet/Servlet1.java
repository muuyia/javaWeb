package com.atguigu.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

//https://www.bilibili.com/video/BV1UN411x7xe/?p=105&spm_id_from=333.880.my_history.page.click&vd_source=14551025f000a7403c153e5a0e5f8140
@WebServlet("/servlet1")
public class Servlet1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        HttpSession session = req.getSession();
        session.setMaxInactiveInterval(120);


        System.out.println(session.getId());
        System.out.println(session.isNew());

        session.setAttribute("username",username);

        resp.setContentType("test/html;charset=UTF-8");
        resp.getWriter().write("成功");
    }
}
