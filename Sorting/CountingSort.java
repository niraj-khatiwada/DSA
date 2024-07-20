package Sorting;

public class CountingSort {
    // O(n)
    public void sort(int[] array) {
        if (array.length == 0) {
            return;
        }

        // Max value can be supplied or we can find it.
        var max = Integer.MIN_VALUE;
        for (var item : array) {
            if (item > max) {
                max = item;
            }
        }

        var newArray = new int[max + 1];

        for (var item : array) {
            newArray[item] += 1;
        }

        var currentIndex = -1;
        for (var i = 0; i < newArray.length; i++) {
            var occurrenceCount = newArray[i];
            if (occurrenceCount > 0) {
                for (var j = 0; j < occurrenceCount; j++) {
                    currentIndex++;
                    array[currentIndex] = i;
                }
            }
        }
    }
}
