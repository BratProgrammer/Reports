package com.example.Reports.Config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {
    @Bean
    public NewTopic createFileTopic() {
        return new NewTopic("create_file", 1, (short) 1);
    }

    @Bean
    public NewTopic readyFilesTopic() {
        return new NewTopic("file_ready", 1, (short) 1);
    }

    @Bean
    public NewTopic fileCreationFailedTopic() {
        return new NewTopic("file_creation_failed", 1, (short) 1);
    }

}
