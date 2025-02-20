package com.mhw.objectDemo;

import com.mhw.objectDemo.pojo.StatusWord;
import com.mhw.objectDemo.pojo.swords;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;


@WebServlet("/getObjectStr")
public class objectDemo extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("getObjectStr  Success");
        Date date = new Date();
        swords swords = new swords(null,"spell","noun","verb","adjective","adverb","int_","det","pron","conj","pret","abbr","classify", StatusWord.Blur,0,date);

        resp.getWriter().write(swords.toString());
    }
}
