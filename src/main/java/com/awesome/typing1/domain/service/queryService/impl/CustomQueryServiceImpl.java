package com.awesome.typing1.domain.service.queryService.impl;

import com.awesome.typing1.domain.dto.response.CustomResponseDTO;
import com.awesome.typing1.domain.entity.Custom;
import com.awesome.typing1.domain.entity.User;
import com.awesome.typing1.domain.exception.UserErrorCode;
import com.awesome.typing1.domain.exception.handler.UserException;
import com.awesome.typing1.domain.repository.CustomRepository;
import com.awesome.typing1.domain.repository.UserRepository;
import com.awesome.typing1.domain.service.queryService.CustomQueryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static com.awesome.typing1.domain.converter.CustomConverter.toCustomPreviewListDTO;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomQueryServiceImpl implements CustomQueryService {

    private final CustomRepository customRepository;
    private final UserRepository userRepository;

    private static final int PAGE_SIZE = 20;

    @Override
    public CustomResponseDTO.CustomPreviewListDTO previewCustoms(Long userId, int page) {

        User user = userRepository.findById(userId).orElseThrow(() -> new UserException(UserErrorCode.USER_NOT_FOUND));

        Pageable pageable = PageRequest.of(page, PAGE_SIZE);
        Page<Custom> customs = customRepository.findActiveCustomsByUser(user, pageable);

        return toCustomPreviewListDTO(customs);
    }
}
