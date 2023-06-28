package com.selfstudy.jpa.bookmanager.repository.dto;

import com.selfstudy.jpa.bookmanager.domain.Book;
import com.selfstudy.jpa.bookmanager.domain.BookReviewInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class BookReviewInfoRepositoryTest {
    @Autowired
    private BookReviewInfoRepository bookReviewInfoRepository;
    @Autowired
    private BookRepository bookRepository;

    @Test
    void crudTest() {
        BookReviewInfo bookReviewInfo = new BookReviewInfo();
        bookReviewInfo.setBoodkId(1L);
        bookReviewInfo.setAverageReviewScore(4.5f);
        bookReviewInfo.setReviewCount(2);

        bookReviewInfoRepository.save(bookReviewInfo);

        System.out.println(">>> " + bookReviewInfoRepository.findAll());
    }
    @Test
    void crudTest2() {
        Book book = new Book();
        book.setName("Jpa 킹왕짱 되기");
        book.setAuthorId(1L);
        book.setPublisherId(1L);

        bookRepository.save(book);

        System.out.println(">>> " + bookRepository.findAll());

        BookReviewInfo bookReviewInfo = new BookReviewInfo();
        bookReviewInfo.setBoodkId(1L);
        bookReviewInfo.setAverageReviewScore(4.5f);
        bookReviewInfo.setReviewCount(2);

        bookReviewInfoRepository.save(bookReviewInfo);
        System.out.println(">>> " + bookReviewInfoRepository.findAll());

        Book result = bookRepository.findById(
                bookReviewInfoRepository
                .findById(1L)
                .orElseThrow(RuntimeException::new)
                .getBoodkId()
        ).orElseThrow(RuntimeException::new);

        System.out.println(">>> " + result);
//        givenBookReviewInfo();
//
//        Book result = bookReviewInfoRepository
//                .findById(1L)
//                .orElseThrow(RuntimeException::new)
//                .getBook();
//
//        System.out.println(">>> " + result);
//
//        BookReviewInfo result2 = bookRepository
//                .findById(7L)
//                .orElseThrow(RuntimeException::new)
//                .getBookReviewInfo();
//
//        System.out.println(">>> " + result2);
    }
//    private Book givenBook() {
//        Book book = new Book();
//        book.setName("Jpa 초격차 패키지");
//        book.setAuthorId(1L);
////        book.setPublisherId(1L);
//
//        return bookRepository.save(book);
//    }
//    private void givenBookReviewInfo() {
//        BookReviewInfo bookReviewInfo = new BookReviewInfo();
//        bookReviewInfo.setBook(givenBook());
//        bookReviewInfo.setAverageReviewScore(4.5f);
//        bookReviewInfo.setReviewCount(2);
//
//        bookReviewInfoRepository.save(bookReviewInfo);
//
//        System.out.println(">>> " + bookReviewInfoRepository.findAll());
//    }
}