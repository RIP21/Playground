package com.los;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PalindromeTest {
    @Test
    @DisplayName("Smoke test")
    void isPalindrome() {
        assertTrue(Palindrome.isPalindrome(""));
        assertTrue(Palindrome.isPalindrome("a"));
        assertTrue(Palindrome.isPalindrome("asa"));
        assertTrue(Palindrome.isPalindrome("assa"));
        assertTrue(Palindrome.isPalindrome("123321"));
        assertTrue(Palindrome.isPalindrome("sator arepo tenet opera rotas"));
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 1000000; i++) {
            sb.append("111111");
        }
        assertTrue(Palindrome.isPalindrome(sb.toString()));
    }

}