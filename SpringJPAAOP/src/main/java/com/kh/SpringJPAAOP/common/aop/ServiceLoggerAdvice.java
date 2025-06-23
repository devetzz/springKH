package com.kh.SpringJPAAOP.common.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class ServiceLoggerAdvice {

    // @After("execution(* com.kh.SpringJPAAOP.service.MyMemberDAOService*.*(..))")
    public void srartLog(JoinPoint jp){
        log.info("stopLog");
        log.info("stopLog : " + jp.getSignature());
        if(jp.getArgs() != null){
            log.info("stopLog : " + Arrays.toString(jp.getArgs()));
        }
    }

    // com.zeus.service.BoardService 클래스에 속한 임의의 메서드를 대상으로 한다. @Around("execution(* com.zeus.service.BoardService*.*(..))")
    @Around("execution(* com.kh.SpringJPAAOP.service.MyMemberDAOService*.*(..))")
    public Object timeLog(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        // serviceImpl 기능(insert(), select(), delete(), selectAll()) 실행하는것
        // 핵심관심 실행되는 부분
        Object result = pjp.proceed();
        
        long endTime = System.currentTimeMillis();
        log.info(pjp.getSignature().getName() + " : " + (endTime - startTime));
        return result;
    }   
}
