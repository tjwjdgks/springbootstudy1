package com.example.springioc.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

// 싱글톤 스콥 안에 프로토 스콥이 포로토 스콥이 변경되지 않는다
// 싱글톤 스콥 쓰레드 safe 하지 않음
@Component
public class Single {
    @Autowired
    Proto proto;
    /*
    //scope 지정시 프로토 프록시 말고 다른 방법
    @Autowired
    private ObjectProvider<Proto> proto;
    public Proto getProto(){
        return proto.getIfAvailable();
    }

     */

}
