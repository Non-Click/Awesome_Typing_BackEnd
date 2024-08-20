package com.awesome.typing1.domain.entity;

import com.awesome.typing1.domain.entity.enums.UserStatus;
import com.awesome.typing1.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    // 유저 아이디
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    // 네이버 아이디
    @Column(nullable = false, length = 30)
    private String naver_id;

    // 유저 이름
    @Column(nullable = false, length = 20)
    private String name;

    // 유저 상태
    @Enumerated(EnumType.STRING)
    private UserStatus user_status;

    public void setUserStatus(UserStatus userStatus) {
        this.user_status = userStatus;
    }

    public void updateName(String name) {
        this.name = name;
    }
}
