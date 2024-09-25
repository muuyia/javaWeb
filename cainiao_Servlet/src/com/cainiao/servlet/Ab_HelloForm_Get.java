package com.cainiao.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


//http://localhost:8080/cainiao_Servlet/HelloFormUrl?name=菜鸟教程&url=www.runoob.com  success
//https://www.runoob.com/servlet/servlet-form-data.html
public class Ab_HelloForm_Get extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public Ab_HelloForm_Get(){
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String title = "使用GET方法读取表单数据";

        //处理中文
        String name = new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");

        String docType = "<!DOCTYPE html> \n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head> \n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<ul>\n" +
                "  <li><b>站点名</b>："
                + name + "\n" +
                "  <li><b>网址</b>："
                + request.getParameter("url") + "\n" +
                "</ul>\n" +
                "</body></html>");

    }

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException , IOException{
        doGet(request,response);
    }
}
