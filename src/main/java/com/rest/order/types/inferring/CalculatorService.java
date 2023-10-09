package com.rest.order.types.inferring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    @Autowired
    public Calculator calculator;

    /**
     * This is an example demonstrating Spring-specific unit testing.
     *
     * As `Calculator` is an interface, there are two possible actions:
     * - to mock its behaviour
     * - to use the implementation instead of the interface
     * First approach is used in `CalculatorServiceNoConfigurationUnitTests`.
     * Second approach is used in `CalculatorServiceWithConfigurationUnitTests`.
     *
     * Note that UnitTestBot gets the information about the relevant
     * interface implementation from the configuration provided by the user.
     */
    public long calcSquareSum(int a, int b) {
        return calculator.multiply(a, a) + calculator.multiply(b, b);
    }
}
