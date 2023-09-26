package com.rest.order.types.inferring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public final class CalculatorServiceNoConfigurationTests {
    ///region Test suites for executable com.rest.order.types.inferring.CalculatorService.calcSquareSum


    @Test
    public void testCalcSquareSum1() {
        CalculatorService calculatorService = new CalculatorService();
        Calculator calculatorMock = mock(Calculator.class);
        (when(calculatorMock.multiply(anyInt(), anyInt()))).thenReturn(0L, 0L);
        calculatorService.calculator = calculatorMock;

        long actual = calculatorService.calcSquareSum(1, -255);

        assertEquals(0L, actual);
    }

    ///endregion
}
