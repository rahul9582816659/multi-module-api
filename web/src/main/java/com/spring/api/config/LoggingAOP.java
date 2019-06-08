package com.spring.api.config;

import com.spring.api.entity.Employee;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAOP {

    // add logger
    private Logger logger = Logger.getLogger(getClass().getName());



    // add pointcut
    @Pointcut("execution(*  com.spring.api.endpoint.*.*(..))")
    private void forEndpointPackage(){}

    @Pointcut("execution(*  com.spring.api.service.*.*(..))")
    private void forServicePackage(){}

    @Pointcut("execution(*  com.spring.api.dao.*.*(..))")
    private void forDaoPackage(){}

    @Pointcut("forEndpointPackage() || forServicePackage() || forDaoPackage()")
    private void forWebFlow(){}



    // add before advice
    @Before("forWebFlow()")
    private void beforeAdvice(JoinPoint joinPoint){

        // display method we are calling
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        logger.info("====> in @Before calling method : " + signature);

        // display argument to method
        Object[] args = joinPoint.getArgs();
        for (Object obj: args){
            logger.info("\"====> argument : " + obj);
        }

    }

    // add after returning advice
    @AfterReturning(pointcut = "forWebFlow()", returning = "userList")
    public void afterAddAccountAdvice(JoinPoint joinPoint, List<String> userList){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        logger.info("====> in @AfterReturning calling method : " + signature);

        userList.add("Modified List");

    }
}
