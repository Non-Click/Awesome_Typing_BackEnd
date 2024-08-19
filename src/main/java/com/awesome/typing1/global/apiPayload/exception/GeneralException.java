package com.awesome.typing1.global.apiPayload.exception;

import com.awesome.typing1.global.apiPayload.code.status.BaseErrorCode;
import lombok.Getter;

@Getter
public class GeneralException extends RuntimeException {

    private final BaseErrorCode errorCode;

    public GeneralException(BaseErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
