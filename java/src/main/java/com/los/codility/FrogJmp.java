package com.los.codility;

public class FrogJmp {
    int getMinJumpsNeeded(int startPoint, int destinationPoint, int jumpDistance) {
        return (int) Math.ceil((double)(destinationPoint - startPoint) / jumpDistance);
    }
}
