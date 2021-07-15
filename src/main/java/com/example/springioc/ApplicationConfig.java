package com.example.springioc;

import com.example.springioc.book.BookRepository;
import com.example.springioc.book.BookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// xml이 아닌 java config
// bean으로 등록만 해도 autowire 가능, 생성자는 불가능 setter에서 가능
// coponentsacn
//@Configuration
//class 부터 componetscan 하는 것
//@ComponentScan(basePackageClasses = SpringiocApplication.class)
public class ApplicationConfig {
    /*
    @Bean
    public BookRepository bookRepository(){
        return new BookRepository();
    }
    @Bean
    public BookService bookService(){
        BookService bookService= new BookService();
        // 메소드 호출
        bookService.setBookRepository(bookRepository());
        return bookService;
    }

     */
}
