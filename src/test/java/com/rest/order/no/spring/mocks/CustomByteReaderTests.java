package com.rest.order.no.spring.mocks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public final class CustomByteReaderTests {
    ///region Test suites for executable com.rest.order.no.spring.mocks.CustomByteReader.readBytes


    @Test
    public void testReadBytes1() {
        byte[] buffer = {Byte.MIN_VALUE};
        DataProvider dataProviderMock = mock(DataProvider.class);
        (when(dataProviderMock.nextByte())).thenReturn((byte) 0, (byte) -1);

        int actual = CustomByteReader.readBytes(buffer, dataProviderMock);

        assertEquals(1, actual);

        byte finalBuffer0 = buffer[0];

        assertEquals((byte) 0, finalBuffer0);
    }

    @Test
    public void testReadBytes2() {
        DataProvider dataProviderMock = mock(DataProvider.class);
        (when(dataProviderMock.nextByte())).thenReturn((byte) -1);

        int actual = CustomByteReader.readBytes(null, dataProviderMock);

        assertEquals(0, actual);
    }

    @Test
    public void testReadBytes3() {
        byte[] buffer = {};
        DataProvider dataProviderMock = mock(DataProvider.class);
        (when(dataProviderMock.nextByte())).thenReturn((byte) 0);
        
        /* This test fails because method [com.rest.order.no.spring.mocks.CustomByteReader.readBytes] produces [java.lang.ArrayIndexOutOfBoundsException: Index 0 out of bounds for length 0]
            com.rest.order.no.spring.mocks.CustomByteReader.readBytes(CustomByteReader.java:9) */
        CustomByteReader.readBytes(buffer, dataProviderMock);
    }

    @Test
    public void testReadBytes4() {
        DataProvider dataProviderMock = mock(DataProvider.class);
        (when(dataProviderMock.nextByte())).thenReturn((byte) 0);
        
        /* This test fails because method [com.rest.order.no.spring.mocks.CustomByteReader.readBytes] produces [java.lang.NullPointerException]
            com.rest.order.no.spring.mocks.CustomByteReader.readBytes(CustomByteReader.java:9) */
        CustomByteReader.readBytes(null, dataProviderMock);
    }

    @Test
    public void testReadBytes5() {
        /* This test fails because method [com.rest.order.no.spring.mocks.CustomByteReader.readBytes] produces [java.lang.NullPointerException]
            com.rest.order.no.spring.mocks.CustomByteReader.readBytes(CustomByteReader.java:8) */
        CustomByteReader.readBytes(null, null);
    }

    ///endregion
}
