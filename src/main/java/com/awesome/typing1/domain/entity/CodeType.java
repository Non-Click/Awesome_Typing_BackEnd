package com.awesome.typing1.domain.entity;

import com.awesome.typing1.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "code_type")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class CodeType extends BaseEntity {

    // 코드 텍스트 타입 아이디
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 코드 텍스트 타입
    @Column(nullable = false)
    private String name;

}
