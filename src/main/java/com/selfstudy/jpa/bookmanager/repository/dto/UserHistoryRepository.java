package com.selfstudy.jpa.bookmanager.repository.dto;

import com.selfstudy.jpa.bookmanager.domain.UserHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserHistoryRepository extends JpaRepository<UserHistory, Long> {
}
