package com.atguigu.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/servletB")
public class ServletB extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object reqMessage = req.getAttribute("request");
        System.out.println("请求域"+reqMessage);

        HttpSession session = req.getSession();
        String sessionMessage = (String) session.getAttribute("session");

        ServletContext application = getServletContext();
        String appMessage = (String) application.getAttribute("application");
        System.out.println("应用域" + appMessage);
    }
}
