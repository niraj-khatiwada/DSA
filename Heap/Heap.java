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

    public int[] heapify(int[] array) {
        var map = new HashMap<Integer, Integer>();
        var heap = new int[array.length];
        for (var i = 0; i < heap.length; i++) {
            heap[i] = array[i];
            map.put(array[i], i);

        }
        int lastParentIndex = (array.length / 2) - 1;
        for (var i = lastParentIndex; i >= 0; i--) {
            var item = array[i];
            if (i != 0) {
                // Bubble Up
                var c = i;
                while (true) {
                    var pi = this._getParentIndex(c);
                    if (pi == -1) {
                        break;
                    }
                    var itemi = map.get(item);
                    if (heap[pi] < heap[itemi]) {
                        var ref = heap[pi];
                        heap[pi] = heap[itemi];
                        heap[itemi] = ref;
                        map.put(heap[pi], pi);
                        map.put(heap[itemi], itemi);
                    } else {
                        break;
                    }
                }
            }

            // Bubble Down
            var c = i;
            while (true) {
                var pi = this._getChildrenIndices(c);
                var li = pi[0];
                var ri = pi[1];
                var itemi = map.get(item);

                if ((li < array.length && (heap[itemi] < heap[li]))
                        || (ri < array.length && (heap[itemi] < heap[ri]))) {
                    var si = heap[li] > heap[ri] ? li : ri;
                    var ref = heap[si];
                    heap[si] = heap[itemi];
                    heap[itemi] = ref;
                    map.put(heap[si], si);
                    map.put(heap[itemi], itemi);
                    c = si;
                } else {
                    break;
                }
            }

        }
        return heap;
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

        System.out.println(Arrays.toString(array));
    }

    // Creating a maxHeap in Java;
    private void maxHeap() {
        var maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        maxHeap.add(1);
        maxHeap.add(2);
        maxHeap.add(3);
        System.out.println(maxHeap);
    }
}
