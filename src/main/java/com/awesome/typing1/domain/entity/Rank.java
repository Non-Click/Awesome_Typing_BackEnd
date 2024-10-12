package com.awesome.typing1.domain.entity;

import com.awesome.typing1.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Rank extends BaseEntity {

    // 랭크 아이디
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 유저 아이디
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
