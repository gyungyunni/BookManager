package com.selfstudy.jpa.bookmanager.domain.listener;

import com.selfstudy.jpa.bookmanager.domain.User;
import com.selfstudy.jpa.bookmanager.domain.UserHistory;
import com.selfstudy.jpa.bookmanager.repository.UserHistoryRepository;
import com.selfstudy.jpa.bookmanager.support.BeanUtils;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;

public class UserEntityListener {

    @PostPersist
    @PostUpdate //user엔티티가 생성되고 수정될때마다 유저 히스토리에 동일한 데이터가 생기게 됨
    public void prePersistAndPreUpdate(Object o){
        UserHistoryRepository userHistoryRepository = BeanUtils.getBean(UserHistoryRepository.class);
        User user = (User) o;

        UserHistory userHistory = new UserHistory();

        userHistory.setName(user.getName());
        userHistory.setEmail(user.getEmail());
        userHistory.setUser(user);

        userHistoryRepository.save(userHistory);
    }
}
