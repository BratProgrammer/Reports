package com.example.Reports.Models.DTO.Requests;

import lombok.Data;
import java.time.LocalDate;

@Data
public class GetRangeDateRequest {

    private LocalDate startDate;

    private LocalDate endDate;

}
