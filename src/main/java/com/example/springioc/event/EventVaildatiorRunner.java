package com.example.springioc.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Arrays;

@Component
public class EventVaildatiorRunner implements ApplicationRunner {
    // annotation 사용
    // maven spring-starter-validation 사용
    @Autowired
    Validator validator;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(validator.getClass());
        Event event = new Event();
        //EventValidator eventValidator = new EventValidator(); // class 만들기
        event.setLimit(-1);
        event.setEmail("aaa2");
        Errors errors = new BeanPropertyBindingResult(event,"event"); // target

        //eventValidator.validate(event, errors); // class 만들기
        validator.validate(event,errors);
        System.out.println(errors.hasErrors());
        errors.getAllErrors().forEach(e->{
            System.out.println("==== error code ==== ");
            Arrays.stream(e.getCodes()).forEach(System.out::println);
            System.out.println(e.getDefaultMessage());
        });
    }
}
