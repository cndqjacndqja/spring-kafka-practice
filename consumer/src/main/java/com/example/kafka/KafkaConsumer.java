package com.example.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "hello2", groupId = "myGroup1")
    public void consume(final String message) {
        System.out.println("consumer message: " + message);
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("end of sleep");
    }
}
