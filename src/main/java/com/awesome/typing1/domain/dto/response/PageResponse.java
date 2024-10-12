package com.awesome.typing1.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageResponse<T> {

    private List<T> content; // Page 내용(알맹이)
    private int currentPage; // 현재 페이지
    private int pageSize; // 한 페이지의 사이즈
    private int totalPages; // 전체 페이지 수(장 수)
    private long totalElements; // 전체 객체 개수(ex) Article 이 총 30개)

}
