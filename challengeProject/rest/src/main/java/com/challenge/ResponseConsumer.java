package com.challenge;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@KafkaListener(topics = "calculator-response", groupId = "rest-module-group")
public class ResponseConsumer {
    
    private final Map<String, CompletableFuture<String>> pendingRequests = new ConcurrentHashMap<>();

    public void registerRequest(String correlationId, CompletableFuture<String> future) {
        pendingRequests.put(correlationId, future);
    }

    @KafkaHandler
    public void consumeResponse(String message) {
        String[] parts = message.split("\\|");
        String correlationId = parts[0];
        String result = parts[1];

        CompletableFuture<String> future = pendingRequests.remove(correlationId);
        if (future != null) {
            future.complete(result);
        }
    }
}
