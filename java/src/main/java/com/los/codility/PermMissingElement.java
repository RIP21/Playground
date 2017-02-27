package com.los.codility;

import java.util.stream.IntStream;

public class PermMissingElement {
    int findMissingElement(int[] array) {
        int length = array.length;
        if (length == 0 || length == 1 && array[0] == 2) {
            return 1;
        } else if (length == 1 && array[0] == 1){
            return 2;
        }
        int missingElement = IntStream.rangeClosed(1, length + 1).parallel().sum();
        for(int element: array){
            missingElement -= element;
        }
        return missingElement;
    }
}
