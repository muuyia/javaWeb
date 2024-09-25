package com.cainiao.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

//http://localhost:8080/cainiao_Servlet/HelloWorldUrl
//https://www.runoob.com/servlet/servlet-first-example.html
public class Aa_Helloworld extends HttpServlet {
    private String message;

    public void init() throws ServletException {
        message = "Hello World";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + "</h1>");

    }

    public void destory(){

    }
}
