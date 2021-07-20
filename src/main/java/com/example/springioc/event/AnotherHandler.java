package com.example.springioc.event;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

// event 순차적 실행 동시에 실행 x 끝나고 다음 실행 A->B or B->A
@Component
public class AnotherHandler {
    @EventListener
    //@Async // 비동기 실행
    public void handle(MyEvent myEvent){
        System.out.println(Thread.currentThread().toString());
        System.out.println("다른 이벤트");
    }
}
