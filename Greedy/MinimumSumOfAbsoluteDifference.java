package Greedy;

import java.util.*;

public class MinimumSumOfAbsoluteDifference {

    public int minimumSum(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);

        var sum = 0;
        for (var i = 0; i < a.length; i++) {
            sum += Math.abs(a[i] - b[i]);
        }
        return sum;
    }
}
