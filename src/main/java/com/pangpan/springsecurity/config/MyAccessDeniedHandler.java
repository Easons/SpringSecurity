package com.pangpan.springsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 统一处理权限异常
 * @author pangpan
 * @date 2022-01-19
 */
@Configuration
public class MyAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {

        //处理乱码
        httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);//设置状态为没有权限403，而不是200
        httpServletResponse.setContentType("application/json;charset=utf-8");
        PrintWriter out = httpServletResponse.getWriter();
//        out.write("权限不足");

        out.write("{\"code\":403,\"message\":\"无权限\",\"data\":\"无权限\"}");


    }
}
