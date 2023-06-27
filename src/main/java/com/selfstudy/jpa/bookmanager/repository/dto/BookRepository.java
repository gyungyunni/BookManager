package com.selfstudy.jpa.bookmanager.repository.dto;

import com.selfstudy.jpa.bookmanager.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
