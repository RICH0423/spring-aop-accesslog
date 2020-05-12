package com.chcm.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(10)
@Slf4j
public class AccessLogAspect {

    @Before("@annotation(com.chcm.aop.annotation.AccessLog)")
    public void accesslog(JoinPoint joinPoint) throws Throwable {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        log.info("AccessLog - user: {}, access point: {}", auth.getName(), joinPoint.getSignature());
    }

}
