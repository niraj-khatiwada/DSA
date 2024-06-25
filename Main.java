import Queues.LinkedListQueue;

class Main {
    public static void main(String[] args) {
        var queue = new LinkedListQueue();
        System.out.println(queue.isEmpty());
        queue.add(10);
        System.out.println(queue.peek());
        queue.add(20);
        queue.add(30);
        System.out.println(queue.remove());
        queue.add(10);
        System.out.println(queue);
        System.out.println(queue.size());
    }
}
