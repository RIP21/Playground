package com.los.codility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MissingIntegerTest {
    @Test
    void findMinimumPositive() {
        MissingInteger fmp = new MissingInteger();
        int result1 = fmp.findMinPositive(new int[]{1, 3, 6, 4, 1, 2});
        assertTrue(result1 == 5);
        int result2 = fmp.findMinPositive(new int[]{-1, -3, -6, -4, -1, -2});
        assertTrue(result2 == 1);
    }

}