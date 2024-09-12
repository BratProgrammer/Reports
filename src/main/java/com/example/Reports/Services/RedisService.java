package com.example.Reports.Services;

import com.example.Reports.Models.DTO.FileGeneratingDto;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class RedisService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @PostConstruct
    public void testRedisConnection() {
        try {
            redisTemplate.getConnectionFactory().getConnection().ping();
            System.out.println("Connected to Redis");
        } catch (Exception e) {
            System.err.println("Cannot connect to Redis: " + e.getMessage());
        }
    }


    public String saveRequestData(FileGeneratingDto fileGeneratingData) {
        var uuid = UUID.randomUUID().toString();
        redisTemplate.opsForValue().set(uuid, fileGeneratingData, 24, TimeUnit.HOURS); // Сохраняем строку с TTL 10 минут
        return uuid;
    }

    public FileGeneratingDto getRequestData(String uuid) {
        return (FileGeneratingDto) redisTemplate.opsForValue().get(uuid);
    }

    public void deleteRequestData(String uuid) {
        redisTemplate.delete(uuid);
    }

}
