package com.los.codility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class LongestPasswordTest {
    @Test
    void longestPassword() {
        //given
        LongestPassword tlp = new LongestPassword();
        String input1 = "test 5 a0A pass007     ?xy1";
        String input2 = "";
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 101; i++) {
            sb.append("1aa");
        }
        String input3 = sb.append(" asdqwdqwefgwrg").toString();
        String input4 = "test 5 a0A pass007©©©©© ?xy1";
        //when
        int result1 = tlp.longestPassword(input1);
        int result2 = tlp.longestPassword(input2);
        int result3 = tlp.longestPassword(input3);
        int result4 = tlp.longestPassword(input4);
        //then
        assertTrue(result1 == 7);
        assertTrue(result2 == -1);
        assertTrue(result3 == 303);
        assertTrue(result4 == 3);
    }

}