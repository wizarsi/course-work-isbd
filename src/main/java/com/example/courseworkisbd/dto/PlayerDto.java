package com.example.courseworkisbd.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDto {
    @NotEmpty(message = "Имя не должно быть пустым")
    private String name;

    @NotEmpty(message = "Фамилия не должна быть пустой")
    private String surname;

    @Min(value = 0, message = "Возраст не может быть меньше нуля")
    private int age;

    private String position;

    private String playerStatistic;

    private String playerContract;

    private int rating;

    private String footballClub;
}
