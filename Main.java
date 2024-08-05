import java.util.*;

import Heap.Heap;

class Main {

    public static void main(String[] args) {

        var heap = new Heap(6);

        System.out.println(Arrays.toString(heap.heapify(new int[] { 5, 3, 8, 4, 1, 2 })));

    }

}
