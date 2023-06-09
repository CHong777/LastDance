package com.example.lastdance.util;

import org.springframework.stereotype.Component;

@Component
public class CalculateTime {
    private long startTime;

    public CalculateTime() {
        startTime = System.currentTimeMillis();
    }

    public long getElapsedTime() {
        long endTime = System.currentTimeMillis();

        return endTime - startTime;
    }

    public long getNowTime() {
        return System.currentTimeMillis();
    }
}
