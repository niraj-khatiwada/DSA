package Hashmap;

import java.util.HashMap;

public class TwoSum {
    public int[] find(int[] array, int sum) {
        var map = new HashMap<Integer, Integer>();

        for (var i = 0; i < array.length; i++) {
            var item = array[i];
            if (map.containsKey(sum - item)) {
                return new int[] { map.get(sum - item), i };
            }
            map.put(item, i);
        }
        return new int[] { -1, -1 };
    }
}
