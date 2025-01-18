package com.challenge.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@KafkaListener(topics = "calculator-request", groupId = "calculator-group")
public class RequestConsumer {
    @Autowired
    private CalculatorService calculatorService;
    @Autowired
    private ResponseProducer responseProducer;

    @KafkaHandler
    public void consumeRequest(String request) {
        String[] message = request.split("\\|");
        String correlationId = message[0];
        String result = calculatorService.calculate(message[1]);
        responseProducer.sendResponse("calculator-response", correlationId + "|" + result);
    }
}
