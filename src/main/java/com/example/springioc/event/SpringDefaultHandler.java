package com.example.springioc.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class SpringDefaultHandler {
    @EventListener
    public void Handle(MyEvent myEvent){
        System.out.println("spring default handler");

    }
    @EventListener
    public void Handle(ContextRefreshedEvent event){
        System.out.println("ContextRefreshedEvent");
        /*
        //이벤트는 어플리케이션 context와 관계 있음
        ApplicationContext applicationContext = event.getApplicationContext();
         */

    }
    @EventListener
    public void Handle(ContextClosedEvent event){
        System.out.println("ContextClosedEvent");
        /*
        //이벤트는 어플리케이션 context와 관계 있음
        ApplicationContext applicationContext = event.getApplicationContext();
         */
    }
}
