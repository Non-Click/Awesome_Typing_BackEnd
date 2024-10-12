package com.awesome.typing1.domain.dto.request;

import lombok.Getter;

public class CustomRequestDTO {

    @Getter
    // 커스텀 텍스트 생성을 위해 전달되는 DTO
    public static class CreateCustomDTO {
        private String title;
        private String content;
        private String source;
    }

    @Getter
    // 커스텀 텍스트 업데이트를 위해 전달되는 DTO
    public static class UpdateCustomDTO {
        private String title; // 제목
        private String content; // 내용
        private String source; // 출처

    }
}
