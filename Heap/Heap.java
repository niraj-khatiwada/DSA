package Heap;

import java.util.*;

public class Heap {
    public int[] heap;
    public int currentIndex = -1;

    public Heap(int size) {
        this.heap = new int[size];
    }

    // O(logn)
    public void add(int val) {
        this.currentIndex++;
        var c = this.currentIndex;
        this.heap[c] = val;
        while (true) {
            var pi = this._getParentIndex(c);
            if (pi == -1) {
                break;
            }
            var parent = this.heap[pi];
            if (val > parent) {
                this.heap[pi] = val;
                this.heap[c] = parent;
                c = pi;
            } else {
                break;
            }
        }
    }

    // O(logn)
    public int remove() {
        if (this.currentIndex == -1) {
            throw new IllegalStateException("No values to remove");
        }
        var removed = this.heap[0];
        this.heap[0] = this.heap[this.currentIndex];
        this.heap[currentIndex] = 0;
        this.currentIndex--;

        var c = 0;
        while (true) {
            var pi = this._getChildrenIndices(c);
            var l = pi[0];
            var r = pi[1];
            if (l == -1) {
                break;
            }
            if ((l <= this.currentIndex && this.heap[c] < this.heap[l])
                    || (r <= this.currentIndex && this.heap[c] < this.heap[r])) {
                var ni = this.heap[l] > this.heap[r] ? l : r;
                var ref = this.heap[ni];
                this.heap[ni] = this.heap[c];
                this.heap[c] = ref;
                c = ni;
            } else {
                break;
            }
        }
        return removed;

    }

    private int _getParentIndex(int i) {
        if (i == 0) {
            return -1;
        }
        var isRight = (i % 2) == 0;
        return (i - (isRight ? 2 : 1)) / 2;
    }

    private int[] _getChildrenIndices(int i) {
        if (i < 0) {
            return new int[] { -1, -1 };
        }
        return new int[] { (i * 2) + 1, (i * 2) + 2 };
    }

    public void print() {
        var array = new int[this.currentIndex + 1];
        for (var i = 0; i < array.length; i++) {
            array[i] = this.heap[i];
        }
        System.out.println(Arrays.toString(array));
    }

    // O(log(n))
    // Pick non leaf nodes only and recursively bubble down
    public void heapify(int[] array) {
        for (var i = ((array.length / 2) - 1); i >= 0; i--) {
            this._heapify(array, i);
        }
    }

    private void _heapify(int[] array, int i) {
        var ci = _getChildrenIndices(i);
        var li = ci[0];
        var ri = ci[1];
        if ((_isIndexBound(li, array) && array[i] < array[li]) || (_isIndexBound(ri, array) && array[i] < array[ri])) {
            var si = _isIndexBound(ri, array) ? (array[li] > array[ri] ? li : ri) : li;
            var ref = array[i];
            array[i] = array[si];
            array[si] = ref;
            _heapify(array, si);
        }
    }

    private boolean _isIndexBound(int i, int[] array) {
        return i < array.length;
    }

    public int kThLargestElement(int[] array, int k) {
        if (k < 1 || k > array.length) {
            throw new IllegalArgumentException("Index out range");
        }
        var heap = new Heap(array.length);
        for (var i : array) {
            heap.add(i);
        }
        var rs = 0;
        for (var i = 0; i < k; i++) {
            rs = heap.remove();
        }
        return rs;
    }

    public boolean isValidMaxHeap(int[] array) {
        for (var i = 0; i < (array.length / 2 - 1); i++) {
            var ci = this._getChildrenIndices(i);
            int li = ci[0], ri = ci[1];
            if ((li < array.length && array[i] < array[li]) || (ri < array.length && array[i] < array[ri])) {
                return false;
            }
        }
        return true;
    }

    // Heap Sort
    // n(log(n)) Because each deletion can be O(logn) in worst case and if we repeat
    // that for n times, it will be nlogn
    public void heapSort() {
        var array = new int[] { 3, 6, 5, 1, 4, 9 };
        var heap = new Heap(array.length);

        // O(n(log(n)))
        for (var a : array) {
            // O(log(n))
            heap.add(a);
        }
        // O(n(log(n)))
        for (var i = 0; i < array.length; i++) {
            // O(log(n))
            array[array.length - 1 - i] = heap.remove();
        }

    }

}
