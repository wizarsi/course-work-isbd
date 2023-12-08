package com.example.courseworkisbd.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SportDirectorDto {
    @NotEmpty(message = "Имя не должно быть пустым")
    private String firstName;

    @NotEmpty(message = "Фамилия не должна быть пустой")
    private String lastName;

    @NotEmpty(message = "Email не должен быть пустым")
    @Email(message = "Неверный формат email")
    private String email;

    @NotEmpty(message = "Пароль не должен быть пустым")
    private String password;
}
