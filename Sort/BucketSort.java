package Sort;

import java.util.LinkedList;
import java.util.Collections;

public class BucketSort {
    public void sort(int[] array, int numberOfBuckets) {
        LinkedList<Integer>[] bucketList = new LinkedList[numberOfBuckets];

        for (var item : array) {
            int index = item / numberOfBuckets;
            if (bucketList[index] == null) {
                bucketList[index] = new LinkedList<>();
            }
            bucketList[index].add(item);
        }

        var currentIndex = -1;
        for (var list : bucketList) {
            if (list != null) {
                // Collections.sort() uses Quick Sort under the hood.
                Collections.sort(list);
                for (var sortedItem : list) {
                    currentIndex++;
                    array[currentIndex] = sortedItem;
                }
            }
        }
    }
}
