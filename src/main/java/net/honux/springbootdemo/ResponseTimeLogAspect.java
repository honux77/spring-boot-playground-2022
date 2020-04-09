package net.honux.springbootdemo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class ResponseTimeLogAspect {

    private Logger logger = LoggerFactory.getLogger(ResponseTimeLogAspect.class);

    @Around("execution(* net.honux.springbootdemo.WelcomeController.hello(..))")
    public Object logResponseTime(ProceedingJoinPoint joinPoint) {
        Object result = null;
        long start = System.currentTimeMillis();
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            logger.error(throwable.getMessage());
        }
        long end = System.currentTimeMillis();
        logger.info("[METHOD]: {} ms", end - start);
        return result;
    }

}
