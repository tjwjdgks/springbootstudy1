package com.example.springioc;

import com.example.springioc.book.BookService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

// spring ioc container bean 설정파일 필요
@SpringBootApplication // 어노테이션 가능
public class SpringiocApplication {

    public static void main(String[] args) {
        /*
        // class 파일 방식
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        */

        /*
        xml 방식
        ApplicationContext context = new ClassPathXmlApplicationContext("application.txt");
         */
        /*
        // test
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        System.out.println(Arrays.toString(beanDefinitionNames));
        BookService bookService = (BookService) context.getBean("bookService");
        System.out.println(bookService.bookRepository!=null);
         */
        SpringApplication.run(SpringiocApplication.class,args);
    }
}
