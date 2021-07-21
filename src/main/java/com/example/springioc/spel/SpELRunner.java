package com.example.springioc.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;

@Component
// SpEL ( 스프링 Expression Language)
/*
스프링 EL이란?
 객체 그래프를 조회하고 조작하는 기능을 제공한다.
 Unified EL과 비슷하지만, 메소드 호출을 지원하며, 문자열 템플릿 기능도 제공한다.
 OGNL, MVEL, JBOss EL 등 자바에서 사용할 수 있는 여러 EL이 있지만, SpEL은 모든 스프링 프로젝트 전반에 걸쳐 사용할 EL로 만들었다.
 스프링 3.0 부터 지원.
 */
public class SpELRunner implements ApplicationRunner {
    // Expression language
    // #과 같이 쓰면 표현식으로 인식 표현식 실행 및 결과값 저장
    @Value("#{1+1}")
    int value;

    @Value("#{'hello '+ 'world'}")
    String greeting;
    @Value("#{1 eq 1}")
    boolean trueOrFalse;

    //spel 다른 방법 프로퍼티 참조
    // app.properties 파일에 있음
    // 주의 표현식 안에는 프로퍼티를 가질수 있지만 반대는 불가능
    @Value("${my.value}")
    int myValue;
    // 가능
    @Value("#{${my.value}+1}")
    int newValue;

    // bean의 정보도 참조 가능
    // Sample bean에 data 참조
    @Value("#{sample.data}")
    int sampledata;
    // @ConditionalOnExpression 애노테이션 spel 사용 가능 ConditionalOn 애노테이션 선택적으로 bean 등록 하거나 설정 파일 읽을 때 사용
    // 스프링 시큐리티에서도 spel 사용 가능
    // 스피링 data query 에노테이션 spel 사용 가능
    // thymeleaf 도 사용
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("==============spring spelrunner============");
        System.out.println(value);
        System.out.println(greeting);
        System.out.println(trueOrFalse);
        System.out.println(myValue);
        System.out.println(newValue);
        System.out.println(sampledata);

        // SPEL 구성 중 ExpressionParser 사용
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("2+100");// 이 자체가 expression이기 때문에 {#} 필요 없음
        Integer evalue = expression.getValue(Integer.class);// Integer class로 가져온다 conversion service 사용한다
        System.out.println(evalue);

        System.out.println("==============spring spelrunner============");
    }
}
