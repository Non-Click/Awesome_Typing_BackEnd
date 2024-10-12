package com.awesome.typing1.domain.exception;

import com.awesome.typing1.global.apiPayload.ApiResponse;
import com.awesome.typing1.global.apiPayload.code.status.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum UserErrorCode implements BaseErrorCode {

    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "USER400", "유저를 찾을 수 없습니다.");

    private final HttpStatus httpsStatus;
    private final String code;
    private final String message;

    @Override
    public HttpStatus getHttpStatus() {
        return null;
    }

    @Override
    public ApiResponse<Void> getErrorResponse() {
        return ApiResponse.onFailure(code, message);
    }

}
