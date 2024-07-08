package Heaps;

public class KthLargestOrSmallestValue {
    public int findLargest(int[] array, int k) {
        if (k <= 0 || k > array.length) {
            throw new IllegalStateException("k out of bound");
        }
        var heap = new Heap(array.length);

        for (var item : array) {
            heap.insert(item);
        }
        var target = 0;
        for (var i = 0; i < k; i++) {
            target = heap.remove();
        }
        return target;
    }

    public int findSmallest(int[] array, int k) {
        if (k <= 0 || k > array.length) {
            throw new IllegalStateException("k out of bound");
        }
        var heap = new Heap(array.length);
        for (var item : array) {
            heap.insert(item);
        }
        var target = 0;
        for (var i = 0; i < (array.length - k + 1); i++) {
            target = heap.remove();
        }
        return target;
    }
}

// var heap = new KthLargestOrSmallestValue();
// var largest = heap.findLargest(new int[] { 5, 3, 8, 4, 1, 2 }, 1);
// System.out.println(largest);
// var smallest = heap.findSmallest(new int[] { 5, 3, 8, 4, 1, 2 }, 6);
// System.out.println(smallest);