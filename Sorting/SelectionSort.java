package Sorting;

public class SelectionSort {
    // O(n^2)
    public void sort(int[] array) {
        var currentIndex = 0;

        while (currentIndex != (array.length - 1)) {
            var minimum = Integer.MAX_VALUE;
            var minimumIndex = -1;
            for (var i = currentIndex; i < array.length; i++) {
                if (array[i] < minimum) {
                    minimum = array[i];
                    minimumIndex = i;
                }
            }

            var ref = array[currentIndex];
            array[currentIndex] = minimum;
            array[minimumIndex] = ref;
            currentIndex++;
        }
    }
}
