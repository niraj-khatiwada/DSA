package Sorting;

public class SelectionSort {
    // O(n^2)
    public void sort(int[] array) {
        var p = 0;
        for (var i = 0; i < array.length; i++) {
            var minIndex = p;
            for (var j = p; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            var ref = array[p];
            array[p] = array[minIndex];
            array[minIndex] = ref;
            p++;
        }
    }
}
