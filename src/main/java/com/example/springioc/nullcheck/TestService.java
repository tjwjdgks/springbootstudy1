package com.example.springioc.nullcheck;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @NonNull // return도 null 금지
    public String createEvent(@NonNull String name){ // 무조건 이름이 있어야 할때
        return "test";
    }
}
