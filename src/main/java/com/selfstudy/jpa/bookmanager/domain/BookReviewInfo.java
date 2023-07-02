package com.selfstudy.jpa.bookmanager.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BookReviewInfo extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    private Long boodkId; 지우고 엔티티 직접 참조하게
    @OneToOne(optional = false) //1대1로 연관관계 매핑, optional = false로 하면 반드시 존재하는 값이 됨. book은 절대 null을 허용하지 않겠다란 의미
                                                             //mappedBy = "bookReviewInfo" 를 하면 연관키를 해당 테이블에선 더이상 가지지 않음
    private Book book;

    private float averageReviewScore;

    private int reviewCount; //null 을 허용할 것인지 아닌지에 따라 primitive 타입, reference 타입 쓰면됨
                             // 평점과 리뷰 수에 null을 허용할지에 따라서, 여기서는 기본값을 0으로 하기 위해 primitive 타입 씀
                             // Integer, Float 쓸거면 null 체크 안하면  nullpointException 에러나니 주의
}
