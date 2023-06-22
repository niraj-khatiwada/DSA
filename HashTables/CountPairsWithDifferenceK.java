package HashTables;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountPairsWithDifferenceK {

    // O(n)
    public int countPairsWithDifferenceK(int[] array, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (int item : array) {
            String leftKey = (item - k) + "|" + item;
            String rightKey = (item) + "|" + (item + k);
            if (map.containsKey(leftKey)) {
                map.put(leftKey, map.get(leftKey) + 1);
            } else {
                map.put(leftKey, 0);
            }
            if (map.containsKey(rightKey)) {
                map.put(rightKey, map.get(rightKey) + 1);
            } else {
                map.put(rightKey, 0);
            }
        }
        int uniquePairsCount = 0;
        System.out.println(map);
        for (var entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                uniquePairsCount++;
            }
        }
        return uniquePairsCount;
    }

    // O(n^2)
    // We can optimize this algo using Hash Table
    public int __countPairsWithDifferenceK(int[] array, int k) {
        Set<String> set = new HashSet<>();
        for (int i : array) {
            for (int j : array) {
                if (j - i == k) {
                    set.add(i < j ? (i + "|" + j) : (j + "|" + i));
                }
            }
        }
        return set.size();
    }
}
