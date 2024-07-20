package Sort;

import java.util.Stack;

public class QuickSort {
    public void sort(int[] array) {
        var stack = new Stack<Integer>();
        for (var i = 0; i < array.length; i++) {
            stack.add(array[i]);
        }
        // We use stack to start from last element
        while (!stack.isEmpty()) {
            var nextItem = stack.pop();
            var pivotIndex = -1;
            // The original array will be changed so we need to find the exact index of last
            // popped value. That will be the pivot index. This makes sure we use every
            // element as a pivot once.
            for (var i = 0; i < array.length; i++) {
                if (nextItem == array[i]) {
                    pivotIndex = i;
                }
            }
            // Now we do comparison between index 0 and pivotIndex for each element.
            // We shift the element one element to left if array[i] > array[pivot]
            var i = 0;
            while (true) {
                if (i == pivotIndex) {
                    break;
                }
                var target = array[i];
                // If target value is greater than pivot value, shift each values one step to
                // the left and replace pivot with target value. Perform this for every value
                // from stack.
                if (target > array[pivotIndex]) {
                    var currentIndex = pivotIndex;
                    var previousRef = array[currentIndex];
                    while (currentIndex > i) {
                        var tempRef = array[currentIndex - 1];
                        array[currentIndex - 1] = previousRef;
                        previousRef = tempRef;
                        currentIndex--;
                    }
                    array[pivotIndex] = target;
                    pivotIndex--;
                    i = 0;
                } else {
                    i++;
                }
            }
        }
    }
}
