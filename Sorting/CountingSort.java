package Sorting;

public class CountingSort {
    public void sort(int[] array) {
        var max = Integer.MIN_VALUE;
        for (var i : array) {
            max = Math.max(max, i);
        }
        var store = new int[max + 1];
        for (var i : array) {
            store[i]++;
        }
        var c = 0;
        for (var i = 0; i < store.length; i++) {
            var s = store[i];
            while (s != 0) {
                array[c] = i;

                c++;
                s -= 1;
            }
        }
    }
}
