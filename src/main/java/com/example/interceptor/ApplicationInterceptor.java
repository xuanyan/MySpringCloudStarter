package com.example.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class ApplicationInterceptor extends HandlerInterceptorAdapter {


    private Long startTime;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        startTime = System.currentTimeMillis();
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String secondSpend = String.format("%.3f", Float.valueOf(System.currentTimeMillis() - startTime)/1000);
        log.debug(request.getMethod()+" "+request.getRequestURI()+" "+secondSpend+"s");
    }
}
