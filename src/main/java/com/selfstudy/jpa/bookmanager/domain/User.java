package com.selfstudy.jpa.bookmanager.domain;

import com.selfstudy.jpa.bookmanager.domain.listener.Auditable;
import com.selfstudy.jpa.bookmanager.domain.listener.UserEntityListener;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Builder
@Entity
@EntityListeners(value = { UserEntityListener.class })
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @OneToMany(fetch =  FetchType.EAGER)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    @ToString.Exclude
    private List<UserHistory> userHistories = new ArrayList<>(); //get.userhistory를 했을 떄 nullpointException이 발생하지 않도록
                                                                 //new ArrayList<>()로 기본 리스트 생성
    @OneToMany
    @JoinColumn(name = "user_id")  //중간 테이블 없애기
    @ToString.Exclude  // 순환참조 제거
    private List<Review> reviews = new ArrayList<>();  //null exception 방지

//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(name = "city", column = @Column(name = "home_city")),
//            @AttributeOverride(name = "district", column = @Column(name = "home_district")),
//            @AttributeOverride(name = "detail", column = @Column(name = "home_address_detail")),
//            @AttributeOverride(name = "zipCode", column = @Column(name = "home_zip_code"))
//    })
//    private Address homeAddress;
//
//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(name = "city", column = @Column(name = "company_city")),
//            @AttributeOverride(name = "district", column = @Column(name = "company_district")),
//            @AttributeOverride(name = "detail", column = @Column(name = "company_address_detail")),
//            @AttributeOverride(name = "zipCode", column = @Column(name = "company_zip_code"))
//    })
//    private Address companyAddress;
//
//

}