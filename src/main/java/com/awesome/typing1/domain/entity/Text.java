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
    private Long text_id;

    // 언어
    @Enumerated(EnumType.STRING)
    private TextLanguage text_language;

    // 제목
    @Column(nullable = false)
    private String text_title;

    // 본문
    @Column(nullable = false)
    private String text_content;

    // 출처(저자)
    @Column(nullable = false)
    private String text_source;

}
