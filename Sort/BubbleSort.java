package Sort;

public class BubbleSort {

    // Best Case: O(n)
    // Worst Case: O(n^2)
    public void sort(int[] array) {
        for (var item : array) {
            var isSorted = true;
            for (var i = 0; i < array.length; i++) {
                var isLast = i == (array.length - 1);
                if (!isLast && array[i] > array[i + 1]) {
                    var ref = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = ref;
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }
}