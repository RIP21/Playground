package com.los.codility;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class MissingInteger {
    int findMinPositive(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        IntStream.of(array).
                filter(i -> i > 0).
                forEach(i -> map.put(i, map.getOrDefault(i, 1) + 1));
        return IntStream.range(1, Integer.MAX_VALUE).parallel().
                filter(i -> map.getOrDefault(i, -1) == -1).
                findFirst().
                orElse(1);
    }
}
