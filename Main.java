import Queues.ReverseKthElements;

import java.util.ArrayDeque;

class Main {
    public static void main(String[] args) {
        var queue = new ArrayDeque<Integer>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        var reverseAQueue = new ReverseKthElements();
        System.out.println(reverseAQueue.reverse(queue, 3));

    }
}
