package com.atguigu.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


//https://www.bilibili.com/video/BV1UN411x7xe/?p=106&spm_id_from=pageDriver&vd_source=14551025f000a7403c153e5a0e5f8140
@WebServlet("/servletA")
public class ServletA extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("requeset","resuestMessage");

        HttpSession session = req.getSession();
        session.setAttribute("session","sessionMessage");

        ServletContext application = getServletContext();
        application.setAttribute("application","applicationMessage");


        Object reqMessage = req.getAttribute("request");
        System.out.println("请求域"+reqMessage);

        req.getRequestDispatcher("servletB").forward(req,resp);
    }
}
