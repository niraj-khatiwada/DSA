package Sorting;

import java.util.*;

public class QuickSort {
    // O(nlog(n))
    // Space: O(log(n))
    public void sort(int[] array) {
        this._sort(array, 0, array.length - 1);
    }

    public void _sort(int[] array, int s, int p) {
        if (p <= 0 || p >= array.length || s < 0 || s >= (array.length - 1) || s >= p) {
            return;
        }

        var pref = p;
        var sref = s;
        while (s != p && p >= 0) {
            if (array[s] >= array[p]) {
                var ref = array[s];
                var c = p;
                var _ref = array[c];
                while (c > s) {
                    var newRef = array[c - 1];
                    array[c - 1] = _ref;
                    _ref = newRef;
                    c--;
                }
                array[p] = ref;
                p--;
            } else {
                s++;
            }
        }
        _sort(array, sref, p - 1);
        _sort(array, p + 1, pref);
    }
}
