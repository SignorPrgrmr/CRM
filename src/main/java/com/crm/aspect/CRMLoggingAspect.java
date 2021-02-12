package com.crm.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

    // Setting up logger
    private final Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.crm.controller.*.*(..))")
    private void forControllerPackage() {}

    @Pointcut("execution(* com.crm.dao.*.*(..))")
    private void forServicePackage() {}

    @Pointcut("execution(* com.crm.service.*.*(..))")
    private void forDaoPackage() {}

    @Pointcut("forControllerPackage() || forDaoPackage() || forServicePackage()")
    private void forAppFlow() {}

    // Adding before advice
    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {
        // display the method calling
        String method = joinPoint.getSignature().toShortString();
        logger.info("======>> in @Before: calling method:" + method);
        // display the arguments of that method
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            logger.info("=======>> argument: " + arg.toString());
        }
    }

    @AfterReturning(pointcut = "forAppFlow()", returning = "result")
    public void after(JoinPoint joinPoint, Object result) {
        String method = joinPoint.getSignature().toShortString();
        logger.info("=====>> in @AfterReturning: Calling method: " + method);
        logger.info("=====>> in @AfterReturning: returned value of method: " + result.toString());
    }
}
