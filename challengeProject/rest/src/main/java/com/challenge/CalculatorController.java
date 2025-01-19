package com.challenge;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    @Autowired
    private RequestProducer requestProducer;

    @Autowired
    private ResponseConsumer responseConsumer;

    @PostMapping("/addition")
    public ResponseEntity<String> addition(@RequestBody PayloadHandler payload) {
        try {
            String correlationId = UUID.randomUUID().toString();

            CompletableFuture<String> future = new CompletableFuture<>();
            responseConsumer.registerRequest(correlationId, future);

            requestProducer.sendRequest("calculator-request", correlationId + "|addition," + payload.toString());
            
            String result = future.get(5, TimeUnit.SECONDS);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing request");
        }
    }

    @PostMapping("/subtraction")
    public ResponseEntity<String> subtraction(@RequestBody PayloadHandler payload) {
        try {
            String correlationId = UUID.randomUUID().toString();

            CompletableFuture<String> future = new CompletableFuture<>();
            responseConsumer.registerRequest(correlationId, future);

            requestProducer.sendRequest("calculator-request", correlationId + "|subtraction," + payload.toString());
            
            String result = future.get(5, TimeUnit.SECONDS);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing request");
        }
    }

    @PostMapping("/multiplication")
    public ResponseEntity<String> multiplication(@RequestBody PayloadHandler payload) {
        try {
            String correlationId = UUID.randomUUID().toString();

            CompletableFuture<String> future = new CompletableFuture<>();
            responseConsumer.registerRequest(correlationId, future);

            requestProducer.sendRequest("calculator-request", correlationId + "|multiplication," + payload.toString());
            
            String result = future.get(5, TimeUnit.SECONDS);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing request");
        }
    }

    @PostMapping("/division")
    public ResponseEntity<String> division(@RequestBody PayloadHandler payload) {
        try {
            String correlationId = UUID.randomUUID().toString();

            CompletableFuture<String> future = new CompletableFuture<>();
            responseConsumer.registerRequest(correlationId, future);

            requestProducer.sendRequest("calculator-request", correlationId + "|division," + payload.toString());
            
            String result = future.get(5, TimeUnit.SECONDS);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing request");
        }
    }
}