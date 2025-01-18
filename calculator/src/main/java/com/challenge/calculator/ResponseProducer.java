package com.challenge.calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ResponseProducer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendResponse(String topic, String message) {
        kafkaTemplate.send(topic, message);
    }
}
