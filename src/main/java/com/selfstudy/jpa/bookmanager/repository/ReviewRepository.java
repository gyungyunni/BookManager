package com.selfstudy.jpa.bookmanager.repository;

import com.selfstudy.jpa.bookmanager.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
