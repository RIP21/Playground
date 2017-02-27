package com.los.codility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FloodDepthTest {
    @Test
    void getMaximumDepth() {
        //given
        int[] input1 = new int[]{1,3,2,1,2,1,5,3,3,4,2};
        int[] input2 = new int[]{1,0,2};
        int[] input3 = new int[]{1,0};
        int[] input4 = new int[]{};
        int[] input5 = new int[]{1,2,3};
        int[] input6 = new int[]{3,2,1};
        int[] input7 = new int[]{3, 1, 2};
        int[] input8 = new int[]{2, 1, 3};
        FloodDepth wf = new FloodDepth();
        //when
        int result1 = wf.getMaximumDepth(input1);
        int result2 = wf.getMaximumDepth(input2);
        int result3 = wf.getMaximumDepth(input3);
        int result4 = wf.getMaximumDepth(input4);
        int result5 = wf.getMaximumDepth(input5);
        int result6 = wf.getMaximumDepth(input6);
        int result7 = wf.getMaximumDepth(input7);
        int result8 = wf.getMaximumDepth(input8);
        //then
        assertTrue(result1 == 2);
        assertTrue(result2 == 1);
        assertTrue(result3 == 0);
        assertTrue(result4 == 0);
        assertTrue(result5 == 0);
        assertTrue(result6 == 0);
        assertTrue(result7 == 1);
        assertTrue(result8 == 1);
    }

}