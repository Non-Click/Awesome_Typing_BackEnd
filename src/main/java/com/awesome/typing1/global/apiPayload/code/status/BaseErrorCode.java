package com.awesome.typing1.global.apiPayload.code.status;

import com.awesome.typing1.global.apiPayload.ApiResponse;
import org.springframework.http.HttpStatus;

public interface BaseErrorCode {

    HttpStatus getHttpStatus();

    String getCode();

    String getMessage();

    ApiResponse<Void> getErrorResponse();
}