package com.example.courseworkisbd.dto;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class Response {

    private final Long errCode;

    private final String errDescription;

}