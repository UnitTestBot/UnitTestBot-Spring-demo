package com.rest.order.no.spring.mutable;

import com.rest.order.no.spring.mutable.MutableService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class MutableServiceTests {
    @Test
    @DisplayName("getAndSetToOne: -> return res")
    public void testGetAndSetToOne_ReturnRes() {
        MutableService mutableService = new MutableService();
        mutableService.setState(-255);

        int actual = mutableService.getAndSetToOne();
        assertEquals(-255, actual);

        int finalMutableServiceState = mutableService.getState();
        assertEquals(1, finalMutableServiceState);
    }

    @Test
    @DisplayName("getAndSetToTwo: -> return res")
    public void testGetAndSetToTwo_ReturnRes()  {
        MutableService mutableService = new MutableService();
        mutableService.setState(-255);

        int actual = mutableService.getAndSetToTwo();

        assertEquals(-255, actual);

        int finalMutableServiceState = mutableService.getState();
        assertEquals(2, finalMutableServiceState);
    }
}
