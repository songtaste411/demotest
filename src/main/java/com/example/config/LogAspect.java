package com.example.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
@Aspect
@Component
@Order(2)



public class LogAspect {
    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);
    @Pointcut("execution(public * com.example.controller..*.*(..))")
    public void logPointCut(){}

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        // 执行方法
        Object result = point.proceed();
        // 执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;
        //异步保存日志
        saveLog(point, time);
        return result;
    }
    //处理日志,比如输出 保存到数据库...
    void saveLog(ProceedingJoinPoint joinPoint, long time) throws InterruptedException {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        String methodName = signature.getName();
        // 请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        logger.info("------------------------这是第二个执行的接口日志-----------------------"+"\n"+"类名称:"+className
                +"\n"+"方法名:"+methodName+"\n"+"执行时间:"+time+"毫秒");
    }

}
