package com.awesome.typing1.domain.service.queryService;

import com.awesome.typing1.domain.dto.response.CustomResponseDTO;

public interface CustomQueryService {

    CustomResponseDTO.CustomPreviewListDTO previewCustoms(Long userId, int page);

}
