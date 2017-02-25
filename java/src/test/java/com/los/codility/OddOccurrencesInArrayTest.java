package com.los.codility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OddOccurrencesInArrayTest {
    @Test
    void getUnpaired() {
        //given
        OddOccurrencesInArray oddOccurrencesInArray = new OddOccurrencesInArray();
        //when
        int result1 = oddOccurrencesInArray.getUnpaired(new int[]{1,1,2,2,6,6,5});
        int result2 = oddOccurrencesInArray.getUnpaired(new int[]{2,1,2,5,6,6,5});
        int result3 = oddOccurrencesInArray.getUnpaired(new int[]{1,1,5,2,6,6,5});
        int result4 = oddOccurrencesInArray.getUnpaired(new int[]{});
        //then
        assertTrue(result1 == 5);
        assertTrue(result2 == 1);
        assertTrue(result3 == 2);
        assertTrue(result4 == 0);

    }

}