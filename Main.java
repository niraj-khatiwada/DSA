import java.util.*;

import Heap.Heap;

class Main {

    public static void main(String[] args) {

        var heap = new Heap(6);
        var array = new int[] { 1, 2, 3, 4, 5 };
        heap.heapify(array);
        System.out.println(Arrays.toString(array));
    }

}
