package com.example.Reports.Services;

import com.example.Reports.Models.DTO.FileGeneratingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class RedisService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public String saveRequestData(FileGeneratingDto fileGeneratingData) {
        String uuid = UUID.randomUUID().toString();
        redisTemplate.opsForValue().set(uuid, fileGeneratingData, 24, TimeUnit.HOURS); // Сохраняем строку с TTL 10 минут
        return uuid;
    }

    public FileGeneratingDto getSRequestData(String uuid) {
        return (FileGeneratingDto) redisTemplate.opsForValue().get(uuid);
    }

    public void deleteRequestData(String uuid) {
        redisTemplate.delete(uuid);
    }

}
