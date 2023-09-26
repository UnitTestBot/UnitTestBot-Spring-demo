package com.rest.order.no.spring.basic.flow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class IntComparatorTests {
    ///region Test suites for executable com.rest.order.no.spring.basic.flow.IntComparator.max

    ///region SYMBOLIC EXECUTION: SUCCESSFUL EXECUTIONS for method max(int, int)

    /**
     * @utbot.classUnderTest {@link IntComparator}
     * @utbot.methodUnderTest {@link IntComparator#max(int, int)}
     * @utbot.executesCondition {@code (x > y): True}
     * @utbot.returnsFrom {@code return x;}
     */
    @Test
    @DisplayName("max: x > y : True -> return x")
    public void testMax_XGreaterThanY() {
        IntComparator intComparator = new IntComparator();

        int actual = intComparator.max(-1, -2);

        assertEquals(-1, actual);
    }

    /**
     * @utbot.classUnderTest {@link IntComparator}
     * @utbot.methodUnderTest {@link IntComparator#max(int, int)}
     * @utbot.executesCondition {@code (x > y): False}
     * @utbot.returnsFrom {@code return y;}
     */
    @Test
    @DisplayName("max: x > y : False -> return y")
    public void testMax_XLessOrEqualY() {
        IntComparator intComparator = new IntComparator();

        int actual = intComparator.max(-240, -240);

        assertEquals(-240, actual);
    }
    ///endregion

    ///endregion
}
