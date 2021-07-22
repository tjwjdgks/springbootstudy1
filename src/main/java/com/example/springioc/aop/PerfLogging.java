package com.example.springioc.aop;

import java.lang.annotation.*;

// retention은 class 인데 class 이상으로 주어야 함
@Documented
@Retention(RetentionPolicy.CLASS) // 기본 값으로 없애도 가능
@Target(ElementType.METHOD)
public @interface PerfLogging {
}
