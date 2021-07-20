package com.example.springioc.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;

//의존성 주입을 받으려면 bean 이어야 한다
// 싱글톤을 만들고 싶을 때
// 라이프 사이클 인터페이스
// beanfactory 상속 받은 applicationContext 가장 많이 사용
//MessageSource
// 컴포넌트 어노테이션으로 bean 등록
// bean으로 등록 의존성 주입은 autowired

// bean의 id 기본적으로 class name 스몰 케이스
// bean은 싱글톤 스콥
@Service
public class BookService {
    // 필드에서도 autowired 가능
    // Qulifier bean id 적어야 한다

    //@Autowired(required = false) // @Qualifier("seoBookRepository")
    // bean lifecycle 초기화 전에 bean 주입 해준다
    // bookRepository와 동일한 이름의 bean을 주입 받을 수 있다(비 추천)
    // @Primary 추천
    //public BookRepository bookRepository;
    @Autowired
    BookRepository bookRepository;

    //@Autowired
    //List<BookRepository> bookRepositories;

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
    /*
    public void printBookRepository(){
        //System.out.println(bookRepository.getClass());
        this.bookRepositories.forEach(s->System.out.println(s));
    }

     */
    @PostConstruct
    public void setup(){
        System.out.println("PostConstruct " + bookRepository.getClass());
    }

}
