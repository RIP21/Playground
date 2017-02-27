package com.los.codility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TapeEquilibriumTest {
    @Test
    void split() {
        TapeEquilibrium ts = new TapeEquilibrium();
        int result1 = ts.split(new int[]{3, 1, 2, 4, 3});
        assertTrue(result1 == 1);
        int result2 = ts.split(new int[]{-1000, 1000});
        assertTrue(result2 == 2000);
        int result3 = ts.split(new int[]{-1000, 1000, 1000});
        assertTrue(result3 == 1000);
        int result4 = ts.split(new int[]{-10, -5, -3, -4, -5});
        assertTrue(result4 == 3);
    }

}