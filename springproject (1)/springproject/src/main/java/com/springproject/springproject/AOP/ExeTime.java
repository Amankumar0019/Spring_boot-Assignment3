package com.springproject.springproject.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class ExeTime {
    private static final Logger logger = LoggerFactory.getLogger(ExeTime.class);
    @Around("execution(* com.springproject.springproject.Service.ServiceSale.getData(..))")
    public Object logTimeTaken(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long timeTaken = System.currentTimeMillis() - startTime;
        logger.info("Time taken by {} is {} ms", joinPoint.getSignature(), timeTaken);
        return result;
    }
}