package Sorting;

import java.util.LinkedList;

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
                var listSize = list.size();
                int[] arrayList = new int[listSize];
                for (var i = 0; i < listSize; i++) {
                    arrayList[i] = list.remove();
                }
                var sortingAlgorithm = new InsertionSort();
                sortingAlgorithm.sort(arrayList);
                for (var sortedItem : arrayList) {
                    currentIndex++;
                    array[currentIndex] = sortedItem;
                }
            }
        }
    }
}
