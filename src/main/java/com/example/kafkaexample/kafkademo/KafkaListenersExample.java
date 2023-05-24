package com.example.kafkaexample.kafkademo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
class KafkaListenersExample {
    @Value("${spring.kafka.consumer.group-id}")
    private String groupId;
    Logger LOG = LoggerFactory.getLogger(KafkaListenersExample.class);

    @KafkaListener(topics = "javaguides", groupId = "myGroup")
    void listener(String data) {
        LOG.info(data);
    }

//    @KafkaListener(
//            topics = "javaguides",
//            groupId = "reflectoring-group-1")
//    void commonListenerForMultipleTopics(String message) {
//        LOG.info("MultipleTopicListener - {}", message);
//    }
}
