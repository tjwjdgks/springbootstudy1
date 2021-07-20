package com.example.springioc.event;

// ApplicationEvenPublisher
// 이벤트 프로그래밍에 필요한 인터페이스 제공. 옵저버 패턴 구현체

import org.springframework.context.ApplicationEvent;
// bean 으로 등록되는 것이 아님 // 소스및 dta 전달
// event를 퍼블리싱 해야하는데 해당 퍼블리싱 기능을 Application context가 가지고 있음
// 4.2 이후에는 ApplicationEvent 상속 받지 않아도 가능
/*
스프링의 철학 비침투성 스프링 소스코드가 들어가지않는 것 Framework 코드가 내 코드에 노출 되지 않음
test 편리, 유지 보수 편리
 */
public class MyEvent /* 4.2< extends ApplicationEvent*/ {
    private  int data;
    /*
    4.2<
    public MyEvent(Object source) {
        super(source);
    }

    public MyEvent(Object source, int data) {
        super(source);
        this.data = data;
    }
    */
    private Object source;

    public MyEvent(int data, Object source) {
        this.data = data;
        this.source = source;
    }

    public Object getSource() {
        return source;
    }

    public int getData(){
        return data;
    }
}
