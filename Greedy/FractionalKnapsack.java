package Greedy;

import java.util.*;

public class FractionalKnapsack {
    public double maxProfit(int[][] items, int maxWeight) {
        Arrays.sort(items, Comparator.comparingDouble(x -> (double) (x[0] / x[1])));
        double max = 0;
        for (var i = items.length - 1; i >= 0; i--) {
            var v = items[i][0];
            var w = items[i][1];
            if (maxWeight >= w) {
                max += v;
                maxWeight -= w;
            } else {
                max += (double) (v / w) * maxWeight;
                maxWeight = 0;
                break;
            }
        }
        return max;
    }
}
