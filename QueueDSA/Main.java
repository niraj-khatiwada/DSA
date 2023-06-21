package QueueDSA;

import java.util.Arrays;

public class Main {
    public static void main(String[] __) {
        QueueUsingLinkedList queue = new QueueUsingLinkedList();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        System.out.println(queue.isEmpty());

        System.out.println(Arrays.toString(queue.toArray()));

    }

}
