package com.spring.api.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class LoggingConfig {

    /**
     *  "execution(public void addHome())" only methods with name addHome
     *  "execution(public void add*())" any method which start with add
     *  "execution(* add*())" any return type
     *
     *
     *  testAOPAspect() no arguments
     *  testAOPAspect(*) 1 arguments
     *  testAOPAspect(..) o or more arguments
     *
     *
     *  on package
     *  "execution(* com.spring.api.service.*.*(..))" service package (service.*.* first * is any class and second * is any method)
     *  "execution(* com.spring.api.dao.*.*(..))" dao package
     *  "execution(public void addHome(com.spring.api.entity.Employee))" only match method addHome with argument Employee
     *  "execution(public void addHome(com.spring.api.entity.Employee, ..))" only match method addHome with argument Employee, any no of argument
     */

   /* @Before("execution(public void addHome())")
    public void testAOPAspect(){
        System.out.println("Logging For testAOP Only Called");
    }

    @Before("execution(public void addHome(com.spring.api.entity.Employee))")
    public void testAOPAspectWithParam(){
        System.out.println("Logging For testAOP with param Only Called");
    }

    @Before("execution(public void add*())")
    public void testAOPForAll(){
        System.out.println("Logging For ALL Called");
    }

    @Before("execution(*  com.spring.api.service.*.*(..))")
    public void servicePackage(){
        System.out.println("Logging For Service Package Only");
    }*/


    /**
     * Pointcut Expression
     *  @Pointcut("execution(*  com.spring.api.service.*.*(..))")
     *  @Before("forDaoPackage()")
     *
     *
     *  @Pointcut("execution(*  com.spring.api.service.*.get*(..))")
     *  @Pointcut("execution(*  com.spring.api.service.*.set*(..))")
     *  @Pointcut("forDaoPackage() && !(forDaoGetters() || forDaoSetters())")
     */

    @Pointcut("execution(*  com.spring.api.service.*.*(..))")
    public void forDaoPackage(){ }
/*
    @Pointcut("execution(*  com.spring.api.service.*.get*(..))")
    public void forDaoGetters(){ }

    @Pointcut("execution(*  com.spring.api.service.*.set*(..))")
    public void forDaoSetters(){ }*/

    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice(){
        System.out.println("Logging Added");
    }

    @AfterReturning("forDaoPackage()")
    public void afterAddAccountAdvice(JoinPoint joinPoint){
        System.out.println("Logging Added After Returning");
    }

    @AfterThrowing(pointcut = "forDaoPackage()", throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Throwable exception){
        System.out.println("Logging : After Throwing Exception Advice : " + exception);
    }

    @After("forDaoPackage()")
    public void afterThrowing(){
        System.out.println("Logging : After  Advice");
    }

    @Around("forDaoPackage()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        long begin = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();

        long duration = end - begin;
        System.out.println("Logging : Duration " + duration + " milliseconds");
        return result;
    }

   /* @Before("forDaoPackage()")
    public void security(){
        System.out.println("Security Added");
    }

    @Before("forDaoPackage()")
    public void performApiAnalytics(){
        System.out.println("Api Analytics Added");
    }


    @Pointcut("forDaoPackage() && !(forDaoGetters() || forDaoSetters())")
    private void forDaoPackageNoGetterSetter(){}

    @Before("forDaoPackageNoGetterSetter()")
    public void forDaoPackageNoGetterSetterPoincut(){
        System.out.println("forDaoPackageNoGetterSetter");
    }
*/
}
