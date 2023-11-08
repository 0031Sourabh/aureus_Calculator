package com.Aureus.calculator.controller;

import com.Aureus.calculator.dto.CalculatorRequest;
import com.Aureus.calculator.dto.CalculatorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

     public static final Logger LOG = LoggerFactory.getLogger(CalculatorController.class);

    @PostMapping("/calculate")
    public ResponseEntity<CalculatorResponse> calculate(@RequestBody CalculatorRequest calculatorRequest) {
        Double result = 0D;
        String operation = calculatorRequest.getOperation();
        double value1 = calculatorRequest.getValue1();
        double value2 = calculatorRequest.getValue2();
        CalculatorResponse calculatorResponse = new CalculatorResponse();
        try {
            switch (operation) {
                case "add":
                    LOG.info("Addition operation");
                    result = value1 + value2;
                    break;
                case "subtract":
                    LOG.info("Subtraction opertion");
                    result = value1 - value2;
                    break;
                case "multiply":
                    LOG.info("Multipliction operation");
                    result = value1 * value2;
                    break;
                case "divide":
                    LOG.info("Devision opertaion");
                    if (value2 == 0 || value1 == 0) {
                        throw new IllegalArgumentException("Division by zero is not allowed");
                    }
                    if (value2 > value1) {
                        result = value2 / value1;
                    }
                    if (value1 > value2) {
                        result = value1 / value2;
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Invalid operation.Supported opertions: add, subtract, multiply, divide");
            }
            calculatorResponse.setResult(result);
            calculatorResponse.setStatus("Operation done successfully");
        } catch (Exception e) {
            e.printStackTrace();
            calculatorResponse.setStatus("Exception :: " + e.getMessage());
        }
        return ResponseEntity.ok(calculatorResponse);
    }


}
