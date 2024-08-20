package com.awesome.typing1.domain.entity;

import com.awesome.typing1.domain.entity.enums.TextType;
import com.awesome.typing1.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class History extends BaseEntity {

    // 히스토리 아이디
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long history_id;

    // 유저 아이디
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // 텍스트 아이디
    @Column(nullable = false)
    private Long text_id;

    // 텍스트 유형
    @Enumerated(EnumType.STRING)
    private TextType text_type;

    // 제목
    @Column(nullable = false)
    private String history_title;

    // 정확도
    @Column(nullable = false)
    private int history_accuracy;

    // 타이핑 wpm
    @Column(nullable = false)
    private int history_wpm;

    // 타이핑 cpm
    @Column(nullable = false)
    private int history_cpm;

    public void setUser(User user) {
        this.user = user;
    }

}
