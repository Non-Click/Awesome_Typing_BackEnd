package com.awesome.typing1.domain.entity;

import com.awesome.typing1.domain.dto.request.CustomRequestDTO;
import com.awesome.typing1.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Custom extends BaseEntity {

    // 커스텀 텍스트 아이디
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long custom_id;

    // 유저 아이디
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // 제목
    @Column(nullable = false)
    private String custom_title;

    // 본문
    @Column(nullable = false)
    private String custom_content;

    // 출처(저자)
    @Column(nullable = false)
    private String custom_source;

    public void setUser(User user) {
        this.user = user;
    }

    public void update(CustomRequestDTO.UpdateCustomDTO updateCustomDTO) {
        this.custom_title = updateCustomDTO.getCustomTitle();
        this.custom_content = updateCustomDTO.getCustomContent();
        this.custom_source = updateCustomDTO.getCustomSource();
    }

}
