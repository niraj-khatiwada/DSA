package HashMaps;

import java.util.HashSet;

public class UniqueIntegersThatHaveDifferenceK {

    // [1, 7, 5, 9, 2, 12, 3]
    public static int getCount(int[] array, int k) {
        HashSet<Integer> set = new HashSet<>();

        for (int val : array) {
            set.add(val);
        }

        int count = 0;
        for (int val : array) {
            if (set.contains(val + k)) {
                count++;
            }
            if (set.contains(val - k)) {
                count++;
            }
            set.remove(val);
        }

        return count;
    }
}