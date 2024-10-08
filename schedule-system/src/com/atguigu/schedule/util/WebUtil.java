package com.atguigu.schedule.util;

import com.atguigu.schedule.common.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;

public class WebUtil {

    private static ObjectMapper objectMapper;
    static{
        objectMapper = new ObjectMapper();
    }

    public static <T> T readJson(HttpServletRequest request,Class<T> clazz){
        T t = null;
        BufferedReader reader = null;
        try{
            reader = request.getReader();
            StringBuffer buffer = new StringBuffer();
            String line = null;
            while ((line = reader.readLine())!= null){
                buffer.append(line);
            }

            t = objectMapper.readValue(buffer.toString(),clazz);

        }catch(IOException e){
            throw new RuntimeException(e);
        }
        return t;
    }

    //专门
    public static void writeJson(HttpServletResponse response, Result result){
        response.setContentType("application/json;charset=UTF-8");

        try{
            String info = objectMapper.writeValueAsString(result);
            response.getWriter().write(info);
        }catch(IOException e){
            throw new RuntimeException(e);
        }

    }
}
