package com.atguigu.schedule.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.Method;

@WebServlet("/schedule/*")
public class SysScheduleController extends BaseController {


    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        System.out.println("add方法");
    }

    protected void find (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        System.out.println("find方法");
    }

    //http://localhost:8080/schedule/update
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        System.out.println("update方法");
    }

    protected void remove(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        System.out.println("remove方法");
    }




}
