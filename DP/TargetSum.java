package DP;

import java.util.*;

public class TargetSum {
    // O(n*target)
    public boolean targetSum(int[] nums, int target) {
        var dp = new boolean[nums.length + 1][target + 1];
        for (var i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }

        for (var i = 1; i < dp.length; i++) {
            for (var j = 1; j < dp[0].length; j++) {
                var value = nums[i - 1];
                if (value <= j && dp[i - 1][j - value]) {
                    dp[i][j] = true;
                } else if (dp[i - 1][j]) {
                    dp[i][j] = true;
                }
            }
        }
        print(dp);
        return dp[nums.length][target];
    }

    public void print(boolean[][] dp) {
        for (var i = 0; i < dp.length; i++) {
            for (var j = 0; j < dp[0].length; j++) {
                System.out.printf("%8s", dp[i][j]);
            }
            System.out.println();
        }
    }

}
