package com.challenge;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@RequestMapping("/calculator")
public class CalculatorController {

    @Autowired
    private RequestProducer requestProducer;

    @Autowired
    private ResponseConsumer responseConsumer;

    public static void main(String[] args) {
		SpringApplication.run(CalculatorController.class, args);
	}

    @GetMapping("/addition")
    public ResponseEntity<String> addition(
            @RequestParam double a,
            @RequestParam double b,
            @RequestParam int precision) {
        try {
            String correlationId = UUID.randomUUID().toString();

            CompletableFuture<String> future = new CompletableFuture<>();
            responseConsumer.registerRequest(correlationId, future);

            requestProducer.sendRequest("calculator-request", 
            correlationId + "|addition," + a + "," + b + "," + precision);
            
            String result = future.get(5, TimeUnit.SECONDS);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing request");
        }
    }

    @GetMapping("/subtraction")
    public ResponseEntity<String> subtraction(
        @RequestParam double a,
        @RequestParam double b,
        @RequestParam int precision) {
    try {
        String correlationId = UUID.randomUUID().toString();

        CompletableFuture<String> future = new CompletableFuture<>();
        responseConsumer.registerRequest(correlationId, future);

        requestProducer.sendRequest("calculator-request", 
        correlationId + "|subtraction," + a + "," + b + "," + precision);
            
            String result = future.get(5, TimeUnit.SECONDS);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing request");
        }
    }

    @GetMapping("/multiplication")
    public ResponseEntity<String> multiplication(
        @RequestParam double a,
        @RequestParam double b,
        @RequestParam int precision) {
    try {
        String correlationId = UUID.randomUUID().toString();

        CompletableFuture<String> future = new CompletableFuture<>();
        responseConsumer.registerRequest(correlationId, future);

        requestProducer.sendRequest("calculator-request", 
        correlationId + "|multiplication," + a + "," + b + "," + precision);
            
            String result = future.get(5, TimeUnit.SECONDS);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing request");
        }
    }

    @GetMapping("/division")
    public ResponseEntity<String> division(
        @RequestParam double a,
        @RequestParam double b,
        @RequestParam int precision) {
    try {
        String correlationId = UUID.randomUUID().toString();

        CompletableFuture<String> future = new CompletableFuture<>();
        responseConsumer.registerRequest(correlationId, future);

        requestProducer.sendRequest("calculator-request", 
        correlationId + "|division," + a + "," + b + "," + precision);
            
            String result = future.get(5, TimeUnit.SECONDS);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing request");
        }
    }
}