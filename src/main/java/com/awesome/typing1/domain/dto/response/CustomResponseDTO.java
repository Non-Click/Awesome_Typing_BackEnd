package com.awesome.typing1.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

public class CustomResponseDTO {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    // 커스텀 텍스트 생성의 결과 (테스트 목적으로 사용, 실사용으로는 생성 후에 String 반환할 것 같아서 필요없을지도)
    public static class CreateCustomResultDTO {
        private Long id; // 커스텀 텍스트 아이디
        private Long userId; // 작성자 아이디
        private String title; // 제목
        private String content; // 내용
        private String source; // 출처(저자)
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class CustomPreviewDTO {
        private Long userId; // 데이터 확인 목적으로 추가, but 실제로는 필요없을 수 있기 때문에 제거할 수도
        private String title; // 제목
        private String source; // 출처(저자)
        private LocalDateTime createdAt; // 텍스트 작성일
        private LocalDateTime updatedAt; // 텍스트 수정일
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class CustomPreviewListDTO {
        private PageResponse<CustomPreviewDTO> customPreviewDTOS;
    }
}
