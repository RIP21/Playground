package com.los;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class InTheFutureTest {
    @Test
    public void daysToOvertake() {
        InTheFuture itf = new InTheFuture();
        assertTrue(itf.daysToOvertake(3, 5, 1) == 1);
        assertTrue(itf.daysToOvertake(4, 5, 1) == 2);
        assertTrue(itf.daysToOvertake(5, 4, 1) == -1);
        assertTrue(itf.daysToOvertake(5, 6, 0) == 1);
        assertTrue(itf.daysToOvertake(5, 5, 0) == -1);
    }
}