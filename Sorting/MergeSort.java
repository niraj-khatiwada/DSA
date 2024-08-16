package Sorting;

import java.util.*;

public class MergeSort {
    // O(nlog(n))
    // Space: O(n)
    public void sort(int[] array) {
        array = this._sort(array);
    }

    private int[] _sort(int[] array) {
        var m = array.length / 2;
        if (m == 0) {
            return array;
        }

        var l = Arrays.copyOf(array, m);
        var r = Arrays.copyOfRange(array, m, array.length);

        var sl = _sort(l);
        var sr = _sort(r);

        var pl = 0;
        var pr = 0;
        for (var i = 0; i < array.length; i++) {
            if (pl >= (sl.length)) {
                array[i] = sr[pr];
                pr++;
            } else if (pr >= (sr.length)) {
                array[i] = sl[pl];
                pl++;
            } else {
                if (sl[pl] < sr[pr]) {
                    array[i] = sl[pl];
                    pl++;
                } else {
                    array[i] = sr[pr];
                    pr++;
                }
            }
        }
        return array;

    }

}
