package DynamicProgramming;

import java.util.*;

public class KnapSack01 {

    public int maxProfit(int[] items, int[] weights, int maxWeight) {
        var rs = new int[] { Integer.MIN_VALUE };
        var map = new HashMap<Integer, Integer>();
        for (var i = 0; i < items.length; i++) {
            var used = new ArrayList<Integer>();
            this._maxProfit(items, weights, maxWeight, i, 0, 0, used, map, rs);
        }
        return rs[0];
    }

    public void _maxProfit(int[] items, int[] weights, int m, int i, int value, int weight, List<Integer> used,
            Map<Integer, Integer> map, int[] rs) {
        if (i >= (items.length) || used.contains(items[i]) || map.get(items[i]) != null) {
            return;
        }
        if ((weight + weights[i]) > m) {
            rs[0] = Math.max(rs[0], value);
            map.put(used.get(0), rs[0]);
            return;
        }
        value += items[i];
        used.add(items[i]);
        weight += weights[i];

        for (var j = 0; j < items.length; j++) {
            _maxProfit(items, weights, m, j, value, weight, used, map, rs);
        }
    }

}