package Hashmap;

import java.util.HashSet;

public class CountUniquePairsWithDiffK {
    public int count(int[] array, int k) {
        var set = new HashSet<Integer>();

        for (var item : array) {
            set.add(item);

        }
        var count = 0;
        for (var item : array) {
            var min = item - k;
            if (set.contains(min)) {
                count++;
            }
            var max = item + k;
            if (set.contains(max)) {
                count++;
            }
            set.remove(item);

        }

        return count;
    }
}
