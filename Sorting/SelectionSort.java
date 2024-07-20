package Sorting;

public class SelectionSort {
    // O(n^2)
    public void sort(int[] array) {
        var startIndex = 0;

        while (startIndex != (array.length - 1)) {
            var minimum = Integer.MAX_VALUE;
            var minimumIndex = -1;
            for (var i = startIndex; i < array.length; i++) {
                if (array[i] < minimum) {
                    minimum = array[i];
                    minimumIndex = i;
                }
            }
            var ref = array[startIndex];
            array[startIndex] = minimum;
            array[minimumIndex] = ref;
            startIndex++;
        }
    }
}
