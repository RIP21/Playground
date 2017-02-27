package com.los.codility;

import java.util.HashMap;
import java.util.Map;

public class PermCheck {
    int isPermutated(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int item : array) {
                map.put(item, map.getOrDefault(item, 0) + 1);
                max = Math.max(max, item);
                if(max > array.length) {
                    return 0;
                }
        }
        for (int current : map.values()) {
            if (current > 1) {
                return 0;
            }
        }
        return 1;
    }
}
