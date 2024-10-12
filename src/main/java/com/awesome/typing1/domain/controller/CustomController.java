package com.awesome.typing1.domain.controller;

import com.awesome.typing1.domain.converter.CustomConverter;
import com.awesome.typing1.domain.dto.request.CustomRequestDTO;
import com.awesome.typing1.domain.dto.response.CustomResponseDTO;
import com.awesome.typing1.domain.entity.Custom;
import com.awesome.typing1.domain.service.commandService.CustomCommandService;
import com.awesome.typing1.domain.service.queryService.CustomQueryService;
import com.awesome.typing1.global.apiPayload.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CustomController {

    private final CustomCommandService customCommandService;
    private final CustomQueryService customQueryService;

    @PostMapping("/users/{userId}/customs/create")
    @Operation(summary = "커스텀 타이핑 텍스트를 생성하는 api")
    public ApiResponse<CustomResponseDTO.CreateCustomResultDTO> createCustom(
            @PathVariable Long userId,
            @RequestBody CustomRequestDTO.CreateCustomDTO createCustomDTO) {

        Custom custom = customCommandService.createCustom(userId, createCustomDTO);
        return ApiResponse.onSuccess(CustomConverter.toCreateCustomResultDTO(custom));
    }

    @PutMapping("/customs/{customId}")
    @Operation(summary = "커스텀 타이핑 텍스트를 업데이트하는 api")
    public ApiResponse<String> updateCustom(
            @PathVariable Long customId,
            @RequestBody CustomRequestDTO.UpdateCustomDTO updateCustomDTO) {

        customCommandService.updateCustom(customId, updateCustomDTO);
        return ApiResponse.onSuccess("커스텀 텍스트 업데이트에 성공하였습니다.");
    }

    @DeleteMapping("/customs/{customId}")
    @Operation(summary = "커스텀 타이핑 텍스트를 soft 삭제하는 api")
    public ApiResponse<String> deleteCustom(@PathVariable Long customId) {

        customCommandService.deleteCustom(customId);
        return ApiResponse.onSuccess("커스텀 텍스트 삭제에 성공하였습니다.");
    }

    @GetMapping("/users/{userId}/customs")
    @Operation(summary = "커스텀 타이핑 텍스트 리스트를 가져오는 api")
    public ApiResponse<CustomResponseDTO.CustomPreviewListDTO> previewCustoms(
            @PathVariable Long userId,
            @RequestParam(defaultValue = "0") int page) {

        return ApiResponse.onSuccess(customQueryService.previewCustoms(userId, page));
    }

}
