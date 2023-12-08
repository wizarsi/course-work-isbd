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
public class FootballLeagueDto {
    private Long id;

    @NotEmpty(message = "Название лиги не должно быть пустым")
    private String name;

    @NotEmpty(message = "Страна не должна быть пустой")
    private String country;

    @Min(value = 0, message = "Количество матчей не может быть меньше нуля")
    private int count_matches;
}
