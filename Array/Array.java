package Array;

import java.util.*;

public class Array {

    // Iteration
    public void printSubArrays(int[] array) {
        for (var i = 0; i < array.length; i++) {
            for (var j = i; j < array.length; j++) {
                var store = new ArrayList<Integer>();
                for (var k = i; k <= j; k++) {
                    store.add(array[k]);
                }
                System.out.println(store);
            }
        }
    }

    public void printSubArraysRecursion(int[] array) {
        this.printSubArraysRecursion(array, 0, new ArrayList<Integer>());
    }

    // Recursion
    // Recursion will have an empty sub-array at the end.
    // It depends upon the question if empty sub array needs to be included or not
    private void printSubArraysRecursion(int[] array, int index, List<Integer> store) {
        if (index == array.length) {
            System.out.println(store);
            return;
        }
        var store1 = new ArrayList<>(store);
        var store2 = new ArrayList<>(store);

        store1.add(array[index]);
        this.printSubArraysRecursion(array, index + 1, store1);
        this.printSubArraysRecursion(array, index + 1, store2);
    }

    // Prefix Sum Method using 2D array
    // This is Tabular DP approach
    // O(n^2)
    public int maximumSumFromSubArrayDP(int[] array) {
        var prefix = new int[array.length][array.length];
        var max = Integer.MAX_VALUE;
        var start = -1;
        var end = -1;
        for (var i = 0; i < array.length; i++) {
            for (var j = i; j < array.length; j++) {
                prefix[i][j] = (j > 0 ? (prefix[i][j - 1]) : 0) + array[j];
                if (prefix[i][j] > max) {
                    max = prefix[i][j];
                    start = i;
                    end = j;
                }
            }
        }
        System.out.println("Sub Array:");
        for (var i = start; i <= end; i++) {
            System.out.printf("%2s", array[i]);
        }
        System.out.printf("\nLength of sub-array %s", end - start + 1);
        System.out.println();
        return max;
    }

    // Prefix sum but using 1D array
    // O(n^2)
    public int maximumSumFromSubArray(int[] array) {
        var prefix = new int[array.length];
        for (var i = 0; i < array.length; i++) {
            prefix[i] = (i == 0 ? 0 : prefix[i - 1]) + array[i];
        }
        var max = Integer.MIN_VALUE;
        var start = -1;
        var end = -1;
        for (var i = 0; i < array.length; i++) {
            for (var j = i; j < array.length; j++) {
                var newSum = prefix[j] - (i > 0 ? prefix[i - 1] : 0);
                if (newSum > max) {
                    max = newSum;
                    start = i;
                    end = j;
                }
            }
        }
        System.out.println("Sub Array:");
        for (var i = start; i <= end; i++) {
            System.out.printf("%2s", array[i]);
        }
        System.out.printf("\nLength of sub-array is %s from %s to %s", end - start + 1, start, end);
        System.out.println();
        return max;
    }

    // O(n)
    public int kadanesAlgorithm(int[] array) {
        var ms = 0;
        var cs = 0;
        var maxValue = Integer.MIN_VALUE;
        var allNegative = true;

        for (var i = 0; i < array.length; i++) {
            if ((cs + array[i]) > 0) {
                cs = cs + array[i];
                ms = Math.max(ms, cs);
            }
            maxValue = Math.max(maxValue, array[i]);
            if (allNegative && array[i] >= 0) {
                allNegative = false;
            }
        }
        return allNegative ? maxValue : ms;
    }

    private void _print(int[][] matrix) {
        for (var i = 0; i < matrix.length; i++) {
            for (var j = 0; j < matrix[0].length; j++) {
                System.out.printf("%5s", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
