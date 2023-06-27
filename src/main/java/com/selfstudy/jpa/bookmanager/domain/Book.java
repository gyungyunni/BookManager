package com.selfstudy.jpa.bookmanager.domain;

import com.selfstudy.jpa.bookmanager.domain.listener.Auditable;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
public class Book extends BaseEntity implements Auditable {
    @Id   //pk
    @GeneratedValue  // 생성해주는 값 사용. h2 db를 사용하기 때문에 디폴트인 auto 값에서 hibernate sequence를 사용함
    private Long id;

    private String name;

    private String author;

//    private LocalDateTime createdAt;
//
//    private LocalDateTime updatedAt;

//    @PrePersist
//    public void prePersist(){
//        this.createdAt = LocalDateTime.now();
//        this.updatedAt = LocalDateTime.now();
//    }
//
//    @PreUpdate
//    public void preUpdate(){
//
//        this.updatedAt = LocalDateTime.now();
//    }
}
