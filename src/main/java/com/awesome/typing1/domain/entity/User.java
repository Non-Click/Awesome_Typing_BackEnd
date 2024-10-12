package com.awesome.typing1.domain.entity;

import com.awesome.typing1.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    // 유저 아이디
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 네이버 아이디
    @Column(name = "naver_id", nullable = false, length = 30)
    private String naverId;

    // 유저 이름
    @Column(nullable = false, length = 20)
    private String name;

    // 유저 상태
    @Column(nullable = false)
    private boolean status;

    // 탈퇴한 날짜
    @Column(name = "deleted_date")
    private LocalDate deletedDate;

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void updateName(String name) {
        this.name = name;
    }

}
