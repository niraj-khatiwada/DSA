package Sorting;

import java.util.*;

public class BucketSort {
    public void sort(int[] array) {
        // Bucket size does not work for every item in the array.
        // We need to change the bucket size based on the values in the array.
        // One way to determine the bucket size is to get the maximum value and divide
        // by the array length
        var bucketSize = array.length;
        var max = Integer.MIN_VALUE;
        for (var item : array) {
            max = Math.max(max, item);
        }
        bucketSize = max / bucketSize;

        List<List<Integer>> bucket = new ArrayList<>();

        for (var i = 0; i < bucketSize; i++) {
            bucket.add(i, new LinkedList<>());
        }

        for (var i : array) {
            int bi = i / bucketSize;
            bucket.get(bi).add(i);
        }
        var c = 0;
        for (var b : bucket) {
            if (b != null) {
                Collections.sort(b);
                for (var i : b) {
                    array[c] = i;
                    c++;
                }
            }
        }

    }
}