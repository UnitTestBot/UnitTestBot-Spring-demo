package com.rest.order.no.spring.error.suite;

import java.util.ArrayList;

public class ArrayListVerifier {
    /**
     * It seems that just one test will be enough for 100% coverage.
     *
     * Actually, NPE can occur if `collection == null`.
     * Note that UnitTestBot generated failing test covering this scenario:
     * it is named `testCheckIfNotEmpty_ThrowNullPointerException`.
     */
    boolean checkIfNotEmpty(ArrayList<Integer> collection) {
        return collection.size() > 0;
    }
}
