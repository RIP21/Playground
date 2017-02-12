package com.los;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*; // Spock is better! :D But dangerous since not @CompileStatic :(

class ComplementaryPairServiceTest {

    @Test
        // Tests suppose to be split to separate methods, or parametrized one to be more descriptive, you know.
    void findComplimentaryPairs() {
        assertEquals(6, ComplementaryPair.findComplementaryPairs(new int[]{1, 2, 3, 4, 5, 6, 0}, 6));
        assertEquals(0, ComplementaryPair.findComplementaryPairs(new int[]{}, 5));
        assertEquals(0, ComplementaryPair.findComplementaryPairs(new int[]{6, 5}, 5));
        assertEquals(2, ComplementaryPair.findComplementaryPairs(new int[]{3, 3}, 6));
        assertEquals(4, ComplementaryPair.findComplementaryPairs(new int[]{3, 3, 0}, 3));
        int[] arrRandom = new int[10000];
        for (int i = 0; i < 10000; i++) {
            arrRandom[i] = ThreadLocalRandom.current().nextInt(-150, 2000);
        }
        assertTrue(ComplementaryPair.findComplementaryPairs(arrRandom, 250) >= 0);
    }

}