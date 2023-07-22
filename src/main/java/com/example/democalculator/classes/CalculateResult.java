package com.example.democalculator.classes;

import lombok.Data;

@Data
public class CalculateResult {
    private double result;
    public CalculateResult(double result) {
        this.result = result;
    }
}

