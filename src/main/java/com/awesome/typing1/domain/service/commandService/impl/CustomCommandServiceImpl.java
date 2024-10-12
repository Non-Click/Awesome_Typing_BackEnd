package com.awesome.typing1.domain.service.commandService.impl;

import com.awesome.typing1.domain.converter.CustomConverter;
import com.awesome.typing1.domain.dto.request.CustomRequestDTO;
import com.awesome.typing1.domain.entity.Custom;
import com.awesome.typing1.domain.entity.User;
import com.awesome.typing1.domain.exception.CustomErrorCode;
import com.awesome.typing1.domain.exception.UserErrorCode;
import com.awesome.typing1.domain.exception.handler.CustomException;
import com.awesome.typing1.domain.exception.handler.UserException;
import com.awesome.typing1.domain.repository.CustomRepository;
import com.awesome.typing1.domain.repository.UserRepository;
import com.awesome.typing1.domain.service.commandService.CustomCommandService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomCommandServiceImpl implements CustomCommandService {

    private final CustomRepository customRepository;
    private final UserRepository userRepository;

    @Override
    // 커스텀 타이핑 텍스트를 생성
    public Custom createCustom(Long userId, CustomRequestDTO.CreateCustomDTO createCustomDTO) {

        Custom custom = CustomConverter.toCustom(createCustomDTO);
        User user = userRepository.findById(userId).orElseThrow(() -> new UserException(UserErrorCode.USER_NOT_FOUND));
        custom.setUser(user);

        return customRepository.save(custom);
    }

    @Override
    // 커스텀 타이핑 텍스트를 업데이트
    public void updateCustom(Long customId, CustomRequestDTO.UpdateCustomDTO updateCustomDTO) {

        Custom custom = customRepository.findById(customId).orElseThrow(() -> new CustomException(CustomErrorCode.CUSTOM_NOT_FOUND));
        custom.update(updateCustomDTO.getTitle(), updateCustomDTO.getContent(), updateCustomDTO.getSource());
    }

    @Override
    // 커스텀 타이핑 텍스트를 soft 삭제
    public void deleteCustom(Long customId) {

        Custom custom = customRepository.findById(customId).orElseThrow(() -> new CustomException(CustomErrorCode.CUSTOM_NOT_FOUND));
        custom.setIsDeleted(true);
        custom.setDeletedDate(LocalDate.now());
    }
}
