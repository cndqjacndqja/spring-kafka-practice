package com.example.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;


@SpringBootApplication
public class SpringConsumer {

    public static void main(String[] args) {
        SpringApplication.run(SpringConsumer.class, args);
    }
}
