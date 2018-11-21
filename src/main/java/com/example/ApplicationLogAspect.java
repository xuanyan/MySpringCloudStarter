package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Aspect
@Component
@Slf4j
public class ApplicationLogAspect {

    @Autowired
    private ObjectMapper mapper;

    private ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("@within(org.springframework.web.bind.annotation.RestController)")
    public void webLog(){}

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint)  throws Throwable {
        if (!log.isInfoEnabled()) {
            return;
        }
        startTime.set(System.currentTimeMillis());

        for (Object object : joinPoint.getArgs()) {
            if (object instanceof MultipartFile) {
                continue;
            }
            if (object instanceof HttpServletRequest) {
                continue;
            }
            if (object instanceof HttpServletResponse) {
                continue;
            }
            String info = "["+joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName()+" - request]";
            info = info + mapper.writeValueAsString(object);
            log.info(info);
        }
    }


    @AfterReturning(returning = "response", pointcut = "webLog()")
    public void doAfterReturning(JoinPoint joinPoint, Object response) throws Throwable {
        if (response == null) {
            return;
        }
        if (!log.isInfoEnabled()) {
            return;
        }
        String secondSpend = String.format("%.3f", (float)(System.currentTimeMillis() - startTime.get())/1000);

        String info = "["+joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName()+" - response "+secondSpend+"s]";
        info = info + mapper.writeValueAsString(response);
        log.info(info);
    }
}