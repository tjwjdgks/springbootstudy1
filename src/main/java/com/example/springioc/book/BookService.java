package com.example.springioc.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;

//의존성 주입을 받으려면 bean 이어야 한다
// 싱글톤을 만들고 싶을 때
// 라이프 사이클 인터페이스
// beanfactory 상속 받은 applicationContext 가장 많이 사용
@Service
public class BookService {


    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public Book save(Book book){
        book.setCreated(new Date());
        book.setBookStatus(BookStatus.DRAFT);
        return bookRepository.save(book);
    }
    @PostConstruct
    public void postConstruct(){
        System.out.println("==========>");
    }
}
