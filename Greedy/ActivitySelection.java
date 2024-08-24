package Greedy;

import java.util.*;

public class ActivitySelection {
    public static int c;

    public int maxNumberOfJobs(int[] start, int[] end) {
        var count = 1;
        var lastIndex = 0;
        for (var i = 1; i < start.length; i++) {
            if (start[i] >= end[lastIndex]) {
                count++;
                lastIndex = i;
            }
        }
        return count;
    }

    private int _maxNumberOfJobsRecursion(int[] start, int[] end, int i, int count) {
        var next = _findNext(start, end, i);
        if (_findNext(start, end, i) == -1) {
            return count;
        }
        return _maxNumberOfJobsRecursion(start, end, next, count + 1);

    }

    private int _findNext(int[] start, int[] end, int i) {
        var targetEnd = end[i];
        for (var j = i; j < start.length; j++) {
            if (start[j] > targetEnd) {
                return j;
            }
        }
        return -1;
    }

}
