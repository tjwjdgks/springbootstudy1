package com.example.springioc.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

//event handler, bean으로 등록되어야 한다
@Component
// 4.2 이전에는 listener 등록
//  evenrunner 실행 -> event 발생 -> handler 처리
public class MyEventHandler /* <4.2 implements ApplicationListener<MyEvent>*/ {

    @EventListener
    //@Order(Ordered.HIGHEST_PRECEDENCE) // Order 순서 지정, 가장 높은 우선순위
    //@Async // 비동기 실행
    public void handle(MyEvent myEvent) {
        System.out.println(Thread.currentThread().toString());

        System.out.println("이벤트 받음 " + myEvent.getData());
    }
}
