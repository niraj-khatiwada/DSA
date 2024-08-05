package Heap;

import java.util.*;

public class Heap {
    public int[] heap;
    public int currentIndex = -1;

    public Heap(int size) {
        this.heap = new int[size];
    }

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

    public void remove() {
        if (this.currentIndex == -1) {
            return;
        }
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
            if (this.heap[c] < this.heap[l] || this.heap[c] < this.heap[r]) {
                var ni = this.heap[l] > this.heap[r] ? l : r;
                var ref = this.heap[ni];
                this.heap[ni] = this.heap[c];
                this.heap[c] = ref;
                c = ni;
            } else {
                break;
            }
        }

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
}
