package com.Aureus.calculator.dto;

import lombok.Data;

@Data
public class CalculatorResponse {

    private Double result;
    private String status = "OK";

    public CalculatorResponse(Double result) {

        this.result = result;
    }



    public CalculatorResponse(){

    }

}
