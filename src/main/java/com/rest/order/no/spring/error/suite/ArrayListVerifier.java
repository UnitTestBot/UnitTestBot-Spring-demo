package com.rest.order.no.spring.error.suite;

import java.util.ArrayList;

public class ArrayListVerifier {
    boolean checkIfNotEmpty(ArrayList<Integer> collection) {
        return collection.size() > 0;
    }
}
