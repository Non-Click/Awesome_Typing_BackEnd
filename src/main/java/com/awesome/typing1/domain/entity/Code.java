package com.awesome.typing1.domain.entity;

import com.awesome.typing1.domain.entity.enums.CodeType;
import com.awesome.typing1.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Code extends BaseEntity {

    // 코드 텍스트 아이디
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code_id;

    // 코드 유형(언어)
    @Enumerated(EnumType.STRING)
    private CodeType code_type;

    // 제목
    @Column(nullable = false)
    private String code_title;

    // 본문
    @Column(nullable = false)
    private String code_content;

    // 출처(저자)
    @Column(nullable = false)
    private String code_source;
}
