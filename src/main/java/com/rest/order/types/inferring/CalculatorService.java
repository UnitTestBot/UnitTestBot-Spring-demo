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
     * <ul>As <code>Calculator</code> is an interface, there are two possible actions:
     * <li>to mock its behavior</li>
     * <li>to use the implementation instead of the interface</li></ul>
     * The first approach is used in <code>CalculatorServiceNoConfigurationUnitTests</code>.
     * The second approach is used in <code>CalculatorServiceWithConfigurationUnitTests</code>.
     *
     * Note that UnitTestBot gets information about the relevant
     * interface implementation from the configuration provided by the user.
     */
    public long calcSquareSum(int a, int b) {
        return calculator.multiply(a, a) + calculator.multiply(b, b);
    }
}
