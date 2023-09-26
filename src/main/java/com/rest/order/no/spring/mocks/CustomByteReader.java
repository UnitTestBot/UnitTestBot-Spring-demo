package com.rest.order.no.spring.mocks;

public class CustomByteReader {
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