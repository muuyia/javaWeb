package com.mhw.formDemo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


//http://localhost:8080/practiceServlet/formGETdemo2?username=sss22s&userPwd=dddd22
@WebServlet("/formGETdemo2")
public class formGET2 extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet  Success");
        String username = req.getParameter("username");
        String userPwd = req.getParameter("userPwd");
        System.out.println(username + "  " + userPwd);
    }

}
