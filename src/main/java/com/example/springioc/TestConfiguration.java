package com.example.springioc;

import com.example.springioc.book.BookRepository;
import com.example.springioc.book.TestBookRepostiory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
// 프로파일 설정 방법 Edit configuration에서 active profile에 Profile 이름 추가
public class TestConfiguration {
    /*
    @Bean
    public TestBookRepostiory bookRepository(){
        return new TestBookRepostiory();
    }

     */
}
