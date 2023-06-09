package com.example.kafkaexample.kafkademo;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig
{
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;
    @Bean
    KafkaAdmin admin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic javaguidesTopic(){
return TopicBuilder.name("javaguides").build();
}

    @Bean
    public NewTopic javaguidesjsonTopic(){
        return TopicBuilder.name("javaguides_json").build();
    }
}
