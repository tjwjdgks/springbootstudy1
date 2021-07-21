package com.example.springioc.event;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

// formatter web에 특화, 다국화 기능 제공(locale 정보 기반)
// thread safe bean으로 등록 가능
@Component // bean으로 등록
public class EventFormatter implements Formatter<Event> {
    // 문자 --> 객체
    //@Autowired
    //MessageSource messageSource;
    @Override
    public Event parse(String s, Locale locale) throws ParseException {
        return new Event(Integer.parseInt(s));
    }
    // 객체 --> 문자
    @Override
    public String print(Event event, Locale locale) {
        return event.getId().toString();
    }
}
