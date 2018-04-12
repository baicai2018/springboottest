package com.nondo.springboot.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * AOP实现
 */
@Aspect
@Component
public class TimeAspect {
    @Around("execution(* com.nondo.springboot.controller.fastjson.FastjsonController..*(..))")
    public Object method(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("----aspect处理----");
        Object[] args = pjp.getArgs();
        for (Object arg : args) {
            System.out.println("参数为"+arg);
        }
        long start = System.currentTimeMillis();
        Object obj = pjp.proceed();
        System.out.println("耗时："+ (System.currentTimeMillis()-start));
        return obj;
    }
}
