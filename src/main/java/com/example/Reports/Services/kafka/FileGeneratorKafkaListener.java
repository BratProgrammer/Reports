package com.example.Reports.Services.kafka;

import com.example.Reports.Models.DTO.FileGeneratingDto;
import com.example.Reports.Services.NotificationService;
import com.example.Reports.Services.RedisService;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileGeneratorKafkaListener {

    private final RedisService redisService;

    private final NotificationService notificationService;

    @KafkaListener(topics = "file_ready", groupId = "reports-group")
    private void fileCreatedListener(ConsumerRecord<String, String> record) {
        String uuid = record.key();

        FileGeneratingDto requestData = redisService.getRequestData(uuid);

        redisService.deleteRequestData(uuid);

        notificationService.sendFileCreatedNotification(requestData.getUsername(), record.value());
    }

    @KafkaListener(topics = "file_creation_failed", groupId = "reports-group")
    private void fileCreationFailedListener(ConsumerRecord<String, String> record) {
        String uuid = record.key();

        FileGeneratingDto requestData = redisService.getRequestData(uuid);

        redisService.deleteRequestData(uuid);

        notificationService.sendFileCreationFailedNotification(requestData.getUsername(), record.value());
    }


}
