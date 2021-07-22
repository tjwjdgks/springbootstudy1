package com.example.springioc.nullcheck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/*
    null safety
    spring framework 5에 추가된 기능
    null 관련된 annotation
    목적 comfile time에 최소한 null point exception 방지
    null 허용 null 허용 x annotation marking
 */
@Component
public class NullRunner implements ApplicationRunner {
    @Autowired
    TestService testService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String message = testService.createEvent("seo");
    }
}
