package DP;

import java.util.*;

public class Fibonacci {
    public int fibonacci(int t) {
        var dp = new int[t + 1];
        return _fibonacciOptimized(t, dp);
        // return _fibonacci(t);

    }

    // All recursion methods are called Memoization DP

    // O(2^n)
    // This one calculates f() for numbers lower than target multiple times.
    // For example, while calculating f(5), we calculate f(3) twice and f(2) thrice.
    // Since f(3) and f(2) are always same, once we get the value we store them
    // somewhere and reuse them later. See, _fibonacciOptimized()
    private int _fibonacci(int target) {
        if (target == 0 || target == 1) {
            return target;
        }
        // f(n-1) + f(n-2)
        return _fibonacci(target - 1) + _fibonacci(target - 2);
    }

    // O(n)
    private int _fibonacciOptimized(int target, int[] dp) {
        if (target == 0 || target == 1) {
            return target;
        }
        if (dp[target] != 0) {
            return dp[target];
        }
        dp[target] = _fibonacciOptimized(target - 2, dp) + _fibonacciOptimized(target - 1, dp);
        return dp[target];
    }

    public void fibonacciPattern(int upto) {
        _fibonacciPattern(-1, 1, upto);
    }

    private void _fibonacciPattern(int a, int b, int target) {
        if (b >= target) {
            return;
        }
        var sum = a + b;
        System.out.println(sum);
        _fibonacciPattern(b, sum, target);
    }

    // Tabulation DP: Iteration methods are called Tabulation DP.
    // O(n)
    public int fibonacciTabulation(int target) {
        var dp = new int[target + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (var i = 2; i <= target; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[target];
    }
}
