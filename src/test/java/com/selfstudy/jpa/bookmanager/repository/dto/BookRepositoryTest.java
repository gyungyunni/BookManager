package com.selfstudy.jpa.bookmanager.repository.dto;


import com.selfstudy.jpa.bookmanager.domain.Book;
import com.selfstudy.jpa.bookmanager.domain.Publisher;
import com.selfstudy.jpa.bookmanager.domain.Review;
import com.selfstudy.jpa.bookmanager.domain.User;
import com.selfstudy.jpa.bookmanager.repository.BookRepository;
import com.selfstudy.jpa.bookmanager.repository.PublisherRepository;
import com.selfstudy.jpa.bookmanager.repository.ReviewRepository;
import com.selfstudy.jpa.bookmanager.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
public class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository; //relaton 관계를 다 보고싶어서 아래 다 추가해줌
    @Autowired
    private PublisherRepository publisherRepository;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    void bookTest() {
        Book book = new Book();
        book.setName("JPA 킹왕짱 되기");
        book.setAuthorId(1L);
//        book.setPublisherId(1L);

        bookRepository.save(book);

        System.out.println(bookRepository.findAll());
    }

    @Test
    @Transactional
    void bookRelationTest(){
        givenBookAndReview();

        User user = userRepository.findByEmail("martin@mutsa.com");

        System.out.println("Review: " + user.getReviews());
        System.out.println("Book: " + user.getReviews().get(0).getBook()); // 처음 정보만 가져옴
        System.out.println("Publisher: " + user.getReviews().get(0).getBook().getPublisher());
    }

    private void givenBookAndReview(){
        givenReview(givenUser(), givenBook(givenPublisher()));
    }
    private User givenUser(){
        return userRepository.findByEmail("martin@mutsa.com");
    }
    private void  givenReview(User user, Book book){
        Review review = new Review();
        review.setTitle("내 인생을 바꾼 책");
        review.setContent("너무너무 재미있고 즐거운 책이었어요.");
        review.setScore(5.0f);
        review.setUser(user);
        review.setBook(book);

        reviewRepository.save(review);
    }
    private  Book givenBook(Publisher publisher){
        Book book = new Book();
        book.setName("JPA 킹왕짱 되기");
        book.setPublisher(publisher);

        return bookRepository.save(book);
    }
    private Publisher givenPublisher(){
        Publisher publisher = new Publisher();
        publisher.setName("멋쟁이사자처럼");

        return publisherRepository.save(publisher);
    }
}
