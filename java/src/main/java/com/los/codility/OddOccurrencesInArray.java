package com.los.codility;

import java.util.LinkedHashMap;
import java.util.Map;

public class OddOccurrencesInArray {
    int getUnpaired(int [] array) {

        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int element : array) {
                map.put(element, map.getOrDefault(element, 0) + 1);
        }
        for (int key : map.keySet()) {
            if(map.get(key)%2 == 1) {
                return key;
            }
        }
        return 0;
    }
}
