package com.los.codility;

import java.util.stream.IntStream;

public class TapeEquilibrium {
    int split(int[] array) {
        int left = 0;
        int right = IntStream.of(array).parallel().sum();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length - 1; i++) {
            int current = array[i];
            left += current;
            right -= current;
            int diff = Math.abs(right - left);
            min = Math.min(min, diff);
        }
        return min;
    }
}
