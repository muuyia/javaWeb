package com.atguigu.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;


public class LoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("loggingFilter before filterChain.doFilter invoked");

        //放行
        filterChain.doFilter(servletRequest,servletResponse);

        System.out.println("loggingFilter after filterChain.doFilter invoked");
    }
}
