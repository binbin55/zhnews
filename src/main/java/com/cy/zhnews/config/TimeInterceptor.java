package com.cy.zhnews.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;

public class TimeInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandler");
        String username = (String) request.getSession().getAttribute("username");
        System.out.println("username="+username);
        if (StringUtils.isEmpty(username)){
            response.sendRedirect("/doNewsPage/start?reg=0");
            return true;
        }else {
            return true;
        }
    }

}
