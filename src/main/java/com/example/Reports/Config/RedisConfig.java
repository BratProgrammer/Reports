package com.example.Reports.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        var factory = new JedisConnectionFactory();
        factory.setHostName("redis");
        factory.setPort(6379);
        factory.setPassword("1234");
        return factory;
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);

        // Устанавливаем сериализацию ключей
        template.setKeySerializer(new StringRedisSerializer());

        // Устанавливаем сериализацию значений
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());

        return template;
    }
}
