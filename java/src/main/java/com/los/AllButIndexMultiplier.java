package com.los;

public class AllButIndexMultiplier {

    public int[] multiply(int[] input) {
        int[] result = new int[input.length];
        int product = 1;
        for (int anInput : input) {
            product *= anInput;
        }
        for (int i = 0; i < input.length; i++) {
            result[i] = product / input[i];
        }
        return result;
    }
}
