package com.selfstudy.jpa.bookmanager.domain;


import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import com.selfstudy.jpa.bookmanager.domain.listener.Auditable;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@MappedSuperclass  // 해당 클래스의 필드를 상속받는 엔티티의 컬럼으로 포함시켜줌.

@EntityListeners(value = AuditingEntityListener.class)
public class BaseEntity implements Auditable {
    @CreatedDate
    @Column(columnDefinition = "datetime(6) default now(6) comment '생성시간'", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(columnDefinition = "datetime(6) default now(6) comment '수정시간'", nullable = false)
    private LocalDateTime updatedAt;
}