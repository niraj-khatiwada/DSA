import java.util.Arrays;

import Heaps.Heapify;
import Heaps.Heap;

class Main {
    public static void main(String[] args) {
        var heap = new Heapify();
        var heapify = heap.heapify(new int[] { 5, 3, 8, 4, 1, 2 });
        System.out.println(Arrays.toString(heapify));

    }

}
