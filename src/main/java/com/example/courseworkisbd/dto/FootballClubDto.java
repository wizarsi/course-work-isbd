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
public class FootballClubDto {
    @NotEmpty(message = "Имя клуба не должно быть пустым")
    private String name;

    @NotEmpty(message = "Лига не должна быть пустой")
    private String league;

    @NotEmpty(message = "Имя тренера не должно быть пустым")
    private String coach;

    @Min(value = 0, message = "Количество выигранных матчей не может быть отрицательным")
    private int wonMatches;

    private int budget;

    private String currency;

    @Min(value = 0, message = "Количество игроков не может быть меньше нуля")
    private int playersCount = 0;

    private String sportDirector;

    @Override
    public String toString() {
        return "FootballClubDto{" +
                "name='" + name + '\'' +
                ", league='" + league + '\'' +
                ", coach='" + coach + '\'' +
                ", wonMatches=" + wonMatches +
                ", budget=" + budget +
                ", currency='" + currency + '\'' +
                ", playersCount=" + playersCount +
                ", sportDirector='" + sportDirector + '\'' +
                '}';
    }
}
