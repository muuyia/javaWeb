package com.mhw.formDemo;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class formGET extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet  Success");
        String username = req.getParameter("username");
        String userPwd = req.getParameter("userPwd");
        System.out.println(username + "  " + userPwd);

    }
}
