package com.los.codility;

public class FloodDepth {

    public int getMaximumDepth(int[] A) {
        int highestIdx = 0;
        int lowestIdx = 0;
        int max = 0;

        for (int i = 1; i < A.length; i++) {
            int current = A[i];
            int highest = A[highestIdx];
            int lowest = A[lowestIdx];
            if (current > highest) {
                max = Math.max(highest - lowest, max);
                highestIdx = i;
                lowestIdx = highestIdx;
            } else if (current > lowest) {
                max = Math.max(current - lowest, max);
            } else if (current < lowest) {
                lowestIdx = i;
            }
        }
        return max;
    }
}
