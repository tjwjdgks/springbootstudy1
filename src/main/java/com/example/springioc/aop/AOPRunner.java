package com.example.springioc.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/*
spring aop 개념
aop는 oop를 보완하는 수단으로, 흩어진 Aspect를 모듈화 할 수 있는 기능 프로그래밍 기법
aop 구현체 제공
자바 aop framework (AspectJ) 연동해서 사용 가능
spring 자체 aop 활용 가능
spring transaction, cache 활용 가능
aspect로 파편화된 코드를 유지 보수 쉽게 모은다.
aspect 모듈, advice 해야할 일, pointcut 어디에 적용해야 하는 지 join point의 구체적인 지점
target 적용해야할 대상, join point 끼어들 수 있는 지점, 합류 하는 지점, 메타적인 정보
AOP 적용 방법
    컴파일
        자바 파일을 CLASS 파일로 만들때, 바이트 코드 조작 및 생성
        성능 부하 줄어든다 BUT 별도 컴파일 과정 거쳐야 한다
    로딩
        클래스를 로딩하는 시점에 변경, 로드타임위빙
        로딩 시점에 부하가 생기고 로드타임위버를 사용해야한다. 다양한 문법 사용 가능
    런타임
        스프링 AOP가 사용하는 방법
        빈을 만들때 빈을 감싼 프록시 빈을 만듬, 프록시 빈이 타겟 함수 호출 직전에 해당 함수 호출한다.
        Bean 초기에 성능 부하, 별도의 기능이 필요 없음, 문법이 쉬움

자바
    AspectJ
        다양한 기능 제공
    스프링 AOP
        국한적으로 기능 제공

 */
// 프록시 기반의 AOP
// 스프링 빈에만 AOP를 적용할 수 있음
/*
프록시 패턴
https://limkydev.tistory.com/79
client 인터페이스로 프록시 객체 참조
프록시 객체와 서비스 객체는 같은 type이고
프록시 객체에서 서비스 객체 참조
패턴의 목적
접근제어와 부가기능을 추가하기 위해서

 */
@Component
public class AOPRunner implements ApplicationRunner {

    @Autowired
    AOPEventService eventService;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("============AOPRunncer===========");
        eventService.createEvent();
        eventService.publishEvent();
        eventService.deleteEvent();
        System.out.println("============AOPRunncer===========");
    }
}
