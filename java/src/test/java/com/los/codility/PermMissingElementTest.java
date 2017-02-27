package com.los.codility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PermMissingElementTest {
    @Test
    void findMissingElement() {
        PermMissingElement pme = new PermMissingElement();
        int result1 = pme.findMissingElement(new int[]{1, 2, 3, 5});
        assertTrue(result1 == 4);
        int result2 = pme.findMissingElement(new int[]{1});
        assertTrue(result2 == 2);
        int result3 = pme.findMissingElement(new int[]{2});
        assertTrue(result3 == 1);
        int result4 = pme.findMissingElement(new int[]{});
        assertTrue(result4 == 1);
    }

}