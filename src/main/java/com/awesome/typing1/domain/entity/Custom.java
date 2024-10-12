package com.awesome.typing1.domain.entity;

import com.awesome.typing1.domain.dto.request.CustomRequestDTO;
import com.awesome.typing1.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Custom extends BaseEntity {

    // 커스텀 텍스트 아이디
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 유저 아이디
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // 제목
    @Column(nullable = false)
    private String title;

    // 본문
    @Column(nullable = false)
    private String content;

    // 출처(저자)
    @Column(nullable = false)
    private String source;

    // 삭제 여부
    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;

    // 삭제된 날짜
    @Column(name = "deleted_date")
    private LocalDate deletedDate;

    public void setUser(User user) {
        this.user = user;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public void setDeletedDate(LocalDate deletedDate) {
        this.deletedDate = deletedDate;
    }

    public void update(String title, String content, String source) {
        this.title = title;
        this.content = content;
        this.source = source;
    }

}
