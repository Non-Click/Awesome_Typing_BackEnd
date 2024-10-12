package com.awesome.typing1.domain.entity;

import com.awesome.typing1.domain.entity.enums.TextLanguage;
import com.awesome.typing1.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Text extends BaseEntity {

    // 텍스트 아이디
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 언어
    @Enumerated(EnumType.STRING)
    private TextLanguage textLanguage;

    // 제목
    @Column(nullable = false)
    private String title;

    // 본문
    @Column(nullable = false)
    private String content;

    // 출처(저자)
    @Column(nullable = false)
    private String source;

}
