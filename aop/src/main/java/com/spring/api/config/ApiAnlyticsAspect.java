package com.spring.api.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class ApiAnlyticsAspect {

    @Pointcut("execution(*  com.spring.api.service.*.*(..))")
    public void forDaoPackage(){ }

    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice(){
        System.out.println("Analytics Added");
    }

    @AfterReturning("forDaoPackage()")
    public void afterAddAccountAdvice(JoinPoint joinPoint){
        System.out.println("Analytics Added After Returning");
    }

    @AfterThrowing(pointcut = "forDaoPackage()", throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Throwable exception){
        System.out.println("Analytics : After Throwing Exception Advice : " + exception);
    }

    @After("forDaoPackage()")
    public void afterThrowing(){
        System.out.println("Analytics : After  Advice");
    }

    @Around("forDaoPackage()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        long begin = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();

        long duration = end - begin;
        System.out.println("Analytics : Duration " + duration + " milliseconds");
        return result;
    }
}
