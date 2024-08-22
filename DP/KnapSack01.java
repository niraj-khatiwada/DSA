package DP;

import java.util.*;

public class KnapSack01 {

    // O(n*maxWeight)
    public int knapSackTabulation(int[] items, int[] weights, int maxWeight) {
        var n = items.length;
        var wn = maxWeight;
        var dp = new int[n + 1][wn + 1];
        for (var i = 1; i <= n; i++) {
            for (var j = 1; j <= wn; j++) {
                var weight = weights[i - 1];
                var value = items[i - 1];
                var included = 0;
                if (weight <= j) {
                    included = value + dp[i - 1][j - weight];
                }
                var excluded = dp[i - 1][j];
                dp[i][j] = Math.max(included, excluded);
            }
        }
        print(dp);
        return dp[n][wn];
    }

    // O(n*maxWeight)
    public int knapSackRecursion(int[] items, int[] weights, int maxWeight) {
        var dp = new int[items.length + 1][maxWeight + 1];
        for (var i = 0; i <= items.length; i++) {
            for (var j = 0; j <= maxWeight; j++) {
                dp[i][j] = -1;
            }
        }
        var rs = this._knapSackRecursion(items, weights, maxWeight, 0, dp);
        print(dp);
        return rs;
    }

    private int _knapSackRecursion(int[] items, int[] weights, int weight,
            int i, int[][] dp) {
        if (i >= items.length || weight < 0) {
            return 0;
        }
        if (dp[i][weight] != -1) {
            return dp[i][weight];
        }
        var included = 0;
        if (weights[i] <= weight) {
            included = items[i] + _knapSackRecursion(items, weights, weight - weights[i], i
                    + 1, dp);
        }
        var excluded = _knapSackRecursion(items, weights, weight, i + 1, dp);
        dp[i][weight] = Math.max(included, excluded);
        return dp[i][weight];
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