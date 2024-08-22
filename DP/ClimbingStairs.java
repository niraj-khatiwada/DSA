package DP;

public class ClimbingStairs {
    public int countPossibilities(int n) {
        return this._countPossibilitiesTabulation(n);
    }

    // Un-optimized
    // 2^n
    private int _countPossibilitiesUnOptimized(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }

        return _countPossibilitiesUnOptimized(n - 1) + _countPossibilitiesUnOptimized(n - 2);
    }

    // Memoization DP
    // O(n)
    private int _countPossibilities(int n, int[] dp) {
        if (n <= 0) {
            return n;
        }

        if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] = _countPossibilitiesUnOptimized(n - 1) + _countPossibilitiesUnOptimized(n - 2);
        return dp[n];
    }

    // Tabulation DP
    // O(n)
    private int _countPossibilitiesTabulation(int n) {
        var dp = new int[n + 1];

        dp[0] = 1;

        for (var i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }

        return dp[n];

    }
}
