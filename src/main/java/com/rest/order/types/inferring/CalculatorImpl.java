package com.rest.order.types.inferring;

import org.springframework.stereotype.Service;

@Service
public class CalculatorImpl implements Calculator {

    public CalculatorImpl() {}

    @Override
    public long multiply(int a, int b) {
        return a * b;
    }
}
