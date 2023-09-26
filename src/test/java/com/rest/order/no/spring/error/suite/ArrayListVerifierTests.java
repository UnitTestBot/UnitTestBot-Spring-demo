package com.rest.order.no.spring.error.suite;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class ArrayListVerifierTests {
    ///region Test suites for executable com.rest.order.no.spring.error.suite.ArrayListVerifier.checkIfNotEmpty

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method checkIfNotEmpty(java.util.ArrayList)

    /**
     * @utbot.classUnderTest {@link ArrayListVerifier}
     * @utbot.methodUnderTest {@link ArrayListVerifier#checkIfNotEmpty(ArrayList)}
     * @utbot.returnsFrom {@code return collection.size() > 0;}
     */
    @Test
    @DisplayName("checkIfNotEmpty: return collection.size() > 0 : False -> return collection.size() > 0")
    public void testCheckIfNotEmpty_CollectionSizeLessOrEqualZero() {
        ArrayListVerifier arrayListVerifier = new ArrayListVerifier();
        ArrayList collection = new ArrayList();

        boolean actual = arrayListVerifier.checkIfNotEmpty(collection);

        assertFalse(actual);
    }

    /**
     * @utbot.classUnderTest {@link ArrayListVerifier}
     * @utbot.methodUnderTest {@link ArrayListVerifier#checkIfNotEmpty(ArrayList)}
     * @utbot.returnsFrom {@code return collection.size() > 0;}
     */
    @Test
    @DisplayName("checkIfNotEmpty: return collection.size() > 0 : True -> return collection.size() > 0")
    public void testCheckIfNotEmpty_CollectionSizeGreaterThanZero() {
        ArrayListVerifier arrayListVerifier = new ArrayListVerifier();
        ArrayList collection = new ArrayList();
        collection.add(null);
        collection.add(null);
        collection.add(null);

        boolean actual = arrayListVerifier.checkIfNotEmpty(collection);

        assertTrue(actual);
    }
    ///endregion

    ///region SYMBOLIC EXECUTION: ERROR SUITE for method checkIfNotEmpty(java.util.ArrayList)

    /**
     * @utbot.classUnderTest {@link ArrayListVerifier}
     * @utbot.methodUnderTest {@link ArrayListVerifier#checkIfNotEmpty(ArrayList)}
     * @utbot.invokes {@link ArrayList#size()}
     * @utbot.throwsException {@link NullPointerException} in: return collection.size() > 0;
     */
    @Test
    @DisplayName("checkIfNotEmpty: return collection.size() > 0 : True -> ThrowNullPointerException")
    public void testCheckIfNotEmpty_ThrowNullPointerException() {
        ArrayListVerifier arrayListVerifier = new ArrayListVerifier();
        
        /* This test fails because method [com.rest.order.no.spring.error.suite.ArrayListVerifier.checkIfNotEmpty] produces [java.lang.NullPointerException]
            com.rest.order.no.spring.error.suite.ArrayListVerifier.checkIfNotEmpty(ArrayListVerifier.java:7) */
        arrayListVerifier.checkIfNotEmpty(null);
    }
    ///endregion

    ///endregion
}
