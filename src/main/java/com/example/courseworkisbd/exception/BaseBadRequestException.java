package com.example.courseworkisbd.exception;

public class BaseBadRequestException extends BaseRuntimeException {
    public BaseBadRequestException(ErrorCode code) {
        super(code);
    }

    public BaseBadRequestException(ErrorCode code, String description) {
        super(code, description);
    }

    public BaseBadRequestException(ErrorCode code, String description, Throwable cause) {
        super(code, description, cause);
    }
}
