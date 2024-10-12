package com.awesome.typing1.domain.exception.handler;

import com.awesome.typing1.global.apiPayload.code.status.BaseErrorCode;
import com.awesome.typing1.global.apiPayload.exception.GeneralException;

public class UserException extends GeneralException {
    public UserException(BaseErrorCode baseErrorCode) {
        super(baseErrorCode);
    }
}
