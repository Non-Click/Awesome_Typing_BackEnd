package com.awesome.typing1.domain.dto.request;

import lombok.Getter;

public class CustomRequestDTO {

    @Getter
    public static class UpdateCustomDTO { // 커스텀 텍스트 업데이트를 위해 전달되는 DTO
        private String customTitle; // 제목
        private String customContent; // 내용
        private String customSource; // 출처

    }
}
