package Sorting;

public class InsertionSort {
    // O(n^2)
    public void sort(int[] array) {
        for (var i = 0; i < array.length; i++) {
            if (i == 0) {
                continue;
            }
            var p = i;
            while (p >= 0) {
                if ((p - 1) < 0) {
                    break;
                }
                if (array[p] < array[p - 1]) {
                    var ref = array[p];
                    array[p] = array[p - 1];
                    array[p - 1] = ref;
                }
                p--;
            }
        }
    }
}
