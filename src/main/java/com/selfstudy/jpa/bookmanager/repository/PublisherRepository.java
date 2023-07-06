package com.selfstudy.jpa.bookmanager.repository;

import com.selfstudy.jpa.bookmanager.domain.Publisher;
import com.selfstudy.jpa.bookmanager.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
