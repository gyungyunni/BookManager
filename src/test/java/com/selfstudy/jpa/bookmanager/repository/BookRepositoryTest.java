package com.selfstudy.jpa.bookmanager.repository;


import com.selfstudy.jpa.bookmanager.domain.Book;
import com.selfstudy.jpa.bookmanager.repository.dto.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;

    @Test
    void bookTest() {
        Book book = new Book();
        book.setName("JPA 킹왕짱 되기");
        book.setAuthor("김작가");
//        book.setPublisherId(1L);

        bookRepository.save(book);

        System.out.println(bookRepository.findAll());
    }
}
