package com.challenge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class RequestProducer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendRequest(String topic, String message) {
        kafkaTemplate.send(topic, message);
    }
}
