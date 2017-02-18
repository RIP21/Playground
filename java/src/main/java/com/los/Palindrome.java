package com.los;

import java.util.stream.IntStream;

public class Palindrome {

    public boolean isPalindrome(String string) { // O(n/2)
        if (string == null) {
            return false;
        }
        int stringLength = string.length();
        int midIndex = stringLength / 2;
        return IntStream.range(0, midIndex).
                noneMatch(i -> string.charAt(i) != string.charAt(stringLength - i - 1));
    }
}
