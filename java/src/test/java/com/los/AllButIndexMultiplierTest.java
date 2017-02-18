package com.los;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AllButIndexMultiplierTest {
    @Test
    void multiply() {
        //given
        int[] input = new int[]{3, 1, 6, 4};
        //when
        int[] actual = new AllButIndexMultiplier().multiply(input);
        //then
        int[] expected = new int[]{24, 72, 12, 18};
        for (int i = 0; i < expected.length; i++) {
            assertTrue(expected[i] == actual[i]);
        }
    }

}