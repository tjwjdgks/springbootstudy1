package com.example.springioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

@Component
public class ConverstionRunner implements ApplicationRunner {
    // WebConversionService 가 나옴 이것은 Spring boot 가 제공  DefaultFormattingConversionService 상속 받아 구현
    @Autowired
    ConversionService conversionService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //System.out.println(conversionService); // 등록되어 있는 converter 볼 수 있음
        System.out.println("conversionrunner " + conversionService.getClass().toString());
    }
}
