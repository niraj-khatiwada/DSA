package Sort;

public class InsertionSort {
    // Best Case: O(n)
    // Worst Case: O(n^2)
    public void sort(int[] array) {
        var startIndex = 0;
        for (var i = 0; i < array.length; i++) {
            var ref = array[startIndex];
            for (var j = startIndex; j >= 0; j--) {
                if (j == 0 || (ref >= array[j - 1])) {
                    array[j] = ref;
                    break;
                }
                array[j] = array[j - 1];
            }
            startIndex++;
        }
    }
}
