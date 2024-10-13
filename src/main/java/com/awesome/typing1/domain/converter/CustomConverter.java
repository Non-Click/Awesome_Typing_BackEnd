package com.awesome.typing1.domain.converter;

import com.awesome.typing1.domain.dto.request.CustomRequestDTO;
import com.awesome.typing1.domain.dto.response.CustomResponseDTO;
import com.awesome.typing1.domain.dto.response.PageResponse;
import com.awesome.typing1.domain.entity.Custom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

public class CustomConverter {

    // 커스텀 텍스트 생성 시 사용
    public static Custom toCustom(CustomRequestDTO.CreateCustomDTO createCustomDTO) {

        return Custom.builder()
                .title(createCustomDTO.getTitle())
                .content(createCustomDTO.getContent())
                .source(createCustomDTO.getSource())
                .isDeleted(false)
                .build();
    }

    // 커스텀 텍스트 생성 후, 생성의 결과로 변환 시에 사용
    public static CustomResponseDTO.CreateCustomResultDTO toCreateCustomResultDTO(Custom custom) {

        return CustomResponseDTO.CreateCustomResultDTO.builder()
                .id(custom.getId())
                .userId(custom.getUser().getId())
                .title(custom.getTitle())
                .content(custom.getContent())
                .source(custom.getSource())
                .build();
    }

    // 커스텀 텍스트를 미리보기 DTO 로 변환 시에 사용
    public static CustomResponseDTO.CustomPreviewDTO toCustomPreviewDTO(Custom custom) {

        return CustomResponseDTO.CustomPreviewDTO.builder()
                .userId(custom.getUser().getId())
                .title(custom.getTitle())
                .source(custom.getSource())
                .createdAt(custom.getCreatedAt())
                .updatedAt(custom.getUpdatedAt())
                .build();
    }

    // 페이징된 커스텀 텍스트를, 페이징된 미리보기로 변환 시에 사용
    public static CustomResponseDTO.CustomPreviewListDTO toCustomPreviewListDTO(Page<Custom> customs) {

        // Page<Custom> 내의 각 Custom 에 대하여 CustomPreviewDTO 객체로 변환
        List<CustomResponseDTO.CustomPreviewDTO> customPreviewDTOs = customs.getContent().stream()
                .map(CustomConverter::toCustomPreviewDTO)
                .toList();

        // List<CustomResponseDTO.CustomPreviewDTO> 페이징 및 페이지응답으로 변환
        PageResponse<CustomResponseDTO.CustomPreviewDTO> customPreviewDTOPageResponse = toCustomPageResponse(new PageImpl<>(customPreviewDTOs));

        return CustomResponseDTO.CustomPreviewListDTO.builder()
                .customPreviewDTOs(customPreviewDTOPageResponse)
                .build();

    }

    // 커스텀 텍스트를 자세히보기 DTO 로 변환 시에 사용
    public static CustomResponseDTO.CustomViewDTO toCustomViewDTO(Custom custom) {

        return CustomResponseDTO.CustomViewDTO.builder()
                .id(custom.getId())
                .userId(custom.getUser().getId())
                .title(custom.getTitle())
                .content(custom.getContent())
                .source(custom.getSource())
                .build();
    }

    // 페이징된 커스텀 텍스트를, 페이징된 자세히보기로 변환 시에 사용
    public static CustomResponseDTO.CustomViewListDTO toCustomViewListDTO(Page<Custom> customs) {

        List<CustomResponseDTO.CustomViewDTO> customViewDTOs = customs.getContent().stream()
                .map(CustomConverter::toCustomViewDTO)
                .toList();

        PageResponse<CustomResponseDTO.CustomViewDTO> customViewDTOPageResponse = toCustomPageResponse(new PageImpl<>(customViewDTOs));

        return CustomResponseDTO.CustomViewListDTO.builder()
                .customViewDTOs(customViewDTOPageResponse)
                .build();
    }

    // Page<>를 페이지응답으로 변환
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
