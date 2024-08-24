package Greedy;

import java.util.*;

public class ActivitySelection {
    public static int c;

    // O(nlog(n))
    // Also can be called, Non Overlapping Jobs
    public int maxNumberOfJobs(int[] start, int[] end) {
        var matrix = new int[start.length][3];
        for (var i = 0; i < start.length; i++) {
            matrix[i][0] = i;
            matrix[i][1] = start[i];
            matrix[i][2] = end[i];
        }

        Arrays.sort(matrix, Comparator.comparingInt(x -> x[2]));

        var count = 1;
        var lastIndex = 0;
        var jobs = new ArrayList<Integer>();
        jobs.add(matrix[0][0]);
        for (var i = 1; i < matrix.length; i++) {
            if (matrix[i][1] >= matrix[lastIndex][2]) {
                count++;
                lastIndex = i;
                jobs.add(matrix[i][0]);
            }
        }
        System.out.println(jobs);
        return count;
    }

    private int _maxNumberOfJobsRecursion(int[] start, int[] end, int i, int count) {
        var next = _findNext(start, end, i);
        if (next == -1) {
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

    public void print(int[][] grid) {
        for (var i = 0; i < grid.length; i++) {
            for (var j = 0; j < grid[0].length; j++) {
                System.out.printf("%5s", grid[i][j]);
            }
            System.out.println();
        }
    }

}
