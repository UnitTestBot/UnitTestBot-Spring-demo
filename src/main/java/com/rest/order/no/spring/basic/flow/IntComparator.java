package com.rest.order.no.spring.basic.flow;

public class IntComparator {

    /**
     * Trivial function to show UnitTestBot basic flow.
     *
     * What we expect from tests?
     * - two tests covering both execution branches
     * - meaningful variable names: x, y, expected
     * - test method names describing scenario under test
     * - display names in IDE runner are pretty too
     */
    public int max(int x, int y) {
        if (x > y) {
            return x;
        } else {
            return y;
        }
    }
}
