package ru.bellintegrator.practice.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class AspectExample {
    Logger log = LoggerFactory.getLogger(AspectExample.class);

    @Around("execution(* ru.bellintegrator.practice.controller.impl.DummyControllerImpl.ping())")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("INVOCATION METHOD:" + joinPoint.getSignature().toShortString());

        //method invocation
        Object returnValue = joinPoint.proceed();

        log.info("METHOD:" + joinPoint.getSignature().toShortString() + "RETURNS:" + returnValue);

        return returnValue;
    }

}
