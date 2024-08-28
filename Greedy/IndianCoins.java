package Greedy;

import java.util.*;

public class IndianCoins {
    // Indian coin combination can be used to always sum to any numbers
    // 1, 2, 5, 10, 20, 50, 100, 500, 2000
    // This logic only works for Indian coins not other coins combination
    // O(nlog(n))
    public int minNumOfCoins(int[] coins, int target) {
        Arrays.sort(coins);
        var rs = new ArrayList<Integer>();
        var p = coins.length - 1;
        while (p >= 0) {
            var current = coins[p];
            int quotient = target / current;
            if (quotient != 0) {
                for (var i = 0; i < quotient; i++) {
                    rs.add(current);
                }
            }
            target -= quotient * current;
            p--;
        }
        return target == 0 ? rs.size() : -1;
    }
}
