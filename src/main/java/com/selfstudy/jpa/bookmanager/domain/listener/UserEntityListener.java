package com.selfstudy.jpa.bookmanager.domain.listener;

import com.selfstudy.jpa.bookmanager.domain.User;
import com.selfstudy.jpa.bookmanager.domain.UserHistory;
import com.selfstudy.jpa.bookmanager.repository.dto.UserHistoryRepository;
import com.selfstudy.jpa.bookmanager.support.BeanUtils;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class UserEntityListener {

//    @Autowired // 스프링 빈으로 지정을 해야 이 어노테이션 가능(@Component)
//    UserHistoryRepository userHistoryRepository; // 저장을 위해
    @PrePersist
    @PreUpdate //user엔티티가 생성되고 수정될때마다 유저 히스토리에 동일한 데이터가 생기게 됨
    public void prePersistAndPreUpdate(Object o){
        UserHistoryRepository userHistoryRepository = BeanUtils.getBean(UserHistoryRepository.class);
        User user = (User) o;

        UserHistory userHistory = new UserHistory();
        userHistory.setUserId(user.getId());
        userHistory.setName(user.getName());
        userHistory.setEmail(user.getEmail());

        userHistoryRepository.save(userHistory);
    }
}
