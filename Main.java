import java.util.*;

import Heap.Heap;

class Main {

    public static void main(String[] args) {

        var heap = new Heap(6);

        System.out.println(heap.isValidMaxHeap(new int[] { 10, 8, 4, 5, 3, 2, 1 }));

    }

}
