package com.los.codility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PermCheckTest {
    @Test
    void isPermutated() {
        PermCheck pc = new PermCheck();
        int nonPermutated = pc.isPermutated(new int[]{1, 3, 2, 4});
        assertTrue(nonPermutated == 1);
        int permutated = pc.isPermutated(new int[]{1, 3, 4});
        assertTrue(permutated == 0);

    }
}