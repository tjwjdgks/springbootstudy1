package com.example.springioc;


/*
// 수동 등록시 소스사용
@Configuration
// spring boot 에서는 converter와 formatter가 bean으로 등록되어 있다면 자동 등록
// converter 나 formatter 들은 ConversionService에 등록
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        //registry.addConverter(new EventConverter.StringToEventConverter()); // converter 사용시
        registry.addFormatter(new EventFormatter()); // formatter 사용
    }
}

 */
