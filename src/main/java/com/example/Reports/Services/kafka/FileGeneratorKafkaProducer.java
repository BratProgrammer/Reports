package com.example.Reports.Services.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileGeneratorKafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendGenerateFileRequest(String requestId, String fileName) {
        kafkaTemplate.send("create_file", requestId, fileName);
    }

}
