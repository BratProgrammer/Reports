package com.example.Reports.Controllers;

import com.example.Reports.Services.FileGeneratorKafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("api/v1/reports_getter")
@RequiredArgsConstructor
public class GetFileController {

    private final FileGeneratorKafkaProducer fileGeneratorKafkaProducer;

    @GetMapping("/single_day_report/{file_name}")
    public ResponseEntity<String> getDayReport(@PathVariable("file_name") String fileName) {
        String fileURL = "";

        //TODO

        return ResponseEntity.ok(fileURL);
    }

    @GetMapping("/range_report/{file_name}")
    public ResponseEntity<String> getRangeReport(@PathVariable("file_name") String fileName) {
        String fileURL = "";
        String requestId = UUID.randomUUID().toString();

        fileGeneratorKafkaProducer.sendGenerateFileRequest(requestId, fileName);

        CompletableFuture<String> response = new CompletableFuture<String>();

        return ResponseEntity.ok(fileURL);
    }





}
