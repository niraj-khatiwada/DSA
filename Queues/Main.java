package Queues;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        PriorityQueue pQueue = new PriorityQueue(5);

        pQueue.enqueue(1);
        pQueue.enqueue(3);
        pQueue.enqueue(5);
        pQueue.enqueue(2);
        pQueue.enqueue(0);

        System.out.println(pQueue.dequeue());
        System.out.println(Arrays.toString(pQueue.toArray()));
    }
}