import Queues.PriorityQueue;

class Main {
    public static void main(String[] args) {
        var queue = new PriorityQueue(5);
        queue.add(4);
        queue.add(2);
        queue.add(5);
        queue.add(3);
        queue.add(16);
        queue.remove();
        queue.remove();
        queue.add(20);
        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();
        queue.add(4);
        queue.add(2);
        queue.add(5);
        queue.add(3);
        queue.add(16);
        queue.print();
    }
}
