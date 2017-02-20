package com.los.codility;

public class CountBinaryGaps {
    public int getMaxBinaryGap(int number) {
        int result = 0;
        int currentMax = 0;
        char[] binaryString = Integer.toBinaryString(number).toCharArray();
        for (char gap: binaryString) {
            if (gap == '0') {
                currentMax++;
            } else if (currentMax >= result) {
                result = currentMax;
                currentMax = 0;
            } else {
                currentMax = 0;
            }
        }
        return result;
    }
}
