package com.example.springioc.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

// 프로토 bean은 싱글톤 bean 참조시 문제 없음
// 프로토 proxyMode로 싱글톤에서도 바뀔 수 있게 변경
// 프록시 패턴을 이용하여 싱글톤에서 직접적으로 프로토를 참조하는 것이 아닌 프록시를 참조
@Component @Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Proto {

}
