package com.los.codility;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CyclicRotationTest {
    @Test
    void rotate() {
        //given
        CyclicRotation ar = new CyclicRotation();
        int[] input = new int[]{1,2,3,4,5,6,7};
        //when
        int[] result1 = ar.rotate(input, 5);
        int[] result2 = ar.rotate(input, 12);
        int[] result3 = ar.rotate(input, 7);
        int[] result4 = ar.rotate(input, 14);
        int[] result5 = ar.rotate(input, 0);
        int[] result6 = ar.rotate(new int[]{}, 1);
        //then
       assertTrue(Arrays.equals(result1, new int[]{3,4,5,6,7,1,2}));
       assertTrue(Arrays.equals(result2, new int[]{3,4,5,6,7,1,2}));
       assertTrue(Arrays.equals(result3, input));
       assertTrue(Arrays.equals(result4, input));
       assertTrue(Arrays.equals(result5 , input));
       assertTrue(Arrays.equals(result6 , new int[]{}));

    }

}