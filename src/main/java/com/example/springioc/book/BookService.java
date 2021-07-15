package com.example.springioc.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;

//의존성 주입을 받으려면 bean 이어야 한다
// 싱글톤을 만들고 싶을 때
// 라이프 사이클 인터페이스
// beanfactory 상속 받은 applicationContext 가장 많이 사용
//MessageSource
// 컴포넌트 어노테이션으로 bean 등록
// bean으로 등록 의존성 주입은 autowired

@Service
public class BookService {
    // 필드에서도 autowired 가능
    @Autowired(required = false)
    public BookRepository bookRepository;

    // 생성자 autowired
    /*
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    */
    public BookService() {
    }
    // 세터에서 Autowired 사용시 bookRepository 인스턴스는 만들수 있지만 의존성 주입에서 실패
    // required false시 bean 못찾으면 의존성은 실패 인스턴스만 만들어짐
    //@Autowired(required = false)
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

}
