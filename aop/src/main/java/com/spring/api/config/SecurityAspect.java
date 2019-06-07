package com.spring.api.config;

import com.spring.api.entity.Employee;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(1)
public class SecurityAspect {

    @Pointcut("execution(* com.spring.api.service.*.*(..))")
    public void forDaoPackage(){ }

    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Security Added Before for Method : " + signature);

        Object[] args = joinPoint.getArgs();
        for (Object obj: args){
            System.out.println(obj);

            if(obj instanceof Employee){
                Employee employee = (Employee) obj;
                System.out.println(employee.getName());
            }
        }
    }

    @AfterReturning(pointcut = "forDaoPackage()", returning = "employeeList")
    public void afterAddAccountAdvice(JoinPoint joinPoint, List<Employee> employeeList){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Security Added After Returning : " + signature);

        employeeList.add(new Employee("Modified List"));

    }

    @AfterThrowing(pointcut = "forDaoPackage()", throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Throwable exception){
        System.out.println("Security : After Throwing Exception Advice : " + exception);
    }

    @After("forDaoPackage()")
    public void afterThrowing(){
        System.out.println("Security : After  Advice");
    }

    @Around("forDaoPackage()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        long begin = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();

        long duration = end - begin;
        System.out.println("Security : Duration " + duration + " milliseconds");
        return result;
    }
}
