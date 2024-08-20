package Maths;

import java.util.*;

public class Fibonacci {
    public int fibonacci(int t) {
        var dp = new int[t + 1];
        return _fibonacciOptimized(t, dp);
        // return _fibonacci(t);

    }

    // O(2^n)
    // This one calculates f() for numbers lower than target multiple times.
    // For example, while calculating f(5), we calculate f(3) twice and f(2) thrice.
    // Since f(3) and f(2) are always same, once we get the value we store them
    // somewhere and reuse them later. See, _fibonacciOptimized()
    private int _fibonacci(int target) {
        if (target == 0 || target == 1) {
            return target;
        }
        System.out.println("CALLED");
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
        System.out.println("CALLED");
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
}
