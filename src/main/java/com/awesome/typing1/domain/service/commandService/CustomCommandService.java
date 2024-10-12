package com.awesome.typing1.domain.service.commandService;

import com.awesome.typing1.domain.dto.request.CustomRequestDTO;
import com.awesome.typing1.domain.entity.Custom;

public interface CustomCommandService {

    Custom createCustom(Long userId, CustomRequestDTO.CreateCustomDTO createCustomDTO);

    void updateCustom(Long customId, CustomRequestDTO.UpdateCustomDTO updateCustomDTO);

    void deleteCustom(Long customId);

}
