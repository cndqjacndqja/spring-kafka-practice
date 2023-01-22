package com.example.kafka;


import org.springframework.kafka.core.KafkaProducerException;
import org.springframework.kafka.core.KafkaSendCallback;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;


@RestController
public class KafkaProducerController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducerController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("/producer/future")
    public void producerKey() {
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send("test-topic-name", "test");
        future.addCallback(new KafkaSendCallback<String, String>() {
            @Override
            public void onFailure(KafkaProducerException ex) {

            }

            @Override
            public void onSuccess(SendResult<String, String> result) {

            }
        });
    }

    @GetMapping("/insert")
    public void insert() {
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send("hello2", null, "보낼 데이터" + LocalDateTime.now());
        future.addCallback(sCallback -> {
            long offset = sCallback.getRecordMetadata().offset();
            int partition = sCallback.getRecordMetadata().partition();
            System.out.println("partition: " + partition + " offset: " + offset);
        }, fCallback -> {
            System.out.println("error msg: " + fCallback.getMessage());
        });
    }
}
