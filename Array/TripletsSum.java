package Array;

import java.util.*;

public class TripletsSum {
    // O(n^3)
    public void tripletsSum(int[] array) {
        if (array.length < 3)
            return;
        var used = new TreeSet<int[]>((a, b) -> Arrays.compare(a, b));
        for (var i = 0; i < array.length; i++) {
            for (var j = 1; j < array.length; j++) {
                for (var k = 2; k < array.length; k++) {
                    if (i != j && j != k && i != k) {
                        if ((array[i] + array[j] + array[k]) == 0) {
                            var item = new int[] { array[i], array[j], array[k] };
                            Arrays.sort(item);
                            if (!used.contains(item)) {
                                System.out.printf("%s %s %s\n", array[i], array[j], array[k]);
                                used.add(item);
                            }
                        }
                    }

                }
            }
        }
    }
}
