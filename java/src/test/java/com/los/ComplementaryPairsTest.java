package com.los;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ComplementaryPairsTest {

    @Test
    @DisplayName("When array is empty should return 0")
    void test1() {
        assertTrue(0 == new ComplementaryPairs().findComplementaryPairs(new int[]{}, 5));
    }

    @Test
    @DisplayName("When array is empty and k is 0 should return 0")
    void test2() {
        assertTrue(0 == new ComplementaryPairs().findComplementaryPairs(new int[]{}, 0));
    }

    @Test
    @DisplayName("When array is [0, 0, 3] and k is 0 should return 2")
    void test3() {
        assertTrue(2 == new ComplementaryPairs().findComplementaryPairs(new int[]{0, 0}, 0));
        assertTrue(2 == new ComplementaryPairs().findComplementaryPairs(new int[]{3, 0, 0}, 0));
    }

    @Test
    @DisplayName("{1, 2, 3, 4, 5, 6, 0} array must return 6 when k 6")
    void test4() {
        assertTrue(6 == new ComplementaryPairs().findComplementaryPairs(new int[]{1, 2, 3, 4, 5, 6, 0}, 6));
    }

    @Test
    @DisplayName("When array have digits which are k - element == element must not multiply pairs for each of the appearance")
    void test5() {
        assertTrue(2 == new ComplementaryPairs().findComplementaryPairs(new int[]{3, 3}, 6));
    }

    @Test
    @DisplayName("Pairs like {3, 0} with k = 3 must be counted")
    void test6() {
        assertTrue(4 == new ComplementaryPairs().findComplementaryPairs(new int[]{3, 3, 0}, 3));
    }

    @Test
    @DisplayName("Pairs with negative numbers must be counted properly")
    void test7() {
        assertTrue(2 == new ComplementaryPairs().findComplementaryPairs(new int[]{-3, 3, 0}, 0));
        assertTrue(2 == new ComplementaryPairs().findComplementaryPairs(new int[]{-3, 6, 0}, 3));
    }

}