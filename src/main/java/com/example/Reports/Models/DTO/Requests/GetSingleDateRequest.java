package com.example.Reports.Models.DTO.Requests;

import lombok.Data;

import java.time.LocalDate;

@Data
public class GetSingleDateRequest {

    private LocalDate reportDate;

}
