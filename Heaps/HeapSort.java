package Heaps;

public class HeapSort {

    public static void sort(int[] array, boolean isDesc) {
        var heap = new Heap(array.length);
        for (var item : array) {
            heap.insert(item);
        }

        for (var i = 0; i < array.length; i++) {
            array[isDesc ? i : (array.length - 1 - i)] = heap.remove();
        }
    }
}

// int[] array = { 10, 5, 17, 4, 22 };
// HeapSort.sort(array, false);
// System.out.println(Arrays.toString(array));