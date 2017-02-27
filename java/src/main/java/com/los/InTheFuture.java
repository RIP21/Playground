package com.los;

public class InTheFuture {
    int daysToOvertake(int aheadSolveTempo, int behindSolveTempo, int tasksDelta) {
        boolean willNeverOvertake = aheadSolveTempo < behindSolveTempo;
        return willNeverOvertake ?
                tasksDelta / (behindSolveTempo - aheadSolveTempo) + 1 :
                -1;
    }
}
