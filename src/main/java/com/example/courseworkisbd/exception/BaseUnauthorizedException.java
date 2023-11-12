package com.example.courseworkisbd.exception;

public class BaseUnauthorizedException extends BaseRuntimeException {
    public BaseUnauthorizedException(ErrorCode code) {
        super(code);
    }

    public BaseUnauthorizedException(ErrorCode code, String description) {
        super(code, description);
    }

    public BaseUnauthorizedException(ErrorCode code, String description, Throwable cause) {
        super(code, description, cause);
    }

    public BaseUnauthorizedException(){
        super(ErrorCode.UNAUTHORIZED);
    }
}
