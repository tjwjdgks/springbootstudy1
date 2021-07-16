package com.example.springioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MessageRunner implements ApplicationRunner {
    //messages로 시작하는 properties를 자동으로 읽어준다
    @Autowired
    MessageSource messageSource;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(messageSource.getMessage("greeting", new String[]{"seo"},Locale.US));
        System.out.println(messageSource.getMessage("greeting", new String[]{"seo"},Locale.KOREA));
        //tread build 해줘야 실시간 reload 로 변하는 것 볼 수 있음
        /*
        while(true){
            System.out.println(messageSource.getMessage("greeting", new String[]{"seo"},Locale.KOREA));
            System.out.println(messageSource.getMessage("greeting", new String[]{"seo"},Locale.US));
            Thread.sleep(1000l);
        }
        
         */
    }
}
