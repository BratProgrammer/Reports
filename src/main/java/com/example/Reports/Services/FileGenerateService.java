package com.example.Reports.Services;

import com.example.Reports.Models.DTO.FileGeneratingDto;
import com.example.Reports.Security.userdetails.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileGenerateService {

    private final FileGeneratorKafkaProducer fileGeneratorKafkaProducer;

    private final RedisService redisService;


    public void generateFileByName(String filename) {
        String requestId = UUID.randomUUID().toString();

        redisService.saveRequestData(new FileGeneratingDto(
                requestId,
                ((UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername(),
                filename
        ));

        fileGeneratorKafkaProducer.sendGenerateFileRequest(requestId, filename);
    }






}
