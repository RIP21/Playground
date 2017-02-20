package com.los.codility;

import com.los.codility.CountBinaryGaps;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountBinaryGapsTest {

    @Test
    void getMaxBinaryGap() {
        //given
        CountBinaryGaps cbg = new CountBinaryGaps();
        //when
        int result = cbg.getMaxBinaryGap(1041);
        int result1 = cbg.getMaxBinaryGap(561892);
        int result2 = cbg.getMaxBinaryGap(74901729);
        int result3 = cbg.getMaxBinaryGap(1376796946);
        int result4 = cbg.getMaxBinaryGap(5);
        //then
        assertTrue(result == 5);
        assertTrue(result1 == 3);
        assertTrue(result2 == 4);
        assertTrue(result3 == 5);
        assertTrue(result4 == 1);
    }

}