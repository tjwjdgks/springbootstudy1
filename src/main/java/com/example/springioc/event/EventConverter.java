package com.example.springioc.event;


import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

// Converter S 타입을 T 타입으로 변환 할 수 있게 변환기 역할
// property 에디터 대신 사용 가능함
// 상태 정보가 없기 때문에 bean으로 등록해도 괜찮다
// ConverterRegistry에 등록
// bean 등록 시 자동
public class EventConverter {
    // interface에서 2개 처음 source 나중 target
    @Component // bean으로 등록
    public static class StringToEventConverter implements Converter<String, Event>{

        @Override
        public Event convert(String source) {
            return new Event(Integer.parseInt(source));
        }
    }
    @Component // bean으로 등록
    public static class EventToStringConverter implements  Converter<Event,String>{

        @Override
        public String convert(Event source) {
            return source.getId().toString();
        }
    }
}
