import java.util.*;

import Heap.Heap;

class Main {

    public static void main(String[] args) {

        var queue = new PriorityQueue<Integer>(Collections.reverseOrder());

        queue.add(1);
        queue.add(2);
        queue.add(3);

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

}
