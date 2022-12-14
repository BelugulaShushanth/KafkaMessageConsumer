package com.messageConsumer.service.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "${spring.kafka.topic-name}", groupId = "${spring.kafka.group-id}")
    public void consumeMessage(String message){
        System.out.println("Message Received: "+message);
    }

}
