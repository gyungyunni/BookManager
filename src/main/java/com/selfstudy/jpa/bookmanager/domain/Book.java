package com.selfstudy.jpa.bookmanager.domain;

import com.selfstudy.jpa.bookmanager.domain.listener.Auditable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Book extends BaseEntity {
    @Id   //pk
    @GeneratedValue  // 생성해주는 값 사용. h2 db를 사용하기 때문에 디폴트인 auto 값에서 hibernate sequence를 사용함
    private Long id;

    private String name;

    private String category;

    private Long authorId;

    private Long publisherId;

}
