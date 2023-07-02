package com.example.kafkaproducer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${svc.kafka.topic.name}")
    private String topic;


    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("/produce")
    public String getKafkaProducer() {
        System.out.println("SendMessage kafka");
        for (int i = 0; i < 800; i++) {
            kafkaTemplate.send(topic, "message-" + i);
        }
        return "Completed";
    }


}