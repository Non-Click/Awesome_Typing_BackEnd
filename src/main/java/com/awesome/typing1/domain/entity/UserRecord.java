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
public class UserRecord extends BaseEntity {

    // 기록 아이디
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long record_id;

    // 유저 아이디
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // 텍스트 유형
    @Enumerated(EnumType.STRING)
    private TextType text_type;

    // 평균 wpm
    @Column(nullable = false)
    private int avg_wpm;

    // 평균 cpm
    @Column(nullable = false)
    private int avg_cpm;

    // 평균 정확도
    @Column(nullable = false)
    private int avg_accuracy;

    // 최대 wpm
    @Column(nullable = false)
    private int best_wpm;

    // 최대 cpm
    @Column(nullable = false)
    private int best_cpm;

    // 전체 타이핑 완료 글자 수
    @Column(nullable = false)
    private int total_character;

    // 전체 타이핑 완료 문장 수
    @Column(nullable = false)
    private int total_sentence;

    public void setUser(User user) {
        this.user = user;
    }

    public void update(int avg_wpm, int avg_cpm, int avg_accuracy, int best_wpm, int best_cpm, int total_character, int total_sentence) {
        this.avg_wpm = avg_wpm;
        this.avg_cpm = avg_cpm;
        this.avg_accuracy = avg_accuracy;
        this.best_wpm = best_wpm;
        this.best_cpm = best_cpm;
        this.total_character = total_character;
        this.total_sentence = total_sentence;
    }

}
