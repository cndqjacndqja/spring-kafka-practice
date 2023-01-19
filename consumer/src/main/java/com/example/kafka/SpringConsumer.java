package com.example.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;


@SpringBootApplication
public class SpringConsumer {

    public static void main(String[] args) {
        SpringApplication.run(SpringConsumer.class, args);
    }

    @KafkaListener(topics = "test",
            groupId = "test-group",
            containerFactory = "customContainerFactory")
    public void customListener(String data) {
        System.out.println("customListener" + data);
    }
}
