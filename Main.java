import java.util.*;

import Heap.Heap;

class Main {

    public static void main(String[] args) {
        var heap = new Heap(10);

        heap.add(15);
        heap.add(10);
        heap.add(3);
        heap.add(8);
        heap.add(12);
        heap.add(9);
        heap.add(4);
        heap.add(1);
        heap.add(24);

        heap.print();
        heap.remove();
        heap.remove();
        heap.remove();
        heap.remove();
        heap.remove();
        heap.remove();
        heap.print();

    }

}
