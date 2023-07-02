package com.example.kafkaproducer;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * @author shilpesh
 */
@Configuration
public class TopicCreation {
    @Value(value = "${svc.kafka.topic.name}")
    private String targetTopic;

    @Value("${svc.kafka.topic.rightsizing.name.partition.size}")
    private int partitionCountTopicSize;

    @Bean
    public NewTopic topicRzJobProcessorBuilder() {
        return TopicBuilder.name(targetTopic)
                .partitions(partitionCountTopicSize)
                .build();
    }


}
