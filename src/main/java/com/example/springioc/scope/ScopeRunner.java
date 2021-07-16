package com.example.springioc.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

// bean의 대부분 경우에는 scope 싱글톤

@Component
public class ScopeRunner implements ApplicationRunner {
    @Autowired
    Single single;
    @Autowired
    Proto proto;
    @Autowired
    ApplicationContext ctx;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(single);
        System.out.println(single);
        System.out.println(proto);
        System.out.println(single.proto);

        System.out.println();
        System.out.println(ctx.getBean(Proto.class));
        System.out.println(ctx.getBean(Proto.class));
        System.out.println(ctx.getBean(Proto.class));
        System.out.println(ctx.getBean(Single.class));
        System.out.println(ctx.getBean(Single.class));
        System.out.println(ctx.getBean(Single.class));
    }
}
