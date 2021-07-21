package com.example.springioc.event;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

    @GetMapping("/event/{event}")
    // 기본적인 @PathVariable Integer 같은 기본적인 type은 converter나 formatter이 자동 변환
    public String getEvent(@PathVariable Event event){
        System.out.println(event.toString());
        return event.getId().toString();
    }
}
