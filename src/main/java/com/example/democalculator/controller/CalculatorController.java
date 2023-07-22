package com.example.democalculator.controller;

import com.example.democalculator.classes.CalculateRequest;
import com.example.democalculator.classes.CalculateResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    @GetMapping("/greeting")
    public ResponseEntity<String> greeting(){
        return ResponseEntity.ok("Hello");
    }
    @PostMapping("/add")
    public ResponseEntity<CalculateResult> add(@RequestBody CalculateRequest request) {
        float result = request.getNum1() + request.getNum2();
        return ResponseEntity.ok(new CalculateResult(result));
    }

    @PostMapping("/subtract")
    public ResponseEntity<CalculateResult> subtract(@RequestBody CalculateRequest request) {
        float result = request.getNum1() - request.getNum2();
        return ResponseEntity.ok(new CalculateResult(result));
    }

    @PostMapping("/multiply")
    public ResponseEntity<CalculateResult> multiply(@RequestBody CalculateRequest request) {
        float result = request.getNum1() * request.getNum2();
        return ResponseEntity.ok(new CalculateResult(result));
    }

    @PostMapping("/divide")
    public ResponseEntity<?> divide(@RequestBody CalculateRequest request) {
        if (request.getNum2() == 0) {
            return ResponseEntity.badRequest().body("Error: Division by zero is not allowed.");
        }

        double result = (double) request.getNum1() / request.getNum2();
        return ResponseEntity.ok(new CalculateResult(result));
    }
}
