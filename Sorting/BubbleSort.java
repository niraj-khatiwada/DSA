package Sorting;

public class BubbleSort {
    public void sort(int[] array) {
        for (var i = 0; i < array.length; i++) {
            var c = 0;
            var isSorted = true;
            while (!(c >= (array.length - 1))) {
                if (array[c] > array[c + 1]) {
                    var ref = array[c];
                    array[c] = array[c + 1];
                    array[c + 1] = ref;
                    isSorted = false;
                }
                c++;
            }
            if (isSorted) {
                break;
            }
        }

    }
}
