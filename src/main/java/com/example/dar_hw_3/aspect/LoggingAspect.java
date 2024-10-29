package com.example.dar_hw_3.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Configuration
@Component
public class LoggingAspect {

    @Before(value = "execution(* com.example.dar_hw_3.controller.StudentController.*(..))")
    public void logBeforeEndpointCall(JoinPoint joinPoint) {
        log.info("---------");
        log.info("Before {} endpoint is executed", joinPoint.getSignature().getName());
        log.info("Arguments of endpoint {} ", joinPoint.getArgs());
        log.info("---------");
    }

    @AfterReturning(value = "execution(* com.example.dar_hw_3.controller.StudentController.*(..))", returning = "result")
    public void logAfterEndpointCall(JoinPoint joinPoint, Object result) {
        log.info("---------");
        log.info("After {} endpoint is executed", joinPoint.getSignature().getName());
        log.info("Result of endpoint {} ", result);
        log.info("---------");
    }

    @AfterThrowing(pointcut = "execution(* com.example.dar_hw_3.controller.StudentController.*(..))", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
        log.info("---------");
        log.error("Endpoint {} threw an exception:", joinPoint.getSignature().getName());
        log.error("Exception {}", exception.getMessage());
        log.info("---------");
    }
}
