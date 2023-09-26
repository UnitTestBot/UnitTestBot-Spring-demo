package com.rest.order.types.inferring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    @Autowired
    public Calculator calculator;

    public long calcSquareSum(int a, int b) {
        return calculator.multiply(a, a) + calculator.multiply(b, b);
    }
}
