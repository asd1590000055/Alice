package com.zt.aspect;


import com.zt.entity.LogEntity;
import com.zt.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.UUID;

@Component
@Aspect
@Slf4j
public class Adrice {
    @Autowired
    HttpServletRequest request;


    @Autowired
    LogService logService;

    @Around(value = "pt()")
    public Object testAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object proceed;
        System.out.println("this is around before");
        //怎么获取执行操作的用户
        String admin = (String) request.getSession().getAttribute("admin");
        //怎么获取执行时间
        Date date = new Date();
        //怎么获取做了什么事
        //String name = proceedingJoinPoint.getSignature().getName();
        //获取方法对象
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = signature.getMethod();
        //获取注解对象
        Log annotation = method.getAnnotation(Log.class);
        String name = annotation.name();

        //事情的执行结果
        boolean flag = false;

        try {
            proceed = proceedingJoinPoint.proceed();   //调用目标方法  userService.findAll();
            flag = true;
            return proceed;
        } catch (Throwable throwable) {
            throw throwable;
        } finally {
            log.info("person--->{},date--->{},thing--->{},flag--->{}", admin, date, name, flag);
            LogEntity logEntity = new LogEntity(UUID.randomUUID().toString(), name, admin, date, flag);
            logService.addLog(logEntity);
        }
    }

    @Pointcut(value = "@annotation(com.zt.aspect.Log)")
    public void pt() {
    }
}
