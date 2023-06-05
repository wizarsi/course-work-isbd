package com.example.courseworkisbd.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.Currency;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FootballClubDto {
    @NotEmpty
    private String name;
    @NotEmpty
    private String league;
    @NotEmpty
    private String coach;

    private int wonMatches;

    private int budget;

    private String currency;

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
