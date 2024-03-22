package org.example;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectExample {

    @Pointcut("within(org.example.HelloWorldService) && execution(public * *(..))")
    public void targetMethods() {}

    @Before("targetMethods()")
    public void logBeforeTargetMethods(JoinPoint joinPoint) {

        System.out.println(">>> Logging before method: " + joinPoint.getSignature().getName());
    }

}