package com.los.codility;
import java.util.function.BiFunction;
import java.util.function.Function;

public class FloodDepth {

    public int getMaximumDepth(int[] surface) {
        if(surface.length <= 2) {
            return 0;
        }
        return Math.max(findDeepestSegment(surface, false), findDeepestSegment(surface, true));
    }

    private int findDeepestSegment(int[] surface, boolean reversed) {
        Function<Integer, Integer> operation = i -> i + 1;
        BiFunction<Integer, Integer, Boolean> checkFloodable = (i, segmentStartIndex) -> i - segmentStartIndex > 1;
        int arrayLength = surface.length;
        int highestSegmentHeight = surface[0];
        int deepestInSegment = surface[0];
        int maximumDepth = 0;
        int lastArrayIndex = arrayLength - 1;
        if (reversed) {
            highestSegmentHeight = surface[lastArrayIndex];
            deepestInSegment = surface[lastArrayIndex];
            operation = i -> i - 1;
            checkFloodable = (i, segmentStartIndex) -> segmentStartIndex - i > 1;
        }
        int segmentStartIndex = reversed ? lastArrayIndex : 0;
        int i = reversed ? lastArrayIndex : 1;

        while (i < arrayLength && i >= 0) {
            int currentHeight = surface[i];
            if (deepestInSegment > currentHeight) {
                deepestInSegment = currentHeight;
            } else {
                boolean isFloodable = checkFloodable.apply(i, segmentStartIndex);
                if (currentHeight >= highestSegmentHeight) {
                    if (isFloodable) {
                        int segmentMaxDepth = highestSegmentHeight - deepestInSegment;
                        maximumDepth = Math.max(segmentMaxDepth, maximumDepth);
                        segmentStartIndex = i;
                        highestSegmentHeight = currentHeight;
                        deepestInSegment = currentHeight;
                    } else {
                        segmentStartIndex = i;
                        highestSegmentHeight = currentHeight;
                        deepestInSegment = currentHeight;
                    }
                }
            }
            i = operation.apply(i);
        }
        return maximumDepth;
    }
}
