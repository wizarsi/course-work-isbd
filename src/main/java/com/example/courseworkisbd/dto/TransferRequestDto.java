package com.example.courseworkisbd.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransferRequestDto {
    @NotEmpty
    private String name;
    @NotEmpty
    private String surname;

    private String position;

    private int age;

    private String footballClub;

    private int value;

}
