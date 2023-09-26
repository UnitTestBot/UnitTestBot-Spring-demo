package com.rest.order.types.inferring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class CalculatorServiceWithConfigurationTests {
    ///region Test suites for executable com.rest.order.types.inferring.CalculatorService.calcSquareSum


    @Test
    public void testCalcSquareSum1() {
        CalculatorService calculatorService = new CalculatorService();
        CalculatorImpl calculator = new CalculatorImpl();
        calculatorService.calculator = calculator;

        long actual = calculatorService.calcSquareSum(1, -255);

        assertEquals(65026L, actual);
    }

    ///endregion
}
