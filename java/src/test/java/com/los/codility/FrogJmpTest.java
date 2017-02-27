package com.los.codility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FrogJmpTest {
    @Test
    void getMinJumpsNeeded() {
        FrogJmp fj = new FrogJmp();
        int result1 = fj.getMinJumpsNeeded(10, 85, 30);
        assertTrue(result1 == 3);
        int result2 = fj.getMinJumpsNeeded(85, 85, 30);
        assertTrue(result2 == 0);
        int result3 = fj.getMinJumpsNeeded(999999999, 1_000_000_000, 1);
        assertTrue(result3 == 1);
    }

}