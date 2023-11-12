package com.example.courseworkisbd.exception;


public class BaseNotFoundException extends BaseRuntimeException {
    public BaseNotFoundException(ErrorCode code) {
        super(code);
    }

    public BaseNotFoundException(ErrorCode code, String description) {
        super(code, description);
    }

    public BaseNotFoundException(ErrorCode code, String description, Throwable cause) {
        super(code, description, cause);
    }
}
