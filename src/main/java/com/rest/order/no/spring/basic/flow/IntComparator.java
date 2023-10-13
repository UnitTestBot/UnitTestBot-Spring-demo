package com.rest.order.no.spring.basic.flow;

public class IntComparator {

    /**
     * A trivial function to show the UnitTestBot basic flow.
     *
     * <ul>What do we expect from tests?
     * <li>two tests covering both execution branches</li>
     * <li>meaningful variable names: <code>x</code>, <code>y</code>, <code>expected</code></li>
     * <li>test method names describing scenario under test</li>
     * <li>display names in an IDE runner are pretty too</li></ul>
     */
    public int max(int x, int y) {
        if (x > y) {
            return x;
        } else {
            return y;
        }
    }
}
