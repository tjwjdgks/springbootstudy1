package com.example.springioc.book;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class BookServiceTest {
    @Mock
    BookRepository bookRepository;
    @Test
    public void save(){
        Book book = new Book();
        when(bookRepository.save(book)).thenReturn(book);
        BookService bookService = new BookService(bookRepository);
        Book newbook = bookService.save(book);
        assertNotNull(newbook);
    }
}