import java.util.Arrays;

import Heaps.Heapify;
import Heaps.Heap;

class Main {
    public static void main(String[] args) {
        var heap = new Heap(5);
        heap.insert(8);
        heap.insert(5);
        heap.insert(3);
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());

    }

}
