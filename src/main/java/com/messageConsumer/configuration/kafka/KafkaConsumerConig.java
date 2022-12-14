package com.messageConsumer.configuration.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumerConig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrap_servers;
    @Value("${spring.kafka.key-deserializer}")
    private String key_deserializer;
    @Value("${spring.kafka.value-deserializer}")
    private String value_deserializer;

    @Bean
    public ConsumerFactory<String,String> getConsumerFactory(){
        Map<String,Object> properties = new HashMap();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrap_servers);
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,key_deserializer);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,value_deserializer);
        return new DefaultKafkaConsumerFactory<>(properties);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String,String> kafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String,String> kafkaListenerContainerFactory = new ConcurrentKafkaListenerContainerFactory();
        kafkaListenerContainerFactory.setConsumerFactory(getConsumerFactory());
        return kafkaListenerContainerFactory;
    }
}
