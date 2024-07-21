package Search;

import java.util.Arrays;

public class ExponentialSearch {
    public int find(int[] array, int value) {
        if (array.length == 1) {
            return -1;
        }

        // The given array must be sorted.
        // We are sorting only for making sure here.
        // We do not need to do this in interviews
        Arrays.sort(array);

        var boundIndex = 1;
        while (true) {
            var isOutOfBound = boundIndex > (array.length - 1);
            if (isOutOfBound || value <= array[boundIndex]) {
                // Binary Search
                var binarySearch = new BinarySearch();
                return binarySearch.findUsingRecursion(array, value, boundIndex / 2,
                        isOutOfBound ? (array.length - 1) : boundIndex);

            }
            boundIndex *= 2;
        }
    }
}
