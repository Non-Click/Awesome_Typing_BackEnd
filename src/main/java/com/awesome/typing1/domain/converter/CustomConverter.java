package com.awesome.typing1.domain.converter;

import com.awesome.typing1.domain.dto.request.CustomRequestDTO;
import com.awesome.typing1.domain.dto.response.CustomResponseDTO;
import com.awesome.typing1.domain.dto.response.PageResponse;
import com.awesome.typing1.domain.entity.Custom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

public class CustomConverter {

    public static Custom toCustom(CustomRequestDTO.CreateCustomDTO createCustomDTO) {

        return Custom.builder()
                .title(createCustomDTO.getTitle())
                .content(createCustomDTO.getContent())
                .source(createCustomDTO.getSource())
                .isDeleted(false)
                .build();
    }

    public static CustomResponseDTO.CreateCustomResultDTO toCreateCustomResultDTO(Custom custom) {

        return CustomResponseDTO.CreateCustomResultDTO.builder()
                .id(custom.getId())
                .userId(custom.getUser().getId())
                .title(custom.getTitle())
                .content(custom.getContent())
                .source(custom.getSource())
                .build();
    }

    public static CustomResponseDTO.CustomPreviewDTO toCustomPreviewDTO(Custom custom) {

        return CustomResponseDTO.CustomPreviewDTO.builder()
                .userId(custom.getUser().getId())
                .title(custom.getTitle())
                .source(custom.getSource())
                .createdAt(custom.getCreatedAt())
                .updatedAt(custom.getUpdatedAt())
                .build();
    }

    public static CustomResponseDTO.CustomPreviewListDTO toCustomPreviewListDTO(Page<Custom> customs) {

        // Page<Custom> 내의 각 Custom 에 대하여 CustomPreviewDTO 객체로 변환
        List<CustomResponseDTO.CustomPreviewDTO> customPreviewDTOs = customs.getContent().stream()
                .map(CustomConverter::toCustomPreviewDTO)
                .toList();

        // List<CustomResponseDTO.CustomPreviewDTO> 페이징 및 페이지응답으로 변환
        PageResponse<CustomResponseDTO.CustomPreviewDTO> customPageResponse = toCustomPageResponse(new PageImpl<>(customPreviewDTOs, customs.getPageable(), customs.getTotalElements()));

        return CustomResponseDTO.CustomPreviewListDTO.builder()
                .customPreviewDTOS(customPageResponse)
                .build();

    }

    public static <T> PageResponse<T> toCustomPageResponse(Page<T> customPreviewDTOs) {
        return new PageResponse<>(
                customPreviewDTOs.getContent(), // 현재 페이지의 데이터
                customPreviewDTOs.getNumber(), // 현재 페이지 번호
                customPreviewDTOs.getSize(), // 페이지 크기
                customPreviewDTOs.getTotalPages(), // 총 페이지 수
                customPreviewDTOs.getTotalElements() // 총 요소 수
        );
    }
}
