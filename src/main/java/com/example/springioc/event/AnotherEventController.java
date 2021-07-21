package com.example.springioc.event;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

// 프로퍼티 값을 타겟 객체에 설정하는것
// 사용자가 입력한 값을 application 도메인 객체에 할당하는 기능
// 바인딩 필요한 이유 사용자가 입력한 값은 문자열을 다양한 타입으로 변환해주어야 함, 데이터 바인딩 필요
// 프로퍼티 바인딩 요청 URL 패턴에 있는 일부 값을 맵핑 => thread safe 하지 않고 불편, Object와 String 간의 관계임 따라서 converter와 formatter로 개선
@RestController
public class AnotherEventController {
    // controller 에다가 initbinder를 사용해서 등록, AnotherEvent 클래스 처리할 EventEiditor 사용
    //WebDataBinder가 웹 요청 매개변수를 바인딩 하는 용도
    @InitBinder
    public void init(WebDataBinder webDataBinder){
        webDataBinder.registerCustomEditor(AnotherEvent.class, new AnotherEventEditor());
    }
    @GetMapping("/AnotherEvent/{anotherEvent}")
    public String getEvent(@PathVariable AnotherEvent anotherEvent){
        System.out.println(anotherEvent);
        return anotherEvent.getId().toString();
    }
}
