package com.example.kafka;


import org.springframework.kafka.core.KafkaProducerException;
import org.springframework.kafka.core.KafkaSendCallback;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class KafkaProducerController {

    private final KafkaTemplate<String, String> customKafkaTemplate;

    public KafkaProducerController(KafkaTemplate<String, String> customKafkaTemplate) {
        this.customKafkaTemplate = customKafkaTemplate;
    }

    @GetMapping("/producer/future")
    public void producerKey() {
        ListenableFuture<SendResult<String, String>> future = customKafkaTemplate.send("test-topic-name", "test");
        future.addCallback(new KafkaSendCallback<String, String>(){
            @Override
            public void onFailure(KafkaProducerException ex) {

            }

            @Override
            public void onSuccess(SendResult<String, String> result) {

            }
        });
    }
}
