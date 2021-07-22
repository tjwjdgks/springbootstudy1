package com.example.springioc.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/*
스프링 AOP
스프링 IOC 컨테이너가 제공하는 기반 시설과 Dynamic 프록시를 사용하여 여러 복잡한 문제 해결
동적 프록시 : 동적으로 프록시 객체 생성
빈 생성 -> 빈 post processor에서 AutoProxyCreator로 proxy bean 생성해서 proxy bean 등록
 */
// spring 애노테이션 기반 aop
@Component
@Aspect
public class PerfAspcet {
    // advice가 제공할 대상
    //pointcut 이름
    // advice 어떻게 적용할 것 인가
    // execution 형태로 제공 가능 ..*모든 밑에 모든 패키지 표현식 익힐 것
     //@Around("bean(AOPProxySimpleService)") //(bean 에도 사용 가능)
    //@Around("execution(* com.example.springioc..*.AOPEventService.*(..))") // arounc 메소드를 감싸는 형태로 제공
    // advice
    // before afterreturning afterthrowing around 등
    @Around("@annotation(PerfLogging)") // annotation 기반
    public Object logPerf(ProceedingJoinPoint pip) throws Throwable {
        long begin = System.currentTimeMillis();
        Object proceed = pip.proceed();
        System.out.println("aop annotation" + (System.currentTimeMillis()-begin));
        return proceed;


    }
    @Before("bean(AOPSimpleService)")
    public void hello(){
        System.out.println("aop hi");
    }
}
