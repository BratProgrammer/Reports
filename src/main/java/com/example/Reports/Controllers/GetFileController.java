package com.example.Reports.Controllers;

import com.example.Reports.Models.DTO.Requests.GetRangeDateRequest;
import com.example.Reports.Models.DTO.Requests.GetReportRequest;
import com.example.Reports.Models.DTO.Requests.GetSingleDateRequest;
import com.example.Reports.Services.FileGenerateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reports_getter")
@RequiredArgsConstructor
public class GetFileController {

    private final FileGenerateService fileGenerateService;

    @GetMapping("/get_report_by_name")
    public ResponseEntity<String> getDayReport(@RequestBody GetReportRequest getReportRequest) {

        fileGenerateService.generateFileByName(getReportRequest.getFilename());

        return ResponseEntity.ok(getReportRequest.getFilename());
    }


    @GetMapping("/one_day_report")
    public ResponseEntity<String> getRangeReport(@RequestBody GetSingleDateRequest getSingleDateRequest) {

        fileGenerateService.generateFileByName(getSingleDateRequest.getReportDate().toString());

        return ResponseEntity.ok().build();
    }

    @GetMapping("/range_report")
    public ResponseEntity<String> getRangeReport(@RequestBody GetRangeDateRequest getRangeDateRequest) {

        fileGenerateService.generateFileByName(getRangeDateRequest.getStartDate().toString() + "_" + getRangeDateRequest.getEndDate().toString());

        return ResponseEntity.ok().build();
    }
}
