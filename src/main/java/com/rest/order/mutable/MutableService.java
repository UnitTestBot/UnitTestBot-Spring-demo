package com.rest.order.mutable;

import org.springframework.stereotype.Service;

@Service
public class MutableService {

    private int state = 0;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getAndSetToOne() {
        int res = state;
        state = 1;

        return res;
    }

    public int getAndSetToTwo() {
        int res = state;
        state = 2;

        return res;
    }

}