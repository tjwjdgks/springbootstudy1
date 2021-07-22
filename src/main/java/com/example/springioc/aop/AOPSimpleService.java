package com.example.springioc.aop;

import org.springframework.stereotype.Service;

// target 객체
@Service
public class AOPSimpleService implements AOPEventService {

    @Override
    public void createEvent() {
        // aop 적용 전 예시
        //long l = System.currentTimeMillis();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Create simple Event");
        //System.out.println(System.currentTimeMillis()-l);
    }

    @Override
    public void publishEvent() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Publish simple Event");

    }
    @Override
    public void deleteEvent(){
        System.out.println("Delete simple Event");
    }
}
