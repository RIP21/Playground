package com.los.codility;

import java.util.Arrays;

public class CyclicRotation {

    int[] rotate(int[] array, int cycles) {
        if (array.length == cycles || array.length == 0) {
            return array;
        }
        cycles = cycles - (Math.floorDiv(cycles, array.length) * array.length);
        int rotationIndex = array.length - cycles;
        int[] result = sliceRightKeepingSize(array, rotationIndex);
        appendArrayTillIndex(result, array, cycles, rotationIndex);
        return result;
    }

    private int[] sliceRightKeepingSize(int[] array, int sliceFromIndex) {
        return Arrays.copyOf(Arrays.copyOfRange(array, sliceFromIndex, array.length), array.length);
    }

    private void appendArrayTillIndex(int[] recepientArray, int[] donorArray, int startIndexRecepient, int endIndexDonor) {
        for (int i = 0, j = startIndexRecepient; i < endIndexDonor; i++, j++) {
            recepientArray[j] = donorArray[i];
        }
    }
}
