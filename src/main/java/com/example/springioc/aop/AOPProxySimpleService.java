package com.example.springioc.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


// Spring AOP 프록시 기반 AOP 방법
/*
단점 :
    매번 프록시 클래스를 생성
    여러 클래스 여러 매소드 적용하기 힘듬
    객체의 관계 복잡

 */
@Primary
@Service
public class AOPProxySimpleService implements AOPEventService {

    @Autowired
    AOPSimpleService simpleService;

    @PerfLogging
    @Override
    public void createEvent() {
        long l = System.currentTimeMillis();
        simpleService.createEvent();
        System.out.println(System.currentTimeMillis()-l);
    }
    @PerfLogging
    @Override
    public void publishEvent() {
        long l = System.currentTimeMillis();
        simpleService.publishEvent();
        System.out.println(System.currentTimeMillis()-l);

    }

    @Override
    public void deleteEvent() {
        simpleService.deleteEvent();
    }
}
