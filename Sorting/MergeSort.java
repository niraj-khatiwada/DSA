package Sorting;

public class MergeSort {
    public void sort(int[] array) {
        var sorted = _mergeSort(array);
        for (var i = 0; i < array.length; i++) {
            array[i] = sorted[i];
        }
    }

    private int[] _mergeSort(int[] array) {
        int middleIndex = array.length / 2;
        var array1 = new int[middleIndex];
        var array2 = new int[array.length - middleIndex];
        for (var i = 0; i < array.length; i++) {
            if (i < middleIndex) {
                array1[i] = array[i];
            } else {
                array2[i - middleIndex] = array[i];
            }
        }

        if (array.length == 1) {
            return new int[] { array[0] };
        }

        var merged1 = _mergeSort(array1);
        var merged2 = _mergeSort(array2);

        int[] finalMerge = new int[merged1.length + merged2.length];

        var currentLeftIndex = 0;
        var currentRightIndex = 0;
        var currentFinalIndex = 0;
        for (var i = 0; i < merged1.length; i++) {
            for (var j = 0; j < merged2.length; j++) {
                if (merged1[i] > merged2[currentRightIndex]) {
                    finalMerge[currentFinalIndex] = merged2[currentRightIndex];
                    currentRightIndex++;
                    currentFinalIndex++;
                } else {
                    finalMerge[currentFinalIndex] = merged1[currentLeftIndex];
                    currentLeftIndex++;
                    currentFinalIndex++;
                    break;
                }
            }
            if (currentRightIndex >= merged2.length) {
                break;
            }

        }
        // We need to iterate through the remaining item and add to final
        // For example, if left = [4, 8] and right = [1, 2, 3], above will only give [1,
        // 2, 3, x, x]. So we see the leftCurrentIndex and rightCurrentIndex and add
        // remaining values.
        for (var i = currentLeftIndex; i < merged1.length; i++) {
            finalMerge[currentFinalIndex] = merged1[i];
            currentFinalIndex++;
        }
        for (var i = currentRightIndex; i < merged2.length; i++) {
            finalMerge[currentFinalIndex] = merged2[i];
            currentFinalIndex++;
        }
        return finalMerge;
    }
}
