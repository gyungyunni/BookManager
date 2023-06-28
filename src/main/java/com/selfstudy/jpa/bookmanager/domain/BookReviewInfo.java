package com.selfstudy.jpa.bookmanager.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BookReviewInfo extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    private Long boodkId;

    private float averageReviewScore;

    private int reviewCount; //null 을 허용할 것인지 아닌지에 따라 primitive 타입, reference 타입 쓰면됨
                             // 평점과 리뷰 수에 null을 허용할지에 따라서, 여기서는 기본값을 0으로 하기 위해 primitive 타입 씀
                             // Integer, Float 쓸거면 null 체크 안하면  nullpointException 에러나니 주의
}
