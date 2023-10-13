package com.rest.order.no.spring.error.suite;

import java.util.ArrayList;

public class ArrayListVerifier {
    /**
     * It seems that just one test is enough for 100% coverage.
     *
     * Actually, NPE can occur if <code>collection == null</code>.
     * Note that UnitTestBot generated failing test covering this scenario:
     * it is named <code>testCheckIfNotEmpty_ThrowNullPointerException</code>.
     */
    boolean checkIfNotEmpty(ArrayList<Integer> collection) {
        return collection.size() > 0;
    }
}
