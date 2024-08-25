package Greedy;

import java.util.*;

public class MaxLengthChainOfPairs {
    // nlog(n)
    public int maxPairs(int[][] pairs) {
        // nlog(n)
        Arrays.sort(pairs, Comparator.comparingInt(x -> x[1]));

        var count = 1;
        var end = pairs[0][1];

        for (var i = 1; i < pairs.length; i++) {
            if (end < pairs[i][0]) {
                end = pairs[i][1];
                count++;
            }
        }
        return count;
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
