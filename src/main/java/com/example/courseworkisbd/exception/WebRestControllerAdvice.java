package com.example.courseworkisbd.exception;

import com.example.courseworkisbd.dto.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.*;

@Slf4j
@RestControllerAdvice
public class WebRestControllerAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler({BaseRuntimeException.class})
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Response handleBaseRuntimeException(BaseRuntimeException ex) {
        log.error("Common error", ex);
        return getErrorResponse(ex);
    }

    @ExceptionHandler({BaseBadRequestException.class})
    @ResponseStatus(BAD_REQUEST)
    @ResponseBody
    public Response handleBadeRequestException(BaseBadRequestException ex) {
        log.error("Common error", ex);
        return getErrorResponse(ex);
    }

    @ExceptionHandler({BaseNotFoundException.class})
    @ResponseStatus(NOT_FOUND)
    @ResponseBody
    public Response handleNotFoundException(BaseNotFoundException ex) {
        log.error("Common error", ex);
        return getErrorResponse(ex);
    }

    @ExceptionHandler({BaseUnauthorizedException.class})
    @ResponseStatus(UNAUTHORIZED)
    @ResponseBody
    public Response handleUnauthorizedException(BaseUnauthorizedException ex) {
        log.error("Common error", ex);
        return getErrorResponse(ex);
    }
    private Response getErrorResponse(BaseRuntimeException ex) {
        return Response.builder()
                .errCode(ex.getCode())
                .errDescription(ex.getDescription())
                .build();
    }
}

