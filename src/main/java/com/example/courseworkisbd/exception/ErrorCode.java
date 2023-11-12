package com.example.courseworkisbd.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    BAD_REQUEST(1L, "Некорректные данные."),

    UNAUTHORIZED(2L, "Некорректный логин или пароль."),

    INTERNAL_SERVER_ERROR(3L, "Произошла ошибка сервера."),

    USER_NOT_FOUND(4L, "Пользователь не найден. Обратитесь к администратору."),

    NOT_FOUND(5L, "Не найдено.");

    private final Long code;

    private final String message;
}
