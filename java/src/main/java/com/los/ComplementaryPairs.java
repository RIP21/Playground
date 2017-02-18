package com.los;


import java.util.HashMap;
import java.util.Map;

public class ComplementaryPairs {

    public int findComplementaryPairs(int[] array, int k) {
        Map<Integer, Integer> map = mapElementsOccurrences(array);
        return countPairs(array, k, map);
    }

    private Map<Integer, Integer> mapElementsOccurrences(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        int initialValue = 1;
        for (int element : array) {
            map.merge(element, initialValue, Integer::sum);
        }
        return map;
    }

    private int countPairs(int[] array, int k, Map<Integer, Integer> map) {
        int counter = 0;
        for (int element : array) {
            int valueToComplementPair = k - element;
            if (valueToComplementPair == element && map.get(element) >= 1) {
                counter += map.get(element) - 1;
            } else {
                counter += map.getOrDefault(valueToComplementPair, 0);
            }
        }
        return counter;
    }
}


