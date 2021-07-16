package com.example.springioc.book;

import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
// 프로파일 방법
@Profile("test") // @Profile("!prod")  // prod가 아닐때 bean으로 등록 프로파일 표현식 !(not) &(and) |(or)
public class TestBookRepostiory implements BookRepository {
}
