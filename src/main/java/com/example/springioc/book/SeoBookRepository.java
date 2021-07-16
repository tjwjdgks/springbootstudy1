package com.example.springioc.book;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

// 주요한 repository autowired 때 우선
@Repository // @Primary
public class SeoBookRepository implements BookRepository {

}
