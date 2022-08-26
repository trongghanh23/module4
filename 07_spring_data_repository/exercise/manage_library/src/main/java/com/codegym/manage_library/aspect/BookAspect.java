package com.codegym.manage_library.aspect;

import com.codegym.manage_library.service.ITrafficService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BookAspect {
    @Autowired
    private ITrafficService trafficService;

    @AfterReturning(pointcut = " execution(public * com.codegym.manage_library.controller.LibraryController.*(..)) ")
    public void logHistory(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        System.out.println("The " + name + " method just worked");
    }

    @After(" execution(public * com.codegym.manage_library.controller.LibraryController.*(..)) ")
    public void increaseTraffic(JoinPoint joinPoint) {
        trafficService.increase();
    }
}
