package com.example.Reports.Controllers;

import com.example.Reports.Models.DTO.GetReportRequest;
import com.example.Reports.Services.FileGeneratorKafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/reports_getter")
@RequiredArgsConstructor
public class GetFileController {

    private final FileGeneratorKafkaProducer fileGeneratorKafkaProducer;

    private final RedisTemplate redisTemplate;

    @GetMapping("/get_report_by_name")
    public ResponseEntity<String> getDayReport(@RequestBody GetReportRequest getReportRequest) {
        String requestId = UUID.randomUUID().toString();



        fileGeneratorKafkaProducer.sendGenerateFileRequest(requestId, getReportRequest.getFilename());

        return ResponseEntity.ok(getReportRequest.getFilename());
    }

    @GetMapping("/range_report")
    public ResponseEntity<String> getRangeReport(@RequestBody GetReportRequest getReportRequest) {
        String requestId = UUID.randomUUID().toString();

        fileGeneratorKafkaProducer.sendGenerateFileRequest(requestId, getReportRequest.getFilename());

        return ResponseEntity.ok().build();
    }

}
