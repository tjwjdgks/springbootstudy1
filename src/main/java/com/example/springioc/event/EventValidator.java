package com.example.springioc.event;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

// Validation 추상화
// 어플리케이션에서 사용하는 객체 검증용 인터페이스 주로 spring mvc, 계층형 아키텍쳐에 사용
// annotation으로 bean의 data 검증, Bean Vaildation
// support와 vaildate 구현
public class EventValidator implements Validator {

    @Override
    //Event 검증 할 것이므로 Event 대조
    public boolean supports(Class<?> aClass) {
        return Event.class.isInstance(aClass);
    }

    @Override
    public void  validate(Object o, Errors errors) {
        // vaildation 유틸리티
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title","notempty","Empty title is now allowed");
        // 직접 errors에 조건 주기
        /*
        Event event = (Event) o;
        if (event.getTitle() == null)
            errors.reject("notempty"); // 전반적인 error
            //errors.rejectValue("notempty");  // 특정 field

         */

    }
}
