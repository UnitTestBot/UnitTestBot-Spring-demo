package com.rest.order.no.spring.mocks;

public class CustomByteReader {
    /**
     * This example demonstrates how UnitTestBot processes the external calls.
     * As far as no implementation is given, UnitTestBot uses mocking.
     *
     * Note that there are three ways to get an exception from this method.
     * They are not so obvious if we look at the implementation, but UnitTestBot
     * generates tests to cover each problematic scenario.
     */
    public static int readBytes(byte[] buffer, DataProvider dataProvider) {
        int bytesCount = 0;

        byte c;
        while ((c = dataProvider.nextByte()) != -1) {
            buffer[bytesCount] = c;
            bytesCount++;
        }

        return bytesCount;
    }
}

abstract class DataProvider {
    public abstract byte nextByte();
}