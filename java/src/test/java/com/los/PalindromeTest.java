package com.los;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PalindromeTest {
    @Test
    @DisplayName("Smoke test")
    void isPalindrome() {
        Palindrome palindromeService = new Palindrome();
        assertTrue(palindromeService.isPalindrome(""));
        assertTrue(palindromeService.isPalindrome("a"));
        assertTrue(palindromeService.isPalindrome("asa"));
        assertTrue(palindromeService.isPalindrome("assa"));
        assertTrue(palindromeService.isPalindrome("123321"));
        assertTrue(palindromeService.isPalindrome("sator arepo tenet opera rotas"));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000000; i++) {
            sb.append("111111");
        }
        assertTrue(palindromeService.isPalindrome(sb.toString()));
    }

}