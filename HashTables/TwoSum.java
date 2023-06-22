package HashTables;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    // O(n)
    public int[] twoSum(int[] array, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int item = sum - array[i];
            if (map.containsKey(array[i])) {
                int[] value = { map.get(array[i]), i };
                return value;
            }
            map.put(item, i);

        }
        return null;
    }

    // O(n^2)
    // We can optimize this algo using Hash Table
    public int[] __twoSum(int[] array, int sum) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i] + array[j] == sum) {
                    int[] value = { i, j };
                    return value;
                }
            }
        }
        int[] value = {};
        return value;
    }
}
