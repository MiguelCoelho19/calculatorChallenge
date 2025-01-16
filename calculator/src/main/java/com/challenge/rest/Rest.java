package com.challenge.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.calculator.CalculatorApplication;

@RestController
@RequestMapping("/calculator")
public class Rest {

    @Autowired
    private CalculatorApplication calculatorService;
    
    @PostMapping("/sum")
    public ResponseEntity<String> sum(@RequestBody PayloadHandler payload) {
        return ResponseEntity.ok(calculatorService.sum(payload.getA(), payload.getB(), payload.getPrecision()));
    }

    @PostMapping("/subtraction")
    public ResponseEntity<String> subtraction(@RequestBody PayloadHandler payload) {
        return ResponseEntity.ok(calculatorService.subtraction(payload.getA(), payload.getB(), payload.getPrecision()));
    }

    @PostMapping("/multiplication")
    public ResponseEntity<String> multiplication(@RequestBody PayloadHandler payload) {
        return ResponseEntity.ok(calculatorService.multiplication(payload.getA(), payload.getB(), payload.getPrecision()));
    }

    @PostMapping("/division")
    public ResponseEntity<String> division(@RequestBody PayloadHandler payload) {
        return ResponseEntity.ok(calculatorService.division(payload.getA(), payload.getB(), payload.getPrecision()));
    }
}