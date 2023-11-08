package com.Aureus.calculator.dto;

import lombok.Data;

@Data
public class CalculatorRequest {

    private String operation;
    private double value1;
    private double value2;


}
